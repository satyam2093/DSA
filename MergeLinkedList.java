public class MergeLinkedList {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Merge two UNSORTED lists (concatenate)
    public static Node mergeUnsorted(Node head1, Node head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        Node temp = head1;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head2;  // attach second list

        return head1;
    }

    public static void main(String[] args) {
        MergeLinkedList list1 = new MergeLinkedList();
        list1.insertAtEnd(5);
        list1.insertAtEnd(1);
        list1.insertAtEnd(9);

        MergeLinkedList list2 = new MergeLinkedList();
        list2.insertAtEnd(2);
        list2.insertAtEnd(7);
        list2.insertAtEnd(3);

        Node mergedHead = mergeUnsorted(list1.head, list2.head);

        list1.display(mergedHead);
    }
}
