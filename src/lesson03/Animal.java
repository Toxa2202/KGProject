package lesson03;

/**
 * Created by anton.sviatov on 22.07.2019.
 */
public abstract class Animal {
    private String nick;
    private int age;

    public Animal(String nick, int age) {
        this.nick = nick;
        this.age = age;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract void voice();
}