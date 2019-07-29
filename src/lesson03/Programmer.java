package lesson03;

/**
 * Created by anton.sviatov on 22.07.2019.
 */
public class Programmer implements Job{

    private String rang;
    private String language;

    public Programmer(String rang, String language) {
        this.rang = rang;
        this.language = language;
    }

    public String getRang() {
        return rang;
    }

    public void setRang(String rang) {
        this.rang = rang;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public void getSalary() {
        System.out.println("I got salary in " + nameOfCompany);
    }
}
