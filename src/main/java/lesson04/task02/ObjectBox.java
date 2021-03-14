package lesson04.task02;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ObjectBox implements ObjectList {

    private Set<Object> list;

    public ObjectBox() {
        this.list  = new HashSet();
    }

    @Override
    public void addObject(Object object) {
        if (!list.contains(object)) {
            list.add(object);
        }
    }

    @Override
    public boolean deleteObject(Object object) {
        if (list.contains(object)) {
            list.remove(object);
            return true;
        }
        return false;
    }

    @Override
    public void dump() {
            System.out.println(list.toString());
        }

    @Override
    public String toString() {
        return "ObjectBox " + list;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ObjectBox objectBox = (ObjectBox) object;
        return Objects.equals(list, objectBox.list);
    }

    @Override
    public int hashCode() {
        return list.hashCode();
    }
}
