import java.util.Scanner;

public class AutomobileBST {

    static class Node {
        int year;
        String type, company;
        Node left, right;

        Node(int year, String type, String company) {
            this.year = year;
            this.type = type;
            this.company = company;
        }
    }

    Node root;
    Scanner sc = new Scanner(System.in);

    Node insert(Node root, int year, String type, String company) {

        if (root == null) {
            return new Node(year, type, company);
        }

        if (year < root.year) {
            root.left = insert(root.left, year, type, company);
        } else {
            root.right = insert(root.right, year, type, company);
        }

        return root;
    }

    Node delete(Node root, int year) {

        if (root == null) {
            return null;
        }

        if (year < root.year) {
            root.left = delete(root.left, year);
        } else if (year > root.year) {
            root.right = delete(root.right, year);
        } else {

            if (root.left == null)
                return root.right;

            if (root.right == null)
                return root.left;

            Node temp = minValue(root.right);

            root.year = temp.year;
            root.type = temp.type;
            root.company = temp.company;

            root.right = delete(root.right, temp.year);
        }

        return root;
    }

    Node minValue(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.year + " " + root.type + " " + root.company);
            inorder(root.right);
        }
    }

    void preorder(Node root) {
        if (root != null) {
            System.out.println(root.year + " " + root.type + " " + root.company);
            preorder(root.left);
            preorder(root.right);
        }
    }

    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.year + " " + root.type + " " + root.company);
        }
    }

    public static void main(String[] args) {

        AutomobileBST tree = new AutomobileBST();

        tree.root = tree.insert(tree.root, 2020, "SUV", "Toyota");
        tree.root = tree.insert(tree.root, 2018, "Sedan", "Honda");
        tree.root = tree.insert(tree.root, 2022, "Hatchback", "Hyundai");
        tree.root = tree.insert(tree.root, 2019, "Truck", "Tata");

        System.out.println("Inorder Traversal:");
        tree.inorder(tree.root);

        System.out.println("\nPreorder Traversal:");
        tree.preorder(tree.root);

        System.out.println("\nPostorder Traversal:");
        tree.postorder(tree.root);

        tree.root = tree.delete(tree.root, 2018);

        System.out.println("\nAfter Deletion:");
        tree.inorder(tree.root);
    }
}