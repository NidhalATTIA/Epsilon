/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleservice;

import Entity.Annonce;
import Service.ServiceAnnonce;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sana
 */
public class SingleService {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
//        // TODO code application logic here
//       Annonce A1=new Annonce(1,"ApplicationDesktop","besoin d Experience de 3ans ","java");
//        ServiceAnnonce service=new ServiceAnnonce();
//        
//        
//        
//        try {
//            service.ajouterAnnonce(A1);
//        } catch (SQLException ex) {
//            System.out.println(ex);  
//        }
//        
//        List<Annonce> list1=null;
//        
//        
//        try {
//            list1=service.readAll5();
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//        
//        Annonce A2=new Annonce(1, "WebSite","besoin d Experience de 2ans ","angular");
//        Annonce A3=new Annonce(15, "WebSiteforbeginners","besoin d Experience de 4ans ");
//
//
//
//        try {
//            service.modifierAnnonce(A3);
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//          try {
//            service.supprimerAnnonce(8);
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//          
//            try {
//            service.recherche(7);
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//        /* try {
//            service.supprimerAnnonce(A4);
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }*/
//         
//        
//        
//        try {
//            service.ajouterAnnonce(A2);
//        } catch (SQLException ex) {
//            System.out.println(ex);  
//        }
//        
//        System.out.println(list1);
 List<Annonce> list = new ArrayList<>();

          Annonce s = new Annonce();
          ServiceAnnonce sa = new ServiceAnnonce();
          list=sa.Get_Annonce_by_Id(40);
          s=list.get(0);
          System.out.println(s.getDESCRIPTION()+s.getSkills()+s.getTitre());
    }
    
}
