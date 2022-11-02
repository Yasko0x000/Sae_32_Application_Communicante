package com.mycompany.javapro;

import static com.mycompany.javapro.login_form.user_name;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ServeurSocial {
    int nbUtilisateur;
    static final int port = 6010 ;
    DatagramSocket socket;
    DatagramPacket recu;
    
    ServeurSocial() throws SocketException, IOException, ClassNotFoundException, SQLException {
        System.out.println("Serveur en cours");
        //init();
        socket = new DatagramSocket(port) ;
        byte [] buffer  = new byte [1024] ;
        String s ;
        recu = new DatagramPacket(buffer, buffer.length);
        for ( ; ; ) {
          socket.receive(recu) ;
          s = new String(recu.getData(), 0, recu.getLength());
          System.out.println("recu="+s) ;
          String t[]=s.split(",");
          System.out.println("action="+t[0]+" arg="+t[1]);
          if (t[0].equals("creation")) {         ///////////////////////////////  CREATION
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java_app","root","");
                Statement st=con.createStatement();
                //String query = "INSERT INTO login ('email', 'password') VALUES ('"+id+"', '"+pass+"')";
                String query = ("INSERT INTO login (`id`, `user`, `password`)" + " VALUES (NULL, '"+t[1]+"', '"+t[2]+"')");
                //INSERT INTO `login` (`id`, `email`, `password`) VALUES (NULL, 'kikiiiii', 'ioiuio');
                int executeUpdate = st.executeUpdate(query);
                envoi("creation_accepte,"+t[1]);
          }
          if (t[0].equals("connexion")) {         ///////////////////////////////  CONNEXION
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java_app","root","");
                Statement st=con.createStatement();
                //String query = "INSERT INTO login ('email', 'password') VALUES ('"+id+"', '"+pass+"')";
                String query = ("INSERT INTO login (`id`, `user`, `password`)" + " VALUES (NULL, '"+t[1]+"', '"+t[2]+"')");
                //INSERT INTO `login` (`id`, `email`, `password`) VALUES (NULL, 'kikiiiii', 'ioiuio');
                int executeUpdate = st.executeUpdate(query);
              
              
              
              
              
              
              /*boolean present=false;
                for (int i=0; i<nbUtilisateur; i++)
                  if (u[i].login.equals(t[1])) {
                      present=true;
                      if (u[i].estConnecte()) envoi("connexion_refus,"+t[1]);
                      else {
                        u[i].connecte();
                        envoi("connexion_accepte,"+t[1]);
                      }
                  }
                if (!present) envoi("connexion_refus,"+t[1]);*/
          }
          if (t[0].equals("demande_ami")) {         ///////////////////////////////  DEMANDE_AMI
                /*String test = login_form.myName(); 
                var user=login_form.user_name.getText(); //Appelle rentré login (user)
                var name_amis=name_amis.getText();       //Besoin de recup la variable entré sur le champ ajout amis
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java_app","root","");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select user from login,request where user.login='"request"'=user.request");  
            if(rs.next())
            {
                Statement st=con.createStatement();
                //String query = "INSERT INTO login ('email', 'password') VALUES ('"+id+"', '"+pass+"')";
                String query = ("INSERT INTO request (`user`, `nbAmi`, `name_amis`)" + " VALUES ('"+user+"'", /* faire +1 à chaque fois '"+name_amis+"'); //Manque insert du name_amis
            /*int executeUpdate = st.executeUpdate(query);
            }
              
              boolean present=false;
                for (int i=0; i<nbUtilisateur; i++)
                  if (u[i].login.equals(t[2])) {
                      present=true;
                      boolean amiPresent=false;
                      for (int j=0; j<u[i].nbAmi; j++)
                        if (u[i].a[j].login.equals(t[1])) amiPresent=true;
                      if (amiPresent) envoi("demande_ami_refus,"+t[1]+","+t[2]);
                      else {
                        u[i].nouvelAmi(t[1]);
                        envoi("demande_ami_encours,"+t[1]+","+t[2]);
                      }
                  }
                if (!present) envoi("demande_ami_refus,"+t[1]+","+t[2]); */
          }
          if (t[0].equals("action")) {         ///////////////////////////////  ACTION EN ATTENTE SUR LE SERVEUR
                /*boolean present=false, amiPresent=false;
                for (int i=0; i<nbUtilisateur; i++)
                  if (u[i].login.equals(t[1])) {
                      present=true;
                      amiPresent=false;
                      for (int j=0; j<u[i].nbAmi; j++)
                        if (!u[i].a[j].estAccepte()) {
                            amiPresent=true;
                            envoi("demande_ami,"+t[1]+","+u[i].a[j].login);
                        }
                  }
                  if (!present || present && !amiPresent) envoi("aucune,"+t[1]);*/
          }
        }
    }
    
    void envoi(String msg) throws SocketException, IOException {
        int msglen = msg.length() ;
        byte [] message = new byte [msglen] ;
        message=msg.getBytes();
        DatagramPacket envoye = new DatagramPacket(message, msglen, recu.getAddress(), recu.getPort());
        socket.send(envoye);
        System.out.println(msg+" envoye") ;
    }
    
    public static void main(String[] args) throws SocketException, IOException, ClassNotFoundException, SQLException {
      //new ServeurSocial();

    }
}