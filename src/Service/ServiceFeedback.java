/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;


import ConnexionBD.Connexion;
import Entite.Client;
import Entite.Feedback;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Entite.Freelancer;


/**
 *
 * @author Yasser Bel Haj Ali
 */
public class ServiceFeedback {
     private Connection con = Connexion.getInstance().getConnection();
    private Statement ste;

    public ServiceFeedback() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }
    public Client rechercheClientByemail(String email)throws SQLException{
     
     String requete = "SELECT * FROM  `client` WHERE `Email`='" +email+"'" ;
     Client c = new Client ();
      ResultSet res =ste.executeQuery (requete);
       while (res.next()) { 
      c.setId(res.getInt(1));
      c.setNationalite(res.getString(5));
      c.setPrenom(res.getString(3));
      c.setNom(res.getString(2));
      c.setEmail(res.getString(4));
      c.setDescription_Company(res.getString(8));
       }
      return c ;
     }
    
    
     public void ajouterFeedback(Feedback a) throws SQLException{
      String requete = "INSERT INTO `review` (`idClient`, `Contenu`) "+"VALUES ('"+a.getIdClient()+"', '"+a.getContenu()+"');";
             ste.executeUpdate(requete);
        System.out.println("feedback insere");
    }

     public List<Feedback> readAll() throws SQLException
    {List<Feedback> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from review");
    while (res.next()) {    
     Feedback per=new Feedback();
   
      //per=new Feedback(res.getObject(1, getClass()),res.getObject(2,getClass()),res.getInt(3),res.getString(4));
     // per.setId(res.getInt("id"));
     // per.getClient(res.getInt("id"));
      per.setId(res.getInt("ID"));
      per.setIdClient(res.getInt("idClient"));
    //  per.setClient(res.getObject("idClient", getClass()));
      per.setContenu(res.getString("Contenu"));
      
      list.add(per);
     
        }
        System.out.println(list.toString());
        
     
        
    return list;    
    
        }
    
     
     
     public List<Client> get_idClient() throws SQLException
    { List<Client> clie = new ArrayList<>();
    
    
    ResultSet res=ste.executeQuery("select * from client");
  
  
    while (res.next()) {    
     Client fi =new Client();
      fi.setId(res.getInt("id"));
      clie.add(fi);
        }
        System.out.println(clie.toString());
   
    return clie;}
     

       
         public List<Freelancer> get_idfreelancer() throws SQLException
    { List<Freelancer> free = new ArrayList<>();
    
    
    ResultSet res=ste.executeQuery("select * from freelancer");
  
  
    while (res.next()) {    
     Freelancer fi =new Freelancer();
      fi.setId(res.getInt("id"));
      free.add(fi);
      
        }
        System.out.println(free.toString());
        
     
        
    return free;}
     
   
      public void supprimerFeedback(int id) throws SQLException{
      String requete = " DELETE FROM `review` WHERE review.ID =" +id;
        ste.executeUpdate(requete);
        System.out.println("supprime feedback");
    }
      
      
      public void modifierFeedback(Feedback a) throws SQLException{
      String requete = " UPDATE `review` SET  contenu = '"+a.getContenu()+"' WHERE ID =" +a.getId(); 
        ste.executeUpdate(requete);
        System.out.println("modifier feedback");
    }

   

  
    
    
}
