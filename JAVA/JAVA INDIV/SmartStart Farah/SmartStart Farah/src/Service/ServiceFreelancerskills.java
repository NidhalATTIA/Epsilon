/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.sql.*;
import utils.DataSource;
import Entite.Freelancerskills;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class ServiceFreelancerskills {

    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ServiceFreelancerskills() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public List<Freelancerskills> readAllF() throws SQLException {
        List<Freelancerskills> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from freelancerskills");
        Freelancerskills f = null;
        while (res.next()) {
            f = new Freelancerskills(res.getInt(1), res.getInt(2), res.getInt(3), res.getInt(4), res.getInt(5), res.getInt(6), res.getInt(7));
            list.add(f);
        }
        return list;
    }

    public void AjouterFreeS(Freelancerskills F) throws SQLException {
        String req = "INSERT INTO `freelancerskills` ( `ID`,`idFreelancer`,`skill1`,`skill2`,`skill3`,`skill4`,`skill5`) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement pres = con.prepareStatement(req);
        pres.setInt(1, F.getID());
        pres.setInt(2, F.getIdFreelancer());
        pres.setInt(3, F.getSkill1());
        pres.setInt(4, F.getSkill2());
        pres.setInt(5, F.getSkill3());
        pres.setInt(6, F.getSkill4());
        pres.setInt(7, F.getSkill5());

        pres.executeUpdate();
        System.out.println("element inseré");
    }

    public void SupprimerFreeS(int ID) throws SQLException {

        String requete = "DELETE FROM freelancerskills WHERE Freelancerskills.ID =" + ID;
        ste.executeUpdate(requete);
        System.out.println("elment supprimmé");
    }
    
        public void ModifierFreeS(Freelancerskills F) throws SQLException {

        String requete = "UPDATE freelancerskills SET ID = '" + F.getID() + "' ,idFreelancer = '" + F.getIdFreelancer() + "', skill1 = '" + F.getSkill1() + "', skill2 = '" + F.getSkill2() + "',skill3 = '" + F.getSkill3() + "', skill4 = '" + F.getSkill4() + "',skill5 = '" + F.getSkill5() + "' WHERE Freelancerskills.ID ='" + F.getID() + "' ;" ;
        ste.executeUpdate(requete);
        System.out.println("elmente modifié");
    }

}

