package lesson06;

import java.util.*;

/**
 * Created by anton.sviatov on 31.07.2019.
 */
public class Main {
    public static void main(String[] args) {
        Map<Person, Integer> people = new HashMap<>();
        people.put(new Person("Ivan", 22), 1);
        people.put(new Person("Petro", 25), 2);
        people.put(new Person("Ostap", 18), 4);
        people.put(new Person("Svitlana", 20), 3);

        for (Map.Entry entry : people.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

//        for (Person person : people.keySet()) {
//            System.out.println(person + " -> " + people.get(person));
//        }

//        System.out.println(people.values());

//        Iterator<Person> iterator = people.iterator();
//        while (iterator.hasNext()) {
//            if (iterator.next().getName().equals("Petro")) {
//                iterator.remove();
//            }
//        }
//        System.out.println(people);

//        for (Person person : people) {
//            System.out.println(person.getName());
//        }


    }
}

// Entry це обєкт, який містить ключ - значення
// KeySet дає доступ до списку ключів, з яких можна витягнути значення
// values - поверне список всіх значень
// Comparator - можна переставляти стилі сортування

/** HomeWork06 */
/** Перебудувати консольний магазин таким чином, щоб в кожного користувача був свій кошик
 * і кожен був пов"язаний з власним кошиком через мапу і весь функціонал зберігсяю */
// За допомогою Map звязати Person і кошик (TotalOrders). Ключ це Person, значення - TotalOrders
// user mapa , user koshyk, user = key, коли логіниться,
// підтягується його мапа (юзер це ключ)
// в кожного юзера буде свій кошик, створити кошики і підставляти туди значення.