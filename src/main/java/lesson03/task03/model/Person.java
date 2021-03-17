package lesson03.task03.model;

import java.util.Comparator;

/**
 * класс объекта Person
 * <p>
 * version 1.0
 * Copyright Журавлёв Алексей
 */

public class Person implements Comparator<Person> {
    private int age;
    private Sex sex;
    private String name;

    public Person(int age, Sex sex, String name) {
        this.age = age;
        this.sex = sex;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person: { " + name + ", " + age + ", " + sex + " }";
    }

    public int compare(Person a, Person b) {
        return Comparator
                .comparing(Person::getSex)
                .thenComparing(Person::getAge)
                .thenComparing(Person::getName)
                .compare(a, b);
    }

    public static class PersonSexComparator implements Comparator<Person> {
        public int compare(Person a, Person b) {
            if ((a.getSex() == Sex.MAN) && (b.getSex() == Sex.WOMAN))
                return 1;
            else if ((a.getSex() == Sex.WOMAN) && (b.getSex() == Sex.MAN))
                return -1;
            else
                return 0;
        }
    }

    public static class PersonAgeComparator implements Comparator<Person> {
        public int compare(Person a, Person b) {
            if (a.getAge() > b.getAge())
                return 1;
            else if (a.getAge() < b.getAge())
                return -1;
            else
                return 0;
        }
    }

    public static class PersonNameComparator implements Comparator<Person> {
        public int compare(Person a, Person b) {
            return a.getName().compareTo(b.getName());
        }
    }
}
