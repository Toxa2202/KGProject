package lesson08HW.PoliceMan;

import java.io.Serializable;

/**
 * Created by anton.sviatov on 13.08.2019.
 */
public class PoliceMan extends Person implements Serializable, Comparable<PoliceMan>{
    private String rang;
    private Weapon mark;

    public PoliceMan(Integer id, String name, Integer age, String rang, Weapon mark) {
        super(id, name, age);
        this.rang = rang;
        this.mark = mark;
    }

    public String getRang() {
        return rang;
    }

    public void setRang(String rang) {
        this.rang = rang;
    }

    public Weapon getMark() {
        return mark;
    }

    public void setMark(Weapon mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return super.toString() +
                "rang= '" + rang + '\'' +
                ", mark= " + mark;
    }

    @Override
    public int compareTo(PoliceMan o) {
        return this.getAge().compareTo(o.getAge());
    }
}
