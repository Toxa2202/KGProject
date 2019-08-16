package lesson09;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anton.sviatov on 14.08.2019.
 */

// Створюємо певний вимикач, який постачатиме напругу споживачам
    // for ElectricityConsumers...

public class Switcher {
    // Колекція зберігає всіх споживачів електрики
    private List<ElectricityConsumer> consumers;

    // Коструктор передає дані в наш ліст
    public Switcher() {
        this.consumers = new ArrayList<>();
    }

    // Додає користувача в ліст
    public void addConsumer(ElectricityConsumer consumer) {
        consumers.add(consumer);
    }

    // Виводить оголошення і через цикл запускає всіх споживачів, які є в лісті
    public void switchOn(){
        System.out.println("Switch ON");
        for (ElectricityConsumer consumer : consumers) {
            consumer.start();
        }
    }
}
