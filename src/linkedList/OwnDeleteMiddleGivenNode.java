package linkedList;

import org.junit.Test;

public class OwnDeleteMiddleGivenNode {
    private Node head;


    void append(String data) {
        Node new_node = new Node(data);
        if (head == null) {
            new_node = new Node(data);
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = new_node;
    }

    OwnDeleteMiddleGivenNode deleteMiddleAtGivenNode(String data) {
        if (head == null)
            return null;
        OwnDeleteMiddleGivenNode linkedListDelete = new OwnDeleteMiddleGivenNode();
        Node new_node = new Node(data);
        Node last = head;
        while (last != null) {
            if (last.data == new_node.data) {
                last = last.next;
            }
            if (linkedListDelete.head == null) {
                linkedListDelete.head = new Node(last.data);
            } else {
                linkedListDelete.append(last.data);
            }
            last = last.next;
        }
        return linkedListDelete;
    }

    void printLinkedList() {
        if (head == null)
            return;
        Node last = head;
        while (last != null) {
            System.out.print(last.data + " ");
            last = last.next;
        }

    }


    @Test
    public void testDeleteMiddleNode() {
        OwnDeleteMiddleGivenNode linkedList = new OwnDeleteMiddleGivenNode();

        linkedList.head = new Node("a");
        linkedList.append("b");
        linkedList.append("c");
        linkedList.append("d");
        linkedList.append("e");
        linkedList.append("f");

        linkedList = linkedList.deleteMiddleAtGivenNode("c");
        linkedList.printLinkedList();


    }

    static class Node {
        Node next;
        String data;

        public Node(String data) {
            this.data = data;
        }
    }
}
