package lesson09;

/**
 * Created by anton.sviatov on 14.08.2019.
 */

// Споживач електроенергії (абстрактний)
    // він став функціональним інтерфейсом, тому що має тільки один метод.
    // Буде використовуватись лямбдами
@FunctionalInterface
public interface ElectricityConsumer {

    void start();

}
