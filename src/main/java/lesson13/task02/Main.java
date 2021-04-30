package lesson13.task02;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * Программа, демонстрирующая утечку памяти в Java. При этом объекты не только создаваться, но и периодически частично
 * удаляться, чтобы GC имел возможность очищать часть памяти.
 * Через некоторое время программа завершиться с ошибкой OutOfMemoryError c пометкой Metaspace / Permanent Generation.
 *
 * <p>
 * version 1.0
 * Copyright Журавлёв Алексей
 */

public class Main {

    public static String base = "Сat ";
    private static final JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

    public static void main(String[] args) throws ClassNotFoundException {

        File sourceFile = new File("src\\main\\java\\lesson13\\task01\\Cat.java");
        sourceFile.getName();
        compiler.run(null, null, null, sourceFile.getAbsolutePath());

        List<Object> list = new ArrayList<>();

        for (; ; ) {
            for (int i = 0; i < 10000; i++) {

                list.add(new MyClassLoader().loadClass("lesson13.task01.Cat"));
                final Class cat = LoadCatClass();
                System.out.println(cat.getClassLoader());

            }
            list.remove(list.size() - 1);
        }
    }

    public static Class LoadCatClass() throws ClassNotFoundException {

        MyClassLoader myClassLoader = new MyClassLoader();
        final Class<?> catClass = Class.forName("lesson13.task01.Cat", true, myClassLoader);
        System.out.println(catClass + " has been loaded.");
        return catClass;
    }
}