package lesson02HW.task06;

/**
 * Created by anton.sviatov on 18.07.2019.
 */
public class Cow extends Pet{
    private String cow;

    public Cow() {
    }

    public Cow(String cow) {
        this.cow = cow;
    }

    @Override
    public void voice() {
        System.out.println("I am a Cow with name " + cow + " - Myyy-Myyy.");
    }
}
