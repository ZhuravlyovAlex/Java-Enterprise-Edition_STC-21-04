package lesson11.task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static PrintWriter outMessage = null;
    static BufferedReader inMessage = null;

    public static void main(String[] args) throws IOException {

        Socket socket = null;
        Scanner sc = new Scanner(System.in);

        System.out.println("starting connection...");
        try {
            socket = new Socket("127.0.0.1", Server.SERVER_PORT);

            inMessage =
                    new BufferedReader(new InputStreamReader(socket.getInputStream()
                    ));
            outMessage =
                    new PrintWriter(new OutputStreamWriter(socket.getOutputStream()
                    ));
            System.out.println("Input your name:");
            outMessage.println(sc.nextLine());

            Sender sender = new Sender();
            Thread thread = new Thread(sender);
            thread.start();

            sender.setDesconnect();
            // выводим на печать ответ от сервера
            String answer;
            while ((answer = inMessage.readLine()) != null) {
                System.out.println(inMessage.readLine());
            }

        } catch (IOException err) {
            System.out.println("Произошла ошибка вводв-вывода " + err.getMessage());
        }
        socket.close();
    }

    private static class Sender implements Runnable {
        private boolean desconnect;

        public void setDesconnect() {
            desconnect = true;
        }

        @Override
        public void run() {

            while (!desconnect) {
                Scanner sc = new Scanner(System.in);
                String message;
                while (!(message = sc.nextLine()).isEmpty()) {
                    outMessage.write(message);
                    outMessage.flush();
                }
            }
        }
    }
}
