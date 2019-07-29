package lesson04;

/**
 * Created by anton.sviatov on 24.07.2019.
 */
public class Motor {
    private String name;
    private int hp;


    public Motor(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void startEngine() {
        System.out.println("Engine started");
    }
}
