package lesson11.task01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Программа многопользовательский чат, в котором участвует произвольное количество клиентов.
 * Каждый клиент после запуска отправляет свое имя серверу. После чего начинает отправлять ему сообщения.
 * Каждое сообщение сервер подписывает именем клиента и рассылает всем клиентам (broadcast).
 *
 * Усовершенствование программы чат:
 * a. добавлена возможность отправки личных сообщений (unicast)
 * b. добавлена возможность выхода из чата с помощью написанной в чате команды «quit»
 *
 * <p>
 * version 2.0
 * Copyright Журавлёв Алексей
 */

public class Server {

    public static final Integer SERVER_PORT = 25552;
    static Map<String, Connection> users = new HashMap<>();
    static List<Connection> connections = new ArrayList<>();

    public static void main(String[] args) {

        ServerSocket socketListener = null;

        try {
            socketListener = new ServerSocket(SERVER_PORT);
            System.out.println("Server started\n");

            while (true) {
                Socket socket = socketListener.accept();
                System.out.println("Client accepted");
                connections.add(new Connection(socket));

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socketListener.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}