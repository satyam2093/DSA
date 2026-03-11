import java.util.LinkedList;
import java.util.Queue;

class BinaryTree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    BinaryTree() {
        this.root = null;
    }

    // Insert method (Level Order)
    public void insert(int data) {
        Node newNode = new Node(data);

        if (root == null) {
            root = newNode;
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if (temp.left == null) {
                temp.left = newNode;
                return;
            } else {
                queue.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = newNode;
                return;
            } else {
                queue.add(temp.right);
            }
        }
    }

    // Inorder Traversal
    public void inorder(Node node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    // Preorder Traversal
    public void preorder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    // Postorder Traversal
    public void postorder(Node node) {
        if (node == null) {
            return;
        }

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    public void insertintoBinaryTree(int data) {
        insert(data);
    }

    public void displayInorder() {
        inorder(root);
    }

    public void displayPreorder() {
        preorder(root);
    }

    public void displayPostorder() {
        postorder(root);
    }

    // Main Method
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

        tree.insertintoBinaryTree(1);
        tree.insertintoBinaryTree(2);
        tree.insertintoBinaryTree(3);
        tree.insertintoBinaryTree(4);
        tree.insertintoBinaryTree(5);

        System.out.println("Inorder Traversal:");
        tree.displayInorder();

        System.out.println("\nPreorder Traversal:");
        tree.displayPreorder();

        System.out.println("\nPostorder Traversal:");
        tree.displayPostorder();
    }
}