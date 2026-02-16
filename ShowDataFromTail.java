public class ShowDataFromTail{

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    // Insert at end (helper method)
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

    // 🔥 Method to get node from tail
    public int getNodeFromTail(int positionFromTail) {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }

        Node fast = head;
        Node slow = head;

        // Move fast pointer ahead by positionFromTail
        for (int i = 0; i < positionFromTail; i++) {
            fast = fast.next;
        }

        // Move both pointers together
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow.data;
    }

    // Display list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main method to test
    public static void main(String[] args) {
        ShowDataFromTail list = new ShowDataFromTail();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);

        list.display();

        int pos = 2;
        System.out.println("Node from tail at position " + pos + " = " + list.getNodeFromTail(pos));
    }
}

   

