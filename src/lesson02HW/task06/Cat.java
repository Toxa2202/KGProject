package lesson02HW.task06;

/**
 * Created by anton.sviatov on 18.07.2019.
 */
public class Cat extends Pet{
    private String cat;

    public Cat() {
    }

    public Cat(String cat) {
        this.cat = cat;
    }

    @Override
    public void voice() {
        System.out.println("I am a Cat with name " + cat + " - Meouuu-Meouuu.");
    }
}
