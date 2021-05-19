package lesson17;

import lesson17.model.Person;
import lesson17.model.Pet;

import java.util.*;

/**
 * Класс - картотека домашних животных. У каждого животного есть уникальный идентификационный номер, кличка,
 * хозяин (объект класс Person с полями – имя, возраст, пол), вес.
 * Реализованы методы:
 * addPet - добавления животного в общий список (учитывается, что добавление дубликатов должно приводить к
 * исключительной ситуации)
 * search - поиск животного по его кличке.
 * petUpdate - изменение данных животного по его идентификатору
 * sortView - вывод на экран списка животных в отсортированном порядке. Поля для сортировки –  хозяин,
 * кличка животного, вес.
 *
 * реализован поведенческий паттерн "Стратегия" (реализующий наделение питомцев способностями).
 * добавлен метод showAbility - для вывода способностей питомца на экран, по его имени.
 *
 * <p>
 * version 3.0
 * Copyright Журавлёв Алексей
 */

public class PetCardList<T extends Pet> {
    Comparator<Pet> petComparator = new Pet.PetOwnerComparator().thenComparing(
            new Pet.PetNameComparator()).thenComparing(new Pet.PetWeightComparator());
    private Map<Integer, T> pets = new HashMap<Integer, T>();
    // добавления животного в общий список (учитывается, что добавление дубликатов должно приводить
    // к исключительной ситуации)
    public void addPet(T t) {
        if (pets.containsValue(t)) {
            try {
                throw new PetDuplicateException();
            } catch (PetDuplicateException err) {
                System.out.println("Ошибка! В картотеке уже имеется данный питомец. \n");
            }
        } else {
            pets.put(t.getId(), t);
        }
    }
    // поиск животного по его кличке.
    public void search(String name) {
        for (Pet pet : pets.values()) {
            if (name.equals(pet.getName())) {
                System.out.println(pet);
            }
        }
    }

    // изменение данных животного по его идентификатору.
    public void petUpdate(int id, double weight) {
        T pet = (T) pets.get(id);
        pet.setWeight(weight);
        pets.put(pet.getId(), pet);
    }
    // изменение клички животного по его идентификатору.
    public void petUpdate(int id, String name) {
        T pet = pets.get(id);
        pet.setName(name);
        pets.put(pet.getId(), pet);
    }
    // изменение владельца животного по его идентификатору.
    public void petUpdate(int id, Person owner) {
        T pet = (T) pets.get(id);
        pet.setOwner(owner);
        pets.put(pet.getId(), pet);
    }
    // вывод на экран списка животных в отсортированном порядке. Поля для сортировки –  хозяин, кличка животного, вес.
    public void sortView() {
        List list = new ArrayList();
        for (Pet pet : pets.values()) {
            list.add(pet);
        }

        Collections.sort(list, petComparator);
        for (Object pet : list) {
            System.out.println(pet);
        }
    }
    // класс для вывода на экран способюностей питомца
    public void showAbility(String name) {
        for (Pet pet : pets.values()) {
            if (name.equals(pet.getName())) {
                System.out.print("Меня зовут: " + pet.getName() + "\n");
                pet.performMove();
                System.out.print("and saying: ");
                pet.performVoice();
                System.out.println();
            }
        }
    }
}