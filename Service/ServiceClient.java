/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.sql.*;
import utils.DataSource;
import Entite.Client;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nidhal
 */
public class ServiceClient 

{
    
    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;
    
        public static void main(String[] args) 
        {
        // TODO code application logic here
        Client c1=new Client(1, "attia", "nidhal","mail","TN","esprit","123","test");
        ServiceClient service=new ServiceClient();
        
/*        
        try {
            service.ajouterClient(c1);
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
/*
        try {
            service.supprimerClient(2);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
 */             
         try {
            service.modifierClient(c1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }     
        
    }

    public ServiceClient() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }

    public void ajouterClient(Client c) throws SQLException
    {
      String requete = "INSERT INTO `Client` (`ID`, `Nom`, `Prenom`, `Email`, `Nationalite`, `Nom_company`,`MotDePass`, `Description_company`) VALUES (NULL, '"+c.getNom()+"', '"+c.getPrenom()+"','"+c.getEmail()+"','"+c.getNationalite()+"','"+c.getNom_company()+"','"+c.getMotdepass()+"','"+c.getDescription_company()+"');";
        ste.executeUpdate(requete);
        System.out.println("Client Ajouté !");
    }
 
   public void supprimerClient(int id)throws SQLException{

    String requete ="DELETE FROM Client WHERE Client.ID ="+id;
    ste.executeUpdate(requete);
        System.out.println("Client supprimé !");
    }
   
    public void modifierClient(Client c)throws SQLException{

    String requete = "UPDATE Client SET Nom = '"+c.getNom()+"',Prenom = '"+c.getPrenom()+"' ,Email = '"+c.getEmail()+"' ,Nationalite = '"+c.getNationalite()+"' , Nom_company = '"+c.getNom_company()+"' , MotDePass = '"+c.getMotdepass()+"', Description_company = '"+c.getDescription_company()+"'WHERE Client.ID ='"+c.getId()+"';";
    ste.executeUpdate(requete);
        System.out.println("Profil mis à jour !");
    }
 
    public List<Client> readAll() throws SQLException
    {
        List<Client> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from Client");
    Client clt=null;
    while (res.next()) {
      clt=new Client(res.getInt(1), res.getInt(4),res.getString(2),res.getString(3),res.getString(5)); // ??????????
      list.add(clt);
       }
    return list;
  }
}

