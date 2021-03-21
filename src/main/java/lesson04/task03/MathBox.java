package lesson04.task03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;


/**
 * Класс конструктор которого на вход получает массив Number. Элементы не могут повторяться. Элементы массива внутри объекта раскладываются в коллекцию HashSet.
 * Рализует методы:
 * remove - который получает на вход Integer и если такое значение есть в коллекции, удаляет его.
 * summator - возвращающий сумму всех элементов коллекции.
 * splitter - метод выполняющий поочередное деление всех хранящихся в объекте элементов на делитель, являющийся аргументом метода. Хранящиеся в объекте данные полностью заменяются результатами деления
 * <p>
 * version 1.0
 * Copyright Журавлёв Алексей
 */

public class MathBox<T extends Number, object> extends ObjectBox<Number> {
    public MathBox(T[] number) throws DublicateException {

        for (T num : number) {
            if (!set.contains(num)) {
                set.add(num);
            } else {
                try {
                    throw new DublicateException();
                } catch (DublicateException e) {
                    System.out.println("Ошибка. Вы пытаетесь добавить существующее значение.");
                }
            }
        }
    }

    public double summator() { // Метод возвращает сумму всех элементов коллекции.
        double result = 0;
        for (Number element : set) {
            result += element.doubleValue();
        }
        return result;
    }

    public void splitter(Number div) { // Метод выполняет деление всех элементов коллекции поочередно на число передоваемое ввиде аргумента.
        Set<Number> result = new HashSet<>();
        for (Number element : set) {
            double el = element.doubleValue() / div.doubleValue();
            double d = (double) Math.round(el * 10) / 10.0; // Округляем до одного знака после запятой
            result.add(d);
        }
        set = result;
    }

    public void remove(Integer num) { // Метод который удаляет значение из коллекции если оно соответствует введённому аргументу
        set.remove(num);
    }


    @Override
    public void addObject(Number object) {
        super.addObject(object);

    }

    @Override
    public void deleteObject(Number object) {
        super.deleteObject(object);
    }

    @Override
    public void dump() {
        System.out.println("MathBox: " + set.toString());
    }

    @Override
    public String toString() {
        return "MathBox: " + set;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBox mathBox = (MathBox) o;
        return Objects.equals(set, mathBox.set);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (set != null ? set.hashCode() : 0);
        return result;
    }

}
