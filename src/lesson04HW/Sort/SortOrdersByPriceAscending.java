package lesson04HW.Sort;

import lesson04HW.model.Order;

import java.util.Comparator;

import static lesson04HW.Main.getPriceOfSoldGoodsInOrder;

/**
 * Created by anton.sviatov on 30.07.2019.
 */
public class SortOrdersByPriceAscending implements Comparator<Order> {
    @Override
    public int compare(Order o1, Order o2) {
        return getPriceOfSoldGoodsInOrder(o1).intValue() - (getPriceOfSoldGoodsInOrder(o2)).intValue();
    }
}
