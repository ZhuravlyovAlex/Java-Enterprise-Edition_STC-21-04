package lesson03.task03;

import lesson03.task03.model.Person;
import java.util.Comparator;

/**
 * класс реализующий сортировку по методу Bubble Sort
 * <p>
 * version 1.0
 * Copyright Журавлёв Алексей
 */

public class PersonGeneratorWithBubbleSort extends PersonArrayList{

    @Override
    public void sort() {
        Comparator<Person> personComparator = new Person.PersonSexComparator().thenComparing(new Person.PersonAgeComparator()).thenComparing(new Person.PersonNameComparator().reversed());

        for (int i = 0; i < size() - 1; i++) {
            for (int j = 0; j < size() - i - 1; j++) {
                if (personComparator.compare(get(j), get(j + 1)) < 0) {
                    Person temp = get(j);
                    add(get(j + 1), j);
                    add(temp, (j + 1));
                }
            }
        }
    }
}