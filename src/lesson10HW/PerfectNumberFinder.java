package lesson10HW;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by anton.sviatov on 19.08.2019.
 */
public class PerfectNumberFinder {
    private static int counter = 0;
    private static Timer timer;

    public static void main(String[] args) {

        // create timer task to increment counter
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
//                System.out.println("TimerTask executing counter is: " + counter);
                counter++;
            }
        };

        // create thread to print counter value
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                     System.out.println("Thread reading counter is: " + counter + " sec");
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });

        timer = new Timer("PerfectNumberFinder"); // create a new timer
        timer.scheduleAtFixedRate(timerTask, 30, 1000); // starts timer in 30ms to increment counter
        thread.start(); // start thread to display counter

        perfectNumberSearching();
    }

    private static void perfectNumberSearching() {
        int min;
        int max = Integer.MAX_VALUE;

        for (min = 1; true; min++) {
            int sum = 0;
            for (int e = 1; e < min; e++) {
                if ((min % e) == 0) {
                    sum += e;
                }
            }
            if (sum == min) {
                System.out.println(sum);
            }
        }
    }
}
