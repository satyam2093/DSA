public class ArrayAsList {
    int size;
    int[] array;
    int index;

    // array constructor
    public ArrayAsList(int capacity) {
        this.array = new int[capacity];
        this.index = 0;
        this.size = capacity;
    }

    // Insert at end
    public void insertAtEnd(int value) {
        if (index == size - 1) {
            System.err.println("Array is full");

        } else {
            array[index++] = value;
        }
    }

    // Insert at begin
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
    // insert at position

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

    // insert delete from beginning

    public void deleteFromBeginning() {
        if (index == 0) {
            System.out.println("Array is empty");
        } else {
            int data = array[0];
            for (int i = 0; i < index - 1; i++) {
                array[i] = array[i + 1];
            }
            System.out.println("deleted data -> " + data);
            index--;
        }
    }

    // delete from end
    public void deleteFromEnd() {
        if (index == 0) {
            System.out.println("Array is empty");
        } else {
            index--;
        }
    }

    // delete from position
    public void deleteFromPosition(int position) {
        if (index == 0) {
            System.out.println("Array is empty");

        } else if (position < 0 || position >= index) {
            System.out.println("Invalid position ");
        } else {
            for (int i = position - 1; i < index - 1; i++) {
                array[i] = array[i + 1];
            }
            index--;
        }
    }

    // display function
    public void display() {
        for (int i = 0; i < index; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

    }

    // main function
    public static void main(String[] args) {
        ArrayAsList arrayAsList = new ArrayAsList(20);
        arrayAsList.insertAtEnd(10);
        arrayAsList.insertAtEnd(20);
        arrayAsList.insertAtEnd(120);
        arrayAsList.insertAtEnd(260);
        arrayAsList.insertAtEnd(520);
        arrayAsList.insertAtEnd(230);
        arrayAsList.insertAtEnd(280);
        arrayAsList.insertAtBeginning(5);
        arrayAsList.insertAtPosition(1, 15);
        arrayAsList.display(); // Output: 5 15 10 20
        arrayAsList.deleteFromBeginning();
        arrayAsList.display();
        arrayAsList.deleteFromEnd();
        arrayAsList.display();
        arrayAsList.deleteFromPosition(2);
        arrayAsList.display();

    }
}
