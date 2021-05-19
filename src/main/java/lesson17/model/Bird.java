package lesson17.model;

import lesson17.model.ability.Fly;
import lesson17.model.ability.Whistle;

public class Bird extends Pet{
    public Bird(int id, String name, Person owner, double weight) {
        super(id, name, owner, weight);
        moveBehavior = new Fly();
        voiceBehavior = new Whistle();
    }
}
