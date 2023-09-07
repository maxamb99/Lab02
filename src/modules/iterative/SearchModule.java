package modules.iterative;

public class SearchModule {

    public static int binarySearch(int[] data, int target) {
        int low = 0;
        int high = data.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (data[mid] == target) {
                return mid;
            } else if (data[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return 0; // Element not found
    }

    public static boolean contains(int[] data, int target) {
        for (int element : data) {
            if (element == target) {
                return true;
            }
        }
        return false;
    }

    public static int indexOf(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return 0; // Element not found
    }
}
