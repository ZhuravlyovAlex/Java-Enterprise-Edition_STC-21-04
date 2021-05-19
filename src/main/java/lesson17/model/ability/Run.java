package lesson17.model.ability;

/**
 * реализация поведения Run
 */

public class Run implements MoveBehavior{
    @Override
    public void move() {
        System.out.println("I'm running");
    }
}
