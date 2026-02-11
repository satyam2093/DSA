public class StackByLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node top = null;

    public void push(int data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }

    }

    public void pop() {
        if (top == null) {
            System.out.println("stack is empty");
        } else {

            Node temp = top;
            int data = temp.data;
            top = temp.next;
            temp.next = null;
            System.out.println("data which is poped->" + data);
        }

    }

    public void peek() {
        if (top == null) {
            System.out.println("stack is empty");
        } else {
            int data=top.data;
            System.out.println("data which is at peek ->" + data);


        }

    }

    public void display() {
        if (top == null) {
            System.out.println("Stack underflow");

        } else {
            Node temp = top;
            while (temp != null) {
                System.out.println(temp.data);
                System.out.println("|");
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) {
        StackByLinkedList stack = new StackByLinkedList();
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.display();
        stack.pop();
        stack.display();
        stack.peek();
    }
}
