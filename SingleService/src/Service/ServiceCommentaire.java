/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import java.sql.*;
import utils.DataSource;
import Entite.Commentaire;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author houssembaazoug
 */
public class ServiceCommentaire {
    
  private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ServiceCommentaire() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }

    public void ajouterCommentaire(Commentaire c) throws SQLException{
      String requete = "INSERT INTO `Commentaire_forum` (`ID`, `id_Sujet`, `idFreelancer`, `Contenu`) "
              + "VALUES (NULL, '"+c.getidSujet()+"', '"+c.getIdFreelancer()+"', '"+c.getContenu()+"');";
   ste.executeUpdate(requete);
        System.out.println("elment inseree");
    }
    
    public void supprimerCommentaire(int id)throws SQLException{
   
    String requete ="DELETE FROM `Commentaire_forum` WHERE `Commentaire_forum`.`ID` ="+id;
    ste.executeUpdate(requete);
        System.out.println("elment supprimmee");
    }
    public void modifierCommentaire(Commentaire c)throws SQLException{
   
    String requete ="UPDATE `Commentaire_forum` SET `Contenu` = '"+c.getContenu()+"' WHERE `Commentaire_forum`.`ID` ='"+c.getId()+"' ;";
    ste.executeUpdate(requete);
        System.out.println("elment modifier");
    }
    public List<Commentaire> readAll(int id) throws SQLException
    {
        List<Commentaire> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from Commentaire_forum WHERE `Commentaire_forum`.`id_sujet` ='"+id+"' ;");
    Commentaire c=null;
    while (res.next()) {            
      c=new Commentaire(res.getInt(1), res.getInt(2),res.getInt(3), res.getString(4));
      list.add(c);
       }
    return list;
  } 
     public Commentaire recherche(int id) throws SQLException
    {
       
    ResultSet res=ste.executeQuery("select * from Commentaire_forum  WHERE `Commentaire_forum`.`ID` ='"+id+"' ;");
    Commentaire c=null;
    while (res.next()) {            
      c=new Commentaire(res.getInt(1), res.getInt(2),res.getInt(3), res.getString(4));
      
       }
    return c;
  } 
 
  

}

