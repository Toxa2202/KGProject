package lesson02HW.task06;

/**
 * Created by anton.sviatov on 18.07.2019.
 */
public class Dog extends Pet{
    private String dog = "Dog";

    public Dog() {
    }

    public Dog(String dog) {
        this.dog = dog;
    }

    @Override
    public void voice() {
        System.out.println("I am a Dog with name " + dog + " - Bark-Bark");
    }

}
