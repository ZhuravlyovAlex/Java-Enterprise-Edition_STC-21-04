package lesson04.task02;

public interface ObjectList<T> {

    void addObject(T object);

    boolean deleteObject(T object);

    void dump();
}
