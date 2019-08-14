package lesson09;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anton.sviatov on 14.08.2019.
 */
public class Switcher {
    private List<ElectricityConsumer> consumers;

    public Switcher() {
        this.consumers = new ArrayList<>();
    }

    public void addConsumer(ElectricityConsumer consumer) {
        consumers.add(consumer);
    }

    public void switchOn(){
        System.out.println("Switch ON");
        for (ElectricityConsumer consumer : consumers) {
            consumer.start();
        }
    }
}
