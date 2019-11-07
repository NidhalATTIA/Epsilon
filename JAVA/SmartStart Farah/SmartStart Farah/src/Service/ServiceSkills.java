/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.sql.*;
import utils.DataSource;
import Entite.Skills;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class ServiceSkills {

    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ServiceSkills() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public List<Skills> readAllS() throws SQLException {
        List<Skills> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from skills");
        Skills s = null;
        while (res.next()) {
            s = new Skills(res.getInt(1), res.getString(2));
            list.add(s);
        }
        return list;
    }

    public void AjouterSkills(Skills S) throws SQLException {
        String req = "INSERT INTO `skills` ( `ID`,`Skill`) VALUES (?,?)";
        PreparedStatement pres = con.prepareStatement(req);
        pres.setInt(1, S.getID());
        pres.setString(2, S.getSkill());

        pres.executeUpdate();
        System.out.println("element inseré");

    }

    public void SupprimerSkills(int id) throws SQLException {

        String requete = "DELETE FROM skills WHERE Skills.ID =" + id;
        ste.executeUpdate(requete);
        System.out.println("elment supprimmé");
    }
}
