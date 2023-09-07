package modules.iterative;

/****************************************************************
 * This module implements modules iterative algorithms for array
 * data structures with integer precision.
 ****************************************************************/

public class SortModule {

    //TODO: Update/Complete the following bubbleSort algorithm
    //      using for loops and swap method (see below)
    public static void bubbleSort(int[] data) {

        for(int i = 0; i< data.length;i++){
            for (int j = 0; j<data.length;j++){
                if(data[i] < data[j]){
                    swap(data,i,j);
                }
            }
        }
    }


    //TODO: Update/Complete the following insertionSort algorithm
    //      using for loops
    public static void insertionSort(int[] data) {
        int n = data.length;
        for (int i = 1; i < n; i++) {
            int key = data[i];
            int j = i - 1;


            while (j >= 0 && data[j] > key) {
                data[j + 1] = data[j];
                j--;
            }

            data[j + 1] = key;
        }
    }



    // This is an example of "finding the run time function"
    // for a maximum value algorithm
    public static int max(int[] data){
        int n   = data.length;          // (1)      data size
        int max = data[0];              // (1)

        //       (1)
        for(int i = 0; i < n; i++)     // n times
            // (1  + 1)
            if(max < data[i])               // (1)
                max = data[i];              // (1)
        // (1)      terminates loop
        return max;                     // (1)

        // run time function f(n) = 1 + 1 + 1 + n(2 + 1 + 1)
        //                   f(n) = 4n + 5
    }


    //TODO: Update/Complete the following selectionSort algorithm
    //      using for loops and swap method (see below)
    public static void selectionSort(int[] data) {
        int n = data.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;


            for (int j = i + 1; j < n; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }


            int temp = data[minIndex];
            data[minIndex] = data[i];
            data[i] = temp;
        }
    }



    //TODO: Update/Complete the following swap method
    public static void swap(int[] data, int a, int b) {

        int temp = data[a];
        data[a] = data[b];
        data[b]= temp;
    }
}
