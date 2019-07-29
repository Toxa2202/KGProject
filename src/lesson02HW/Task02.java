package lesson02HW;

/**
 * Created by anton.sviatov on 17.07.2019.
 *
 * Створити двовимірний масив з 5 рядків по 8 стовпців в кожній
 * з випадкових цілих чисел з відрізка [-99, 99]. Вивести масив на
 * екран. Після на окремому рядку вивести на екран значення максимального
 * елементу цього масиву (його індекс не має значення).
 */

public class Task02 {
    public static void main(String[] args) {
        int rows = 5;
        int columns = 8;
        int[][] arr = new int[rows][columns];
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = (int)(Math.random() * (198 + 1)) - 99;
                if (max < arr[i][j]) {
                    max = arr[i][j];
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(arr[i][j] + ", ");
                if (j == columns - 1) {
                    System.out.println();
                }
            }
        }

        System.out.println("Max value is " + max);
    }
}
