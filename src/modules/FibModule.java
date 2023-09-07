package modules;

import functions.Fib;

/****************************************************************
 * This module is included for the Fibonacci Recursion Exercise
 ****************************************************************/
public class FibModule {

    public static long fib(int n) {
        //TODO : COMPLETE BODY OF RECURSIVE METHOD
        if (n <= 1) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);




    }

    public static long ifib(int n) {
        //TODO : COMPLETE BODY OF ITERATIVE METHOD
        if (n <= 1) {
            return n;
        }

        long[] fibArr = new long[n + 1];
        fibArr[0] = 0;
        fibArr[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibArr[i] = fibArr[i - 1] + fibArr[i - 2];
        }

        return fibArr[n];


    }

    public static long mfib(int n) {
        //TODO : COMPLETE BODY OF MEMOIZATION METHOD
        int[] memo = new int[n + 1];
        return memo(n, memo);

    }

    private static long memo(int n, int[] x) {
        //TODO : COMPLETE BODY OF MEMOIZATION HELPER METHOD
        if (n <= 1) {
            return n;
        }

        if (x[n] != 0) { // Use the 'x' array instead of 'memo' array
            return x[n];
        }

        x[n] = (int) (memo(n - 1, x) + memo(n - 2, x)); // Use 'x' instead of 'memo'
        return x[n];


    }


    /****************************************************************
     * prints large value sequence in lines. This uses a functional
     * programming approach to print out the data.
     ****************************************************************/
    public static void largePrint(Fib f, int n){
        System.out.println("============ R E S U L T S  ============");
        System.out.println();
        System.out.println();
        System.out.println("====== Large Value Printing Ahead ====== ");
        System.out.println();

        //PRINTS : value for nth factorial
        System.out.println("\t \t n \t \t value");
        for (int i = 0; i <= n; i++ ) {
            String str1 = String.format("\t \t %d \t \t %d \n", i, f.fib(i));
            String str2 = String.format("\t \t %d \t %d \n", i, f.fib(i));

            //TERNARY OPERATOR
            String fString = (i < 10) ? str1 : str2;
            System.out.print(fString);
        }

        System.out.println();
    }


    /****************************************************************
     * prints nth Fibonacci. This uses a functional programming
     * approach to print out the data.
     ****************************************************************/
    public static void print(Fib f, int n){
        System.out.println("============== nth Fibonacci ============");

        // PRINTS : count of nth factorial
        for (int i = 0; i <= n; i++ ) {
            System.out.printf("%d \t", i);
        }
        System.out.println();

        //PRINTS : value for nth factorial
        for (int i = 0; i <= n; i++ ) {
            System.out.printf("%d \t", f.fib(i));
        }
        System.out.println();
    }

}
