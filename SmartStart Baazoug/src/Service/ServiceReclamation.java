/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.sql.*;
import utils.DataSource;
import Entite.Reclamation;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServiceReclamation {

    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ServiceReclamation() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }

    public void ajouterReclamation(Reclamation r) throws SQLException{
      String requete = "INSERT INTO `Reclamation` (`ID`,`Titre`,`Contenu`, `idClient`, `idFreelancer`) "
              + "VALUES (NULL, '"+r.getTitre() +"', '"+r.getContenu()+"', '"+r.getIdClient()+"', '"+r.getIdFreelancer()+"');";
   ste.executeUpdate(requete);
        System.out.println("element inseree");
    }
    
    public void supprimerReclamation(int id)throws SQLException{
   
    String requete ="DELETE FROM `Reclamation` WHERE `Reclamation`.`ID` ="+id;
    ste.executeUpdate(requete);
        System.out.println("elment supprimmee");
    }
    public void modifierReclamation(Reclamation r)throws SQLException{
   
    String requete ="UPDATE `Reclamation` SET `Titre` = '"+r.getTitre()+"',`Contenu` = '"+r.getContenu()+"' WHERE `Reclamation`.`ID` ='"+r.getId()+"' ;";
    ste.executeUpdate(requete);
        System.out.println("elment modifier");
    }
    public List<Reclamation> readAll() throws SQLException
    {
        List<Reclamation> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from Reclamation");
    Reclamation per=null;
    while (res.next()) {            
      per=new Reclamation(res.getInt(1), res.getString(2),res.getString(3), res.getInt(4), res.getInt(5));
      list.add(per);
       }
    return list;
  } 
     public Reclamation recherche(int id) throws SQLException
    {
       
    ResultSet res=ste.executeQuery("select * from Reclamation  WHERE `Reclamation`.`ID` ='"+id+"' ;");
    Reclamation rev=null;
    while (res.next()) {            
      rev=new Reclamation(res.getInt(1), res.getString(2),res.getString(3), res.getInt(4), res.getInt(5));
      
       }
    return rev;
  } 
 
  

}
