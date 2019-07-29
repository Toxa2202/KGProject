package lesson02HW.task06;

/**
 * Created by anton.sviatov on 18.07.2019.
 *
 * Написати клас Pet,  в якому описати метод voice(). Створити класи
 * Cow, Cat, Dog, які наслідуються від Pet. Перевизначити в них метод
 * voice(), так, щоб викликаючи його в методі main, на консоль виводилось:
 * "Я кіт - Мяууу-Мяууу", "Я пес - Гаууу-Гаууу", "Я корова - Мууу-Мууу".
 */

public class Main {
    public static void main(String[] args) {
        Pet pet = new Pet();
        pet.voice();

        Pet pet01 = new Cow("Korivka");
        pet01.voice();

        Pet pet02 = new Cat("Kaba4ok");
        pet02.voice();

        Pet pet03 = new Dog("Kozak");
        pet03.voice();
    }
}
