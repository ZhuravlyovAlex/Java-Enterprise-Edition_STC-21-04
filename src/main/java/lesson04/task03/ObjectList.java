package lesson04.task03;

public interface ObjectList<T> {

    void addObject(T object);

    boolean deleteObject(T object);

    void dump();
}
