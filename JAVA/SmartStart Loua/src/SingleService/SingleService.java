/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SingleService;

import Entite.Postulation;
import Service.ServicePostulation;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.ws.RequestWrapper;

/**
 *
 * @author sana
 */
public class SingleService {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Postulation p1=new Postulation(27,15,99,"Ingénieur info");
        ServicePostulation service=new ServicePostulation();
       
        
        try {
            service.ajouterPostulation(p1);
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
        
        List<Postulation> list1=null;
       
         try {
            list1=service.readAll();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(list1);
         
         
        Postulation p2 =new Postulation(25,200,40,"Ingénieurs indo");

        
        try {
            service.modifierPostulation(p2);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
       
     
       try {
            service.supprimerPostulation(18);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
     
    }
            

}