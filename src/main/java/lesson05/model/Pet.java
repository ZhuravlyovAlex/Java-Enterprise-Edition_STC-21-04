package lesson05.model;

public class Pet {
    private int id;
    String name;
    Person owner;
    double weight;

    public Pet(int id, String name, Person owner, double weight) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.weight = weight;
    }

    public Pet(int id, String name, double weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
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
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Pet{" + "id=" + id + ", name='" + name + '\'' + ", owner=" + owner + ", weight=" + weight + '}';
    }
}
