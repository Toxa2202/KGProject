package lesson04ProjectStore.Sort;

import lesson04ProjectStore.model.Order;
import java.util.Comparator;
import static lesson04ProjectStore.Main.getPriceOfSoldGoodsInOrder;

/**
 * Created by anton.sviatov on 30.07.2019.
 */
public class SortOrdersByPriceAscending implements Comparator<Order> {

    @Override
    public int compare(Order o1, Order o2) {
        return getPriceOfSoldGoodsInOrder(o1).intValue() - (getPriceOfSoldGoodsInOrder(o2)).intValue();
    }
}
