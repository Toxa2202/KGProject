package lesson09;

/**
 * Created by anton.sviatov on 14.08.2019.
 */
public class Car {
    public Car(String name, Integer power) {
        this.name = name;
        this.power = power;
    }

    private String name;
    private Integer power;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", power=" + power +
                '}';
    }
}
