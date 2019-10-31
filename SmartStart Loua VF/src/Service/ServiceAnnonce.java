/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Annonce;
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
 * @author Med houssem kaffel 
 */
public class ServiceAnnonce {

    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;
    public static int idan;
    public ServiceAnnonce() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }

    public List<Annonce> readAll() throws SQLException
    {List<Annonce> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from annonce ORDER BY dateAjout DESC ");
    Annonce ann=null;
    while (res.next()) {            
      ann=new Annonce(res.getInt(1), res.getString(2),res.getString(3),res.getInt(4),res.getInt(5));
      list.add(ann);
        }
    return list;
    } 
    
    public List<Annonce> readAllc(int id) throws SQLException
    {List<Annonce> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from Annonce WHERE Annonce.id_client ='"+id+"' ORDER BY dateAjout DESC ;");
    Annonce ann=null;
    while (res.next()) {            
      ann=new Annonce(res.getInt(1), res.getString(2),res.getString(3),res.getInt(4),res.getInt(5));
      list.add(ann);
        }
    return list;
    } 
    public List<Annonce> readAlls(int id) throws SQLException
    {List<Annonce> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from Annonce WHERE Annonce.Skill ='"+id+"' ORDER BY dateAjout DESC ;");
    Annonce ann=null;
    while (res.next()) {            
      ann=new Annonce(res.getInt(1), res.getString(2),res.getString(3),res.getInt(4),res.getInt(5));
      list.add(ann);
        }
    return list;
    } 
  
    public Annonce recherche(int id) throws SQLException
    {

    ResultSet res=ste.executeQuery("select * from Annonce  WHERE Annonce.ID ='"+id+"' ;");
    Annonce sujet=null;
    while (res.next()) {
      sujet=new Annonce(res.getInt(1), res.getString(2),res.getString(3),res.getInt(4),res.getInt(5));

       }
    return sujet;
  }
  
}