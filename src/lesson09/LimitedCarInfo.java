package lesson09;

/**
 * Created by anton.sviatov on 14.08.2019.
 */


public class LimitedCarInfo {
    private String name;

    public LimitedCarInfo(Car car) {
        this.name = car.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
