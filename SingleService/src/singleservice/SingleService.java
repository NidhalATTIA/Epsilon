/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleservice;

import Entite.Sujet_forum;
import Entite.Reclamation;
import Entite.Commentaire;
import Service.ServiceCommentaire;
import Service.ServiceSujet_forum;
import Service.ServiceReclamation;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SingleService {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Sujet_forum s1=new Sujet_forum(1,1,"test", "contenu du test");
        ServiceSujet_forum service=new ServiceSujet_forum();
        ServiceReclamation service2= new ServiceReclamation();
        Reclamation r1 = new Reclamation("reclamation 1","contemu de la reclamation",1,1);
        Commentaire c1 = new Commentaire(1,1,1,"commentaire");
        Commentaire c2 = new Commentaire(1,1,1,"commentaire modifier");
        ServiceCommentaire service3 = new ServiceCommentaire();
        Sujet_forum s3 = null;
        Reclamation r3=null;
        Commentaire c3 = null;
         Sujet_forum s2=new Sujet_forum(5,1,"test avec la modification", "contenu du test avec la modification");
        Reclamation r2 = new Reclamation(11,"reclamation 1 modifiee","contemu de la reclamation modifiee",1,1);
       /* try {
            service.ajouterSujet_forum(s1);
        } catch (SQLException ex) {
            System.out.println(ex);  
        }*/
          try {
            service2.ajouterReclamation(r1);
        } catch (SQLException ex) {
            System.out.println(ex);  
        }/*
         try {
            service.supprimerSujet_forum(4);
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
         */  try {
            service2.supprimerReclamation(10);
        } catch (SQLException ex) {
            System.out.println(ex);  
        }/*
         try {
            service.modifierSujet_forum(s2);
        } catch (SQLException ex) {
            System.out.println(ex);  
        } 
          try {
           s3= service.recherche(16);
        } catch (SQLException ex) {
            System.out.println(ex);  
        } */
          try{
          r3 = service2.recherche(5);
        } catch (SQLException ex) {
            System.out.println(ex);  
        } 
        try {
            service2.modifierReclamation(r2);
        }
         catch (SQLException ex) {
           System.out.println(ex);  
        } 
         
       
        /*
        List<Sujet_forum> list1=null;
        
        
       try {
            list1=service.readAll();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        List<Review> list2=null;
        */
        List<Reclamation> list2=null;
       try {
            list2=service2.readAll();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(r3);
        System.out.println(s3);
        //System.out.println(list1);
        System.out.println(list2);
       /* try {
            service3.ajouterCommentaire(c1);
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
        try {
            service3.modifierCommentaire(c2);
        } catch (SQLException ex) {
            System.out.println(ex);  
        } 
        try {
            service3.supprimerCommentaire(2);
        } catch (SQLException ex) {
            System.out.println(ex);  
        }*/
        List<Commentaire> list3=null;
         try {
            list3=service3.readAll();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(list3);
         try{
          c3 = service3.recherche(7);
        } catch (SQLException ex) {
            System.out.println(ex);  
        } 
          System.out.println(c3);
    }
    
}
