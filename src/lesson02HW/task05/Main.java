package lesson02HW.task05;

/**
 * Created by anton.sviatov on 18.07.2019.
 *
 * Створити клас Robot, від якого унаслідувати CoffeeRobot, RobotDancer,
 * RobotCooker. В Robot є метод work(), в якому слід описати роботу, яку
 * виконує кожен з роботів.
 *  -Для Robot в методі work() слід написати код, щоб на консоль виводився
 * наступний текст "Я Robot - я просто працюю".
 *  -Для CoffeeRobot в методі work() слід написати код, щоб на консоль
 * виводився наступний текст "Я CoffeeRobot - я варю каву."
 *  -Для RobotDancer в методі work() слід написати код, щоб на консоль виводився
 * наступний текст "Я RobotDancer - я просто танцюю."
 *  -Для RobotCooker в методі work() слід написати код, щоб на консоль
 * виводився наступний текст "Я RobotCooker - я просто готую."
 * Створити в Main класі екземпляри даних класів і викликати до кожного
 * з них метод work().
 */
public class Main {
    public static void main(String[] args) {
        Robot mainRobot = new Robot();
        mainRobot.work();
        Robot firstRobot = new CoffeeRobot("Capuchino");
        firstRobot.work();
        Robot secondRobot = new RobotDancer("Elvis");
        secondRobot.work();
        Robot thirdRobot = new RobotCooker("Jamey");
        thirdRobot.work();
    }
}
