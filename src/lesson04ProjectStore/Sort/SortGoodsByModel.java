package lesson04ProjectStore.Sort;



import lesson04ProjectStore.model.Good;

import java.util.Comparator;

/**
 * Created by anton.sviatov on 29.07.2019.
 */
public class SortGoodsByModel implements Comparator<Good> {

    @Override
    public int compare(Good o1, Good o2) {
        return o1.getModel().compareTo(o2.getModel());
    }
}
