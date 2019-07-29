package lesson02HW;

/**
 * Created by anton.sviatov on 17.07.2019.
 *
 * Створіть масив з 12 випадкових цілих чисел з відрізка [-15, 15].
 * Визначте, який елемент є в цьому масиві максимальним і повідомте
 * індекс його останнього входження в масив.
 */

public class Task03 {
    public static void main(String[] args) {
        int[] arr = new int[12];
        int max = 0;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * (30 + 1)) - 15;
            if (max <= arr[i]) {
                max = arr[i];
                index = i;
                System.out.println(max + " " + i);
            }
        }

        System.out.println("Max value is " + max + ", last location is " + index);
    }
}
