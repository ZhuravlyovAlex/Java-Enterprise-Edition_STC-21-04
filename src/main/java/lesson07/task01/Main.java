package lesson07.task01;

import java.io.*;
import java.util.*;

/**
 * программа, читающая текстовый файл и составляющая отсортированный по алфавиту список слов, найденных в файле
 * и сохраняющая его в файл-результат.
 * Условия: Найденные слова не должны повторяться, регистр не должен учитываться. Одно слово в разных падежах – это разные слова.
 * * <p>
 * version 1.0
 * Copyright Журавлёв Алексей
 */

public class Main {
    public static void main(String[] args) {
        Set<String> resList = new TreeSet<>();
        // создаем входящие и исходящие файлы / папки
        File dirInput = new File("inputDirectory");
        File dirOutput = new File("outDirectory");
        dirInput.mkdir();
        dirOutput.mkdir();
        File fileOutput = new File(dirOutput, "output.txt");
        File fileInput = new File(dirInput, "input.txt");

        try {
            fileInput.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // считываем текст из исходного файла, уберая знаки припенания и пробелы, результат накапливаем в String Builder
        try (Reader reader = new InputStreamReader(new FileInputStream(fileInput))) {
            int count = reader.read();
            StringBuilder result = new StringBuilder();
            while (count > 0) {
                if ((char) count == ',' || (char) count == '.' || (char) count == ':' || (char) count == ';' || (char) count == '!' || (char) count == '?') {
                    count = reader.read();
                } else if ((char) count == ' ') {
                    result.append('\n');
                    count = reader.read();
                } else {
                    result.append((char) count);
                    count = reader.read();
                }
            }
            // считанную строку делим на слова / переводим в нижний регистр / удаляем дубликаты и сохраняем в отсортированном виде в коллекции TreeSet
            String[] list = result.toString().split("\n");
            for (String str : list) {
                if (!resList.contains(str.toLowerCase())) {
                    resList.add(str.toLowerCase());
                }
            }
        } catch (
                Exception e) {
            e.printStackTrace();
        }
            // выводим отсортированную коллекцию в файл
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(fileOutput))) {
            for (String str : resList) {
                writer.write(str + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

