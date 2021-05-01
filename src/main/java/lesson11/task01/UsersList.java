//package lesson11.task01;
//
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.net.Socket;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//public class UsersList {
//    private Map<String, Client> users = new HashMap<>();
//
//    public void addUser(String name, Socket socket, ObjectOutputStream oos, ObjectInputStream ois) {
//        System.out.println(name + " connected");
//        if (!this.users.containsKey(name)) {
//            this.users.put(name, new Client(socket, oos, ois));
//        } else {
//            int i = 1;
//            while (this.users.containsKey(name)) {
//                name = name + i;
//                i++;
//            }
//            this.users.put(name, new Client(socket, oos, ois));
//        }
//    }
//    public String[] getUsers() {
//        return this.users.keySet().toArray(new String[0]);
//    }
//    public ArrayList<Client> getClientsList() {
//        ArrayList<Client> clientsList = new ArrayList<Client>(this.users.entrySet().size());
//
//        String s = "";
//        for(Map.Entry<String, Client> m : this.users.entrySet()){
//            clientsList.add(m.getValue());
//            System.out.println(m.getKey());
//            s = s + m.getKey();
//        }
//        return clientsList;
//    }
//}
