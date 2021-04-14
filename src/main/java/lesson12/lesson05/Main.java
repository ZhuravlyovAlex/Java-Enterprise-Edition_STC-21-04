package lesson12.lesson05;

import lesson12.lesson05.model.*;

/**
 * Факультативный класс демонстрирующий работу класса PetCardList
 * <p>
 * version 1.0
 * Copyright Журавлёв Алексей
 */

public class Main {
    public static void main(String[] args) {
        Person yana = new Person("Яна", 18, Sex.WOMEN);
        Person igor = new Person("Игорь", 25, Sex.MEN);
        Person andrey = new Person("Андрей", 21, Sex.MEN);
        Person vlada = new Person("Влада", 20, Sex.WOMEN);
        Person viktoria = new Person("Виктория", 27, Sex.WOMEN);
        Cat cat1 = new Cat(1, "Васька", yana, 3.5);
        Cat cat2 = new Cat(2, "Маркза", vlada, 4.5);
        Cat cat3 = new Cat(3, "Барон", andrey, 5.2);
        Dog dog1 = new Dog(4, "Рекс", igor, 9.0);
        Dog dog2 = new Dog(5, "Пират", viktoria, 9.5);
        Dog dog3 = new Dog(6, "Граф", vlada, 8.0);

        System.out.println("Картотека домашних питомцев");
        PetCardList petCardList = new PetCardList();
        petCardList.addPet(cat1);
        petCardList.addPet(cat2);
        petCardList.addPet(cat3);
        petCardList.addPet(dog1);
        petCardList.addPet(dog2);
        petCardList.addPet(dog3);

        petCardList.sortView();
        System.out.println();
        System.out.println("Попытка добавить в картотеку существующего питомца.");
        petCardList.addPet(dog3);
        petCardList.sortView();

        System.out.println();
        System.out.println("поиск животного по его кличке. Ищем питомца по кличке Граф");
        petCardList.search("Граф");
        System.out.println();

        System.out.println("изменение данных животного по его идентификатору (у питомца по кличке Граф изменим вес с 8.0 на 8.7");
        petCardList.petUpdate(6, 8.7);
        petCardList.sortView();
        System.out.println();
        petCardList.search("Граф");

        System.out.println();
        System.out.println("изменение клички животного по его идентификатору (у питомца по кличке Граф изменим вес Граф на Шариков");
        petCardList.petUpdate(6, "Шариков");
        petCardList.sortView();
        System.out.println();
        System.out.println("изменение данных о владельце животного по его идентификатору (питомц по кличке Шариков переехал от Влады к  Яне");
        petCardList.petUpdate(6,yana);
        petCardList.sortView();
        System.out.println();
        petCardList.search("Шариков");
    }
}
