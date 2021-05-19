package lesson17.model;

import lesson17.model.ability.Miu;
import lesson17.model.ability.Run;

public class Cat extends Pet {
    public Cat(int id, String name, Person owner, double weight) {
        super(id, name, owner, weight);
        moveBehavior = new Run();
        voiceBehavior = new Miu();
    }
}
