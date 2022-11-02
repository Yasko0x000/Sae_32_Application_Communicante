
package UDPServer;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class Server {

    static List<Users> users = new ArrayList<>();
    static String[] newUser;
    static String username;

    private static void sendMessage(String data, DatagramSocket socket) throws UnknownHostException, IOException {
        for (int i = 0; i < users.size(); i++) {
            NetworkTools.sendData(data, InetAddress.getByName(users.get(i).getIp()), Integer.parseInt(users.get(i).getPort()), socket);
        }
    }

    public static void main(String args[]) throws IOException {
        DatagramSocket socket = null;

        //Créer un socket pour envoyé et recevoir
        socket = new DatagramSocket(4242);

        while (true) {
            String data = null, message;
            String s = NetworkTools.receiveData(socket);
            System.out.println("Serveur" + s);
            String[] sp = s.split("#"); //sp[0] = message, sp[1] = IP as @String, sp[2]= Port @String
            sp[1] = sp[1].replace("/", ""); //Removing the "/" char from IP String

            if (sp[0].contains("/signin")) {
                newUser = sp[0].split("--"); // Separe /signin command et le username
                users.add(new Users(newUser[1], sp[1], sp[2]));
                System.out.println(users.toString());
                System.out.println("Message: " + sp[0] + " de " + sp[1] + ":" + Integer.parseInt(sp[2]));
                message = "Un nouvel utilisateur vient de se connecter -> " + newUser[1];
                sendMessage(message, socket);
            } else if (sp[0].equals("/qui")) {   //Pour connaitre qui fait parti du groupe
                ArrayList<String> onUsers = new ArrayList<>();
                for (int i = 0; i < users.size(); i++) {
                    onUsers.add(users.get(i).getUsername());
                }
                message = "Users en ligne: " + onUsers;
                NetworkTools.sendData(message, InetAddress.getByName(sp[1]), Integer.parseInt(sp[2]), socket);
                System.out.println(message);
            } else if (sp[0].equals("/selem")) {   //Permet de se déconnecter
                for (int i = 0; i < users.size(); i++) {
                    if (users.get(i).getPort().equals(sp[2])) {
                        username = users.get(i).getUsername();
                        users.remove(i);
                    }
                }
                message = username + " a quitter le chat";
                sendMessage(message, socket);
                System.out.println(message);
            } else {
                for (int i = 0; i < users.size(); i++) {
                    // Recherche de l’utilisateur qui envoie le message
                    if (users.get(i).getPort().equals(sp[2]) && users.get(i).ip.equals(sp[1])) {
                        username = users.get(i).getUsername();
                    }
                    data = username + ": " + sp[0];
                    System.out.println(data);
                }
                System.out.println("Envoyé: " + data);
                sendMessage(data, socket);
            }
        }
    }
}
