package lesson02;

/**
 * Created by anton.sviatov on 17.07.2019.
 */
public class Car extends Transport{
    private int power;

    public Car(String name, int power) {
        super(name);
        this.power = power;
    }

//    public void drive() {
//        System.out.println(super.getName() + " " + this.power + " Drive..........");
//    }

    @Override
    public void move(String nameOfPlaces) {
        System.out.println("Move to " + nameOfPlaces + " on car witg name: " + super.getName());
    }

    @Override
    public String toString() {
        return "Car{" +
                "power=" + power +
                ", name='" + name + '\'' +
                '}';
    }
}
