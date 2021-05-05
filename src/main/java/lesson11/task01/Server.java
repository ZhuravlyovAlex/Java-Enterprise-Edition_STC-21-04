package lesson11.task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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
    private static Socket clientSocket;
    private static BufferedReader fromClient;
    private static PrintWriter toClient;
//    private static String name;

    public Server(Socket socket) {
        clientSocket = socket;

        try {
            fromClient = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            toClient = new PrintWriter(
                    new OutputStreamWriter(clientSocket.getOutputStream()), true);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Клиент был закрыт...");
            try {
                socket.close();
                toClient.close();
                fromClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {

        ServerSocket socketListener = null;

        try {
            socketListener = new ServerSocket(SERVER_PORT);
            System.out.println("Server started\n");

            while (true) {
                Socket socket = socketListener.accept();
                System.out.println("Client accepted");
                new Server(socket).start();
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
        try {
            Client client = new Client(clientSocket);
            String name = fromClient.readLine();
            toClient.print("[" + name + "]:  User join to the chat \n");
            System.out.println(name);
            users.put(name, client);

            String message;

            while (true) {
                message = fromClient.readLine();
                client.setMessageToServer(message);
                System.out.println("Server read: " + message);
                broadcast(users, message);
                toClient.flush();
                if (message.equals("stop")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка ввода/вывода");
            e.printStackTrace();
        }
    }

    private static void broadcast(Map<String, Client> users, String message) {

        for (Client client : users.values()) {
            client.setMessageFromServer(message);
            toClient.write(client.getMessageFromServer());
            toClient.flush();
        }
    }
}