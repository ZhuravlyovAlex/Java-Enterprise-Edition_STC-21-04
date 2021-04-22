package lesson10;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Дан интерфейс:
 *
 * public interface Worker {
 *     void doWork();
 * }
 *
 * Программа построчно считывает с консоли код метода doWork.
 * После ввода пустой строки считывание прекращается и считанные строки добавляются в тело метода
 * public void doWork() в файле lesson10.SomeClass.java.
 * Файл lesson10.SomeClass.java компилируется программой (в рантайме) в файл lesson10.SomeClass.class.
 * Полученный файл подгружается в программу с помощью кастомного загрузчика
 * Метод, введенный с консоли, исполняется в рантайме (вызывается у экземпляра объекта подгруженного класса)
 * <p>
 * version 1.0
 * Copyright Журавлёв Алексей
 */

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        WorkWithFile newClass = new WorkWithFile();
        newClass.create();

        final Class someClass = LoadSomeClass();

        try {
            someClass.getMethod("doWork").invoke(someClass.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Class LoadSomeClass() throws ClassNotFoundException {
        MyClassLoader myClassLoader = new MyClassLoader();
        final Class<?> someClass = Class.forName("lesson10.SomeClass", true, myClassLoader);
        System.out.println(someClass + " has been loaded.");
        return someClass;
    }
}