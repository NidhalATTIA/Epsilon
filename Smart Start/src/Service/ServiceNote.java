/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import utils.DataSource;
import Entite.Note;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yasser Bel Haj Ali
 */
public class ServiceNote {
      private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ServiceNote() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }
 
     public void ajouterNote(Note a) throws SQLException{
      String requete = "INSERT INTO `note` (`id`,`Note`,`idClient`, `idFreelancer`) "
              + "VALUES (NULL,'"+a.getNote()+"', '"+a.getIdClient()+"', '"+a.getIdFreelancer()+"');";
   ste.executeUpdate(requete);
        System.out.println("Note insere");
    }
     public List<Note> readAll() throws SQLException
    {List<Note> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from note");
    Note per=null;
    while (res.next()) {            
      per=new Note( res.getInt(1), res.getInt(2), res.getInt(3),res.getInt(4));
      list.add(per);
        }
    return list;
    
}
      public void supprimerNote(int id) throws SQLException{
      String requete = " DELETE FROM `note` WHERE note.ID =" +id;
        ste.executeUpdate(requete);
        System.out.println("supprime feedback");
    }
      
      
      public void modifierNote(Note a) throws SQLException{
      String requete = " UPDATE `note` SET note = '"+a.getNote()+"' WHERE note.ID =" +a.getId(); 
        ste.executeUpdate(requete);
        System.out.println("modifier note");
    }
    
}