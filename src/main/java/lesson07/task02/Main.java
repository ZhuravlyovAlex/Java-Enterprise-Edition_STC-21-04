package lesson07.task02;

public class Main {

    public static void main(String[] args) {

        String path = "folder/a";
        String[] wordsVoc = new String[]{"fall", "winter", "spring", "summer", "sun", "moon", "day", "night"};

        TxtGenerator text = new TxtGenerator();
        text.getFiles(path, 3, 5000, wordsVoc, 60);
    }
}
