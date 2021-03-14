package lesson04.task02;

import java.util.HashSet;
import java.util.Set;

public class ObjectBox<T> implements ObjectList<T> {

    private Set<T> list;

    public ObjectBox() {
        this.list = new HashSet();
    }

    @Override
    public void addObject(T object) {
        if (!list.contains(object)) {
            list.add(object);
        }
    }

    @Override
    public boolean deleteObject(T object) {
        if (list.contains(object)) {
            list.remove(object);
            return true;
        }
        return false;
    }

    @Override
    public void dump() {
        System.out.println("ObjectBox: " + list.toString());
    }

    @Override
    public String toString() {
        return "ObjectBox " + list;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ObjectBox<?> objectBox = (ObjectBox<?>) object;
        return list.equals(objectBox.list);
    }

    @Override
    public int hashCode() {
        return list.hashCode();
    }
}
