/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.sql.*;
import utils.DataSource;
import Entity.Free;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *
 */
public class ServiceFree {

    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ServiceFree() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public List<Free> readAll() throws SQLException {
        List<Free> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from freelancer");
        Free f = null;
        while (res.next()) {
            f = new Free(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8));
            list.add(f);
        }
        return list;
    }

    public void ajouterFree(Free F) throws SQLException {
        String req = "INSERT INTO `freelancer` ( `ID`,`Nom`,`Prenom`,`MotDePasse`,`Email`,`Nationalite`,`CV`,`Description`) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement pres = con.prepareStatement(req);
        pres.setInt(1, F.getID());
        pres.setString(2, F.getNom());
        pres.setString(3, F.getPrenom());
        pres.setString(4, F.getMotDePasse());
        pres.setString(5, F.getEmail());
        pres.setString(6, F.getNationalite());
        pres.setString(7, F.getCV());
        pres.setString(8, F.getDescription());

        pres.executeUpdate();
        System.out.println("element inseré");

    }

    public void supprimerFree(int id) throws SQLException {

        String requete = "DELETE FROM freelancer WHERE Freelancer.ID =" + id;
        ste.executeUpdate(requete);
        System.out.println("elment supprimmé");
    }

    public void modifierFree(Free s) throws SQLException {

        String requete = "UPDATE freelancer SET ID = '" + s.getID() + "' ,Nom = '" + s.getNom() + "', Prenom = '" + s.getPrenom() + "', Email = '" + s.getEmail() + "',MotDePasse = '" + s.getMotDePasse() + "', Nationalite = '" + s.getNationalite() + "',CV = '" + s.getCV() + "', Description = '" + s.getDescription() + "' WHERE Freelancer.ID ='" + s.getID() + "' ;";
        ste.executeUpdate(requete);
        System.out.println("elmente modifié");
    }

    /*  public Free recherche(int id) throws SQLException
    {

    ResultSet res=ste.executeQuery("select * from freelancer  WHERE Freelancer.ID ='"+id+"' ;");
    Free sujet=null;
    while (res.next()) {
      sujet=new Free(res.getInt(1), res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7));

       }
    return sujet;
  }*/

    public void ajouter(Free f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
