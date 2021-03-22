package lesson05.model;

public class Dog extends Pet{
    public Dog(int id, String name, Person owner, double weight) {
        super(id, name, owner, weight);
    }

    public Dog(int id, String name, double weight) {
        super(id, name, weight);
    }
}
