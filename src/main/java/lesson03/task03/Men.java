package lesson03.task03;

import java.util.Random;

public enum Men {
    Марсель, Иван, Александр, Кирилл, Пётр, Борис, Сергей, Василь, Дмитрий, Михаил;

    public static Men randomMen() {
        int ran = new Random().nextInt(Men.values().length);
        return Men.values()[ran];
    }
}
