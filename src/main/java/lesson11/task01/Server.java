package lesson11.task01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Разработать приложение - многопользовательский чат, в котором участвует произвольное количество клиентов.
 * Каждый клиент после запуска отправляет свое имя серверу. После чего начинает отправлять ему сообщения.
 * Каждое сообщение сервер подписывает именем клиента и рассылает всем клиентам (broadcast).
 *
 * <p>
 * version 1.0
 * Copyright Журавлёв Алексей
 */

public class Server {

    public static final Integer SERVER_PORT = 25552;
    private static UsersList list = new UsersList();

    public static void main(String[] args) {

        ServerSocket socketListener = null;
        Socket client = null;
        try {
            socketListener = new ServerSocket(SERVER_PORT);
            while (true) {
                client = null;
                while (client == null) {
                    client = socketListener.accept();
                }
                new ClientThread(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader clientReader =
                     new BufferedReader(new InputStreamReader(client.getInputStream()));
             BufferedWriter clientWriter =
                     new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))
        ) {
            String message;
            while ((message = clientReader.readLine()) != null) {
                System.out.println("Server read: " + message);
                clientWriter.write("[" + message + "]:  User join to the chat \n");
                clientWriter.flush();
            }
        } catch (IOException e) {
            System.err.println("Ошибка ввода/вывода");
            e.printStackTrace();
        }
    }
    public synchronized static UsersList getUsersList() {
        return list;
    }
}