package lesson11.task01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Разработать приложение - многопользовательский чат, в котором участвует произвольное количество клиентов.
 * Каждый клиент после запуска отправляет свое имя серверу. После чего начинает отправлять ему сообщения.
 * Каждое сообщение сервер подписывает именем клиента и рассылает всем клиентам (broadcast).
 *
 * <p>
 * version 1.0
 * Copyright Журавлёв Алексей
 */

public class Server extends Thread {

    public static final Integer SERVER_PORT = 25552;
    private static Map<String, Client> users = new HashMap<>();
    private static Socket clientSocket = null;
    private static int num;

    public Server() {
    }

    public void setSocket(int num, Socket clientSocket) {
        this.num = num;
        this.clientSocket = clientSocket;
        setDaemon(true);
        start();
    }

    public static void main(String[] args) {

        ServerSocket socketListener = null;

        try {
            int i = 0; // Счетчик подключений
            socketListener = new ServerSocket(SERVER_PORT);
            System.out.println("Server started\n");

            while (true) {
                clientSocket = null;
                while (clientSocket == null) {
                    clientSocket = socketListener.accept();
                }
                new Server().setSocket(i++, clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socketListener != null) {
                try {
                    socketListener.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void run() {
        try (BufferedReader toServer =
                     new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter fromServer =
                     new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))
        ) {
            String message;
            String name = toServer.readLine();
            Client client = new Client(clientSocket, name);
            users.put(name, client);
            fromServer.write("[" + name + "]:  User join to the chat \n");
            fromServer.flush();

            while ((message = toServer.readLine()) != null) {
                System.out.println("Server read: " + message);
                broadcast(users,message);
                fromServer.flush();
            }
        } catch (IOException e) {
            System.err.println("Ошибка ввода/вывода");
            e.printStackTrace();
        }
    }

    private void broadcast(Map<String, Client> users, String message) {

        for (Client client : users.values()) {
            try {
                client.fromServer().writeObject(message);
            } catch (IOException e) {
                System.out.println("User is not found");
                e.printStackTrace();
            }
        }
    }
}