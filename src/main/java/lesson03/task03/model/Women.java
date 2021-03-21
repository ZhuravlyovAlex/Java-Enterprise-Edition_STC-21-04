package lesson03.task03.model;

import java.util.Random;

/**
 * Enum класс по полю women.
 * Имеет метод возвращающий рандомные значения поля.
 * <p>
 * version 1.0
 * Copyright Журавлёв Алексей
 */

public enum Women {
    Виктория, Иванка, Александра, Татьяна, Василиса, Елена, Галина, Светлана, Юлия, Антонина;

    public static Women randomWomen() { // метод возращающий рандомное значение для поля women
        int ran = new Random().nextInt(Women.values().length);
        return Women.values()[ran];
    }
}
