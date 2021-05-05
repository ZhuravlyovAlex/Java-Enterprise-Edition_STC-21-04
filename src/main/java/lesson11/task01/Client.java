package lesson11.task01;

public class Client {
    private Server.Connection connection;

    private String messageFromServer;
    private String messageToServer;

    public Client(Server.Connection connection) {
        this.connection = connection;
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

    public Server.Connection getConnection() {
        return connection;
    }
}