package linkedList;

import org.junit.Test;


public class ReturnKthToLast {
     private Node head;

    void append(String data) {
        Node new_node = new Node(data);
        if (head == null) {
            new_node = head;
            return;
        }

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        //next node is new_node
        last.next = new_node;
    }

    public void returnKthToLastElement(int k) {
        if (head == null)
            return;

        Node last = head;
        int count = 0;
        while (last != null) {
            count++;
            last = last.next;
        }
        //reset the node
        Node secondLast = head;
        int length = count - k - 1;
        int index = 0;
        while (secondLast != null  ) {
             if (index == length)   {
                 System.out.println(secondLast.data);
             }
            index++;
            secondLast = secondLast.next;
        }


    }

    @Test
    public void testReturnKthElement() {
        ReturnKthToLast linkedList = new ReturnKthToLast();
        linkedList.head = new Node("A");
        linkedList.append("B");
        linkedList.append("C");
        linkedList.append("D");
        //return first element from end of linkedlist
        linkedList.returnKthToLastElement(0);
    }

    static class Node {
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
        }
    }


}




