package lesson03.task03.model;

/**
 * класс объекта Person
 * <p>
 * version 1.0
 * Copyright Журавлёв Алексей
 */

public class Person implements Comparable<Person> {
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

    public void setAge(int age) {
        if (age > 0 || age <= 100) {
            this.age = age;
        } else {
            System.out.println("Вы ввели некоректное значение возроста");
        }
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person: { " + name + ", " + age + ", " + sex + " }";
    }

    @Override
    public int compareTo(Person person) {
        if (this.equals(person)) {  // момент возникновения ошибки DublicatePersonException
            return 0;
        }
        if ((this.getSex() == Sex.MAN) && (person.getSex() == Sex.WOMAN)) { // сравниваем по половой пренадлежности
            return -1;
        } else if ((this.getAge() > person.getAge()) && (this.getSex() == person.getSex())) { // сравниваем по возрасту
            return -1;
        }
        if ((this.getAge() >= person.getAge()) && (this.getSex() == person.getSex()) && (this.getName().compareTo(person.getName()) <= -1)) { // сравниваем по алфавиту {
            return -1;
        }
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        if (age != person.age) {
            return false;
        }
        if (sex != person.sex) {
            return false;
        }
        return name.equals(person.name);
    }

}
