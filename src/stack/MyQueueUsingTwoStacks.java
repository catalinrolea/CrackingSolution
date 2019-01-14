package stack;

import java.util.Stack;

public class MyQueueUsingTwoStacks<T> {
    Stack<T> oldestStack, newestStack;

    public MyQueueUsingTwoStacks() {
        oldestStack = new Stack<>();
        newestStack = new Stack<>();
    }

    public void add(T data) {
        oldestStack.push(data);
    }

    public int size() {
        return newestStack.size() + oldestStack.size();
    }

    public void shiftStacks() {
         if (newestStack.isEmpty()) {
             while (!oldestStack.isEmpty()) {
                 newestStack.push(oldestStack.pop());
             }
         }
    }

    public T peek() {
        shiftStacks();
        return newestStack.peek();
    }

    public T remove() {
        shiftStacks();
        return oldestStack.pop();
    }
    public void printQueue()    {
         for (int i=0; i<oldestStack.size(); i++) {
             System.out.print(oldestStack.get(i) + " ");

         }

    }
    public static void main(String[] args)  {
        MyQueueUsingTwoStacks queueStack = new MyQueueUsingTwoStacks();
        queueStack.add(1);
        queueStack.add(3);
        queueStack.add(5);
        queueStack.add(7);
        //queueStack.printQueue();
         queueStack.peek();
    }

}
