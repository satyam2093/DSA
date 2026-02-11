public class SimpleQueueLinkedList {
    Node front, rear;
//Node clas
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public SimpleQueueLinkedList() {
        front = rear = null;

    }
// empty 
    boolean isEmpty() {
        return front == null;
    }
// enqueue mein insertion at end hoga mtlb linked list ke last element mein jorna
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next=newNode;
            rear = newNode;
        }
    }
// dequeue krna h matlab linked list ke first se data nikalna delete from head
    public void dequeue() {
        if (isEmpty()) {
            rear = null;
            System.out.println("Queue is empty");
           
        } else {
            Node temp = front;
            int data = temp.data;
            System.out.println("the dequeued data is -> " + data);
            front = front.next;
        }

    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue empty");
        } else {
            Node temp = front;
            while (temp != null) {
                System.out.println(temp.data);
                System.out.println("|");
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) {
        SimpleQueueLinkedList sqll = new SimpleQueueLinkedList();
        sqll.enqueue(5);
        sqll.enqueue(15);
        sqll.enqueue(25);
        sqll.enqueue(35);
        sqll.display();
        sqll.dequeue();
        sqll.display();

    }

}
