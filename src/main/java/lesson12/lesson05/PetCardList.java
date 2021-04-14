package lesson12.lesson05;

import lesson12.lesson05.model.Person;
import lesson12.lesson05.model.Pet;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Класс - картотека домашних животных. У каждого животного есть уникальный идентификационный номер, кличка, хозяин (объект класс Person с полями – имя, возраст, пол), вес.
 * Реализованы методы:
 * addPet - добавления животного в общий список (учитывается, что добавление дубликатов должно приводить к исключительной ситуации)
 * search - поиск животного по его кличке.
 * petUpdate - изменение данных животного по его идентификатору
 * sortView - вывод на экран списка животных в отсортированном порядке. Поля для сортировки –  хозяин, кличка животного, вес.
 * <p>
 * version 2.0
 * Copyright Журавлёв Алексей
 */

public class PetCardList<T extends Pet> {
    Comparator<Pet> petComparator = new Pet.PetOwnerComparator().thenComparing(new Pet.PetNameComparator()).thenComparing(new Pet.PetWeightComparator());
    private Map<Integer, T> pets = new HashMap<Integer, T>();

    public void addPet(T t) { // добавления животного в общий список (учитывается, что добавление дубликатов должно приводить к исключительной ситуации)
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

    public void search(String name) { // поиск животного по его кличке.
//        for (Pet pet : pets.values()) {
//            if (name.equals(pet.getName())) {
//                System.out.println(pet);
//            }
//        }
        pets.values().stream()
                .filter(p -> p.getName().equals(name))
                .forEach(System.out::println);
    }

    public void petUpdate(int id, double weight) { // изменение данных животного по его идентификатору.
//        T pet = (T) pets.get(id);
//        pet.setWeight(weight);
//        pets.put(pet.getId(), pet);
        pets.values().stream().anyMatch(pet -> {
            if (pet.getId() == id) {
                pet.setWeight(weight);
                pets.put(pet.getId(), pet);
            }
            return false;
        });
    }

    public void petUpdate(int id, String name) { // изменение клички животного по его идентификатору.
        T pet = pets.get(id);
        pet.setName(name);
        pets.put(pet.getId(), pet);
    }

    public void petUpdate(int id, Person owner) { // изменение владельца животного по его идентификатору.
        T pet = (T) pets.get(id);
        pet.setOwner(owner);
        pets.put(pet.getId(), pet);
    }

    public void sortView() { // вывод на экран списка животных в отсортированном порядке. Поля для сортировки –  хозяин, кличка животного, вес.
//        List list = new ArrayList();
//        for (Pet pet : pets.values()) {
//            list.add(pet);
//        }
//
//        Collections.sort(list, petComparator);
//        for (Object pet : list) {
//            System.out.println(pet);
//        }
        pets.values().stream()
                .sorted(petComparator)
                .forEach(System.out::println);
    }
}