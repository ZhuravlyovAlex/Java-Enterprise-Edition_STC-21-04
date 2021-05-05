package lesson11.task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.rmi.UnknownHostException;
import java.util.Scanner;

public class ClientThread  {
    private static Socket clientSocket;
    private static Scanner scanner;
    private static BufferedReader fromServer;
    private static PrintWriter toServer;

    public ClientThread(Socket socket) {
        clientSocket = socket;
        try {
            fromServer = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
            toServer = new PrintWriter(
                    new OutputStreamWriter(clientSocket.getOutputStream()), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        scanner = new Scanner(System.in);
        WriteMessageToServer writeMessageToServer = new WriteMessageToServer();
        Thread writeThread = new Thread(writeMessageToServer);
        writeThread.start();

        ReadMessageFromServer readMessageFromServer = new ReadMessageFromServer();
        Thread readThread = new Thread(readMessageFromServer);
        readThread.start();

    }

//    @Override
//    public void run() {
//        try {
//            fromServer = new BufferedReader(
//                    new InputStreamReader(clientSocket.getInputStream()));
//            toServer = new PrintWriter(
//                    new OutputStreamWriter(clientSocket.getOutputStream()), true);
//
//            scanner = new Scanner(System.in);
//            System.out.println("Input your name:");
//            toServer.println(scanner.nextLine());
//
//            WriteMessageToServer writeMessageToServer = new WriteMessageToServer();
//            Thread writeThread = new Thread(writeMessageToServer);
//            writeThread.start();
//
//            ReadMessageFromServer readMessageFromServer = new ReadMessageFromServer();
//            Thread readThread = new Thread(readMessageFromServer);
//            readThread.start();
//
//        } catch (UnknownHostException err) {
//            System.out.println("Неизвесный хост");
//        } catch (IOException err) {
//            System.out.println("Произошла ошибка ввода/вывода " + err.getMessage());
//        }
//    }

    public static class WriteMessageToServer extends Thread {
        @Override
        public void run() {
            String messageToServer;
            while (true) {
                messageToServer = scanner.nextLine();
                if (messageToServer.equals("stop")) {
                    toServer.print("stop" + "\n");
                    break;
                } else {
                    toServer.write(messageToServer + "\n");
                }
                toServer.flush();
            }
        }
    }

    public static class ReadMessageFromServer extends Thread {
        @Override
        public void run() {
            try {
                String messageFromServer;
                while (true) {
                    messageFromServer = fromServer.readLine();
                    if (messageFromServer.equals("stop")) {
                        break;
                    }else{
                        System.out.println(messageFromServer);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
