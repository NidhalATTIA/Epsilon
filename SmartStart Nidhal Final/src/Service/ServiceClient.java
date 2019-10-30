/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import Entite.Client;
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
public class ServiceClient {
     private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;
    public static int idcli;
    public ServiceClient() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    public List<Client> readAll() throws SQLException {
        List<Client> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from Client ");
        Client a = null;
        while (res.next()) {
            a = new Client(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7),res.getString(8),res.getBytes(9));
            list.add(a);
        }
        return list;
    }

    public void ajouterClient(Client F) throws SQLException {
        String req = "INSERT INTO `Client` ( `ID`,`Nom`,`Prenom`,`Email`,`Nationalite`,`Nom_company`,`MotDePass`,`Description_company`,`ImageClient`) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement pres = con.prepareStatement(req);
        pres.setInt(1, F.getId());
        pres.setString(2, F.getNom());
        pres.setString(3, F.getPrenom());
        pres.setString(4, F.getEmail());
        pres.setString(5, F.getNationalite());
        pres.setString(6, F.getNom_company());
        pres.setString(7, F.getMotdepass());
        pres.setString(8, F.getDescription_company());
        pres.setBytes(9, F.getImage());

        pres.executeUpdate();
        System.out.println("element inseré");

    }

    public void supprimerFree(int id) throws SQLException {

        String requete = "DELETE FROM Client WHERE Client.ID =" + id;
        ste.executeUpdate(requete);
        System.out.println("element supprimmé");
    }

    public void modifierFree(Client s) throws SQLException {

        String requete = "UPDATE `Client` SET `ID` = ?,`Nom` = ?, `Prenom` = ?, `Email` = ?, `Nationalite` = ?, `Nom_company` = ?, `MotDePass` = ?, `Description_company` = ?, `ImageClient` = ? WHERE Client.ID ='" + s.getId()+ "';";
        PreparedStatement pres = con.prepareStatement(requete);
       pres.setInt(1, s.getId());
        pres.setString(2, s.getNom());
        pres.setString(3, s.getPrenom());
        pres.setString(4, s.getEmail());
        pres.setString(5, s.getNationalite());
        pres.setString(6, s.getNom_company());
        pres.setString(7, s.getMotdepass());
        pres.setString(8, s.getDescription_company());
        pres.setBytes(9, s.getImage());
        System.out.println("done");
        pres.executeUpdate();
    }

      public Client recherche(int id) throws SQLException
    {
    ResultSet res=ste.executeQuery("select * from Client  WHERE Client.ID ='"+id+"' ;");
    Client sujet=null;
    while (res.next()) {
    sujet = new Client(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7),res.getString(8),res.getBytes(9));      
    }
    return sujet;
  }

    
}
