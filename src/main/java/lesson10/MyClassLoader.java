package lesson10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Класс Loader для загрузки SomeClass.class
 *
 * <p>
 * version 1.0
 * Copyright Журавлёв Алексей
 */

public class MyClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if("lesson10.SomeClass".equals(name))
        try {
            byte[] content = Files.readAllBytes(Paths.get("SomeClass.class"));
            final Class<?> simple = defineClass(name, content, 0, content.length);
            return simple;
        } catch (IOException e) {
            System.out.println("Oops, something went wrong");
            return null;
        }
        return super.findClass(name);
    }
}