package lesson11.task01;

/**
 * Класс для подключения с клиентской стороны.
 *
 * <p>
 * version 2.0
 * Copyright Журавлёв Алексей
 */

public class Application {

    public static String ipAddr = "localhost";
    public static int port = 25552;

    public static void main(String[] args) {

        new ClientThread(ipAddr, port);
    }
}