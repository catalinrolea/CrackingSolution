package stack;

import java.util.EmptyStackException;

/*
Stack abstract data type implementation on array
Operations: push(T item) => add an element at top of stack
            pop()        => remove the top element
            peek()       => return top of stack
            isEmpty()    => return true if stack is empty
 */
public class StackArrayMin {
    private int arrayStack[];
    private int index = -1;
    private int size;
    private int minim;
    int temp;

    public StackArrayMin(int size) {
        this.size = size;
        arrayStack = new int[size];

    }


    public void push(int element) {

        if (isStackFull(element))
            throw new EmptyStackException();
        arrayStack[++index] = element;
        minim = minStack(arrayStack[0],arrayStack[index]);
        /*if (minim == 0) {
            temp = arrayStack[0];
            minim = Math.min(arrayStack[0], arrayStack[index]);
        } else {
            temp = minim;
            minim = Math.min(temp, arrayStack[index]);
        } */
    }
    public int minStack(int firstElement, int current) {
        if (minim == 0) {
            temp = firstElement;
            minim = Math.min(firstElement,current);
        } else {
            temp = minim;
            minim = Math.min(temp,current);
        }
        return minim;
    }

    public int pop() {
        if (isStackEmpty(index))
            throw new EmptyStackException();

        arrayStack[index] = 0;
        --index;
        return arrayStack[index];
    }

    //constant time: O(1)
    public int peek(int index) {
        if (isStackEmpty(index))
            throw new EmptyStackException();
        return arrayStack[index];
    }

    public boolean isStackEmpty(int index) {
        if (index == -1)
            arrayStack[index++] = 0;
        else
            arrayStack[index] = 0;
        return arrayStack[index] != 0;
    }

    public boolean isStackFull(int size) {
        if (arrayStack.length > index)
            return false;
        return true;

    }

    public static void main(String[] args) {
        StackArrayMin stackArray = new StackArrayMin(5);
        stackArray.push(5);
        System.out.println("Min for top: "+ stackArray.minim);
        stackArray.push(6);
        System.out.println("Min for top: "+ stackArray.minim);
        stackArray.push(3);
        System.out.println("Min for top: "+ stackArray.minim);
        stackArray.push(7);
        System.out.println("Min for top: "+ stackArray.minim);
        stackArray.push(8);
        System.out.println("Min for top: "+ stackArray.minim);
        stackArray.printStackArray();
        System.out.println("");
        stackArray.peek(stackArray.index);
        stackArray.pop();
        stackArray.pop();
        stackArray.printStackArray();
    }

    public void printStackArray() {
        for (int i = 0; i < arrayStack.length; i++) {
            System.out.print(arrayStack[i] + " ");
        }
    }

}
