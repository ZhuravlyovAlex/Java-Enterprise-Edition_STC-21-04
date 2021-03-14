package lesson04.task03;

import lesson04.task01.DublicateException;
import lesson04.task01.MathBox;

/**
 * Факультативный класс предназначенный для демонстрации работы класса MathBox
 * <p>
 * version 1.0
 * Copyright Журавлёв Алексей
 */
public class Main {
    public static void main(String[] args) throws DublicateException {

        Number[] array = {5,2,20,7,8};
        MathBox el = new MathBox(array);

        System.out.println("Наша колекция");
        System.out.println(el.toString());
        System.out.println();

        int rem = 8;
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

        System.out.println("результат отработки метода addObject() (поочередно добавляем: int, char, String, MathBox)");
        System.out.println("для вывода на экран используем метод dump()");

        el.addObject(54);
        el.dump();

        el.addObject('\u0462');
        el.dump();

        el.addObject("Hola, Innopolis!");
        el.dump();

        el.addObject(el);
        el.dump();
        System.out.println();
        System.out.println("результат отработки метода deleteObject(). Удаляем объект MathBox");
        el.deleteObject(el);
        el.dump();

    }
}
