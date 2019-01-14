package linkedList;

public class LinkedListIntersection {
    private Node head;

    public static void main(String[] args) {

        LinkedListIntersection linkedList1 = new LinkedListIntersection();
        LinkedListIntersection linkedList2 = new LinkedListIntersection();
        LinkedListIntersection linkedList3 = new LinkedListIntersection();
        linkedList1.append(3);
        linkedList1.append(1);
        linkedList1.append(5);
        linkedList1.append(9);
        linkedList1.append(7);
        linkedList1.append(2);
        linkedList1.append(1);
        linkedList2.append(4);
        linkedList2.append(6);
        linkedList2.append(7);
        linkedList2.append(2);
        linkedList2.append(1);

        linkedList3.head = linkedList3.findIntersection(linkedList1.head, linkedList2.head);
        Node finalNode = linkedList3.head;
        if (linkedList3.head != null) {
            System.out.println("Intersection find: Common nodes");
            while (finalNode != null) {
                System.out.print(finalNode.data + " ");
                finalNode = finalNode.next;
            }
        } else {
            System.out.println("No common node! Intersection not find");
        }
    }

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

    //extract tail and size for each list
    Result getTailAndSize(Node list) {
        if (list == null)
            return null;
        int size = 1;
        while (list != null) {
            size++;
            list = list.next;
        }
        return new Result(list, size);
    }

    Node findIntersection(Node list1, Node list2) {
        if (list1 == null && list2 == null)
            return null;
        Result resultList1 = getTailAndSize(list1);
        Result resultList2 = getTailAndSize(list2);

        if (resultList1.tail != resultList2.tail) {
            return null; //no intersection
        }
        //take two pointers and traverse the lists
        //since we don't know who the longer list is, exatract it using ? operator
        Node shorter = resultList1.size < resultList2.size ? list1 : list2;
        Node longer = resultList1.size < resultList2.size ? list2 : list1;
        //advance the pointer from longer list by difference in length compared to second list
        longer = getThNode(longer, Math.abs(resultList1.size - resultList2.size));
        while (shorter.data != longer.data) {
            shorter = shorter.next;
            longer = longer.next;
        }

        return longer;

    }

    Node getThNode(Node head, int k) {
        //cut the difference from the longer list according to shorter list
        Node current = head;
        while (current != null && k > 0) {
            current = current.next;
            k--;
        }
        return current;
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    class Result {
        Node tail;
        int size;

        public Result(Node tail, int size) {
            this.tail = tail;
            this.size = size;
        }
    }

}
