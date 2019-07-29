package lesson03;

/**
 * Created by anton.sviatov on 22.07.2019.
 */
public class Cat extends Animal{
    public Cat(String nick, int age) {
        super(nick, age);
    }

    @Override
    public void voice() {
        System.out.println("miew-miew");
    }
}