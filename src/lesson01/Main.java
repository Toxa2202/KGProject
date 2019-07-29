package lesson01;

import java.util.Scanner;

/**
 * Created by anton.sviatov on 15.07.2019.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to KindGeek!");

        int x = 5;
        int y = 8;
        System.out.println("Result = " + (x + y));

        if (x % 2 == 0) {
            System.out.println("x = Parne chyslo");
        } else {
            System.out.println("x = Neparne chyslo");
        }

        String str = "new string";
        str.equals("new str");

        Scanner input = new Scanner(System.in);
        //String newStr = input.nextLine();
        //System.out.println(newStr.replace("l", ""));

        for (int i = 2; i <= 20; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }

        System.out.println();
        int[] arr = new int[10];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
            System.out.print(arr[i] + " ");
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println("\nMax num = " + max);
    }
}
