public class BinarySearch {
        int size;
    int[] arr;
    int index;

    public BinarySearch(int capacity){
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
    public void sort(){
        for(int i=0;i<index-1;i++){
            for(int j=0;j<index-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    public void sortedBinarySearch(int key){
        int low=0;
        int high=index-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==key){
                System.out.println("Found at index "+ mid);
                return;
            }else if(arr[mid]>key){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        System.out.println("Not found");
    }

    public static void main(String[] args) {
        BinarySearch array=new BinarySearch(10);
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
        array.sort();
        System.out.println("After sorting");
        array.display();
        array.sortedBinarySearch(23);
    }
    
}
