/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import ConnexionBD.Connexion;
import Entite.Admin;
import Entite.Client;
import Entite.Freelancer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Yasser Bel Haj Ali
 */
public class ServiceAuthentification {
    
    
    private Connection con = Connexion.getInstance().getConnection();
    private Statement ste;

    public ServiceAuthentification() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }
    
     public Freelancer rechercheFreelancerByName_Mdp(String email ,String mdp)throws SQLException{
     
     String requete = "SELECT * FROM  `freelancer` WHERE Email='" +email+"' and MotDePass='"+mdp+"'" ;
     Freelancer f = new Freelancer ();
      ResultSet res =ste.executeQuery (requete);
       while (res.next()) { 
      f.setEmail(res.getString("Email"));
      f.setMotDePass(res.getString("MotDePass"));
       }
         System.out.println(f.toString()); 
      return f ;}
     
     public Client rechercheClientByName_Mdp(String email ,String mdp)throws SQLException{
     
     String requete = "SELECT * FROM  `client` WHERE Email='" +email+"' and MotDePass='"+mdp+"'" ;
     Client c = new Client ();
      ResultSet res =ste.executeQuery (requete);
       while (res.next()) { 
     c.setEmail(res.getString("Email"));
      c.setMotDePass(res.getString("MotDePass"));
       }
         System.out.println(c.toString()); 
      return c ;}
     
     public Admin rechercheAdminByName_Mdp(String email ,String mdp)throws SQLException{
     
     String requete = "SELECT * FROM  `admin` WHERE Email='" +email+"' and MotDePass='"+mdp+"'" ;
     Admin a = new Admin ();
      ResultSet res =ste.executeQuery (requete);
       while (res.next()) { 
      a.setEmail(res.getString("Email"));
      a.setMotDePass(res.getString("MotDePass"));
       }
         System.out.println(a.toString()); 
      return a ;}

    

    
    
    
}
