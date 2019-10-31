/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import java.sql.*;
import Entite.Freelancer;
import utils.DataSource;

/**
 *
 * @author houssembaazoug
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
}
