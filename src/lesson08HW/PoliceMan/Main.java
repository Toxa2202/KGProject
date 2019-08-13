package lesson08HW.PoliceMan;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by anton.sviatov on 13.08.2019.
 *
 * Створити клас Person(name, age) i PoliceMan(extends Person)
 * (String rang, Weapon mark). Створити 5 полісменівб записати їх в файл,
 * потім зчитати з файлу. Вивести на консоль посортовані по віку від наймолодшого.
 *
 */
public class Main {
    private static List<PoliceMan> policeManList = new ArrayList<>();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        PoliceMan policeMan1 = new PoliceMan(1,"Mark", 32, "LT", Weapon.COLT);
        PoliceMan policeMan2 = new PoliceMan(2,"Pedro", 22, "Sergent", Weapon.MAUSER);
        PoliceMan policeMan3 = new PoliceMan(3,"Ivan", 35, "Captain", Weapon.WALTER);
        PoliceMan policeMan4 = new PoliceMan(4,"Andrey", 30, "Major", Weapon.COLT);
        PoliceMan policeMan5 = new PoliceMan(5,"George", 49, "CRNL", Weapon.GLOCK);

        policeManList.add(policeMan1);
        policeManList.add(policeMan2);
        policeManList.add(policeMan3);
        policeManList.add(policeMan4);
        policeManList.add(policeMan5);


        File file = new File("src/lesson08HW/PoliceMan/policeMenList.txt");
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
        output.writeObject(policeManList);
        output.close();

        ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
        List<PoliceMan> listFromFile = (List<PoliceMan>) input.readObject();
        input.close();

        Collections.sort(listFromFile);
        for (PoliceMan policeMan: listFromFile) {
            System.out.println(policeMan);
        }
    }
}
