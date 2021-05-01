package lesson11.task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private Socket socket;
    private String name;
    private PrintWriter fromServer;
    private BufferedReader toServer;

    public Client(Socket socket, String name) {

        this.socket = socket;
    }

    public Client(Socket socket, String name, PrintWriter fromServer, BufferedReader toServer) {
        this.socket = socket;
        this.fromServer = fromServer;
        this.toServer = toServer;
    }
}