public class LinearSearch {
    int size;
    int[] arr;
    int index;

    public LinearSearch(int capacity){
        this.size=capacity;
        this.index=0;
        this.arr=new int[capacity];
    }

    public void insertAtEnd(int data){
       
            if(index==size-1){
                System.out.println("It is full");
           
            }else{
                 arr[index++]=data;
            }
        }
    

    public void display(){
        for(int i=0;i<index-1;i++){
            System.out.print(arr[i]+ " ");
           
            }
            System.out.println(" ");
        }

    public void Linear_search(int key){
        for(int i=0;i<index-1;i++){
            if(arr[i]==key){
                System.out.println("Found at index "+ i );
               

            }
             
         
        }

    }

    public static void main(String[] args) {
        LinearSearch array=new LinearSearch(10);
        array.insertAtEnd(5);
        array.insertAtEnd(7);
        array.insertAtEnd(30);
        array.insertAtEnd(23);
        array.insertAtEnd(13);
        array.insertAtEnd(43);
        array.insertAtEnd(93);
        array.insertAtEnd(33);
        array.insertAtEnd(83);
        array.display();
        array.Linear_search(23);

        

        
    }
}
   

