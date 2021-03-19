package lesson03.task03;

import lesson03.task03.model.Person;
import lesson03.task03.model.Sex;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * утилитный класс заполняющий список рандомными объектами Person
 * <p>
 * version 2.0
 * Copyright Журавлёв Алексей
 */

public class PersonGenerator extends PersonArrayList {

    private static Random random = new Random();

    public static List personListSort(int num) { // метод для генерации рандомного объекта Person
        String name;

        List list = new ArrayList();
        for (int i = 0; i < num; i++) {
            int age = random.nextInt(101);

            Sex sex = Sex.randomSex();
            if (sex.equals(Sex.MAN)) {
                name = randomPerson(sex);
            } else {
                name = randomPerson(sex);
            }
            Person person = new Person(age, sex, name);
            if (!list.contains(person)) {
                list.add(person);
            } else {
                try {
                    throw new DublicatePersonException();
                } catch (DublicatePersonException e) {
                    System.out.println("Ошибка! Вы ввели существующую персону.");
                }
            }
        }
        return list;
    }

    public static String randomPerson(Sex sex) { // метод возращающий рандомное значение имени в зависимости от пола
        String[] menRandom = new String[]{"Марсель", "Иван", "Александр", "Кирилл", "Пётр", "Борис", "Сергей", "Василь", "Дмитрий", "Михаил"};
        String[] womenRandom = new String[]{"Виктория", "Иванка", "Александра", "Татьяна", "Василиса", "Елена", "Галина", "Светлана", "Юлия", "Антонина"};

        if (sex.equals(Sex.MAN)) {
            String ran = menRandom[random.nextInt(menRandom.length)];
            return ran;
        } else {
            return womenRandom[random.nextInt(womenRandom.length)];
        }
    }
}