package lesson11.task01;

public class Message {
    private String name;
    private String message;
    private String[] users;

    /** конструктор, которым будет пользоваться клиент */
    public Message(String name, String message) {
        this.name = name;
        this.message = message;
    }
    /** конструктор, которым будет пользоваться сервер */
    public Message(String name, String message, String[] users) {
        this.name = name;
        this.message = message;
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public String[] getUsers() {
        return users;
    }

    public void setUsers(String[] users) {
        this.users = users;
    }
}
