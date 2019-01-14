package linkedList;

public class RemoveDupsLinkedList {
    private Node head;
    static class Node {
        Node next;
        String data;
        public Node(String d)  {
            data = d;
        }
    }
    void appendAtEnd(String data)  {
        Node new_node = new Node(data);
        if (head == null)
            new_node = new Node(data);
        new_node.next = null;
        Node last = head;
        while (last.next != null)   {
            last = last.next;
        }
        new_node = last;
    }
    void printLinkedList()  {
        if (head.next == null)  {
            return;
        }
        Node last = head;
        while (last != null)   {
            System.out.print(last.data);
            last = last.next;
        }
    }
    void removeDupsNode()   {
       if (head == null)
           return;
        Node last = head;
        while (last != null)    {
            Node current = last;

            while (current.next != null)    {
                 if (current.next.data == last.data)    {
                     current.next = current.next.next;
                 } else {
                     current = current.next;
                 }
            }
            System.out.print(last.data);
            last = last.next;
        }

    }
    public static void main(String[] args)  {
        RemoveDupsLinkedList singleLinkedList = new RemoveDupsLinkedList();
        Node one = new Node("F");
        singleLinkedList.head = new Node("F");
        Node second = new Node("F");
        singleLinkedList.head.next = second;
        Node third = new Node("L");
        second.next = third;
        Node four = new Node("L");
        third.next = four;
        Node five = new Node("O");
        four.next = five;
        Node six = new Node("W");
        five.next = six;
        Node seven = new Node(" ");
        six.next = seven;
        Node eight = new Node("U");
        seven.next = eight;
        Node nine = new Node("P");
        eight.next = nine;
        singleLinkedList.removeDupsNode();
       // singleLinkedList.printLinkedList();




    }
}
