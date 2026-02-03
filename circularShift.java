public class circularShift {

    static int countRotations(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;

        while (low <= high) {

            // If array is already sorted
            if (arr[low] <= arr[high]) {
                return low;
            }

            int mid = low + (high - low) / 2;
            int next = (mid + 1) % n;
            int prev = (mid - 1 + n) % n;

            // Check if mid is minimum
            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]) {
                return mid;
            }

            // Left part sorted, go right
            if (arr[low] <= arr[mid]) {
                low = mid + 1;
            }
            // Right part sorted, go left
            else {
                high = mid - 1;
            }
        }

        return 0;
    }

    // Shift array to the nth position (circular rotation)
    static void shiftArray(int[] arr, int n) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int len = arr.length;
        n = n % len; // Handle n greater than array length

        // Reverse the entire array
        reverse(arr, 0, len - 1);
        // Reverse first n elements
        reverse(arr, 0, n - 1);
        // Reverse remaining elements
        reverse(arr, n, len - 1);
    }

    // Helper method to reverse array from start to end index
    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Print array utility
    static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {15, 18, 2, 3, 6, 12};

        int rotations = countRotations(arr);
        System.out.println("Number of rotations = " + rotations);

        // Test circular shift
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.print("\nOriginal array: ");
        printArray(arr2);

        int shiftPosition = 2;
        shiftArray(arr2, shiftPosition);
        System.out.print("After shifting by " + shiftPosition + " positions: ");
        printArray(arr2);
    }
}