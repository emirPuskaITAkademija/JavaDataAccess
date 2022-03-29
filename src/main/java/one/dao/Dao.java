package one.dao;

import java.util.List;

public interface Dao<E> {
    /**
     * <p>
     * Ova metoda treba da snimi elemente koje je dobila kroz parametar elements.
     * </p>
     *
     * @param elements
     */
    public void write(List<E> elements);

    /**
     * <p>
     * Ova metoda treba da pročita trajno snimljene podatke i da nam vrati
     * listu elemenata koji su prethodno snimljeni.
     * </p>
     *
     * @return elements
     */
    public List<E> read();
}
