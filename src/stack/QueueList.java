package stack;

import java.util.NoSuchElementException;
import java.util.Queue;

/*   LIFO
     add() - add at last of the queue
     remove() - remove from top of the queue
     peek() - return top of the queue
      */
//@Implementation queue: linkedList
public class QueueList<T> {
    private QueueNode<T> first;
    private QueueNode<T> last;

    private static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }
    }

    public void add(T item) {
        QueueNode<T> new_node = new QueueNode<>(item);
        if (last != null)
            last.next = new_node;
        last = new_node;
        if (first == null)
            first = last;
    }
    public T remove()   {
        if (first == null)
            throw new NoSuchElementException();
        T data = first.data;
        first = first.next;
        return data;
    }
    public QueueNode<T> printQueue(QueueNode node)    {
        if (node == null)
            return null;
        System.out.print(node.data + " ");
        return printQueue(node.next );
    }

    public T peek() {
        if (first == null)
            throw new NoSuchElementException();
        return first.data;
    }
    public static void main(String[] args)  {
        QueueList<Integer> queueList = new QueueList<>();
        queueList.add(1);
        queueList.add(2);
        queueList.add(3);
        queueList.add(4);
        System.out.println("Remote top of Queue: " );
        System.out.println(queueList.remove());
        System.out.println("Print the queue: " );
        queueList.printQueue(queueList.first);
        System.out.println();
        System.out.println("Peek top of the queue: " + queueList.peek());
    }
}
