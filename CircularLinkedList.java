public class CircularLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    // Insert at Beginning
    public void insertAtBegin(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            newNode.next = newNode;
            head = newNode;
        } else {
            Node temp = head;

            // Move to last node
            while (temp.next != head) {
                temp = temp.next;
            }

            newNode.next = head;
            temp.next = newNode;
            head = newNode;
        }
    }

    // Insert at End
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            newNode.next = newNode;
            head = newNode;
        } else {
            Node temp = head;

            while (temp.next != head) {
                temp = temp.next;
            }

            temp.next = newNode;
            newNode.next = head;
        }
    }

    // Insert at Position (1-based indexing)
    public void insertAtPosition(int data, int position) {
        if (position <= 0) {
            System.out.println("Invalid position");
            return;
        }

        // If inserting at position 1
        if (position == 1) {
            insertAtBegin(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        // Move to node before desired position
        for (int i = 1; i < position - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        // If position is beyond list length
        if (temp.next == head && position > 2) {
            System.out.println("Invalid position");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Display List
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);

        System.out.println();
    }

    // Main Method
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();

        cll.insertAtBegin(25);
        cll.insertAtBegin(95);
        cll.insertAtBegin(65);

        cll.insertAtEnd(85);
        cll.insertAtEnd(25);

        cll.insertAtPosition(5, 2);

        cll.display();
    }
}
