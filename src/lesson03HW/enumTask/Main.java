package lesson03HW.enumTask;

import lesson03.Month;
import lesson03.Season;

import java.util.Arrays;

/**
 * Created by anton.sviatov on 22.07.2019.
 */
public class Main {

    public static void main(String[] args) {

        // ENUM
        Season season;

        for (int i = 0; i < Season.values().length; i++) {
            season = Season.values()[i];
            System.out.println(season.name() + " has " +
                    Arrays.toString(season.getSeasonMonths()) + " months.");
        }

        System.out.println(Arrays.toString(Month.getAutumnMonths()));
    }
}