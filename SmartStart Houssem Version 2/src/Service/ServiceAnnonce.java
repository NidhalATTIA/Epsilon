/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.sql.*;
import utils.DataSource;
import Entity.Annonce;
import Entity.Client;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Med houssem kaffel
 */
public class ServiceAnnonce {

    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;
    private int idAskService;

    public ServiceAnnonce() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public List<Annonce> readAll() throws SQLException {
        List<Annonce> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from annonce where id_client=" + Client.idcnt);
        Annonce ann = null;
        while (res.next()) {
            ann = new Annonce(res.getInt(1), res.getInt(4), res.getString(2), res.getInt(5), res.getString(3));
            list.add(ann);
        }
        return list;
    }

    public List<Annonce> readAll5() throws SQLException {
        List<Annonce> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("SELECT Titre,ID,Skills FROM annonce ");
        Annonce ann = null;
        while (res.next()) {
            ann = new Annonce(res.getString("Titre"), res.getInt("ID"), res.getString("Skills"));
            list.add(ann);
        }
        return list;
    }

    public List<Annonce> readAll6() throws SQLException {
        List<Annonce> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("SELECT Titre,Skills,DESCRIPTION FROM annonce ");
        Annonce ann = null;
        while (res.next()) {
            ann = new Annonce(res.getString(1), res.getInt(3), res.getString(2));
            list.add(ann);
        }
        return list;
    }

    public List<Annonce> Get_Annonce_by_Id(int id) throws SQLException {
        ResultSet res = null;
        List<Annonce> list = new ArrayList<>();
        String resq = "select ID,Titre,Skill,DESCRIPTION from annonce where ID ='" + id + "'";
        PreparedStatement pstmt = con.prepareStatement(resq);
        res = pstmt.executeQuery();
        Annonce as = null;
        while (res.next()) {
            as = new Annonce(
                    res.getInt("ID"),
                    res.getString("Titre"),
                    res.getInt("Skill"),
                    res.getString("DESCRIPTION"));
            list.add(as);

        }
        return list;

    }

    public void ajouterAnnonce(Annonce A) throws SQLException {
        String req = "INSERT INTO `annonce` ( `Titre`,`DESCRIPTION`,`id_client`,`Skill`) VALUES (?,?,?,?)";
        PreparedStatement pres = con.prepareStatement(req);
        pres.setString(1, A.getTitre());
        pres.setString(2, A.getDESCRIPTION());
        pres.setInt(3, A.getId_client());
        pres.setInt(4, A.getSkills());

        pres.executeUpdate();
        System.out.println("element inserer");

    }

    public void supprimerAnnonce(int id) throws SQLException {

        String requete = "DELETE FROM annonce WHERE Annonce.ID =" + id;
        ste.executeUpdate(requete);
        System.out.println("elment supprimmee");
    }

    public void modifierAnnonce(Annonce s) throws SQLException {

        String requete = "UPDATE annonce SET Titre = '" + s.getTitre() + "' ,DESCRIPTION = '" + s.getDESCRIPTION() + "',Skill = '" + s.getSkills() + "' WHERE Annonce.ID ='" + s.getID() + "' ;";
        ste.executeUpdate(requete);
        System.out.println("elmente modifier");
    }

    public Annonce recherche(int id) throws SQLException {

        ResultSet res = ste.executeQuery("select * from annonce  WHERE Annonce.ID ='" + id + "' ;");
        Annonce sujet = null;
        while (res.next()) {
            sujet = new Annonce(res.getInt(1), res.getInt(4), res.getString(2), res.getInt(3), res.getString(5));

        }
        return sujet;
    }

    public int get_id_mission(String Titre) throws SQLException {
        int idd = 0;
        ResultSet rs = null;
        Statement stm = null;
        String req = "select ID from annonce where Titre ='" + Titre + "'";
        stm = con.prepareStatement(req);
        rs = stm.executeQuery(req);
        while (rs.next()) {
            idd = rs.getInt("id");
        }

        return idd;
    }

    public void setIdToEdit(int id) {

        this.idAskService = id;
    }

    public Annonce Get_Annonce_by_id(int id) throws SQLException {
        ResultSet res = null;
        PreparedStatement pstmt = null;
        String resq = "select ID,Titre,Skill,DESCRIPTION from annonce where ID ='" + id + "'";
        pstmt = con.prepareStatement(resq);
        res = pstmt.executeQuery();
        while (res.next()) {
            return new Annonce(res.getInt("ID"),
                    res.getString("Titre"),
                    res.getInt("Skill"),
                    res.getString("DESCRIPTION"));

        }
        return new Annonce();
    }

    public void ajouterAnnonce2(Annonce A) throws SQLException {
        String req = "INSERT INTO `annonce` ( `Titre`,`DESCRIPTION`,`id_client`,`Skill`) VALUES (?,?,?,?)";
        PreparedStatement pres = con.prepareStatement(req);
        pres.setString(1, A.getTitre());
        pres.setString(2, A.getDESCRIPTION());
        pres.setInt(3, A.getId_client());
        pres.setInt(4, A.getSkills());

        pres.executeUpdate();
        System.out.println("element inserer");

    }

    public List<Annonce> readAlll() throws SQLException {
        List<Annonce> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from annonce");
        Annonce ann = null;
        while (res.next()) {
            ann = new Annonce(res.getInt(1), res.getInt(4), res.getString(2), res.getInt(5), res.getString(3));
            list.add(ann);
        }
        return list;
    }

    public String CountAnnonce() throws SQLException {
        String req = "SELECT COUNT(ID) FROM annonce WHERE id_client=" + Client.idcnt;
        Statement stm = con.createStatement();
        ResultSet rst = stm.executeQuery(req);
        while (rst.next()) {
            String annonce = rst.getString("COUNT(ID)");
            System.out.println(annonce);
            return (annonce);

        }

        return (null);

    }
}
