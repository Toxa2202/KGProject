package lesson02HW.task05;

/**
 * Created by anton.sviatov on 18.07.2019.
 */
public class RobotDancer extends Robot{
    private String name;

    public RobotDancer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void work() {
        System.out.println("I am RobotDancer - I just dancing.");
    }
}
