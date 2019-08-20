package lesson10;

/**
 * Created by anton.sviatov on 19.08.2019.
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("My runnable -> " + i);
        }
    }
}
