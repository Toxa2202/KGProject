package lesson09;

/**
 * Created by anton.sviatov on 14.08.2019.
 */

// Конкрретний споживач імплементуєтсья від інтерфейсу
public class TV implements ElectricityConsumer {

    // Переписує метод інтерфейсу з врахуванням своїх особливостей
    @Override
    public void start() {
        System.out.println("Film started");
    }

}
