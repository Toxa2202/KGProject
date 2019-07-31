package lesson05;


import java.util.*;

/**
 * Created by anton.sviatov on 29.07.2019.
 */
public class Main {
    public static void main(String[] args) {
//        Map<Person, String> personModelOfCar = new HashMap<>();
//        personModelOfCar.put(new Person("Ivan", 22), "Audi A6");
//        personModelOfCar.put(new Person("Stepan", 22), "BMW 535");
//        System.out.println(personModelOfCar);

//        Map<Person, String> personStringMapCLone = new HashMap<>(personModelOfCar);
//        System.out.println(personStringMapCLone);

        Map<Person, String> personModelOfCar = new TreeMap<>();
        personModelOfCar.put(new Person("Ivan", 22), "Audi A6");
        personModelOfCar.put(new Person("Igor", 22), "BMW 535");
        personModelOfCar.put(new Person("Oleg", 22), "BMW 535");
        personModelOfCar.put(new Person("Igor", 22), "BMW 535");
        personModelOfCar.put(new Person("Michael", 22), "BMW 535");
        System.out.println(personModelOfCar);

        List<Person> people = new ArrayList<>();
        people.add(new Person("Vova", 21));
        people.add(new Person("Andrii", 24));
        people.add(new Person("Vova", 23));
        people.add(new Person("Misha", 22));
//        people.sort(new SortGoodsByModel());
        Collections.sort(people, new SortByName().thenComparing(new SortByAge()));
        System.out.println(people);
    }
}
/** HashCode must be override always!!! */
// Red Black Tree - selfBalanced tree - MUST READ
// Class Comparable

//Set vdoma - key zanosymo, zna4ennya avtomatom
// HW - Zrobyty sort zamovlenj po kilkosti tovariv, po nazvi, po sumi; tovary po imeni i po cini.
/** Dodaty sortuvannja zamovlenj po cini v rizni storony
 * Dodaty sortuvannja tovariv po nazvi ta cini z vyborom potribnogo sposobu sortuvannja*/


// hashcode peredajetjsia v hashFunc
