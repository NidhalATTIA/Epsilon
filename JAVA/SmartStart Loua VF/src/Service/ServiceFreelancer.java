/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.sql.*;
import utils.DataSource;
import Entite.Freelancer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author houssembaazoug
 */
    
    
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 *
 */
public class ServiceFreelancer {

    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;
    public static int selectedfr;
    
    public ServiceFreelancer() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public List<Freelancer> readAll() throws SQLException {
        List<Freelancer> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from freelancer ");
        Freelancer f = null;
        while (res.next()) {
            f = new Freelancer(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getBytes(9));
            list.add(f);
        }
        return list;
    }

    public void ajouterFree(Freelancer F) throws SQLException {
        String req = "INSERT INTO `freelancer` ( `ID`,`Nom`,`Prenom`,`MotDePasse`,`Email`,`Nationalite`,`CV`,`Description`,) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement pres = con.prepareStatement(req);
        pres.setInt(1, F.getId());
        pres.setString(2, F.getNom());
        pres.setString(3, F.getPrenom());
        pres.setString(4, F.getMotDePass());
        pres.setString(5, F.getEmail());
        pres.setString(6, F.getNationalite());
        pres.setString(7, F.getCv());
        pres.setString(8, F.getDescription());

        pres.executeUpdate();
        System.out.println("element inseré");

    }

    public void supprimerFree(int id) throws SQLException {

        String requete = "DELETE FROM freelancer WHERE Freelancer.ID =" + id;
        ste.executeUpdate(requete);
        System.out.println("elment supprimmé");
    }

    public void modifierFree(Freelancer s) throws SQLException {

        String requete = "UPDATE `Freelancer` SET `ID` = ?,`Nom` = ?, `Prenom` = ?, `Email` = ?, `MotDePass` = ?, `Nationalite` = ?, `CV` = ?, `Description` = ?, `ImageFreelancer` = ? WHERE Freelancer.ID ='" + s.getId() + "';";
        PreparedStatement pres = con.prepareStatement(requete);
        pres.setInt(1, s.getId());
        pres.setString(2, s.getNom());
        pres.setString(3, s.getPrenom());
        pres.setString(4, s.getEmail());
        pres.setString(5, s.getMotDePass());
        pres.setString(6, s.getNationalite());
        pres.setString(7, s.getCv());
        pres.setString(8, s.getDescription());
        pres.setBytes(9, s.getImage());
        System.out.println("done");
        pres.executeUpdate();
    }

      public Freelancer recherche(int id) throws SQLException
    {
    ResultSet res=ste.executeQuery("select * from freelancer  WHERE Freelancer.ID ='"+id+"' ;");
    Freelancer sujet=null;
    while (res.next()) {
      sujet=new Freelancer(res.getInt(1), res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8), res.getBytes(9));
       }
    return sujet;
  }

    
}

