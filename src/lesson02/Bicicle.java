package lesson02;

/**
 * Created by anton.sviatov on 17.07.2019.
 */
public class Bicicle extends Transport{
    private int numberOfWheels;

    public Bicicle() {
    }

    public Bicicle(String name, int numberOfWheels) {
        super(name);
        this.numberOfWheels = numberOfWheels;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    @Override
    public String toString() {
        return "Bicicle{" +
                "numberOfWheels=" + numberOfWheels +
                ", name='" + name + '\'' +
                '}';
    }
}
