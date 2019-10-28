/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SingleService;

import Entite.Client;
import Service.ServiceClient;
import java.sql.*;
import java.util.List;
import java.sql.Connection;
import java.sql.Statement;
import DataSource.DataSource;


/**
 *
 * @author Nidhal
 */
public class Main 
{

    
        public static void main(String[] args) 
        {
        // TODO code application logic here
        Client c1=new Client(10, "attia2", "nidhal2","mail2","TN2","esprit2","123","test1");
        ServiceClient service=new ServiceClient();
        
       
        try {
            service.ajouterClient(c1);
        } catch (SQLException ex) {
            System.out.println(ex);  
        }

        try {
            service.supprimerClient(7);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
              
         try {
            service.modifierClient(c1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }     
    
         List<Client> client1=null;
         try
         {
            client1 = service.readAll();
 
         } 
         catch (SQLException ex)
         {
             System.out.println(ex);
         }
         System.out.println(client1);
         
    } 
}
