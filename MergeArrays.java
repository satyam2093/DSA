import java.util.Arrays;

public class MergeArrays {
    public static void main(String[] args) {

        int[] a = {1, 9, 3};
        int[] b = {4, 5, 6};

        int[] merged = new int[a.length + b.length];

        int k = 0;

        // copy first array
        for (int i = 0; i < a.length; i++) {
            merged[k++] = a[i];
        }

        // copy second array
        for (int i = 0; i < b.length; i++) {
            merged[k++] = b[i];
        }

        System.out.println("Merged Array: " + Arrays.toString(merged));
    }
}
