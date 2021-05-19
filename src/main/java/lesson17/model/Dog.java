package lesson17.model;

import lesson17.model.ability.Gav;
import lesson17.model.ability.Run;

public class Dog extends Pet{
    public Dog(int id, String name, Person owner, double weight) {
        super(id, name, owner, weight);
        moveBehavior = new Run();
        voiceBehavior = new Gav();
    }
}
