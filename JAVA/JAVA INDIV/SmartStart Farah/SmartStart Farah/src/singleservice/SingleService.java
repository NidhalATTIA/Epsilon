/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleservice;

import Entite.Freelancerskills;
import Entite.Freelancer;
import Entite.Skills;
import Service.ServiceFreelancer;
import Service.ServiceFreelancerskills;
import Service.ServiceSkills;
import java.sql.SQLException;
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
    public static void main(String[] args) {
        // TODO code application logic here
    /*   Freelancer F1 = new Freelancer(1, "fafa", "rara", "aa", "aa.com", "TN", "--", "***");

        ServiceFreelancer service = new ServiceFreelancer();


          try {
            service.AjouterFree(F1);
        } catch (SQLException ex) {
            System.out.println(ex);  
        } 
        
        List<Freelancer> list1=null;
        
       
        try {
            list1=service.readAll();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
     
    //   System.out.println(list1);
        
       // Freelancer F2=new Freelancer(1,"foufou","fou","aaa","AA.com","TNTN","CV","Des");
      // Freelancer F3=new Freelancer(1,"Balti","Farah","fff","fb.com","TN","--");

//ServiceFree service=new ServiceFreelancer();

    /* try {
            service.ModifierFree(F2);
        } catch (SQLException ex) {
            System.out.println(ex);
        } */

 /* try {
            service.SupprimerFree(1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
          
        /*    try {
            service.recherche(7);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        try {
            service.SupprimerAnnonce(A4);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         
        
        
      /*  try {
            service.AjouterAnnonce(A2);
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
        
        System.out.println(list1);*/
    

    
    
           Freelancerskills F2 = new Freelancerskills(1, 1, 11, 12, 11, 11,12 );
             //Freelancerskills F1 = new Freelancerskills(1, 1, 1, 2, 3, 4,5 );
             //Freelancerskills F2 = new Freelancerskills(1, 5, 6, 2, 3, 4,5 );
        ServiceFreelancerskills service = new ServiceFreelancerskills();
        try {
            service.AjouterFreeS(F2);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        List<Freelancerskills> list1 = null;

        try {
            list1 = service.readAllF();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

  // Freelancerskills F2 = new Freelancerskills(1, 1, 2, 1, 1, 1, 1);
    
   /*try {
            service.ModifierFreeS(F2);
        } catch (SQLException ex) {
            System.out.println(ex);
        }*/
    /*    try {
            service.SupprimerFreeS(1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }*/
         

 /*  Skills S1 = new Skills(7,"power");
    ServiceSkills service = new ServiceSkills();

           List<Skills> list1 = null;

        try { 
            list1 = service.readAllS();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
                try {
            service.AjouterSkills(S1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    
     /*  try {
            service.SupprimerSkills(1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }*/
}
}
