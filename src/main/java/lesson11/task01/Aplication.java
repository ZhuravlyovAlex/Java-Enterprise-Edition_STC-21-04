package lesson11.task01;

import java.io.IOException;
import java.net.Socket;

public class Aplication {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("localhost", 25552);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Client client = new Client(socket);
    }
}
