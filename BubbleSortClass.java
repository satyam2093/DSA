// public class BubbleSort {
//     public static void bubbleSort(int[] arr) {
//         int n = arr.length;
//         boolean swapped;
//         for (int i = 0; i < n - 1; i++) {
//             swapped = false;
//             for (int j = 0; j < n - i - 1; j++) {
//                 if (arr[j] > arr[j + 1]) {
//                     // Swap arr[j] and arr[j+1]
//                     int temp = arr[j];
//                     arr[j] = arr[j + 1];
//                     arr[j + 1] = temp;
//                     swapped = true;
//                 }
//             }
//             // If no two elements were swapped, the array is already sorted
//             if (!swapped) {
//                 break;
//             }
//         }
//     }

//     public static void main(String[] args) {
//         int[] arr = {64, 34, 25, 12, 22, 11, 90};
//         bubbleSort(arr);
//         System.out.println("Sorted array: ");
//         for (int num : arr) {
//             System.out.print(num + " ");
//         }
//     }
// }



public class BubbleSortClass{
    int size;
    int[] arr;
    int index;
    public BubbleSortClass(int capacity){
        this.size=capacity;
        this.arr= new int[capacity];
        this.index=0;

    }

    public void insertAtEnd(int data){
        if(index==size-1){
            System.out.println("Array is full");
        }
        else{
            arr[index++]= data;
        }
    }
    public void display(){
        for(int i=0;i<index;i++){
            System.out.print(arr[i]+ " ");
        }
        System.err.println(" ");

    }

    public void bubbleSort(){
        for(int i=0;i<index-1;i++){
            for(int j=0;j<index-i-1;j++){
                if(arr[j]>arr[j+1]){
                int temp=arr[j];

                arr[j]=arr[j+1];
                arr[j+1]=temp;

                }

            }

        }
    }


    public static void main(String[] args){
        BubbleSortClass bb= new BubbleSortClass(10);
        bb.insertAtEnd(25);
        bb.insertAtEnd(265);
        bb.insertAtEnd(205);
        bb.insertAtEnd(125);
        bb.insertAtEnd(225);
        bb.insertAtEnd(295);
        bb.insertAtEnd(251);
        bb.insertAtEnd(254);
        bb.insertAtEnd(256);
        bb.insertAtEnd(285);
        bb.display();
        bb.bubbleSort();
        bb.display();
    }

}