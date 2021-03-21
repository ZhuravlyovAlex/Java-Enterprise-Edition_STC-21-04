package lesson03.task03.model;

import java.util.Random;

/**
 * Enum класс по полю sex.
 * Имеет метод возвращающий рандомные значения поля.
 * <p>
 * version 1.0
 * Copyright Журавлёв Алексей
 */

public enum Sex {
    MAN, WOMAN;

    public static Sex randomSex() { // метод возращающий рандомное значение для поля sex
        int ran = new Random().nextInt(Sex.values().length);
        return Sex.values()[ran];
    }
}
