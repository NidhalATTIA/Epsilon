/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnexionBD;
import java.sql.*;
/**
 *
 * @author Yasser Bel Haj Ali
 */
    public class Connexion {
    
    private static Connexion data;
    private Connection con;
    String url = "jdbc:mysql://localhost:3306/smartstart";
    String login = "root";
    String pwd = "";

    private Connexion() {
        try {
            con = DriverManager.getConnection(url, login, pwd);
            System.out.println("connexion etablie");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
   

    public Connection getConnection() {
        return con;
    }

    public static Connexion getInstance() {
        if (data == null) {
            data = new Connexion();
        }
        return data;
    }

    

    
    
}


