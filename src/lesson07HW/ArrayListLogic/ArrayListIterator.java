package lesson07HW.ArrayListLogic;

import java.util.Iterator;

/**
 * Created by anton.sviatov on 08.08.2019.
 */
public class ArrayListIterator<E> implements Iterator<E> {
    private int index = 0;
    private E[] values;

    ArrayListIterator(E[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return index < values.length;
    }

    @Override
    public E next() {
        return values[index++];
    }
}
