/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnexionDB;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author atoufa traore
 */
public class DataSource {
    private static DataSource data;
 String url ="jdbc:mysql://127.0.0.1/pidev";
    String login="root";
    static String password="";
    
    private Connection conn;
 private DataSource(){
        try {
              conn=DriverManager.getConnection(url, login, password);
              System.out.println("connexion");
        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
 public Connection getConnection(){
     return conn;
 }
 
 public static DataSource getInstance(){
     if(data==null){
         data=new DataSource();
     }
     return data;
 }
 }
    
