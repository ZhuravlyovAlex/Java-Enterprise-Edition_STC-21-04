package lesson03.task03.model;

import java.util.Random;

/**
 * Enum класс по полю men.
 * Имеет метод возвращающий рандомные значения поля.
 * <p>
 * version 1.0
 * Copyright Журавлёв Алексей
 */

public enum Men {
    Марсель, Иван, Александр, Кирилл, Пётр, Борис, Сергей, Василь, Дмитрий, Михаил;

    public static Men randomMen() { // метод возращающий рандомное значение для поля men
        int ran = new Random().nextInt(Men.values().length);
        return Men.values()[ran];
    }
}
