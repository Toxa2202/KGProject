package lesson07HW.ArrayListLogic;

/**
 * Created by anton.sviatov on 08.08.2019.
 */
public interface ArrayListInterface<E> extends Iterable<E> {
    boolean add(E e);
    void delete(int index);
    void delete(Object o);
    E get(int index);
    int size();
    boolean contains(Object o);
    void update(int index, E e);
}
