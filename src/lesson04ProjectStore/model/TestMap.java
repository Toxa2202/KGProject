package lesson04ProjectStore.model;


import static lesson04ProjectStore.Main.*;

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
