package lesson17.model;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private Sex sex;

    public Person(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "{" +
                "имя: " + name + '\'' +
                ", возраст: " + age +
                ", пол: " + sex +
                " }";
    }

    @Override
    public int compareTo(Person o) {
        if (name.compareTo(o.getName()) < 0) {
            return -1;
        }
        return 0;
    }
}
