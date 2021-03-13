package lesson04.task01;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Класс тестировния методов класса MathBox
 * <p>
 * version 1.0
 * Copyright Журавлёв Алексей
 */

public class MathBoxTest {
    private MathBox el;


    @Test
    public void whenSumAllElementsThenReturnedRightValue() throws DublicateException {
        Integer[] array = {5, 2, 20, 7};
        el = new MathBox(array);
        Number result = el.summator();
        assertEquals(34.0, result);
    }

    @Test(expected = DublicateException.class)
    public void whenThenThrownException() throws DublicateException {
        Integer[] array = {5, 2, 20, 7, 2};
        el = new MathBox(array);
    }

    @Test
    public void whenEachElementsOfTheArrayDivisibleByTheValueOfTheArgument() throws DublicateException {
        Double[] array1 = {2.5,1.0,10.0,3.5};
        Integer[] array2 = {5,2,20,7};
        MathBox el1 = new MathBox(array1);
        MathBox el2 = new MathBox(array2);
        el2.splitter(2);
        assertEquals(el1.hashCode(), el2.hashCode());
    }
    @Test
    public void whenElementRemovedThenArrayMustBeDecreased() throws DublicateException {
        Integer[] array1 = {5,2,20};
        Integer[] array2 = {5,2,20,7};
        MathBox el1 = new MathBox(array1);
        MathBox el2 = new MathBox(array2);
        el2.remove(7);
        assertEquals(el1.hashCode(), el2.hashCode());
    }
}