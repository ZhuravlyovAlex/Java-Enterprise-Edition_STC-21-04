package lesson03.task03;

import lesson03.task03.model.Person;
import lesson03.task03.model.PersonGenerator;

import java.util.List;
import java.util.Scanner;

/**
 * Приложение генерирующее исходный массив (10000 элементов и более) объектов Person, характеризуется полями age (возраст, целое число 0-100),
 * sex (пол – объект класса Sex со строковыми константами внутри MAN, WOMAN), name (имя - строка).
 * Имеет два класса, методы которые реализовывают два различных метода сортировки объектов, по следующим правилам:
 * первые идут мужчины
 * выше в списке тот, кто более старший
 * имена сортируются по алфавиту
 * Программа выводит на экран отсортированный список и время работы каждого алгоритма сортировки.
 * Если имена людей и возраст совпадают, выбрасывать в программе пользовательское исключение.
 * <p>
 * version 1.0
 * Copyright Журавлёв Алексей
 */

public class Main {
    private static int num;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество персон: ");
        num = sc.nextInt();

        List <Person> people = PersonGenerator.personListSort(num);

        for (Person person : people) {
            System.out.println(person);
        }

    }
}
