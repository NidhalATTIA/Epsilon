/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;


import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

import com.mycompany.gui.ProfileFreelancer;

import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import static com.mycompany.gui.authentification.iduser;
import java.io.IOException;






/**
 *
 * @author Arzack
 */
public class AcceuilFreelancer {
    public static String userr ;
    private Resources theme;
   Form f=new Form("Acceuil");
    
    
    
    public void acceuil(String username){
 theme = UIManager.initFirstTheme("/theme");
   
   
     
        System.out.println(username);
    userr=username;
    Toolbar tb=f.getToolbar();
    
             tb.addMaterialCommandToLeftSideMenu("Profile", FontImage.MATERIAL_WEB,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ProfileFreelancer t = new ProfileFreelancer();                                                                              
                try {
                 
                    t.get().show();
                    
                } catch (IOException ex) 
                    {                  
                    }              
            }
        });
             
            tb.addMaterialCommandToLeftSideMenu("Skills", FontImage.MATERIAL_WEB,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                AfficherSkills you = new AfficherSkills();
                try {
                    you.alleven(iduser);
                    
                } catch (IOException ex) {
                    
                }
     
                try {
                    you.get().show();
                } catch (IOException ex) {
                   
                }
             
            }
            
        });
    
    tb.addMaterialCommandToLeftSideMenu("Jobs", FontImage.MATERIAL_WEB,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
              
            }
        });
      tb.addMaterialCommandToLeftSideMenu("Ads", FontImage.MATERIAL_WEB,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
             
            }
        });
         tb.addMaterialCommandToLeftSideMenu("Trainings", FontImage.MATERIAL_WEB,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               
            }
        });
         tb.addMaterialCommandToLeftSideMenu("Forum", FontImage.MATERIAL_WEB,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
             
            }
        });
         
                    tb.addMaterialCommandToLeftSideMenu("Complaints", FontImage.MATERIAL_WEB,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
              
            }
        });
                    
          f.getToolbar().addCommandToRightBar("Logout",null,e->{authentification b=new authentification();
        b.authentification();
        b.getF().show();});
          

           
           
           
           
                   Label lab = new Label ("WELCOME FREELANCER");
                   f.add(lab);
    }
     public Form getF1() {
         
        return f;
    }
    
}
