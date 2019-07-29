package lesson02;

/**
 * Created by anton.sviatov on 17.07.2019.
 */
public class House {
    private String street;
    private int citizens;

    public House() {
    }

    public House(String street, int citizens) {
        this.street = street;
        this.citizens = citizens;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getCitizens() {
        return citizens;
    }

    public void setCitizens(int citizens) {
        this.citizens = citizens;
    }

    public void check() {
        System.out.println(this.street + " with number of citizens " + this.citizens + " are ready to elections!");
    }
}
