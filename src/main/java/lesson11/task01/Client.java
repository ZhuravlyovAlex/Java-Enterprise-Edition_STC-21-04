package lesson11.task01;

import java.net.Socket;

public class Client {
    private Socket socket;
    private String name;
    private String messageFromServer;
    private String messageToServer;


    public Client(Socket socket) {

        this.socket = socket;

//        try {
//            in = new BufferedReader(new InputStreamReader(
//                    socket.getInputStream()));
//            out = new PrintWriter(socket.getOutputStream(), true);
//
//        } catch (IOException e) {
//            close();
//        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessageFromServer() {
        return messageFromServer;
    }

    public void setMessageFromServer(String messageFromServer) {
        this.messageFromServer = messageFromServer;
    }

    public String getMessageToServer() {
        return messageToServer;
    }

    public void setMessageToServer(String messageToServer) {
        this.messageToServer = messageToServer;
    }

    public Socket getSocket() {
        return socket;
    }

}