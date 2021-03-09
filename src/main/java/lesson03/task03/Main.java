package lesson03.task03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Дан массив объектов Person. Класс Person характеризуется полями age (возраст, целое число 0-100), sex (пол – объект класса Sex со строковыми константами внутри MAN, WOMAN), name (имя - строка). Создать два класса, методы которых будут реализовывать сортировку объектов. Предусмотреть единый интерфейс для классов сортировки. Реализовать два различных метода сортировки этого массива по правилам:
 * первые идут мужчины
 * выше в списке тот, кто более старший
 * имена сортируются по алфавиту
 * Программа должна вывести на экран отсортированный список и время работы каждого алгоритма сортировки.
 * Предусмотреть генерацию исходного массива (10000 элементов и более).
 * Если имена людей и возраст совпадают, выбрасывать в программе пользовательское исключение.
 * <p>
 * version 1.0
 * Copyright Журавлёв Алексей
 */

public class Main {
    private static int num;
    private static String name;

    public static void main(String[] args) {

        List<Person> men = new ArrayList<>();
        Random rd = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите количество персон: ");
        num = sc.nextInt();

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
        for (Person person : men) {
            System.out.println(person);
        }

    }
}
