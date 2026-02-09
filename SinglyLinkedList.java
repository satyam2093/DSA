public class SinglyLinkedList {
    // Node class
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;
    // Insert At Beginning

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }
    // Insert At End

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;

        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;

    }

    // Insert At Position
    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position is not in range");
            return;
        }
        newNode.next = temp.next;

        temp.next = newNode;

    }
    // Delete from Beginning

    public void deleteFromBeginning() {
        Node temp = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
        int data = temp.data;
        temp.next = null;
        System.out.println("The head data has been removed =" + data);

    }
    // Delete from end

    public void deleteFromEnd() {
        Node temp = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == null) {
            int data = head.data;
            head = null;
            System.out.println("The head data has been removed as it has only one element=" + data);
            return;
        }

        while (temp.next.next != null) {
            temp = temp.next;
        }
        int data = temp.next.data;
        temp.next = null;
        System.out.println("The end data which is removed is =" + data);
    }

    // Delete from position
    public void deleteFromPosition(int position) {
        Node temp = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
          if (position == 1) {
            int data = head.data;
            head = head.next;
            System.out.println("Deleted from position " + position + ": " + data);
            return;
        }


        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            System.out.println("Position not in range");
            return;
        }
        int data = temp.next.data;
        temp.next = temp.next.next;
        System.out.println("The data deleted from position " + position + "is" + data);

    }
    // Display

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedList List = new SinglyLinkedList();
        List.insertAtBeginning(5);
        List.display();
        List.insertAtBeginning(10);
        List.display();
        List.insertAtBeginning(20);
        List.display();
        List.insertAtBeginning(30);
        List.display();
        List.insertAtEnd(45);

        List.display();
        List.insertAtEnd(60);

        List.display();
        List.insertAtEnd(90);

        List.display();
        List.insertAtPosition(120, 5);
        List.display();
        List.insertAtPosition(99, 8);

        List.display();
        List.deleteFromBeginning();

        List.display();
        List.deleteFromEnd();

        List.display();
        List.deleteFromPosition(6);
        List.display();
    }
}
