package lesson04.task01;

import lesson04.task02.ObjectBox;

import java.util.HashSet;
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

public class MathBox<T extends Number> extends ObjectBox<Number> {

    private Set<Number> list;

    public MathBox(T[] number) throws DublicateException {
        list = new HashSet<>();

        for (T num : number) {
            if (!list.contains(num)) {
                list.add(num);
            } else {
                throw new DublicateException();
            }
        }
    }

    public double summator() { // Метод возвращает сумму всех элементов коллекции.
        double result = 0;
        for (Number element : list) {
            result += element.doubleValue();
        }
        return result;
    }

    public void splitter(Number div) { // Метод выполняет деление всех элементов коллекции поочередно на число передоваемое ввиде аргумента.
        Set<Number> result = new HashSet<>();
        for (Number element : list) {
            double el = element.doubleValue() / div.doubleValue();
            double d = (double)Math.round(el * 10) / 10.0; // Округляем до одного знака после запятой
            result.add(d);
        }
        list = result;
    }

    public void remove(Integer num) { // Метод который удаляет значение из коллекции если оно соответствует введённому аргументу
        list.remove(num);
    }

    @Override
    public String toString() {
        return "MathBox: " + list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBox<?> mathBox = (MathBox<?>) o;
        return Objects.equals(list, mathBox.list);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (list != null ? list.hashCode() : 0);
        return result;
    }
}
