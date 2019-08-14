package lesson09;

/**
 * Created by anton.sviatov on 14.08.2019.
 */
public class TV implements ElectricityConsumer {

    @Override
    public void start() {
        System.out.println("Film started");
    }

}
