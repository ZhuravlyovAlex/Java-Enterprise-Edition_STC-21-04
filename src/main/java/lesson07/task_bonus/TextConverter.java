package lesson07.task_bonus;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * программа, которая читающая файл в кодировке UTF-8, а пишет в другой файл в кодировке UTF-16.
 * В программе используется InputStreamReader/OutputStreamWriter
 * * <p>
 * version 1.0
 * Copyright Журавлёв Алексей
 */

public class TextConverter {

    public static void main(String[] args) {
        // создаем входящие и исходящие файлы / папки
        File directory = new File("textConverter");
        directory.mkdir();
        File fileUtf8 = new File(directory, "fileUtf8.txt");
        File fileUtf16 = new File(directory, "fileUtf16.txt");

        try {
            fileUtf8.createNewFile();
            fileUtf16.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // считываем данные из файла в кодировке UTF-8
        StringBuilder result = new StringBuilder();
        try (Reader reader = new InputStreamReader(new FileInputStream(fileUtf8))) {
            int a = reader.read();
            while (a > 0) {
                result.append((char) a);
                a = reader.read();
            }
        } catch (
                Exception e) {
            e.printStackTrace();
        }
        // выводим данные в файл в кодировке UTF-16
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(fileUtf16), StandardCharsets.UTF_16)) {
            writer.write(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}