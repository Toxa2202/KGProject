package lesson02HW;

/**
 * Created by anton.sviatov on 17.07.2019.
 *
 * Створіть масив з 11 випадкових цілих чисел з відрізка [-1, 1],
 * виведіть масив а екран у рядок. Визначте, який елемент зустрічається
 * в масиві найчастіше і виведіть про це повідомлення на екран.
 * Якщо дав якихось елемента зустрічаються однакову кількість разів,
 * то не виводьте нічого.
 */

public class Task01 {
    public static void main(String[] args) {
        int[] arr = new int[11];
        int countMinus = 0;
        int countZero = 0;
        int countPlus = 0;
        int maxCount = 6;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 3);
            if (arr[i] == 0) {
                arr[i] = -1;
                countMinus++;
            } else if (arr[i] == 1) {
                arr[i] = 0;
                countZero++;
            } else {
                arr[i] = 1;
                countPlus++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }

        if (countMinus > countZero && countMinus > countPlus) {
            maxCount = countMinus;
            System.out.println("\n-1 repeated " + countMinus + " times");
        } else if (countZero > countMinus && countZero > countPlus) {
            maxCount = countZero;
            System.out.println("\n0 repeated " + countZero + " times");
        } else if (countPlus > countMinus && countPlus > countZero) {
            maxCount = countPlus;
            System.out.println("\n1 repeated " + countPlus + " times");
        } else {
            System.out.println();
        }

        if (countMinus == countZero && countMinus > maxCount) {
            System.out.println("\n-1 and 0 repeated " + countMinus + " times");
        } else if (countMinus == countPlus && countMinus > maxCount) {
            System.out.println("\n-1 and +1 repeated " + countMinus + " times");
        } else if (countZero == countPlus && countZero > maxCount) {
            System.out.println("\n0 and +1 repeated " + countZero + " times");
        }
    }
}