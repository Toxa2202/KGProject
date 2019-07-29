package lesson02HW.task04;

/**
 * Created by anton.sviatov on 17.07.2019.
 * *
 *  Написати клас Rectangle, в якому буде описано поля: довжина,
 *  ширина. Описати дані поля в конструкторі. Створити конструктор
 *  з параметрами і без параметрів. Написати методи, які будуть розраховувати
 *  площу та периметр. В Main класі продемонструвати створення об'єктів
 *  використовуючи два конструктори. Вивести на консоль площу і периметр
 *  прямокутника. Вивід на консолі повинен мати наступний вигляд:
 *  "Площа прямокутника = тут буде площа", "Периметр прямокутника = тут
 *  буде периметр".
 */
public class Main {
    public static void main(String[] args) {
        Rectangle rect01 = new Rectangle(10, 21);
        System.out.println("First rectangle");
        rect01.square();
        rect01.perimeter();

        Rectangle rect02 = new Rectangle(8, 14);
        System.out.println("\nSecond rectangle");
        rect02.square();
        rect02.perimeter();
    }
}
