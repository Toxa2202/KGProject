package lesson08HW.InternetStore.model;

/**
 * Created by anton.sviatov on 24.07.2019.
 */
public class Client extends Person{

    private String login;
    private String password;

    public Client(Integer id, String name, Integer age, String login, String password) {
        super(id, name, age);
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Client " + super.toString();
    }
}
