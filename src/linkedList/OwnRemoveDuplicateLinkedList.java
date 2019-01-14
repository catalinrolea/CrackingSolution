package linkedList;

import org.junit.Test;

public class OwnRemoveDuplicateLinkedList {
    private Node head;

    public void appendAtTheEndLinkedList(String data) {
        Node new_node = new Node(data);
        if (head == null) {
            new_node = head;
            return;
        }
        //link the node to others
        new_node.next = null;
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = new_node;

    }

    public void removeDuplicates()  {
        if (head == null)
            return;
        Node last = head;
        while (last != null)    {
            System.out.println("beginning last: " + last.data);
            //assign the same objects fom stack of last to current
            // current.next(Node@793) = last.next(Node793)
            //if something is happenning to current, will modifi last
            Node current = last;
            System.out.println("beginning current: " + current.data);
            while (current.next != null)    {
                if (current.next.data == last.data) {
                    current.next = current.next.next;
                }
                else {
                    current = current.next;


                }
            }
            System.out.println(last.data);
            last = last.next;
        }


    }

    @Test
    public void testRemoveDups() {
        OwnRemoveDuplicateLinkedList linkedList = new OwnRemoveDuplicateLinkedList();
        linkedList.head = new Node("F");
        linkedList.appendAtTheEndLinkedList("O");
        linkedList.appendAtTheEndLinkedList("L");
        linkedList.appendAtTheEndLinkedList("L");
       /* linkedList.appendAtTheEndLinkedList("O");
        linkedList.appendAtTheEndLinkedList("W");
        linkedList.appendAtTheEndLinkedList(" ");
        linkedList.appendAtTheEndLinkedList("U");
        linkedList.appendAtTheEndLinkedList("P");*/
        linkedList.removeDuplicates();
    }

    static class Node {
        Node next;
        String data;

        public Node(String data) {
            this.data = data;
        }
    }
}
