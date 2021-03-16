package lesson04.task01;

/**
 * Факультативный класс предназначенный для демонстрации работы класса MathBox
 * <p>
 * version 1.0
 * Copyright Журавлёв Алексей
 */
public class Main {
    public static void main(String[] args) throws DublicateException {
        System.out.println();
        System.out.println("Попытка спровацировать ошибку DublicateException");

        Number[] numbers = new Number[]{(byte) 13, (short) 230, 52, 23f, 3.1, 555l, 52};
        MathBox el = new MathBox(numbers);
        System.out.println();

        System.out.println("Наша колекция:");
        System.out.println(el.toString());
        System.out.println();

        int rem = 230;
        System.out.println("результат отработки метода: remove (удаляем число: " + rem + ")");
        el.remove(rem);
        System.out.println(el.toString());
        System.out.println();

        System.out.println("результат отработки метода: summator");
        double sum = el.summator();
        System.out.println(sum);
        System.out.println();

        int div = 2;
        System.out.println("результат отработки метода: splitter с делителем " + div);
        el.splitter(div);
        System.out.println(el.toString());
        System.out.println();

    }
}
