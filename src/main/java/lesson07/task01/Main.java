package lesson07.task01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Set;
import java.util.TreeSet;

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

        // считываем текст из исходного файла накапливая в String Builder
        try (Reader reader = new InputStreamReader(new FileInputStream(fileInput))) {

            int count = reader.read();
            StringBuilder stringBuilder = new StringBuilder();
            while (count > 0) {
                stringBuilder.append((char) count);
                count = reader.read();
            }
            // форматируем полученный текст
            String string = stringBuilder.toString().toLowerCase().replaceAll("\\s+", "\n").replaceAll("\\p{Punct}", "");
            String[] list = string.split("\n");
            for (String str : list) {
                resList.add(str);
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