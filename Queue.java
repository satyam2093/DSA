import java.util.Scanner;

public class Queue {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node front = null;
    Node rear = null;

    Scanner sc = new Scanner(System.in);

    void insert() {
        System.out.print("Enter value to insert: ");
        int val = sc.nextInt();

        Node newNode = new Node(val);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        System.out.println(val + " inserted into queue.");
    }

    void delete() {
        if (front == null) {
            System.out.println("Queue Underflow!");
            return;
        }

        System.out.println("Deleted: " + front.data);
        front = front.next;

        if (front == null) {
            rear = null;
        }
    }

    void display() {
        if (front == null) {
            System.out.println("Queue is empty.");
            return;
        }

        Node temp = front;

        System.out.print("Queue Elements: ");

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Queue queue = new Queue();
        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n1.Insert 2.Delete 3.Display 4.Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    queue.insert();
                    break;

                case 2:
                    queue.delete();
                    break;

                case 3:
                    queue.display();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);
    }
}