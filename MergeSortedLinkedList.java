public class MergeSortedLinkedList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }
    Node head;

    public void insertAtEnd(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
        }else{
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;

            }
            temp.next=newNode;
        }
    }

    public void display(){
        if(head==null){
            System.out.println("List is empty ");
        }else{
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data + " -> ");
                temp=temp.next;

            }
            System.out.println(" ");
        }

    }

    public static Node mergeLinkList(Node head1, Node head2){
        if(head1==null){
            return head2;
        }

        if(head2==null){
            return head1;
        }

        Node mergedHead = null;
        Node mergedTail = null;

        if(head1.data < head2.data){
            mergedHead = head1;
            head1 = head1.next;
        }else{
            mergedHead = head2;
            head2 = head2.next;
        }
        mergedTail = mergedHead;

        while(head1 != null && head2 != null){
            if(head1.data < head2.data){
                mergedTail.next = head1;
                head1 = head1.next;
            }else{
                mergedTail.next = head2;
                head2 = head2.next;
            }
            mergedTail = mergedTail.next;
        }

        if(head1 != null){
            mergedTail.next = head1;
        }else{
            mergedTail.next = head2;
        }

        return mergedHead;

    }

    public static void main(String[] args) {
        MergeSortedLinkedList list1 = new MergeSortedLinkedList();
        list1.insertAtEnd(1);
        list1.insertAtEnd(3);
        list1.insertAtEnd(5);

        MergeSortedLinkedList list2 = new MergeSortedLinkedList();
        list2.insertAtEnd(2);
        list2.insertAtEnd(4);
        list2.insertAtEnd(6);

        System.out.println("List 1:");
        list1.display();

        System.out.println("List 2:");
        list2.display();

        Node mergedHead = mergeLinkList(list1.head, list2.head);
        System.out.println("Merged Sorted Linked List:");
        Node temp = mergedHead;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
