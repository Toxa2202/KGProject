package lesson03HW.enumTask;

import lesson03.Month;

/**
 * Created by anton.sviatov on 22.07.2019.
 */
public enum Season {

//    WINTER(new String[]{"DECEMBER", "JANUARY", "FEBRUARY"}, -2),
//    SPRING(new String[]{"MARCH", "APRIL", "MAY"}, 18),
//    SUMMER(new String[]{"JUNE", "JULY", "AUGUST"}, 25),
//    AUTUMN(new String[]{"SEPTEMBER", "OCTOBER", "NOVEMBER"}, 15);

    WINTER(new String[]{String.valueOf(Month.DECEMBER),
            String.valueOf(Month.JANUARY),
            String.valueOf(Month.FEBRUARY)},-2),
    SPRING(new String[]{String.valueOf(Month.MARCH),
            String.valueOf(Month.APRIL),
            String.valueOf(Month.MAY)}, 18),
    SUMMER(new String[]{String.valueOf(Month.JUNE),
            String.valueOf(Month.JULY),
            String.valueOf(Month.AUGUST)}, 25),
    AUTUMN(new String[]{String.valueOf(Month.SEPTEMBER),
            String.valueOf(Month.OCTOBER),
            String.valueOf(Month.NOVEMBER)}, 15);

    private String[] seasonMonths;
    private int avgTemp;

    Season(String[] seasonMonths, int avgTemp) {
        this.seasonMonths = seasonMonths;
        this.avgTemp = avgTemp;
    }


    public int getAvgTemp() {
        return avgTemp;
    }


    public String[] getSeasonMonths() {
        return seasonMonths;
    }
}

// Створити список місяців в енамі і вивести
// список днів в місяці через енам.
// Домашка на середу
