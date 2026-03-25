class BST{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;

        }
    }

    // Insertion of a node in tree
    Node root;
    Node insert(Node root, int data){
        if(root== null){
            return new Node(data);

        }
        if(data<root.data){
            root.left=insert(root.left,data);
        }
        else if(data>root.data){
            root.right=insert(root.right,data);
        }
        return root;
    }

    //Searching 
    boolean Search(Node root, int key ){
        if(root==null){
            return false;
        }
        if(root.data== key ) return true;
        if(key < root.data) return Search(root.left,key);
        return Search(root.right,key );

    }

    // Find Minimum 
    Node findMin(Node root){
        while(root.left!=null){

            root=root.left;
           
        }
         return root;
    }

    //Deletion in BST
    Node delete(Node root, int key ){
        if (root==null){
            return null;

        }
        if(key<root.data){
            root.left=delete(root.left,key);

        }else if (key>root.data){
            root.right=delete(root.right,key );
        }else{
            if(root.left==null&& root.right==null){
                return null;

            }else if(root.left==null){
                return root.right;
            }else if (root.right==null){
                return root.left;
            }else{
                Node successor=findMin(root.right);
                root.data=successor.data;
                root.right=delete(root.right, successor.data);
            }
            
        }
        return root;
    }
    //Inorder Traversal
    void Inorder(Node root){
        if(root!=null){
            Inorder(root.left);
            System.out.print(root.data+ " " );
            Inorder(root.right);
        }
    }
    // Preorder Traversal
    void Preorder(Node root){
        if(root!=null){
            System.out.print(root.data+ " ");
            Preorder(root.left);
            Preorder(root.right);
        }
    }
    //Postorder Traversal
    void Postorder(Node root){
        if(root!=null){
           
            Postorder(root.left);
            Postorder(root.right);
             System.out.print(root.data+" ");
        }
    }

    //Level Order Traversal
    

    public static void main(String[] args){
        BST tree= new BST();
        tree.root = tree.insert(tree.root,50);
        tree.root = tree.insert(tree.root,30);
        tree.root = tree.insert(tree.root,40);
        tree.root = tree.insert(tree.root,20);
        tree.root = tree.insert(tree.root,90);
        tree.root = tree.insert(tree.root,80);
        tree.root = tree.insert(tree.root,99);
        tree.root = tree.insert(tree.root,10);
        tree.Inorder(tree.root);
        System.out.println();
        tree.Preorder(tree.root);
          System.out.println();
        tree.Postorder(tree.root);
        System.out.println();
        tree.root=tree.delete(tree.root,99);
        System.out.println();
        tree.Preorder(tree.root);

}
}


