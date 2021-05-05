package lesson11.task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.rmi.UnknownHostException;
import java.util.Scanner;

public class Aplication {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 25552);
            new ClientThread(socket);

        } catch (UnknownHostException err) {
            System.out.println("Неизвесный хост");
        } catch (IOException err) {
            System.out.println("Произошла ошибка ввода/вывода " + err.getMessage());
        }
    }
}
