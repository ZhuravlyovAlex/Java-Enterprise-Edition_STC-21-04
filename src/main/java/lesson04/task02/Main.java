package lesson04.task02;

/**
 * Факультативный класс предназначенный для демонстрации работы класса ObjectBox
 * <p>
 * version 1.0
 * Copyright Журавлёв Алексей
 */
public class Main {
    public static void main(String[] args) {

        Object[] objects = new Object[] {"string", new Integer(23), new Float(2.5f), new Double(23.3), new Character('A')};
        ObjectBox objectBox = new ObjectBox<>();
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
    }
}
