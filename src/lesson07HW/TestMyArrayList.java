package lesson07HW;

import lesson07HW.ArrayListLogic.ArrayListInterface;
import lesson07HW.ArrayListLogic.MyArrayList;

/**
 * Created by anton.sviatov on 08.08.2019.
 *
 * Створити класс MyArrayList, в якому реалізувати
 * фукціональність вже існуючого класу ArrayList,
 * а саме:
 * - додаваня в ліст зі зміною розміру масиву за
 *   правильною формулою
 * - видалення за об"єктом та видалення за індексом
 *   з звуженням масиву
 * - вивід всіх елементів можна зробити через toString()
 * - перевірка на наявність конкретного об"єкта
 */
public class TestMyArrayList {
    public static void main(String[] args) {
        ArrayListInterface<String> strings = new MyArrayList<>();
        strings.add("first");
        strings.add("second");
        strings.add("third");
        strings.add("fourth");

        System.out.println(strings.contains("second"));

//        strings.delete("second");
//        strings.delete("five");
        System.out.println(strings);
//
//        System.out.println(strings.contains("second"));
//
//        strings.delete(1);
//        System.out.println(strings.get(1));
//
//        strings.update(1, "update");
//
//        System.out.println(strings.get(1));
//        System.out.println(strings.size());
//
//        System.out.println(strings);
    }
}
