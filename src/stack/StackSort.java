package stack;

import org.junit.Test;

import java.util.NoSuchElementException;

public class StackSort<T> {

    MyStack<T> initialStack, temp;

    public StackSort() {
        initialStack = new MyStack<>();
    }

    public void add(T data) {
        initialStack.push(data);
    }

    public T remove() {
        return initialStack.pop();
    }

    public T peek() {
        return initialStack.peek();
    }

    public void sort(MyStack<Integer> input) {
        if (input.isEmpty())
            throw new NoSuchElementException();
        MyStack<Integer> tempStack = new MyStack<>();
        while (!input.isEmpty())    {
            int temp = input.pop();
            while (!tempStack.isEmpty() && tempStack.peek() > temp) {
                input.push(tempStack.pop());
            }
            tempStack.push(temp);
        }
    }

    @Test
    public void testSTackSort() {
        StackSort<Integer> stack = new StackSort<>();

        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.sort(stack.initialStack);
    }
}
