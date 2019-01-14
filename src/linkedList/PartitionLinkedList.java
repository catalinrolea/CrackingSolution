package linkedList;

public class PartitionLinkedList {
    Node head;

    void append(int data) {
        Node new_node = null;
        if (head == null) {
            head = new Node(data);
        } else {
            new_node = new Node(data);
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = new_node;

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


    Node partitionLinkedList(Node myNode, int x)    {
        Node headList = myNode;
        Node tailList = myNode;
        while (myNode != null)  {
            Node next = myNode.next;
            if (myNode.data < x)    {
                //add to head
                 myNode.next = headList;
                headList = myNode;
            }
            else {
                //add to tail
                tailList.next = myNode;
                tailList = myNode;
            }
            myNode = next;
        }
        tailList.next = null;


        return headList;
    }

    public static void main(String[] args)  {
        PartitionLinkedList linkedList = new PartitionLinkedList();
        linkedList.append(3);
        linkedList.append(5);
        linkedList.append(8);
        linkedList.append(5);
        linkedList.append(10);
        linkedList.append(2);
        linkedList.append(1);
        linkedList.head = linkedList.partitionLinkedList(linkedList.head,5);
        linkedList.printLinkedList();
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
