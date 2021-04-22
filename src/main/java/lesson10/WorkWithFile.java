package lesson10;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Класс создающий создающий SomeClass.java, с переопределенным методом doWork()
 * с учетом введенного с консоли кода и компилирующий его в class - файл.
 *
 * <p>
 * version 1.0
 * Copyright Журавлёв Алексей
 */
public class WorkWithFile {
    private static final JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

    public void create() throws IOException {

        File file = new File("SomeClass.java");
        file.createNewFile();

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("package lesson10;\n" + "\n"
                + "public class SomeClass implements Worker {\n"
                + "\t@Override\n" + "\tpublic void doWork() {\n\t");

        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        String s = "";
        System.out.println("Enter your code:\n");
        while (true) {
            s = sc.nextLine();
            if (s.equals("")) break;
            sb.append(s);
            sb.append("\n");
        }
        sb.append("\t}\n" + "}");
        fileWriter.write(sb.toString());
        fileWriter.close();

        compiler.run(null, null, null, file.getAbsolutePath());
    }
}