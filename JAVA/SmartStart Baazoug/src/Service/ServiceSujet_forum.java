/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.sql.*;
import utils.DataSource;
import Entite.Sujet_forum;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServiceSujet_forum {

    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ServiceSujet_forum() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }

    public void ajouterSujet_forum(Sujet_forum s) throws SQLException{
      String requete = "INSERT INTO `Sujet_forum` (`ID`, `Titre`, `Contenu`, `IdFreelancer`) "
              + "VALUES (NULL, '"+s.getTitre() +"', '"+s.getContenu()+"', '"+s.getIdFreelancer()+"');";
   ste.executeUpdate(requete);
        System.out.println("elment insere");
    }
    
    public void supprimerSujet_forum(int id)throws SQLException{
   
    String requete ="DELETE FROM `Sujet_forum` WHERE `Sujet_forum`.`ID` ="+id;
    ste.executeUpdate(requete);
        System.out.println("elment supprimmee");
    }
    public void modifierSujet_forum(Sujet_forum s)throws SQLException{
   
    String requete ="UPDATE `Sujet_forum` SET `Titre` = '"+s.getTitre()+"' ,`Contenu` = '"+s.getContenu()+"' WHERE `Sujet_forum`.`ID` ='"+s.getId()+"' ;";
    ste.executeUpdate(requete);
        System.out.println("elment modifier");
    }
    public List<Sujet_forum> readAll() throws SQLException
    {
        List<Sujet_forum> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from Sujet_forum");
    Sujet_forum per=null;
    while (res.next()) {            
      per=new Sujet_forum(res.getInt(1), res.getInt(4),res.getString(2), res.getString(3));
      list.add(per);
       }
    return list;
  } 
    
    public Sujet_forum recherche(int id) throws SQLException
    {
       
    ResultSet res=ste.executeQuery("select * from Sujet_forum  WHERE `Sujet_forum`.`ID` ='"+id+"' ;");
    Sujet_forum sujet=null;
    while (res.next()) {            
      sujet=new Sujet_forum(res.getInt(1), res.getInt(4),res.getString(2), res.getString(3));
      
       }
    return sujet;
  } 

}
