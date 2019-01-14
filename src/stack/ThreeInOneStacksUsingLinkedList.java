package stack;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.Stack;

/*
Stack abstract data type implementation on linkedlist
Operations: push(T item) => add an element at top of stack
            pop()        => remove the top element
            peek()       => return top of stack
            isEmpty()    => return true if stack is empty
 */
public class ThreeInOneStacksUsingLinkedList<T> {
    private static class StackNode<T>   {
        private T data;
        private StackNode<T> next;
        public StackNode(T data)    {
            this.data = data;
        }
    }

    private StackNode<T> top;

    public void push(T item)    {
        StackNode<T> new_node;
        if (top == null)
            new_node = top;
          new_node = new StackNode<>(item);
         new_node.next = top;
         top = new_node;
    }

    public T pop()   {
        if (top == null)
            throw new EmptyStackException();
        T data = top.data;
        top = top.next;
        return data;
    }
    public T peek()    {
        if (top == null)
            throw new EmptyStackException();
        return top.data;
    }
    public boolean isEmpty()    {
        if (top == null)
            throw new EmptyStackException();
        return top == null;
    }
    public boolean isFull()    {
        if (top == null)
            throw new EmptyStackException();
        return top.next == null;
    }
    public void printStackList()
    {
        if (top == null)
            throw new EmptyStackException();
        while (top != null) {
            System.out.print(top.data + " ");
            top = top.next;
        }
    }
    public static void main(String[] args)  {
        ThreeInOneStacksUsingLinkedList stackList = new ThreeInOneStacksUsingLinkedList();
        stackList.push(10);
        stackList.push(20);
        stackList.push(30);
        stackList.push(40);
        stackList.push(50);
        System.out.println("Stack is full: " + stackList.isFull());
        System.out.println("Check if stack 1 is empty: "+stackList.isEmpty());
        System.out.println("Retrieve first element of stack: " + stackList.peek());
        System.out.println("Delete first element from stack: " + stackList.pop());
        System.out.println("Stack list One: ");
        stackList.printStackList();
        System.out.println("");
        System.out.println("Stack list Two: ");

        stackList = new ThreeInOneStacksUsingLinkedList();
        stackList.push(11);
        stackList.push(22);
        stackList.push(33);
        stackList.push(44);
        System.out.println("Stack is full: " + stackList.isFull());
        System.out.println("Check if stack 2 is empty: "+stackList.isEmpty());
        System.out.println("Retrieve first element of stack: " + stackList.peek());
        System.out.println("Delete first element from stack: " + stackList.pop());
        System.out.println("Stack list One: ");
        stackList.printStackList();
        System.out.println("");
        System.out.println("Stack list Three: ");
        stackList = new ThreeInOneStacksUsingLinkedList();
        stackList.push(12);
        stackList.push(24);
        stackList.push(38);
        stackList.push(616);
        System.out.println("Stack is full: " + stackList.isFull());
        System.out.println("Check if stack 3 is empty: "+stackList.isEmpty());
        System.out.println("Retrieve first element of stack: " + stackList.peek());
        System.out.println("Delete first element from stack: " + stackList.pop());
        System.out.println("Stack list One: ");
        stackList.printStackList();


    }
}
