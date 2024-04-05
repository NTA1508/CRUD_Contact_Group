/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ktgk_demon.database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
public class DBConnect {
private static Connection connect;
    
    // This method establishes a connection to the database and returns the Connection object
    public static Connection getConnection(){
        try{
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/contactdb", "root", "tuananh1582");
            System.err.println(connect);
        } catch(Exception e){
            e.printStackTrace();
        }
        return connect;
    }
}
