package lesson05.model;

public class Cat extends Pet{
    public Cat(int id, String name, Person owner, double weight) {
        super(id, name, owner, weight);
    }

    public Cat(int id, String name, double weight) {
        super(id, name, weight);
    }
}
