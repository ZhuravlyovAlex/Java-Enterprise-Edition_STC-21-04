package lesson17.model.ability;

/**
 * реализация поведения Swim
 */

public class Swim implements MoveBehavior{
    @Override
    public void move() {
        System.out.println("I'm swimming");
    }
}
