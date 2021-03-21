package lesson03.task03;

import lesson03.task03.model.Person;
import java.util.Comparator;

/**
 * класс реализующий сортировку по методу Insertion sort
 * <p>
 * version 1.0
 * Copyright Журавлёв Алексей
 */

public class PersonGeneratorWithInsertionSort extends PersonArrayList {

    @Override
    public void sort() {
        Comparator<Person> personComparator = new Person.PersonSexComparator().thenComparing(new Person.PersonAgeComparator()).thenComparing(new Person.PersonNameComparator().reversed());
        Person person;
        for (int i = 1; i < size(); i++) {
            person = get(i);
            int j = i - 1;
            while (j >= 0 && personComparator.compare(get(j), person) < 0) {
                add(get(j), (j + 1));
                j = j - 1;
            }
            add(person, (j + 1));
        }
    }
}




