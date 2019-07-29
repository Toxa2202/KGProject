package lesson02;

/**
 * Created by anton.sviatov on 17.07.2019.
 */
public class Transport {
    protected String name;

    public Transport() {
    }

    public Transport(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void move(String nameOfPlace) {
        System.out.println("Move to " + nameOfPlace);
    }

    @Override
    public String toString() {
        return "Transport{" +
                "name='" + name + '\'' +
                '}';
    }
}
