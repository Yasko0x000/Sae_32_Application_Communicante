
package UDPClient;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client {

    String username = null, s, data;
    String[] sp;
    JFrame frame = new JFrame("UDP Client Messagerie");
    JTextField textField = new JTextField(40);
    JTextArea messageArea = new JTextArea(8, 40);

    InetAddress serverAddress = null;
    int serverPort = 4242;
    DatagramSocket socket = null;

    public Client() {
        // L'interface
        textField.setEditable(false);
        messageArea.setEditable(false);
        frame.getContentPane().add(textField, "North");
        frame.getContentPane().add(new JScrollPane(messageArea), "Center");
        frame.pack();

        // Permet d'apuyer un bouton assigner pour faire une action
        textField.addActionListener((ActionEvent e) -> {
            try {
                NetworkTools.sendData(textField.getText(), serverAddress, serverPort, socket);
                if (textField.getText().equals("/selem")) { //Permet de se déconnecter 

                    System.exit(0);
                }
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            textField.setText("");
        }
        );
    }

    /**
     * Renvoie l'adresse du serveur.
     */
    private String getServerAddress() throws UnknownHostException {
        String serverIP = null;
        do {
            serverIP = (String) JOptionPane.showInputDialog(
                    frame,
                    "Entrer l'address IP du serveur:",
                    "Bienvenue sur le tchat",
                    JOptionPane.QUESTION_MESSAGE, null, null, InetAddress.getLocalHost().getHostAddress());
        } while ((serverIP == null || (serverIP != null && ("".equals(serverIP))))); // Do not procced if null or user press the Cancel button
        return serverIP;
    }

    /**
     * Retourne le nom ecris afin de se connecter.
     */
    private String getName() {
        String name = null;
        do {
            name = JOptionPane.showInputDialog(
                    frame,
                    "Username:",
                    "Entrer le Username",
                    JOptionPane.PLAIN_MESSAGE);
        } while ((name == null || (name != null && ("".equals(name))))); // Ne pas traiter si null ou utilisateur appuyez sur le bouton Annuler
        return name;
    }

    private void run() throws IOException {
        //
        String serverIP = getServerAddress(); //Pour obtenir l’adresse IP du serveur actuel exécutant l’application Java
        try {
            serverAddress = InetAddress.getByName(serverIP); //Détermine l’adresse IP d’un hôte à partir du nom de l’hôte donné
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        // Créer un socket pour envoyé et recevoir 
        try {
            socket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //
        String newUser = "/signin";
        username = getName();
        newUser = newUser.concat("--" + username);
        frame.setTitle("UDP Client Messagerie | " + username);
        /* System.out.println(newUser); */
        NetworkTools.sendData(newUser, serverAddress, serverPort, socket);
        s = NetworkTools.receiveData(socket);
        sp = s.split("#"); //sp[0] = message, sp[1] = Sender IP , sp[2]= Sender port 
        System.out.println("Serveur: " + sp[0]);
        messageArea.append("Avaliable commands: /qui, /selem" + "\n");
        messageArea.append("Serveur: " + sp[0] + "\n");
        textField.setEditable(true);

        while (true) {
            data = null;
            try {
                String s = NetworkTools.receiveData(socket);
                //sp[0] = message, sp[1] = Sender IP, sp[2]= Sender Port
                // l’adresse IP et le port sont ceux du serveur car le serveur reçoit et transfère le message
                String[] sp = s.split("#");
                System.out.println("Message: " + sp[0] + " de " + sp[1] + ":" + Integer.parseInt(sp[2]));
                messageArea.append(sp[0] + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client.frame.setVisible(true);
        client.run();
    }
}
