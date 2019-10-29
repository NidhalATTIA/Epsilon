/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Admin;
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
public class ServiceAdmin {
    public static int idfselected ;
    public static int idcselected ;
   private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ServiceAdmin() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public List<Admin> readAll() throws SQLException {
        List<Admin> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from Admin ");
        Admin a = null;
        while (res.next()) {
            a = new Admin(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7),res.getBytes(8));
            list.add(a);
        }
        return list;
    }

    public void ajouterFree(Admin F) throws SQLException {
        String req = "INSERT INTO `Admin` ( `ID`,`Nom`,`Prenom`,`MotDePasse`,`Email`,`Nationalite`,`Fonction`,`image`,) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement pres = con.prepareStatement(req);
        pres.setInt(1, F.getID());
        pres.setString(2, F.getNom());
        pres.setString(3, F.getPrenom());
        pres.setString(4, F.getMotDePass());
        pres.setString(5, F.getEmail());
        pres.setString(6, F.getNationalite());
        pres.setString(7, F.getFonction());
        pres.setBytes(8, F.getImage());

        pres.executeUpdate();
        System.out.println("element inseré");

    }

    public void supprimerFree(int id) throws SQLException {

        String requete = "DELETE FROM Admin WHERE Admin.ID =" + id;
        ste.executeUpdate(requete);
        System.out.println("elment supprimmé");
    }

    public void modifierFree(Admin s) throws SQLException {

        String requete = "UPDATE `Admin` SET `ID` = ?,`Nom` = ?, `Prenom` = ?, `Email` = ?, `MotDePass` = ?, `Nationalite` = ?, `Fonction` = ?,`Image` = ? WHERE Admin.ID ='" + s.getID()+ "';";
        PreparedStatement pres = con.prepareStatement(requete);
        pres.setInt(1, s.getID());
        pres.setString(2, s.getNom());
        pres.setString(3, s.getPrenom());
        pres.setString(4, s.getEmail());
        pres.setString(5, s.getMotDePass());
        pres.setString(6, s.getNationalite());
        pres.setString(7, s.getFonction());
        pres.setBytes(8, s.getImage());
        System.out.println("done");
        pres.executeUpdate();
    }

      public Admin recherche(int id) throws SQLException
    {
    ResultSet res=ste.executeQuery("select * from Admin  WHERE Admin.ID ='"+id+"' ;");
    Admin sujet=null;
    while (res.next()) {
      sujet=new Admin(res.getInt(1), res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7), res.getBytes(8));
       }
    return sujet;
  }

    
}


