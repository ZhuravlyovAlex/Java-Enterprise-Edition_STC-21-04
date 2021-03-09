package lesson03.task03.model;

/**
 * класс объекта Person
 * <p>
 * version 1.0
 * Copyright Журавлёв Алексей
 */

public class Person {
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

    public void setAge (int age) {
        if(age > 0 || age <= 100) {
            this.age = age;
        }else{
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
}
