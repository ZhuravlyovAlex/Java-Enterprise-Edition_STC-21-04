package lesson17.model.ability;

/**
 * реализация поведения Fly
 */

public class Fly implements MoveBehavior{
    @Override
    public void move() {
        System.out.println("I'm flying");
    }
}
