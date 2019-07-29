package lesson03HW;

/**
 * Created by anton.sviatov on 23.07.2019.
 */
public class MyMath {
        private static final int FIRST = 5;
        private static final int SECOND = 5;

    public static void main(String[] args) {
        System.out.println("By using Math.pow --> " + Math.pow(FIRST, SECOND));
        System.out.println("By using own method --> " + power(FIRST, SECOND));
        System.out.println("By using multiple --> " + multiple(FIRST, SECOND));
        System.out.println("By using factorial --> " + factorial(FIRST));
    }

    private static int multiple(int first, int second) {
        return first * second;
    }

    private static int factorial(int num) {
        if (num == 0) {
            return 1;
        } else {
            return (num * factorial(num - 1));
        }
    }

    /** Positive only */
//    private static double power(double num, int pow) {
//        long result = 1;
//        for (int i = 0; i < pow; i++) {
//            result *= num;
//        }
//        return result;
//    }

    /** Positive and negative */
    private static double power(double number, int exponent) {
        double result = 1;
        if (exponent != 0) {
            int polarityExp = exponent > 0 ? exponent : (-1) * exponent;
            for (int i = 1; i <= polarityExp; i++) {
                result *= number;
            }

            if (exponent < 0) {
                // Negative exp
                result = 1.0 / result;
            }
        } else {
            // If exponent = 0
            result = 1;
        }

        return result;
    }
}
