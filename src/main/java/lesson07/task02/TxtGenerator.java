package lesson07.task02;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Random;

/**
 * Класс генератор текстовых файлов, работающий по следующим правилам:
 * <p>
 * Предложение состоит из 1<=n1<=15 слов. В предложении после произвольных слов могут находиться запятые.
 * Слово состоит из 1<=n2<=15 латинских букв
 * Слова разделены одним пробелом
 * Предложение начинается с заглавной буквы
 * Предложение заканчивается (.|!|?)+" "
 * Текст состоит из абзацев. в одном абзаце 1<=n3<=20 предложений. В конце абзаца стоит разрыв строки и перенос каретки.
 * Есть массив слов 1<=n4<=1000. Есть вероятность probability вхождения одного из слов этого массива в следующее предложение (1/probability).
 * Необходимо написать метод getFiles(String path, int n, int size, String[] words, int probability), который создаст n файлов размером size в каталоге path. words - массив слов, probability - вероятность.* * <p>
 * * <p>
 * version 1.0
 * Copyright Журавлёв Алексей
 */

public class TxtGenerator {
    Random rd = new Random();
    private static char[] charDict = new char[]{'.', '!', '?'};

    public void getFiles(String path, int n, int size, String[] words, int probability) {
        for (int i = 1; i <= n; i++) {
            generator(path, i, size, words, probability);
        }
    }

    public void generator(String path, int i, int size, String[] words, int probability) {
        StringBuilder result = new StringBuilder();
        File directory = new File(path);
        directory.mkdirs();
        File file = new File(path + "_" + i + ".txt");
        int count = size;
        while (count > 0) {
            if (count <= 15) {
                result.append(getWord());
                count -= result.length();
            } else if (count > 15 && count <= 254) {
                result.append(getSentence(words, probability));
                count -= result.length();
            } else if (count > 254) {
                result.append(getParagraph(words, probability));
                count -= result.length();
            }
        }
        // выводим сгенерированный текст в файл
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(file))) {
            writer.write(result.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод генерирует слово
     * <p>
     * Слово состоит из 1<=n2<=15 латинских букв
     */
    public String getWord() {
        StringBuilder words = new StringBuilder();
        int n2 = rd.nextInt(14) + 1;
        for (int i = 0; i < n2; i++) {
            words.append((char) (rd.nextInt((122 - 97) + 1) + 'a'));
        }
        return words.toString();
    }

    /**
     * Метод генерирует предложение
     * <p>
     * Предложение состоит из 1<=n1<=15 слов.
     * Предложение начинается с заглавной буквы
     * Слова разделены одним пробелом
     * В предложении после произвольных слов могут находиться запятые.
     * Предложение заканчивается (.|!|?)+" "
     */
    public String getSentence(String[] wordsVoc, int probability) {
        StringBuilder builder = new StringBuilder();
        int n1 = rd.nextInt(14) + 1;
        String s = null;
        boolean wordsFromVoc = false;
        int iWordInVoc = rd.nextInt(n1);
        if (rd.nextInt(100) < probability) {
            wordsFromVoc = true;
            }
        for (int i = 0; i < n1; i++) {
            s = (wordsFromVoc && i == iWordInVoc) ? wordsVoc[rd.nextInt(wordsVoc.length)]:getWord();
//             if (wordsFromVoc && i == iWordInVoc) {
//                s = wordsVoc[rd.nextInt(wordsVoc.length)];
//            } else {
//                s = getWord();
//            }
            builder.append(s + " ");
        }

        // рандомно добавляем в конец предложения символ . / ! / ?
        int n0 = rd.nextInt(3);
        char symbol = charDict[n0];
        builder.setCharAt(builder.length() - 1, symbol);
        builder.append(" ");

        // рандомно добавляем в предложение запятые
        if (rd.nextInt(4) > 2) {
            s.replaceAll(" ", ", ");
        }

        String word = builder.toString();
        // Первую букву предложения делаем заглавной
        word = word.substring(0, 1).toUpperCase() + word.substring(1);
        return word;
    }

    /**
     * Метод генерирует абзац
     * <p>
     * Абзац состоит из 1<=n3<=20 предложений.
     * В конце абзаца стоит разрыв строки и перенос каретки.
     */
    public String getParagraph(String[] wordsVoc, int probability) {
        StringBuilder builderParagraph = new StringBuilder();
        int n3 = rd.nextInt(20);
        for (int i = 0; i < n3; i++) {
            builderParagraph.append(getSentence(wordsVoc, probability));
//            if (i == n3 - 1) {
//                builderParagraph.append(s + "\n");
//            } else {
//                builderParagraph.append(s);
//            }
        }
        builderParagraph.append("\n");
        return builderParagraph.toString();
    }

}