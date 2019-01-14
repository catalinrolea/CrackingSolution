package linkedList;

public class LoopDetection {
    private Node head;

    public   Node recursiveDisplay(Node node) {
        if (node == null)
            return null;
        System.out.print(node.data + " ");
        return recursiveDisplay(node.next);
    }

    void append(String data) {
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

    static class Node {
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
        }
    }

    Node getLoopDetection(Node node)    {
        if (node == null)   {
            return null;
        }
        Node current = null;
        Node last = node;
        while (last != null)    {
            current = last;

            if (checkIfLoopEqual(last, current))    {
                last.next = null;
                return last;
            }
           last = last.next;
        }
        return null;
    }
    boolean checkIfLoopEqual(Node last, Node current)  {
        boolean flag = false;
        if (last == null && current == null)    {
            return false;
        }
        while (current.next!= null) {
            if (current.next.data == last.data) {
                flag = true;
            }
            current = current.next;
        }
        return flag;
    }

    public static void main(String[] args) {
        LoopDetection linkedList = new LoopDetection();
        linkedList.append("A");
        linkedList.append("B");
        linkedList.append("C");
        linkedList.append("D");
        linkedList.append("E");
        linkedList.append("D");
       // linkedList.recursiveDisplay(linkedList.head);
        Node loop = null;
        loop = linkedList.getLoopDetection(linkedList.head);
        linkedList.recursiveDisplay(loop);

    }
}
