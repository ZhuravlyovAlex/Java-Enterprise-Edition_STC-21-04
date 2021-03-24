package lesson05;

import lesson05.model.Pet;

import java.util.*;

/**
 * Класс - картотека домашних животных. У каждого животного есть уникальный идентификационный номер, кличка, хозяин (объект класс Person с полями – имя, возраст, пол), вес.
 * Реализованы методы:
 * addPet - добавления животного в общий список (учитывается, что добавление дубликатов должно приводить к исключительной ситуации)
 * search - поиск животного по его кличке.
 * petUpdate - изменение данных животного по его идентификатору
 * sortView - вывод на экран списка животных в отсортированном порядке. Поля для сортировки –  хозяин, кличка животного, вес.
 * <p>
 * version 1.0
 * Copyright Журавлёв Алексей
 */

public class PetCardList<T extends Pet> {
    Comparator<Pet> petComparator = new Pet.PetOwnerComparator().thenComparing(new Pet.PetNameComparator()).thenComparing(new Pet.PetWeightComparator());
    private List<T> pets = new ArrayList<T>();
    private Map<String, T> petsMap = new HashMap<String, T>();
    private Map<Integer, T> petsId = new HashMap<Integer, T>();

    public void addPet(T t) { // добавления животного в общий список (учитывается, что добавление дубликатов должно приводить к исключительной ситуации)
        if (pets.contains(t)) {
            try {
                throw new PetDuplicateException();
            } catch (PetDuplicateException err) {
                System.out.println("Ошибка! В картотеке уже имеется данный питомц. \n");
            }
        } else {
            pets.add(t);
            petsMap.put(t.getName(), t);
            petsId.put(t.getId(), t);
        }

    }

    public void search(String name) { // поиск животного по его кличке.
        T petInfo = petsMap.get(name);
        System.out.println(petInfo);
    }

    public void petUpdate(int id, double weight) { // изменение данных животного по его идентификатору.
        T pet = (T) petsId.get(id);
        pets.remove(pet);
        pet.setWeight(weight);
        pets.add((T) pet);
    }


    public void sortView() { // вывод на экран списка животных в отсортированном порядке. Поля для сортировки –  хозяин, кличка животного, вес.
        pets.sort(petComparator);
        for (Pet pet : pets) {
            System.out.println(pet);
        }
    }
}