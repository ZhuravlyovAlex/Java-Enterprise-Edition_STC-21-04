package lesson03.task03.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * утилитный класс заполняющий список рандомными объектами Person
 * <p>
 * version 1.0
 * Copyright Журавлёв Алексей
 */

public class PersonGenerator {

    private static String name;

    public static List<Person> personListSort(int num) {
        Random rd = new Random();
        List<Person> men = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int age = rd.nextInt(101);

            Sex sex = Sex.randomSex();
            if (sex.equals(Sex.MAN)) {
                name = Men.randomMen().toString();
            } else {
                name = Women.randomWomen().toString();
            }
            men.add(new Person(age, sex, name));
        }
        return men;
    }

}
