package lesson17.model.ability;

/**
 * реализация голоса для кошки
 */

public class Miu implements VoiceBehavior{
    @Override
    public void voice() {
        System.out.println("Miu, miu");
    }
}
