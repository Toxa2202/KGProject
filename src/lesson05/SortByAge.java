package lesson05;

import java.util.Comparator;

/**
 * Created by anton.sviatov on 29.07.2019.
 */
public class SortByAge implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge() - (o2.getAge());
    }
}
