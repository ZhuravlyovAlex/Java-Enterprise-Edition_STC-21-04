package lesson11.task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.rmi.UnknownHostException;


public class ClientThread extends Thread {
    private Socket socket;
    private String message;
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
        try (BufferedReader toServer = new BufferedReader(
                new InputStreamReader(this.socket.getInputStream()));
             PrintWriter fromServer = new PrintWriter(
                     new OutputStreamWriter(this.socket.getOutputStream()
                     ))) {
            System.out.println("Input your name:");
            while ((message = toServer.readLine()) != null) {
                System.out.println(toServer.readLine());
                fromServer.println(message);
            }

//            this.name = this.message.getName();
//            /**
//             * Отправляем сообщения пользователям
//             */
//            if (!this.message.getMessage().
//
//                    equals("User join to the chat")) {
//                System.out.println("[" + this.message.getName() + "]: " + this.message.getMessage());
//                this.broadcast(getUsersList().getClientsList(), this.message);
//            } else {
//                writer.writeObject("User " + name + " join to the chat");
//            }
//
//            /**
//             * Добавляем нового пользователя к списку
//             */
//            getUsersList().
//
//                    addUser(name, socket, writer, reader);
//            //Для ответа, указываем список доступных пользователей
//            this.message.setUsers(
//
//                    getUsersList().
//
//                            getUsers());
//            //Принимаем сообщение
//            this.message = reader.readObject();

        } catch (UnknownHostException err) {
            System.out.println("Неизвесный хост");
        } catch (IOException err) {
            System.out.println("Произошла ошибка ввода/вывода " + err.getMessage());
        }
    }

//    private void broadcast(ArrayList<Client> clientsArrayList, String message) {
//
//        for (Client client : clientsArrayList) {
//            try {
//                client.fromServer().writeObject(message);
//            } catch (IOException e) {
//                System.out.println("User is not found");
//                e.printStackTrace();
//            }
//        }
//    }
}