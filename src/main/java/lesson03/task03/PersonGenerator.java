package lesson03.task03;

import lesson03.task03.model.Men;
import lesson03.task03.model.Person;
import lesson03.task03.model.Sex;
import lesson03.task03.model.Women;

import java.util.Random;

/**
 * утилитный класс заполняющий список рандомными объектами Person
 * <p>
 * version 1.0
 * Copyright Журавлёв Алексей
 */

public class PersonGenerator {

    private static String name;

    public static PersonGeneratorWithBubbleSort personListBubbleSort(int num) {
        Random rd = new Random();
        PersonGeneratorWithBubbleSort men = new PersonGeneratorWithBubbleSort();
        for (int i = 0; i < num; i++) {
            int age = rd.nextInt(101);

            Sex sex = Sex.randomSex();
            if (sex.equals(Sex.MAN)) {
                name = Men.randomMen().toString();
            } else {
                name = Women.randomWomen().toString();
            }
            Person person = new Person(age, sex, name);
            men.add(person);
        }
        return men;
    }

    public static PersonGeneratorWithInsertionSort personListInsertionSort(int num) {
        Random rd = new Random();
        PersonGeneratorWithInsertionSort men = new PersonGeneratorWithInsertionSort();
        for (int i = 0; i < num; i++) {
            int age = rd.nextInt(101);

            Sex sex = Sex.randomSex();
            if (sex.equals(Sex.MAN)) {
                name = Men.randomMen().toString();
            } else {
                name = Women.randomWomen().toString();
            }
            Person person = new Person(age, sex, name);
            men.add(person);
        }
        return men;
    }

}
