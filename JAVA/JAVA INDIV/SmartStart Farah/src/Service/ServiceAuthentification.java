/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import java.sql.*;
import Entite.Freelancer;
import Entite.Admin;
import utils.DataSource;

/**
 *
 * @author LENOVO
 */
public class ServiceAuthentification {
    public static int idf;
    public static int idc;
    public static int ida;
     private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ServiceAuthentification() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
public Freelancer rechercheFreelancerByName_Mdp(String email ,String mdp)throws SQLException{

     String requete = "SELECT * FROM  Freelancer WHERE Email='" +email+"' and MotDePass='"+mdp+"'" ;
     Freelancer f = new Freelancer ();
      ResultSet res =ste.executeQuery (requete);
       while (res.next()) { 
      f.setEmail(res.getString("Email"));
      f.setMotDePass(res.getString("MotDePass"));
      f.setId(res.getInt("ID"));
      f.setCv(res.getString("Cv"));
      f.setDescription(res.getString("Description"));
      f.setNationalite(res.getString("Nationalite"));
      f.setNom(res.getString("Nom"));
      f.setPrenom(res.getString("Prenom"));
       }
         System.out.println(f.toString()); 
      return f ;}

      
    public Admin rechercheAdminByName_Mdp(String email ,String mdp)throws SQLException{

     String requete = "SELECT * FROM  Admin WHERE Email='" +email+"' and MotDePass='"+mdp+"'" ;
     Admin a = new Admin ();
      ResultSet res =ste.executeQuery (requete);
       while (res.next()) { 
      a.setEmail(res.getString("Email"));
      a.setMotDePass(res.getString("MotDePass"));
      a.setID(res.getInt("ID"));
      a.setNom(res.getString("Nom"));
      a.setNationalite(res.getString("Nationalite"));
      a.setPrenom(res.getString("Prenom"));
      a.setFonction(res.getString("Fonction"));
      
       }
         System.out.println(a.toString()); 
      return a ;}
    
}
