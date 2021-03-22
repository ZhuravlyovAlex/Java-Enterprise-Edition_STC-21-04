package lesson05.model;

import java.util.HashSet;
import java.util.Set;

public class Person {
    private String name;
    private int age;
    private Sex sex;
    private Set<Pet> pet = new HashSet<>();

    public Person(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

}
