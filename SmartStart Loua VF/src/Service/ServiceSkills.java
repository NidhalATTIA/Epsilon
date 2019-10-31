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
