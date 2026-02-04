public class ArrayAsList {
    int size;
    int[] array;
    int index;

    public ArrayAsList(int capacity) {
        this.array = new int[capacity];
        this.index = 0;
        this.size = capacity;
    }

    public void insertAtEnd(int value) {
        if (index == size - 1) {
            System.err.println("Array is full");

        } else {
            array[index++] = value;
        }
    }

    public void insertAtBeginning(int value) {
        if (index == size - 1) {
            System.out.println("Array is full");

        } else {
            for (int i = index; i > 0; i--) {
                array[i] = array[i - 1];
            }
            array[0] = value;
            index++;
        }
    }

    public void insertAtPosition(int position, int value) {
        if (index == size - 1) {
            System.out.println("Array is full");
        } else if (position < 0 || position > index) {
            System.out.println("Invalid position");
        } else {
            for (int i = index; i > position; i--) {
                array[i] = array[i - 1];
            }
            array[position] = value;
            index++;
        }

    }

    public void display() {
        for (int i = 0; i < index; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

    }
    public static void main(String[] args) {
        ArrayAsList arrayAsList = new ArrayAsList(5);
        arrayAsList.insertAtEnd(10);
        arrayAsList.insertAtEnd(20);
        arrayAsList.insertAtBeginning(5);
        arrayAsList.insertAtPosition(1, 15);
        arrayAsList.display(); // Output: 5 15 10 20
    }
}
