package linkedList;

import org.junit.Test;

public class SumList {
    private Node head;

    void printLinkedList() {
        System.out.println("*** List ***");
        if (head == null)
            return;
        Node last = head;
        while (last != null) {
            System.out.print(last.data + " ");
            last = last.next;
        }
    }

    void append(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = new Node(data);
            return;
        } else {
            new_node = new Node(data);
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        //add node at the end
        last.next = new_node;
    }

    Node sumOfTwoList(Node list1, Node list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        Node lastList1 = list1;
        Node lastList2 = list2;

        int sumTemp = 0;
        int totalSum = 0;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        Node tailOfLast = null;
        Node sumOfListNodes = null;
        while (lastList1 != null) {
            while (lastList2 != null) {
                sumTemp = lastList1.data + lastList2.data;
                sb1.append(lastList1.data);
                sb2.append(lastList2.data);
                lastList2 = lastList2.next;
                break;
            }
            lastList1 = lastList1.next;
        }

        totalSum = Integer.valueOf(sb1.toString()) + Integer.valueOf(sb2.toString());
        String finalSum = String.valueOf(totalSum);
        int parseCharToInt = 0;
        for (int i = 0; i < finalSum.length(); i++) {
            //create a new node
            parseCharToInt = Character.getNumericValue(finalSum.charAt(i));
            Node new_node = new Node(Integer.valueOf(parseCharToInt));
            if (sumOfListNodes == null) {
                //populate the head with first resulted sum
                sumOfListNodes = new_node;
                //create a null Node and store the tail
                tailOfLast = new_node;
            } else {
                //if i add another node => make the link between current node and next node from memory
                tailOfLast.next = new_node;
            }

            //set the tail to be last node
            //if NOT, THE LAST ELEMENT WILL ALWAYS BE THE SECOND
            tailOfLast = new_node;
        }

        return sumOfListNodes;
    }

    Node reverseLinkedList(Node list1) {
        Node lastList1 = list1;

        Node head = null;
        Node tail = null;

        while (lastList1 != null) {
            Node new_node = new Node(lastList1.data);
            if (head == null) {
                head = new_node;
            } else {
                new_node.next = head;
            }
            head = new_node;

            lastList1 = lastList1.next;
        }
        return head;
    }

    @Test
    public void testSumListOfLinkedList() {
        SumList linkedList1 = new SumList();
        SumList linkedList2 = new SumList();
        SumList linkedList3 = new SumList();
        linkedList1.append(7);
        linkedList1.append(1);
        linkedList1.append(6);
        linkedList2.append(5);
        linkedList2.append(9);
        linkedList2.append(2);

        linkedList1.head = linkedList1.reverseLinkedList(linkedList1.head);
        linkedList2.head = linkedList2.reverseLinkedList(linkedList2.head);
        linkedList1.printLinkedList();
        System.out.println("");
        linkedList2.printLinkedList();
        System.out.println("");
        //initialize the head with the sum of both linkedlist
        linkedList3.head = linkedList3.sumOfTwoList(linkedList1.head, linkedList2.head);
        linkedList3.printLinkedList();
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
