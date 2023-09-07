package modules.recursive;

public class SortModule {

    private static int[] getFirstHalf(int[] data) {
        int size = data.length / 2;
        int[] firstHalf = new int[size];
        System.arraycopy(data, 0, firstHalf, 0, size);
        return firstHalf;
    }

    private static int[] getSecondHalf(int[] data) {
        int size = data.length - data.length / 2;
        int[] secondHalf = new int[size];
        System.arraycopy(data, data.length / 2, secondHalf, 0, size);
        return secondHalf;
    }

    private static void merge(int[] data, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                data[k++] = left[i++];
            } else {
                data[k++] = right[j++];
            }
        }
        while (i < left.length) {
            data[k++] = left[i++];
        }
        while (j < right.length) {
            data[k++] = right[j++];
        }
    }

    public static void mergeSort(int[] data) {
        if (data.length <= 1) {
            return;
        }

        int[] left = getFirstHalf(data);
        int[] right = getSecondHalf(data);

        mergeSort(left);
        mergeSort(right);

        merge(data, left, right);
    }

    private static int partition(int[] data, int low, int high) {
        int pivot = data[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (data[j] < pivot) {
                i++;
                swap(data, i, j);
            }
        }
        swap(data, i + 1, high);
        return i + 1;
    }

    public static void quickSort(int[] data) {
        quickSort(data, 0, data.length - 1);
    }

    private static void quickSort(int[] data, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(data, low, high);
            quickSort(data, low, pivotIndex - 1);
            quickSort(data, pivotIndex + 1, high);
        }
    }

    public static void selectionSort(int[] data) {
        selectionSort(data, 0);
    }

    private static void selectionSort(int[] data, int start) {
        int minIndex;
        if (start < data.length - 1) {
            minIndex = start;
            for (int i = start + 1; i < data.length; i++) {
                if (data[i] < data[minIndex]) {
                    minIndex = i;
                }
            }
            swap(data, start, minIndex);
            selectionSort(data, start + 1);
        }
    }

    public static void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
}
