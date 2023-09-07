package week04$algoanalysis;

public class PerformanceTest {

    public static int[] dataSet(int n) {
        long startTime = System.currentTimeMillis();

        //Just some Tom Foolery I drummed up
        int[] data = new int[n];

        //begin the Tom Foolery
        for (int i = 0; i < n; i++) {
            data[i] =  i + 105;
        }

        long endTime   = System.currentTimeMillis();

        System.out.print("DataSet:  n = " + n + "\t");
        System.out.println("RunTime: " + (endTime - startTime) + " ms");
        return data;
    }

    public static int findRangeAlgo01(int[] data) {
        int diff    = 0;
        int maxDiff = 0;

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                diff = Math.abs(data[j] - data[i]);

                if(maxDiff < diff) {
                    maxDiff = diff;
                }
            }
        }
        return maxDiff;
    }

    public static int findRangeAlgo02(int[] data) {
        int diff    = 0;
        int maxDiff = 0;

        for (int i = 0; i < data.length; i++) {
            for (int j =  i + 1; j < data.length; j++) {
                diff = Math.abs(data[j] - data[i]);

                if(maxDiff < diff) {
                    maxDiff = diff;
                }
            }
        }
        return maxDiff;
    }

    public static int findRangeAlgo03(int[] data) {
        int max = data[0];
        int min = max;

        for (int i = 0; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];

            } else if(data[i]< min){
                min = data[i];
            }
        }
        return max - min;
    }

    public static void intro(){
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
        System.out.println(" \t \t \t \t  W E L C O M E  ");
        System.out.println();
        System.out.println("P E R F O R M A N C E    T E S T    P R O G R A M");
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
    }


    public static void timeAlgoRange01(int[] data) {
        long startTime = System.currentTimeMillis();
        int range      = findRangeAlgo01(data);
        long endTime   = System.currentTimeMillis();
        System.out.print("Range " + range + "\t");
        System.out.print("DataSet:  n = " + data.length + "\t");
        System.out.println("RunTime: " + (endTime - startTime) + " ms");
    }

    public static void timeAlgoRange02(int[] data) {
        long startTime = System.currentTimeMillis();
        int range      = findRangeAlgo02(data);
        long endTime   = System.currentTimeMillis();
        System.out.print("Range " + range + "\t");
        System.out.print("DataSet:  n = " + data.length + "\t");
        System.out.println("RunTime: " + (endTime - startTime) + " ms");
    }

    public static void timeAlgoRange03(int[] data) {
        long startTime = System.currentTimeMillis();
        int range      = findRangeAlgo03(data);
        long endTime   = System.currentTimeMillis();
        System.out.print("Range " + range + "\t");
        System.out.print("DataSet:  n = " + data.length + "\t");
        System.out.println("RunTime: " + (endTime - startTime) + " ms");
    }

    //TODO: Run The Three (3) Algorithms Separately
    public static void main(String[] args) {
        intro();

        System.out.println("Data Set - 1 to 8");
        int[] data1  = dataSet(1000);
        int[] data2  = dataSet(5000);
        int[] data3  = dataSet(10000);
        int[] data4  = dataSet(25000);
        int[] data5  = dataSet(50000);
        int[] data6  = dataSet(75000);
        int[] data7  = dataSet(100000);
        int[] data8  = dataSet(125000);
        int[] data9  = dataSet(250000);
        int[] data10 = dataSet(500000);

        //TODO: Comment This Out After Running and GOTO Algo2
        System.out.println();
        System.out.println("Range 1 - Run Time Analysis");
        timeAlgoRange01(data1);
        timeAlgoRange01(data2);
        timeAlgoRange01(data3);
        timeAlgoRange01(data4);
        timeAlgoRange01(data5);
        timeAlgoRange01(data6);
        timeAlgoRange01(data7);
        timeAlgoRange01(data8);
        timeAlgoRange01(data9);
        timeAlgoRange01(data10);

        //TODO: Run after Algo1
//		System.out.println();
//		System.out.println("Range 2 - Run Time Analysis");
//		timeAlgoRange02(data1);
//		timeAlgoRange02(data2);
//		timeAlgoRange02(data3);
//		timeAlgoRange02(data4);
//		timeAlgoRange02(data5);
//		timeAlgoRange02(data6);
//		timeAlgoRange02(data7);
//		timeAlgoRange02(data8);
//		timeAlgoRange02(data9);
//		timeAlgoRange02(data10);
//

         //TODO: Run After Algo2, need to include Following Data Sets
//        System.out.println();
//        System.out.println("Data Set - 9 to 18 for Range 3");
//
//        int[] data11 = dataSet(10000000);
//        int[] data12 = dataSet(20000000);
//        int[] data13 = dataSet(40000000);
//        int[] data14 = dataSet(60000000);
//        int[] data15 = dataSet(80000000);
//        int[] data16 = dataSet(100000000);
//        int[] data17 = dataSet(125000000);
//        int[] data18 = dataSet(150000000);
//        int[] data19 = dataSet(200000000);
//        int[] data20 = dataSet(250000000);
//
//        System.out.println();
//        System.out.println("Range 3 - Run Time Analysis");
//        timeAlgoRange03(data1);
//        timeAlgoRange03(data2);
//        timeAlgoRange03(data3);
//        timeAlgoRange03(data4);
//        timeAlgoRange03(data5);
//        timeAlgoRange03(data6);
//        timeAlgoRange03(data7);
//        timeAlgoRange03(data8);
//        timeAlgoRange03(data9);
//        timeAlgoRange03(data10);
//        timeAlgoRange03(data11);
//        timeAlgoRange03(data12);
//        timeAlgoRange03(data13);
//        timeAlgoRange03(data14);
//        timeAlgoRange03(data15);
//        timeAlgoRange03(data16);
//        timeAlgoRange03(data17);
//        timeAlgoRange03(data18);
//        timeAlgoRange03(data19);
//        timeAlgoRange03(data20);

        //TODO: Place Your Times in EXCEL SPREADSHEET in data folder.
    }
}
