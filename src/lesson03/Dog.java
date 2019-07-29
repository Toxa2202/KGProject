package lesson03;

/**
 * Created by anton.sviatov on 22.07.2019.
 */
public class Dog extends Animal{

    public Dog(String nick, int age) {
        super(nick, age);
    }

    @Override
    public void voice() {
        System.out.println("Bark-Bark!");
    }
}