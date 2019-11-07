/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.sql.*;
import utils.DataSource;
import Entite.Postulation;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sana
 */
public class ServicePostulation {

    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ServicePostulation() {
        try {
            ste=con.createStatement(); 
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }

    
    public void ajouterPostulation(Postulation p) throws SQLException{
      String requete = "INSERT INTO `postulation` (`ID`, `idFreelancer`, `idAnnonce`, `Contenu`) "
              + "VALUES (NULL, '"+p.getIdFreelancer()+"', '"+p.getIdAnnonce()+"', '"+p.getContenu()+"');";
   ste.executeUpdate(requete);
        System.out.println("elment inste");
    }
    
    public List<Postulation> readAll() throws SQLException{
        
        List<Postulation> list=new ArrayList<>();
        ResultSet res=ste.executeQuery("select * from postulation");
        Postulation pos=null;
        while (res.next()) {            
        pos=new Postulation(res.getInt(1),res.getInt(2), res.getInt(3),res.getString(4));
        list.add(pos);
        }
    return list; 
    } 
    
    
    public void modifierPostulation(Postulation p)throws SQLException{

    String requete ="UPDATE postulation SET IdFreelancer = '"+p.getIdFreelancer()+"' ,idAnnonce = '"+p.getIdAnnonce()+"' WHERE Postulation.ID ='"+p.getID()+"' ;";
    ste.executeUpdate(requete);
        System.out.println("elmente modifier");
    }
    
    public void supprimerPostulation(int id)throws SQLException{

    String requete ="DELETE FROM postulation WHERE Postulation.ID ="+id;
    ste.executeUpdate(requete);
        System.out.println("elment supprimmee");
    }
    
    
}
