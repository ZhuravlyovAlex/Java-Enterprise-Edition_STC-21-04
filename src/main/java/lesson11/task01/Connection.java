package lesson11.task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;

import static lesson11.task01.Server.users;
import static lesson11.task01.Server.connections;

/**
 * Класс реализующий работу сервера с подключенными клиентами
 *
 * <p>
 * version 2.0
 * Copyright Журавлёв Алексей
 */

public class Connection extends Thread {

    private BufferedReader fromClient;
    private PrintWriter toClient;
    private Socket clientSocket;

    public Connection(Socket socket) {
        clientSocket = socket;
        try {
            fromClient = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            toClient = new PrintWriter(
                    new OutputStreamWriter(socket.getOutputStream()), true);
            start();

        } catch (IOException e) {
            System.out.println("Клиент был закрыт...");
            exit();
        }
    }

    private void exit() {
        try {

            if (!clientSocket.isClosed()) {
                clientSocket.close();
                toClient.close();
                fromClient.close();
                for (Connection con : connections) {
                    if (con.equals(this)) con.interrupt();
                    connections.remove(this);
                    users.remove(users.containsValue(this));
                }
            }
        } catch (IOException ignored) {
        }
    }


    @Override
    public void run() {
        String name;
        try {
            name = fromClient.readLine();
            System.out.println("Client name: " + name);
            users.put(name, this);

            for (Connection con : connections) {
                con.toClient.println("[Server]:  User " + name + " join to the chat \n");
            }

            String message;

            while (true) {
                message = fromClient.readLine();
                System.out.println("[" + name + "]: " + message);
                if (message.equals("quit")) {
                    for (Connection con : connections) {
                        con.toClient.println("[Server]:  User " + name + " left chat \n");
                    }
                    toClient.println("quit");
                    exit();
                    break;
                }
                if (message.equals("~")) {
                    String contactName = fromClient.readLine();
                    Connection unicastConnection = users.get(contactName);
                    message = fromClient.readLine();
                    unicastConnection.toClient.println("[" + name + "]: is writing to you\n" + message);
                    continue;
                }

                for (Map.Entry<String, Connection> item : users.entrySet()) {
                    if (item.getValue().equals(this)) {
                        continue;
                    } else {
                        item.getValue().toClient.println("[" + name + "]: " + message);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка ввода/вывода");
            e.printStackTrace();
        }
    }
}