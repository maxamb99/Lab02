package modules;

public class RecModule {

    public static int fac(int n) {
        //TODO: COMPLETE BODY
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * fac(n - 1);
        }
//        return 0;
    }

    public static boolean isPalindrome(String s) {

        if (s.length() <= 1) {
            return true;
        } else {
            char first = s.charAt(0);
            char last = s.charAt(s.length() - 1);
            if (first != last) {
                return false;
            } else {
                String subString = s.substring(1, s.length() - 1);
                return isPalindrome(subString);
            }
        }

    }

    public static double pow(double x, int n) {

        if (n == 0) {
            return 1;
        } else if (n > 0) {
            return x * pow(x, n - 1);
        } else {
            return 1 / (x * pow(x, -n - 1));
        }


    }

    public static int sum(int n) {

        if (n == 0) {
            return 0;
        } else {
            return n + sum(n - 1);
        }

    }

}
