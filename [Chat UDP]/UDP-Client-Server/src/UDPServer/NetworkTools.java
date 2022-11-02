
package UDPServer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class NetworkTools {

    public static void sendData(String data, InetAddress address, int port, DatagramSocket socket) throws IOException {
        byte[] dataToSend = data.getBytes(); // Convertit le message de String en tableau d’octets
        DatagramPacket packet = new DatagramPacket(dataToSend, dataToSend.length, address, port);
        socket.send(packet);
    }

    public static String receiveData(DatagramSocket socket) throws IOException {
        DatagramPacket packet = null;
        byte[] msg = new byte[200];
        Arrays.fill(msg, (byte) 0); //Supprime le message précedent 
        packet = new DatagramPacket(msg, 200);
        socket.receive(packet);
        return new String(packet.getData(), 0, packet.getLength()) + "#" + packet.getAddress() + "#" + packet.getPort();
    }
}
