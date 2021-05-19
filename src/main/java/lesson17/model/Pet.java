package lesson17.model;

import lesson17.model.ability.MoveBehavior;
import lesson17.model.ability.VoiceBehavior;

import java.util.Comparator;

public abstract class Pet implements Comparator<Pet> {
    private int id;
    private String name;
    private Person owner;
    private double weight;
    /**
     * объявляемм ссылочные переменные с типами интерфесов поведения
     */
    VoiceBehavior voiceBehavior;
    MoveBehavior moveBehavior;

    public Pet(int id, String name, Person owner, double weight) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.weight = weight;
    }

    /**
     * деллигируем операции классам поведения
     */
    public void performVoice () {
        voiceBehavior.voice();
    }
    public void performMove () {
        moveBehavior.move();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    @Override
    public String toString() {
        return "Питомец { id=" + id + ", кличка: " + name + '\'' + ", владелец: " + owner + ", вес: " + weight + '}';
    }

    @Override
    public int compare(Pet a, Pet b) {
        return Comparator
                .comparing(Pet::getOwner)
                .thenComparing(Pet::getName)
                .thenComparing(Pet::getWeight)
                .compare(a, b);
    }

    public static class PetOwnerComparator implements Comparator<Pet> {
        public int compare(Pet a, Pet b) {
            return a.getOwner().getName().compareTo(b.getOwner().getName());
        }
    }

    public static class PetNameComparator implements Comparator<Pet> {
        public int compare(Pet a, Pet b) {
            return a.getName().compareTo(b.getName());
        }
    }

    public static class PetWeightComparator implements Comparator<Pet> {
        public int compare(Pet a, Pet b) {
            if (a.getWeight() > b.getWeight()) {
                return 1;
            } else if (a.getWeight() < b.getWeight()) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}

