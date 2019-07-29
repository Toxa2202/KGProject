package lesson03;

import java.util.Arrays;

/**
 * Created by anton.sviatov on 22.07.2019.
 */
public class Main {

    public static void test(){
    }

    public static void main(String[] args) {
        test();
        //Can't do this with final --> MyMath.PI = 3;
//        System.out.println(MyMath.PI);
//        System.out.println(MyMath.sum(5, 55));
//        Animal animal = new Cat("Allice", 10);
//        animal.voice();

//        animal = new Dog("Bob", 15);
//        animal.voice();

        // ENUM
        Season season = Season.SUMMER;
        System.out.println(season.ordinal());
        System.out.println(season.name());
        System.out.println(Arrays.toString(Season.values()));

        // Projshly 4erez ENUM za dopomogy for each
        for (int i = 0; i < Season.values().length; i++){
            season = Season.values()[i];
            System.out.println(season.name() + " avg temp --> " + season.getAvgTemp());
        }

        for (int i = 0; i < Season.values().length; i++) {
            season = Season.values()[i];
            System.out.println(season.name() + " has " +
                    Arrays.toString(season.getSeasonMonths()) + " months.");
        }

        System.out.println(Arrays.toString(Month.getAutumnMonths()));
    }
}