package lesson17.model.ability;
/**
 * реализация голоса для собаки
 */
public class Gav implements VoiceBehavior{
    @Override
    public void voice() {
        System.out.println("Gav, gav");
    }
}
