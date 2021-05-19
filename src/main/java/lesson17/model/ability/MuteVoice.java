package lesson17.model.ability;

/**
 * реализация не способности говорить
 */

public class MuteVoice implements VoiceBehavior{
    @Override
    public void voice() {
        System.out.println("Silence");
    }
}
