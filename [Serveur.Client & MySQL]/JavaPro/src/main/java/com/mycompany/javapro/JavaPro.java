/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.javapro;

import java.io.IOException;
import java.net.SocketException;
import java.sql.SQLException;

/**
 *
 * @author rayan
 */
public class JavaPro {

    public static void main(String[] args) throws IOException, SocketException, ClassNotFoundException, SQLException {
        new login_form().setVisible(true);
        new ServeurSocial();

    }
}