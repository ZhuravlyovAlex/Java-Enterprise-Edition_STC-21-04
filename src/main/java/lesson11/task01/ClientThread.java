package lesson11.task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Класс реализующий работу с клиентскими потоками.
 *
 * <p>
 * version 2.0
 * Copyright Журавлёв Алексей
 */

class ClientThread {

    public String ipAddr;
    public int port;
    private static Socket clientSocket;
    private static BufferedReader fromServer;
    private static BufferedReader inputUser;
    private static PrintWriter toServer;

    public ClientThread(String ipAddr, int port) {
        this.ipAddr = ipAddr;
        this.port = port;

        try {
            this.clientSocket = new Socket(ipAddr, port);
        } catch (IOException e) {
            System.err.println("Неизвесный хост");
        }

        try {
            inputUser = new BufferedReader(
                    new InputStreamReader(System.in));
            fromServer = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            toServer = new PrintWriter(
                    new OutputStreamWriter(clientSocket.getOutputStream()), true);

            System.out.println("Input your name: ");
            toServer.println(inputUser.readLine());
            new ReadMessageFromServer().start();
            new WriteMessageToServer().start();

        } catch (IOException err) {
            System.err.println("Произошла ошибка ввода/вывода " + err.getMessage());
            try {
                clientSocket.close();
                toServer.close();
                fromServer.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    private class WriteMessageToServer extends Thread {
        @Override
        public void run() {

            while (true) {
                String messageToServer;
                try {
                    messageToServer = inputUser.readLine();
                    toServer.write(messageToServer + "\n");
                    toServer.flush();
                } catch (IOException err) {

                }
            }
        }
    }

    private class ReadMessageFromServer extends Thread {
        @Override
        public void run() {
            String messageFromServer;
            try {
                while (true) {
                    messageFromServer = fromServer.readLine();
                    if (messageFromServer.equals("quit")) {
                        break;
                    } else {
                        System.out.println(messageFromServer);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}