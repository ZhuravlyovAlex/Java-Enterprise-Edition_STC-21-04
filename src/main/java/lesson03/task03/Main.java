package lesson03.task03;

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

    public static void main(String[] args) throws DublicatePersonException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество персон: ");
        num = sc.nextInt();

        // Генерация коллекции и сортировка по методу Bubble Sort
        long start = System.currentTimeMillis();
        PersonGeneratorWithBubbleSort people1 = PersonGenerator.personListBubbleSort(num);
        people1.sort();

        for (int i = 0; i < people1.size(); i++) {
            System.out.println(people1.getNode(i).getValue());
        }

        long finish = System.currentTimeMillis();

        System.out.println("Время выполнения сортировки по методу Bubble Sort: " + (finish - start) + "ms");

        System.out.println();

        // Генерация коллекции и сортировка по методу Insertion sort
        start = System.currentTimeMillis();
        PersonGeneratorWithInsertionSort people2 = PersonGenerator.personListInsertionSort(num);
        people2.sort();

        for (int i = 0; i < people2.size(); i++) {
            System.out.println(people2.getNode(i).getValue());
        }

        finish = System.currentTimeMillis();

        System.out.println("Время выполнения сортировки по методу Insertion sort: " + (finish - start) + "ms");
    }
}
