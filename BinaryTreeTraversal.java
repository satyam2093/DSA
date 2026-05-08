public class BinaryTreeTraversal {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    void display(Node root, int space) {
        if (root == null)
            return;

        space += 5;

        display(root.right, space);

        System.out.println();

        for (int i = 5; i < space; i++)
            System.out.print(" ");

        System.out.println(root.data);

        display(root.left, space);
    }

    public static void main(String[] args) {

        BinaryTreeTraversal tree = new BinaryTreeTraversal();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Tree Structure:");
        tree.display(tree.root, 0);

        System.out.println("\nPreorder:");
        tree.preorder(tree.root);

        System.out.println("\n\nInorder:");
        tree.inorder(tree.root);

        System.out.println("\n\nPostorder:");
        tree.postorder(tree.root);
    }
}