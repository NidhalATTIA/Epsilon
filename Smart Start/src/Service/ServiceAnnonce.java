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

    public ServiceAnnonce() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }

    public List<Annonce> readAll() throws SQLException
    {List<Annonce> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from annonce");
    Annonce ann=null;
    while (res.next()) {            
      ann=new Annonce(res.getInt(1), res.getString(2),res.getString(3),res.getInt(4),res.getInt(5));
      list.add(ann);
        }
    return list;
    } 
    
    public List<Annonce> readAllc(int id) throws SQLException
    {List<Annonce> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from Annonce WHERE Annonce.id_client ='"+id+"' ;");
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
  public void ajouterAnnonce (Annonce A) throws SQLException{  
  String req="INSERT INTO `annonce` ( `Titre`,`DESCRIPTION`,`id_client`,`Skills`) VALUES (?,?,?,?)";
  PreparedStatement pres=con.prepareStatement(req);
  pres.setString(1, A.getTitre());
  pres.setString(2, A.getDESCRIPTION());
  pres.setInt(3, A.getId_client());
  pres.setInt(4, A.getSkills());

   pres.executeUpdate();
      System.out.println("element inserer");
  
  }
  public void supprimerAnnonce(int id)throws SQLException{

    String requete ="DELETE FROM annonce WHERE Annonce.ID ="+id;
    ste.executeUpdate(requete);
        System.out.println("elment supprimmee");
    }
    public void modifierAnnonce(Annonce s)throws SQLException{

    String requete ="UPDATE annonce SET Titre = '"+s.getTitre()+"' ,DESCRIPTION = '"+s.getDESCRIPTION()+"' WHERE Annonce.ID ='"+s.getID()+"' ;";
    ste.executeUpdate(requete);
        System.out.println("elmente modifier");
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