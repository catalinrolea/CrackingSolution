package stack;
/*
Stack abstract data type implementation on array
Operations: push(T item) => add an element at top of stack
            pop()        => remove the top element
            peek()       => return top of stack
            isEmpty()    => return true if stack is empty
 */

import java.util.EmptyStackException;

public class ThreeInOneStacksUsingArray {

    private int stackCapacity;
    private int numberOfStacks = 3;
    private int[] arrSizesStacks;
    private int[] arrValuesStack;
    //each stack in the array should contain stackSize elements[10,0,0,11,0,0,22,0,0]
    public ThreeInOneStacksUsingArray(int stackSize) {
        stackCapacity = stackSize;
        arrValuesStack = new int[stackSize * numberOfStacks];
        arrSizesStacks = new int[numberOfStacks];

    }

    public void push(int index,int element) {
        if (isFull(index))  {
            return;
        }

        arrSizesStacks[index]++;
        arrValuesStack[topIndexOfStack(index)] = element;
    }

    public int pop(int index)   {
        if (isFull(index))  {
            throw new EmptyStackException();
        }
        int topIndex = topIndexOfStack(index);
        int value = arrValuesStack[topIndex];
        arrValuesStack[topIndex] = 0;
        arrSizesStacks[index]--;
        return value;
    }

    public int peek(int index)  {
        return arrValuesStack[index];
    }
    //get index from each top stack
     public int topIndexOfStack(int element)    {
        int offset = element * stackCapacity;
        int size = arrSizesStacks[element];
        return offset + size - 1;
    }

    public boolean isEmpty(int index)    {
        return arrSizesStacks[index] ==0;
    }
    public boolean isFull(int index)    {
        return arrSizesStacks[index] == stackCapacity;
    }

    public static void main(String[] args)  {
        ThreeInOneStacksUsingArray arrayStack = new ThreeInOneStacksUsingArray(3);
        arrayStack.push(0,11);
        arrayStack.push(0,333);
        arrayStack.push(1,22);
        arrayStack.push(2,33);

    }

}
