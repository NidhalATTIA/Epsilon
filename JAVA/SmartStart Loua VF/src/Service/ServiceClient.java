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
