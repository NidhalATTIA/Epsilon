/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Subscription;
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
public class ServiceSubscription {
      private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ServiceSubscription() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }
    
    public void ajouterFreelancerSkills(Subscription c) throws SQLException{
      String requete = "INSERT INTO `Subscribtion` (`ID`,`ID_client`, `id_Freelancer`) "
              + "VALUES (NULL, '"+c.getID_client()+"', '"+c.getID_Freelancer()+"');";
   ste.executeUpdate(requete);
        System.out.println("elment inseree");
    }
    public void supprimerSkill(int id)throws SQLException{
   
    String requete ="DELETE FROM `Subscribtion` WHERE `Subscribtion`.`ID` ="+id;
    ste.executeUpdate(requete);
        System.out.println("elment supprimmee");
    }
    
    public List<Subscription> readAll(int id) throws SQLException
    {
        List<Subscription> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from Subscribtion WHERE `Subscribtion`.`ID_Freelancer` ='"+id+"' ;");
    Subscription c=null;
    while (res.next()) {            
      c=new Subscription(res.getInt(1), res.getInt(2),res.getInt(3));
      list.add(c);
       }
    return list;
  } 
    
     public Subscription recherche(int id ,int id2) throws SQLException
    {
       
    ResultSet res=ste.executeQuery("select * from Subscribtion  WHERE `Subscribtion`.`ID_Freelancer` ='"+id+"' AND `Subscribtion`.`ID_client` ='"+id2+"' ;");
    Subscription c=null;
    while (res.next()) {            
      c=new Subscription(res.getInt(1), res.getInt(2),res.getInt(3));
      
       }
    return c;
  } 
}
