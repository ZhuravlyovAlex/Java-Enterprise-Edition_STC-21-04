package lesson03.task03;

import lesson03.task03.model.Person;
import java.util.Arrays;

/**
 * собственная реализация ArrayList
 * <p>
 * version 1.0
 * Copyright Журавлёв Алексей
 */

public class PersonArrayList implements PersonList {

    private Person[] array = new Person[10];
    private int size = 0;

    @Override
    public Person get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public void add(Person person) {
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size] = person;
        size++;
    }

    @Override
    public void add(Person person, int index) {
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[index] = person;
    }

    @Override
    public boolean remove(Person person) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(person)) {
                return removeAt(i);
            }
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Person[10];
        size = 0;
    }

    @Override
    public void sort() {

    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
}
