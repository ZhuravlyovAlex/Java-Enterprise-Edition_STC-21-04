package lesson11.task01;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import static lesson11.task01.Server.getUsersList;

public class ClientThread extends Thread {
    private Socket socket;
    private Message m;
    private String name;
    public static Integer CLIENT_PORT = 25553;

    public ClientThread(Socket socket) {
        this.socket = socket;
        this.start();
    }

    public static void main(String[] args) {
        Socket clientSocket = null;
        try {
            clientSocket = new Socket("127.0.0.1", Server.SERVER_PORT);
            new ClientThread(clientSocket);
        } catch (IOException e) {
            System.err.println("Ups...");
        }
    }

    @Override
    public void run() {
        try (ObjectOutputStream writer = new ObjectOutputStream(this.socket.getOutputStream());
             ObjectInputStream reader = new ObjectInputStream(this.socket.getInputStream())) {

            System.out.println("Input your name:");
            this.m = (Message) reader.readObject();
            this.name = this.m.getName();
            /**
             * Отправляем сообщения пользователям
             */
            if (!this.m.getMessage().equals("User join to the chat")) {
                System.out.println("[" + this.m.getName() + "]: " + this.m.getMessage());
                this.broadcast(getUsersList().getClientsList(), this.m);
            } else {
                writer.writeObject("User " + name + " join to the chat");
            }

            /**
             * Добавляем нового пользователя к списку
             */
            getUsersList().addUser(name, socket, writer, reader);
            //Для ответа, указываем список доступных пользователей
            this.m.setUsers(getUsersList().getUsers());
            //Принимаем сообщение
            this.m = (Message) reader.readObject();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void broadcast(ArrayList<Client> clientsArrayList, Message message) {

        for (Client client : clientsArrayList) {
            try {
                client.getOos().writeObject(message);
            } catch (IOException e) {
                System.out.println("User is not found");
                e.printStackTrace();
            }
        }
    }
}