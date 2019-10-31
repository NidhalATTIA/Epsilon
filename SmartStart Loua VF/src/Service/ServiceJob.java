/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Job;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class ServiceJob {
    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;
    public static int idjob;

    public ServiceJob() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }

    public List<Job> readAllf(int idf) throws SQLException
    {List<Job> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from Job WHERE Job.id_freelancer ='"+idf+"' ORDER BY dateAjout DESC");
    Job ann=null;
    while (res.next()) {            
      ann=new Job(res.getInt(1), res.getString(2),res.getString(3),res.getInt(4),res.getInt(5),res.getInt(6));
      list.add(ann);
        }
    return list;
    }
    public List<Job> readAllc(int idf) throws SQLException
    {List<Job> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from Job WHERE Job.id_client ='"+idf+"'ORDER BY dateAjout DESC ;");
    Job ann=null;
    while (res.next()) {            
      ann=new Job(res.getInt(1), res.getString(2),res.getString(3),res.getInt(4),res.getInt(5),res.getInt(6));
      list.add(ann);
        }
    return list;
    }
    
    public Job recherche(int id) throws SQLException
    {

    ResultSet res=ste.executeQuery("select * from Job  WHERE Job.ID ='"+id+"' ;");
    Job sujet=null;
    while (res.next()) {
      sujet=new Job(res.getInt(1), res.getString(2),res.getString(3),res.getInt(4),res.getInt(5),res.getInt(6));

       }
    return sujet;
  }
}
