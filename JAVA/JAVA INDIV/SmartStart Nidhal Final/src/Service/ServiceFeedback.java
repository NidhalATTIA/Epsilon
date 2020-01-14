/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Feedback;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.DataSource;

/**
 *
 * @author houssembaazoug
 */
public class ServiceFeedback {
    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ServiceFeedback() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }

    public void ajouterSujet_forum(Feedback s) throws SQLException{
      String requete = "INSERT INTO `Review` (`ID`, `idClient`, `idFreelancer`, `Contenu`) "
              + "VALUES (NULL, '"+s.getClient()+"', '"+s.getidFreelancer()+"', '"+s.getContenu()+"');";
   ste.executeUpdate(requete);
        System.out.println("elment insere");
    }
    
    public void supprimerSujet_forum(int id)throws SQLException{
   
    String requete ="DELETE FROM `Review` WHERE `Review`.`ID` ="+id;
    ste.executeUpdate(requete);
        System.out.println("elment supprimmee");
    }
    public void modifierSujet_forum(Feedback s)throws SQLException{
   
    String requete ="UPDATE `Review` SET `Contenu` = '"+s.getContenu()+"' WHERE `Review`.`ID` ='"+s.getId()+"' ;";
    ste.executeUpdate(requete);
        System.out.println("elment modifier");
    }
    public List<Feedback> readAll(int id) throws SQLException
    {
        List<Feedback> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from Review WHERE `Review`.`idfreelancer` ='"+id+"' ORDER BY dateAjout DESC");
    Feedback per=null;
    while (res.next()) {            
      per=new Feedback(res.getInt(1), res.getInt(2),res.getInt(3), res.getString(4));
      list.add(per);
       }
    return list;
  } 
    
    public Feedback recherche(int id) throws SQLException
    {
       
    ResultSet res=ste.executeQuery("select * from Review  WHERE `Review`.`ID` ='"+id+"' ;");
    Feedback sujet=null;
    while (res.next()) {            
      sujet=new Feedback(res.getInt(1), res.getInt(2),res.getInt(3), res.getString(4));
      
       }
    return sujet;
  } 
}
