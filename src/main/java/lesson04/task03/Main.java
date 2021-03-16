package lesson04.task03;


import lesson04.task02.ObjectBox;

/**
 * Факультативный класс предназначенный для демонстрации работы класса MathBox
 * <p>
 * version 1.0
 * Copyright Журавлёв Алексей
 */
public class Main {
    public static void main(String[] args) throws DublicateException, ClassCastException {

        Number[] numbers = new Number[]{(byte) 13, (short) 230, 52, 23f, 3.1, 555l, 52};
        MathBox el = new MathBox(numbers);
        System.out.println();

        System.out.println("наша колекция");
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

        Object[] objects = new Object[]{"string", new Integer(23), new Float(2.5f), new Double(23.3), new Character('A')};
        lesson04.task02.ObjectBox objectBox = new ObjectBox<>();
        System.out.println();
        System.out.println("результат отработки метода addObject() (через цикл добавляем в objectBox объекты: String, Integer, Float, Double, Character)");
        System.out.println("для вывода на экран используем метод dump()");
        System.out.println();

        for (Object object : objects) {
            objectBox.addObject(object);
        }
        objectBox.dump();
        System.out.println();

        System.out.println("результат отработки метода deleteObject(). Удаляем объект Character");
        objectBox.deleteObject('A');
        objectBox.dump();
        System.out.println();

        System.out.println("добавляем MathBox в ObjectBox");
        objectBox.addObject(el);
        objectBox.dump();
        System.out.println();

        System.out.println("пытаемся добавить ObjectBox в MathBox");
        try {
            el.addObject (objectBox);
        } catch (NoNumberClassException e) {
            System.out.println("Ошибка. Нельзя добавить ObjectBox в MathBox ");
        }
    }
}
