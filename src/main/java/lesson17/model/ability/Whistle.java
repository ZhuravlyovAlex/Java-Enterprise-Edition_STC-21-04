package lesson17.model.ability;

/**
 * реализация голоса для птиц
 */

public class Whistle implements VoiceBehavior{
    @Override
    public void voice() {
        System.out.println("Chiric, chiric");
    }
}