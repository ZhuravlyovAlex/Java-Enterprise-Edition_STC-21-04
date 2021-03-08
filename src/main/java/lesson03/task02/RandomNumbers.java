package lesson03.task02;

import java.util.Random;
import java.util.Scanner;

/**
 * Программа, генерирующую N случайных чисел.
 * Для каждого числа k вычисляется квадратный корень q. Если квадрат целой части q числа равен k,
 * то это число выводиться на экран.
 * Если первоначальные числа отрицательные, то в этом случае генерируется исключение.
 * <p>
 * version 1.0
 * Copyright Журавлёв Алексей
 */

public class RandomNumbers {
    public static int k;

    public static void main(String[] args) {
        Random rd = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите число N: "); // просим пользователя задать количество (N) случайных целых чисел .
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) { // генерим N случайных целых чисел.
            k = rd.nextInt(400) - 200;
            try {
                if (k < 0) { // проверяем на отрицательные значения; если значение отицательное, то выкидываем исключение IllegalArgumentException.
                    throw new IllegalArgumentException();
                } else {
                    int q = (int) Math.sqrt(k); // вычисляем квадратный корень рандомного числа.
                    if (Math.pow(q, 2) == k) {  // проверяем равен ли квадрат целой части q, рандомному числу k, если да, выводим k на экран.
                        System.out.println(k);
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("неверное значение аргумента k (" + k + ")");
            }
        }
    }
}