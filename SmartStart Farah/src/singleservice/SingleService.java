/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleservice;

import Entity.Free;
import Service.ServiceFree;
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
    Free F1=new Free(1,"Farah","Farah","fff","fb.com","TN","--","***");
        ServiceFree service=new ServiceFree();
        
        
     
        try {
            service.ajouterFree(F1);
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
        
        List<Free> list1=null;
        
       
        try {
            list1=service.readAll();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
     
    //   System.out.println(list1);
        
        Free F2=new Free(1,"Balti","Papi","aaa","AA.com","TNTN","CV","Des");
      // Free F3=new Free(1,"Balti","Farah","fff","fb.com","TN","--");

//ServiceFree service=new ServiceFree();

      try {
            service.modifierFree(F2);
        } catch (SQLException ex) {
            System.out.println(ex);
        } 

      /*   try {
            service.supprimerFree(1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
          
        /*    try {
            service.recherche(7);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        try {
            service.supprimerAnnonce(A4);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         
        
        
      /*  try {
            service.ajouterAnnonce(A2);
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
        
        System.out.println(list1);*/
    }
    
}
