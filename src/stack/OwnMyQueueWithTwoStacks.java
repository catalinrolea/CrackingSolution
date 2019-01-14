package stack;

import org.junit.Test;

import java.util.Stack;

public class OwnMyQueueWithTwoStacks<T> {

    public MyStack<T> newestStack, oldestStack;
    public OwnMyQueueWithTwoStacks()    {
         newestStack = new MyStack<>();
         oldestStack = new MyStack<>();
    }

    public void add(T data) {
        oldestStack.push(data);
    }
    public void shiftStacks()   {
        if (newestStack.isEmpty())  {
            while (!oldestStack.isEmpty()) {
                newestStack.push(oldestStack.pop());
            }
        }
    }
    //remove first element of stack
    public T remove()    {
        shiftStacks();
        return newestStack.pop();
    }
    //retrieve first element of stack
    public T peek() {
        shiftStacks();
        return newestStack.peek();
    }

    public int size()   {
        return oldestStack.size() + newestStack.size();
    }

    public void printQueueList()    {
           newestStack.printStackList();

    }

    @Test
    public void testOwnVersionQueueImplementedByTwoStacks() {
        OwnMyQueueWithTwoStacks<Integer> queueList = new OwnMyQueueWithTwoStacks<>();
        queueList.add(1);
        queueList.add(2);
        queueList.add(3);
        queueList.add(4);
        queueList.peek();
        queueList.peek();
        System.out.println("Queue obtained by two stacks: d");
        queueList.printQueueList();
    }
}
