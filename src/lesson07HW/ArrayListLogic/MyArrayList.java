package lesson07HW.ArrayListLogic;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by anton.sviatov on 08.08.2019.
 */
public class MyArrayList<E> implements ArrayListInterface<E> {
    private E[] values;

    public MyArrayList() {
        values = (E[]) new Object[0];
    }


    @Override
    public boolean add(E e) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length + 1];
            System.arraycopy(
                    temp, 0,    // src
                    values, 0, // target
                    temp.length);       // amount
            values[values.length - 1] = e;
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public void delete(int index) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length - 1];
            System.arraycopy(
                    temp, 0, values, 0, index);
            int amountElementsAfterIndex = temp.length - index - 1;
            System.arraycopy(
                    temp, index + 1, values, index, amountElementsAfterIndex); // amount
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(Object o) {
        try {
            if (contains(o)) {
                E[] temp = values;
                values = (E[]) new Object[temp.length - 1];
                for (int i = 0; i < temp.length; i++) {
                    if (o.equals(temp[i])) {
                        System.arraycopy(
                                temp, 0, values, 0, i);
                        int amountElementAfterIndex = temp.length - i - 1;
                        System.arraycopy(
                                temp, i + 1, values, i, amountElementAfterIndex);
                    }
                }
            }
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public boolean contains(Object o) {
        for (E e: values) {
            if (o.equals(e)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public void update(int index, E e) {
        values[index] = e;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator<>(values);
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }
}
