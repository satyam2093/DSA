public class AVLTreeAutomobile {

    static class Node {
        int year, height;
        String type, company;
        Node left, right;

        Node(int year, String type, String company) {
            this.year = year;
            this.type = type;
            this.company = company;
            height = 1;
        }
    }

    Node root;

    int height(Node n) {
        if (n == null)
            return 0;
        return n.height;
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    int getBalance(Node n) {
        if (n == null)
            return 0;
        return height(n.left) - height(n.right);
    }

    Node rightRotate(Node y) {

        Node x = y.left;
        Node t2 = x.right;

        x.right = y;
        y.left = t2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    Node leftRotate(Node x) {

        Node y = x.right;
        Node t2 = y.left;

        y.left = x;
        x.right = t2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    Node insert(Node node, int year, String type, String company) {

        if (node == null)
            return new Node(year, type, company);

        if (year < node.year)
            node.left = insert(node.left, year, type, company);

        else if (year > node.year)
            node.right = insert(node.right, year, type, company);

        else
            return node;

        node.height = 1 + max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && year < node.left.year)
            return rightRotate(node);

        if (balance < -1 && year > node.right.year)
            return leftRotate(node);

        if (balance > 1 && year > node.left.year) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && year < node.right.year) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    Node minValue(Node node) {
        Node current = node;

        while (current.left != null)
            current = current.left;

        return current;
    }

    Node delete(Node root, int year) {

        if (root == null)
            return root;

        if (year < root.year)
            root.left = delete(root.left, year);

        else if (year > root.year)
            root.right = delete(root.right, year);

        else {

            if ((root.left == null) || (root.right == null)) {

                Node temp;

                if (root.left != null)
                    temp = root.left;
                else
                    temp = root.right;

                if (temp == null) {
                    root = null;
                } else {
                    root = temp;
                }

            } else {

                Node temp = minValue(root.right);

                root.year = temp.year;
                root.type = temp.type;
                root.company = temp.company;

                root.right = delete(root.right, temp.year);
            }
        }

        if (root == null)
            return root;

        root.height = max(height(root.left), height(root.right)) + 1;

        int balance = getBalance(root);

        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
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

        AVLTreeAutomobile tree = new AVLTreeAutomobile();

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