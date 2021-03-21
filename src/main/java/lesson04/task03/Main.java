package lesson04.task03;


/**
 * Факультативный класс предназначенный для демонстрации работы класса MathBox
 * <p>
 * version 1.0
 * Copyright Журавлёв Алексей
 */
public class Main {
    public static void main(String[] args) throws DublicateException, ClassCastException {
        System.out.println();
        System.out.println("Подаём на вход массив: {(byte) 13, (short) 230, 52, 23f, 3.1, 555l, 52}");
        System.out.println("Попытка спровоцировать ошибку DublicateException. Пытаемся передать на вход два одинаковых элемента со значением 52");
        System.out.println();
        Number[] numbers = new Number[]{(byte) 13, (short) 230, 52, 23f, 3.1, 555l, 52};
        MathBox el = new MathBox(numbers);
        System.out.println(el.toString());

        System.out.println();
        System.out.println("Добавляем в MathBox объект Integer со значением 8 и Double со значением 13, используя метод addObject()");
        Integer a = 8;
        Double b = 13.0;
        el.addObject(a);
        el.addObject(b);
        el.dump();

        System.out.println();
        System.out.println("Удаляем объект Integer со значением 8 через метод remove(), а объект Double со значением 13 используя метод deleteObject() ");
        el.remove(a);
        el.deleteObject(b);
        el.dump();
        System.out.println();

        System.out.println("результат отработки метода: summator");
        double sum = el.summator();
        System.out.println(sum);
        System.out.println();

        int div = 2;
        System.out.println("результат отработки метода: splitter с делителем " + div);
        el.splitter(div);
        System.out.println(el.toString());

        Object[] objects = new Object[]{"string", new Integer(23), new Float(2.5f), new Double(23.3), new Character('A')};
        ObjectBox objectBox = new ObjectBox<>();
        System.out.println();
        System.out.println("Демонстрируем работоспособность класса ObjectBox (через цикл добавляем в objectBox объекты: String, Integer, Float, Double, Character)");
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
            el.addObject(objectBox);
        } catch (ClassCastException e) {
            System.out.println("Ошибка. Нельзя добавить ObjectBox в MathBox ");
        }
    }
}
