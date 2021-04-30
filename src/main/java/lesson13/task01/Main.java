package lesson13.task01;

import java.util.ArrayList;
import java.util.List;

/**
 * Программа, демонстрирующая утечку памяти в Java. При этом объекты не только создаваться, но и периодически частично
 * удаляться, чтобы GC имел возможность очищать часть памяти.
 * Через некоторое время программа завершиться с ошибкой OutOfMemoryError c пометкой Java Heap Space.
 * <p>
 * version 1.0
 * Copyright Журавлёв Алексей
 */

public class Main {

    public static void main(String[] args) {
        List<Cat> list = new ArrayList<>();
        for (; ; ) {
            for (int i = 0; i < 20; i++) {
                list.add(new Cat());
            }
            list.remove(list.size() - 1);
        }
    }
}

