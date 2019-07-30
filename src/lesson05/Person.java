package lesson05;

import java.util.Objects;

/**
 * Created by anton.sviatov on 29.07.2019.
 */
public class Person implements Comparable<Person>{
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", age=" + age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Person o) {
//        int byName = this.name.compareTo(o.name);
//        int byAge = this.age.compareTo(o.age);
        if (this.name.compareTo(o.name) == 0){
            /** To compare Strings */
            return this.age.compareTo(o.age);
        } else if (this.age.compareTo(o.age) == 0) {
            return 0;
        }

        return this.name.compareTo(o.name);

        /** To compare int */
//        if (this.age > o.age) {
//            return 1;
//        } else if (this.age < o.age) {
//            return -1;
//        }
//
//        return 0;
    }
}
