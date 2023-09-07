package week03$recursion;

import modules.FibModule;

import static modules.FibModule.largePrint;
import static modules.FibModule.print;

/*******************************************************************************
 * This Test shows a modules recursive, modules iterative and
 * memoized modules recursive implementation
 * of the Fibonacci Sequence for you to analyze the results.
 *******************************************************************************/
public class FibonacciTest {

    public static void checkIterativeFib(int n){
        System.out.println("\t \t \t I T E R A T I V E   -   ifib(n)");
        System.out.println();
        print(FibModule::ifib, n);
        System.out.println();
    }


    /**********************************************************************
    * Test for modules iterative Fibonacci for Large
    **********************************************************************/
    public static void checkLargeNIteration(int n){
        System.out.println("\t \t \t L A R G E  N   -   ifib(n)");
        System.out.println();
        largePrint(FibModule::ifib, n);
        System.out.println();
    }


    /**********************************************************************
    * Test for memoized Fibonacci for Large N
    **********************************************************************/
    public static void checkLargeNMemoization(int n){
        System.out.println("\t \t \t L A R G E  N   -   mfib(n)");
        System.out.println();
        largePrint(FibModule::mfib, n);
        System.out.println();
    }


    /**********************************************************************
     * Test for the standard modules recursive Fibonacci for Large N
     **********************************************************************/
    public static void checkLargeNRecursion(int n){
        System.out.println("\t \t \t L A R G E  N   -   fib(n)");
        System.out.println();
        largePrint(FibModule::fib, n);
        System.out.println();
    }


    public static void checkMemoizedFib(int n){
        System.out.println("\t \t \t M E M O I Z A T I O N   -   mfib(n)");
        System.out.println();
        print(FibModule::mfib, n);
        System.out.println();
    }


    public static void checkRecursiveFib(int n){
        System.out.println("\t \t \t R E C U R S I V E   -   fib(n)");
        System.out.println();
        print(FibModule::fib, n);
        System.out.println();
    }


    public static void intro(){
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
        System.out.println(" \t \t \t \t  W E L C O M E  ");
        System.out.println();
        System.out.println(" F I B O N A C C I    T E S T    P R O G R A M");
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
    }


    public static void main(String[] args) {
        intro();
        checkRecursiveFib(11);
        checkMemoizedFib(11);
        checkIterativeFib(11);
    }

}
