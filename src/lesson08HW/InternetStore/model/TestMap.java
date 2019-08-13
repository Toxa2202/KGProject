package lesson08HW.InternetStore.model;


import static lesson08HW.InternetStore.Main.*;

/**
 * Created by anton.sviatov on 07.08.2019.
 */
public class TestMap {
    public static void main(String[] args) {
        initData();
        addToMap(orders);
        clientBasket.forEach((key, value) -> System.out.println(key + " - " + value));
    }
}
