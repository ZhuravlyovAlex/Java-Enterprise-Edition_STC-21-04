package lesson03.task03;

import java.util.Random;

public enum Sex {
    MAN, WOMAN;

    public static Sex randomSex() {
        int ran = new Random().nextInt(Sex.values().length);
        return Sex.values()[ran];
    }
}
