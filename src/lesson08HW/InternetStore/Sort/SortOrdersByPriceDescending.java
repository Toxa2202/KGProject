package lesson08HW.InternetStore.Sort;

import lesson08HW.InternetStore.model.Order;

import java.util.Comparator;

import static lesson08HW.InternetStore.Main.getPriceOfSoldGoodsInOrder;

/**
 * Created by anton.sviatov on 30.07.2019.
 */
public class SortOrdersByPriceDescending implements Comparator<Order> {
    @Override
    public int compare(Order o1, Order o2) {
        return getPriceOfSoldGoodsInOrder(o2).intValue() - getPriceOfSoldGoodsInOrder(o1).intValue();
    }
}