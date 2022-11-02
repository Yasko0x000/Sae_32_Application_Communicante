/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client._chat;

import java.sql.Connection;
import java.sql.DriverManager;





/**
 *
 * @author Go
 */
public class db {
    
 public static Connection mycon(){
 
 
     Connection con = null;
     
     try {
         Class.forName("com.mysql.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://169.254.16.66:3306/netme","root",""); 
         
         // 169.254.16.66:3306  Saver ip and port number
         //netme    database name
         //root     user name
         // password is empty
         
         return con;
         
     } catch (Exception e) {
         
         return null;
     }
 
 
 }
      
}
