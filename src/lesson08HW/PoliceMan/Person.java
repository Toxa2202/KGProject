package lesson08HW.PoliceMan;

import java.io.Serializable;

/**
 * Created by anton.sviatov on 13.08.2019.
 */
public class Person implements Serializable {
    private Integer id;
    private String name;
    private Integer age;

    public Person(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  "id= " + id +
                ", name= '" + name + '\'' +
                ", age= " + age + ", ";
    }
}
