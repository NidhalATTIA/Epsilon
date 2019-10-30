/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import ConnexionBD.Connexion;
import Entite.Client;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Yasser Bel Haj Ali
 */
public class ServiceClient {
 
        
    private Connection con = Connexion.getInstance().getConnection();
    private Statement ste;

    public ServiceClient() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }
    
   
      
       public Client chercher_connexte(int id) throws SQLException{
      String requete = " SELECT * FROM  `client` WHERE id='"+id+"'";
       ResultSet res =ste.executeQuery (requete);
       Client a = new Client();
       while (res.next()) { 
      a.setEmail(res.getString("Email"));
      a.setMotDePass(res.getString("MotDePass"));
      a.setId(res.getInt("ID"));
      a.setNationalite(res.getString("Nationalite"));
      a.setNom_Company(res.getString("Nom_Company"));
      a.setPrenom(res.getString("Prenom"));
      a.setDescription_Company(res.getString("Description_company"));
      a.setNom(res.getString("Nom"));
      a.setEtat(res.getInt("etat"));
      a.setImage(res.getString("Image"));
 
       }System.out.println("client: "+a.toString());
       return a;
}
       
        
    
    
}
    
    
    


