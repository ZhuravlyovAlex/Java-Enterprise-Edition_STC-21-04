package lesson03.task01;

/**
 * класс выводящий строку "Hello World!" на экран и  моделирующий возникновение ошибок c их дальнейшей отработкой.
 * моделирование ошибки: NullPointerException;
 * моделирование ошибки: ArrayIndexOutOfBoundsException;
 * моделирование своего варианта ошибки
 *
 * version 1.0
 * Copyright Журавлёв Алексей
 */

public class HelloWorld {

    static String nullString; // создаем строковую статическую переменную со значением Null

    public static void main(String[] args) {
        String s = "Hello world!";
        System.out.println(s);

        String[] arr = {s}; // создаем массив и сразу же инициализируем его строкой: "Hello world!"

        try {
            System.out.println(arr[1]); // эмулируем возникновение ошибки ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Произошёл выход за пределы массива.");
        }

        try {
            if (nullString.equals(s)) { // эмулируем возникновение ошибки NullPointerException
                System.out.println(s);
            }
        } catch (NullPointerException e) {
            System.out.println("Произошла ошибка использования ссылки не ссылающийся ни на одно место в памяти.");
        }
        try {
            if (s.contains(" ")) {
                throw new HelloWorldException(); // вызываем свой вариант ошибки.
            }else{
                System.out.println("s");
            }
        } catch (HelloWorldException e) {
            System.out.println("Необходимо пробелы заменить на символ подчеркивание _ (Было вызвано исключение HelloWorldException.)");
        }

    }
}
