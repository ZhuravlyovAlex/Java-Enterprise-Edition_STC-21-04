package lesson03.task03;

import java.util.Random;

public enum Women {
    Виктория, Иванка, Александра, Татьяна, Василиса, Елена, Галина, Светлана, Юлия, Антонина;

    public static Women randomWomen() {
        int ran = new Random().nextInt(Women.values().length);
        return Women.values()[ran];
    }
}
