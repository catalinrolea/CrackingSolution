package stack;

import java.util.EmptyStackException;

//implemented using linked list
public class StackList<T> {
    private StackNode<T> top;

    public static void main(String[] args) {
        StackList<Integer> listOfStacks = new StackList<>();
        listOfStacks.push(11);
        listOfStacks.push(12);
        listOfStacks.push(13);
        listOfStacks.push(14);
        System.out.println("Pop the top: "+listOfStacks.pop());
        System.out.println("top of stack: " + listOfStacks.peek());
        System.out.println("is empty: "+listOfStacks.isEmpty());
        listOfStacks.printStackList();

    }
    public boolean isEmpty() {
        if (top == null)
            return true;
        else
            return false;
    }
    //add item to stack (front)
    public void push(T item) {
        StackNode<T> data = new StackNode<>(item);
        data.next = top;
        top = data;
    }

    //remove First out = top
    public T pop() {
        if (top == null)
            throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        return item;
    }

    public void printStackList() {
        if (top == null)
            return;
        while (top != null) {
            System.out.print(top.data + " ");
            top = top.next;
        }
    }

    //return top of stack
    public T peek() {
        if (top == null)
            throw new EmptyStackException();
        return top.data;
    }

    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }


}
