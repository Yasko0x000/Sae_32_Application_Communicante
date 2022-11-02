/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.clientscenariosocial;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ClientScenarioSocial {

  static final int port = 6010 ;
  DatagramSocket socket;
  DatagramPacket envoye, recu;
  InetAddress address;
  
  void envoi(String msg) throws UnknownHostException, SocketException, IOException {
    int msglen = msg.length() ;
    byte [] message = new byte [msglen] ;
    message = msg.getBytes() ;
    envoye = new DatagramPacket(message, msglen, address, port) ;
    socket.send(envoye) ;
    System.out.println("msg envoye "+msg);      
  }
  
  String recu() throws UnknownHostException, SocketException, IOException {
    byte[] buf = new byte[1000];
    recu = new DatagramPacket(buf, buf.length);
    socket.receive(recu);
    String rcvd = "rcvd from " + recu.getAddress() + ", " + recu.getPort() + ": "
          + new String(recu.getData(), 0, recu.getLength());
    System.out.println(rcvd);
    return new String(recu.getData(), 0, recu.getLength());
  }
  
  ClientScenarioSocial() throws UnknownHostException, SocketException, IOException{
    address = InetAddress.getByName("127.0.0.1") ;
    socket = new DatagramSocket() ;

    envoi("creation,francois,1234");
    System.out.println(recu());
    
    envoi("creation,hakim,0000");
    System.out.println(recu());
    
    envoi("connexion,francois,1234");
    System.out.println(recu());

    envoi("connexion,jean,0644");
    System.out.println(recu());
/* 
    envoi("demande_ami,francois,hakim");
    System.out.println(recu());

    envoi("connexion,hakim");
    System.out.println(recu());

    envoi("action,hakim");
    System.out.println(recu());

    envoi("demande_ami_accepte,hakim,francois");
    System.out.println(recu());

    envoi("action,francois");
    System.out.println(recu());*/
  }
      
  public static void main(String args[])
  throws UnknownHostException, SocketException, IOException {
    new ClientScenarioSocial();
  }
}
