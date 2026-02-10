public class DoublyLinkedList {

    // Node class
    static class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;

        }

    }

    Node head = null;

    // Method of inserting a new node at beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;

        }

        head = newNode;
    }

    // Method of inserting a node at the end of the dll
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
            newNode.prev = temp;
        }
    }

    // Insert at specific postiton at the linked list
    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        if (position == 1) {
            if (head != null) {
                newNode.next = head;
                head.prev = newNode;
            }
            head = newNode;
            return;
        }
        Node temp = head;
        for (int i = 1; i < position - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        newNode.prev = temp;
        newNode.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        temp.next = newNode;

    }

    // Delete from the staring of the node
    public void deleteFromBeginning() {

        if (head == null) {
            System.out.println("List is empty;");

        }
        // below commented line is also a way to delete the node from the beginning

        // Node temp = head;
        // int data = temp.data;
        // head = head.next;
        // temp.next.prev = null;
        // temp.next = null;

        int data = head.data;
        head = head.next;
        System.out.println("Deleted data -> " + data);
        if (head != null) {
            head.prev = null;
        }
    }

    // delete the last node of dll
    public void deleteFromEnd() {

        if (head == null) {
            System.out.println("List is empty");
        }
        if (head.next == null) {
            head = null;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        int data = temp.next.data;
        System.out.println("Deleted data -> " + data);
        temp.next = null;
    }

    public void deleteFromPosition(int position) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (position == 1) {
            head = head.next;
            head.prev = null;
            return;
        }
        Node temp = head;
        for (int i = 1; i < position  && temp.next != null; i++) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Positon out of range");
            return;
        }
        int data = temp.data;

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }

        System.out.println("Deleted data -> " + data);

    }

    // Display method
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {

            System.out.print(temp.data + " -> ");
            temp = temp.next;

        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAtBeginning(15);

        dll.insertAtBeginning(10);

        dll.insertAtBeginning(5);
        dll.display();
        dll.insertAtEnd(20);
        dll.display();
        dll.insertAtPosition(35, 1);

        dll.insertAtPosition(45, 2);

        dll.insertAtPosition(95, 6);

        dll.insertAtPosition(85, 10);
        dll.display();
        dll.deleteFromBeginning();
        dll.display();
        dll.deleteFromEnd();
        dll.display();
        dll.deleteFromPosition(5);
        dll.display();
        dll.deleteFromPosition(4);
        dll.display();
    }

}


















