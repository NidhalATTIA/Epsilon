/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;


import Entite.FreelancerSkills;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.DataSource;

/**
 *
 * @author LENOVO
 */
public class ServiceSkillsFreelancer {
     private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ServiceSkillsFreelancer() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }
    
    public void ajouterFreelancerSkills(FreelancerSkills c) throws SQLException{
      String requete = "INSERT INTO `FreelancerSkills` (`ID`,`idFreelancer`, `skill5`) "
              + "VALUES (NULL, '"+c.getIdFreelancer()+"', '"+c.getSkill5()+"');";
   ste.executeUpdate(requete);
        System.out.println("elment inseree");
    }
    public void supprimerSkill(int id)throws SQLException{
   
    String requete ="DELETE FROM `FreelancerSkills` WHERE `FreelancerSkills`.`ID` ="+id;
    ste.executeUpdate(requete);
        System.out.println("elment supprimmee");
    }
    public void modifierFreelancerSkills(FreelancerSkills c)throws SQLException{
   
    String requete ="UPDATE `FreelancerSkills` SET `Contenu` = '"+c.getSkill5()+"' WHERE `FreelancerSkills`.`ID` ='"+c.getId()+"' ;";
    ste.executeUpdate(requete);
        System.out.println("elment modifier");
    }
    public List<FreelancerSkills> readAll(int id) throws SQLException
    {
        List<FreelancerSkills> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from FreelancerSkills WHERE `FreelancerSkills`.`idFreelancer` ='"+id+"' ;");
    FreelancerSkills c=null;
    while (res.next()) {            
      c=new FreelancerSkills(res.getInt(1), res.getInt(2),res.getInt(3));
      list.add(c);
       }
    return list;
  } 
    
     public FreelancerSkills recherche(int id) throws SQLException
    {
       
    ResultSet res=ste.executeQuery("select * from FreelancerSkills  WHERE `FreelancerSkills`.`skill5` ='"+id+"' ;");
    FreelancerSkills c=null;
    while (res.next()) {            
      c=new FreelancerSkills(res.getInt(1), res.getInt(2),res.getInt(3));
      
       }
    return c;
  } 
}
