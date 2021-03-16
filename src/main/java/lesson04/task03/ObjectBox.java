package lesson04.task03;

import java.util.HashSet;
import java.util.Set;

public class ObjectBox<T> implements ObjectList<T> {

    private Set<Object> set;

    public ObjectBox() {
        this.set = new HashSet();
    }

    @Override
    public void addObject(T object) {
        if (!set.contains(object)) {
            set.add(object);
        }
    }

    @Override
    public boolean deleteObject(T object) {
        if (set.contains(object)) {
            set.remove(object);
            return true;
        }
        return false;
    }

    @Override
    public void dump() {
        System.out.println("ObjectBox: " + set.toString());
    }

    @Override
    public String toString() {
        return "ObjectBox " + set;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ObjectBox<?> objectBox = (ObjectBox<?>) object;
        return set.equals(objectBox.set);
    }

    @Override
    public int hashCode() {
        return set.hashCode();
    }
}
