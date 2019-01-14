package stack;

import org.junit.Test;

import java.util.NoSuchElementException;

  class MyStack<T> {

    private int elementCount;
    public class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    public StackNode<T> top;

    public void push(T data) {
        elementCount++;
        StackNode<T> element = new StackNode<>(data);
        if (top == null) {
            top = element;
            return;
        }
        element.next = top;
        top = element;
    }
    public int size()  {
        return elementCount;
    }
    public T peek()  {
        if (top == null)
            throw new NoSuchElementException();
        return top.data;
    }
    public T pop() {
        if (top == null)
            throw new NoSuchElementException();
        T data = top.data;
        top = top.next;
        return data;
    }

    public boolean isEmpty()    {
        return top ==null;
    }

    public void printStackList()    {
        StackNode<T> last = top;
        while (last != null)    {
            System.out.println(last.data);
            last = last.next;
        }
    }

    public T getCurrentElement(StackNode<T> current) {
        return current.data;
    }

    @Test
    public void testMyOwnQueue() {
        MyStack stackList = new MyStack();
        stackList.push("A");
        stackList.push("B");
        stackList.push("C");
        stackList.push("D");
        stackList.printStackList();
    }

}
