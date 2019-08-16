package lesson09;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Created by anton.sviatov on 14.08.2019.
 */
public class Main {

//    static class Laptop implements ElectricityConsumer {
//
//        @Override
//        public void start() {
//            System.out.println("Laptop ON");
//        }
//    }


    public static void main(String[] args) {

//        Switcher switcher = new Switcher();
//        switcher.addConsumer(new Lamp());
//        switcher.addConsumer(new TV());
//        switcher.addConsumer(() -> System.out.println("Laptop ON"));
                // anonim class, when is interface in enter. If use this once.
                // If functional interface have one method (like lambda)
//        switcher.switchOn();

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Audi a4", 290));
        cars.add(new Car("BMW 540i", 280));
        cars.add(new Car("Mercedes E-Class", 210));
//        for (Car car : cars) {
//            System.out.println(car.getName());
//            System.out.println(car.getName());
//            System.out.println(car.getName());
//            System.out.println(car.getName());
//        }

//        // method car get parameter to foreach
//        cars.forEach(car -> {
//            System.out.println(car.getName());
//            System.out.println(car.getName());
//            System.out.println(car.getName());
//            System.out.println(car.getName());
//        });

        // Зверху була спрощена форма цього
//        cars.stream().forEach(new Consumer<Car>() {
//            @Override
//            public void accept(Car car) {
//
//            }
//        });

//        List<LimitedCarInfo> limitedCarInfos =
//                cars.stream().map(car -> new LimitedCarInfo(car)).collect(Collectors.toList());
        // OLD
//        for (Car car: cars) {
//            if (car.getPower() > 300) {
//                System.out.println(car);
//            }
//        }

        // NEW LAMBDA
        // Car::getPower means method getPower in Class Car

        cars.stream().filter(car -> car.getPower() > 250)
                .sorted(Comparator.comparing(Car::getPower))
                .forEach(System.out::println);


    }
}

// вимикач, вмикає різні прилади.
// change class - change realisation -- weak connection (like in Spring)
// фільтрування, сортування, перетворення мап, фор-іч,

/** ДЗ
 *  Переписати все лямбдами в інтернет проект
 * */