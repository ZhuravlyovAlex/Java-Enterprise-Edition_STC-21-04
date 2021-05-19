package lesson17.model;

import lesson17.model.ability.MuteVoice;
import lesson17.model.ability.Swim;

public class Fish extends Pet{
    public Fish(int id, String name, Person owner, double weight) {
        super(id, name, owner, weight);
        moveBehavior = new Swim();
        voiceBehavior = new MuteVoice();
    }
}
