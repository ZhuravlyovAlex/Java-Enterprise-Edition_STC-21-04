package lesson03.task03;

import lesson03.task03.model.Person;

public interface PersonList {
    Person get(int index);

    void add(Person person);

    void add(Person person, int index);

    boolean remove(Person person);

    boolean removeAt(int index);

    int size();

    void clear();

    void sort();
}
