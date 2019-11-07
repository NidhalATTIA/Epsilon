/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utils.DataSource;

/**
 *
 * @author MED HOUSSEM KAFFEL
 */
public class ServiceClient {
    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;
    private int idAskService;

    public ServiceClient() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
        public Boolean login(String email, String password) {
        try {
            String requete = "SELECT * FROM `Client` where `Email`=? and `MotDePass`=?";
            PreparedStatement st = con.prepareStatement(requete);
            st.setString(1, email);
            st.setString(2, password);
            ResultSet res = st.executeQuery();
            
            if(res.next()){
                System.out.println("True");
                 Client.setIdcnt(res.getInt("ID"));
                 System.out.println("ID :" +Client.idcnt);
                 return true;
            }
            else{
                System.out.println("cannot login");
               
                return false;
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            
        }

        return false;
        
    }
        public Client recherche(int id_client) throws SQLException
    {
    ResultSet res=ste.executeQuery("select * from client  WHERE client.ID ='"+id_client+"' ;");
    Client sujet=null;
    while (res.next()) {
    sujet = new Client(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7),res.getString(8),res.getBytes(9));
    }
    return sujet;
  }


}
