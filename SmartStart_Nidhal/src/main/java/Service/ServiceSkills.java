/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Skills;
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
public class ServiceSkills {
     private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ServiceSkills() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }
    public void ajouterSkill(Skills c) throws SQLException{
      String requete = "INSERT INTO `Skills` (`ID`, `Skill`) "
              + "VALUES (NULL,'"+c.getContenu()+"');";
   ste.executeUpdate(requete);
        System.out.println("elment inseree");
    }
    
    public void supprimerSkill(int id)throws SQLException{
   
    String requete ="DELETE FROM `Skills` WHERE `Skills`.`ID` ="+id;
    ste.executeUpdate(requete);
        System.out.println("elment supprimmee");
    }
    public void modifierSkill(Skills c)throws SQLException{
   
    String requete ="UPDATE `Skills` SET `Skill` = '"+c.getContenu()+"' WHERE `Skills`.`ID` ='"+c.getId()+"' ;";
    ste.executeUpdate(requete);
        System.out.println("elment modifier");
    }
    public List<Skills> readAll() throws SQLException
    {
        List<Skills> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from Skills");
    Skills c=null;
    while (res.next()) {            
      c=new Skills(res.getInt(1), res.getString(2));
      list.add(c);
       }
    return list;
  } 
     public Skills recherche(int id) throws SQLException
    {
       
    ResultSet res=ste.executeQuery("select * from Skills  WHERE `Skills`.`ID` ='"+id+"' ;");
    Skills c=null;
    while (res.next()) {            
      c=new Skills(res.getInt(1), res.getString(2));
      
       }
    return c;
  } 
}
