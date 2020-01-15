/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.FloatingActionButton;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import java.io.IOException;





/**
 *
 * @author Oussama
 */
public class AcceuilClient {
    Form f2;
    private Resources theme;
    public Form getF2() {
        return f2;
    }
    
    
    
    public void acceuil(String username){
        theme = UIManager.initFirstTheme("/theme");

        f2=new Form("Acceuil");

            System.out.println(username);

        Toolbar tb=f2.getToolbar();
        
                tb.addMaterialCommandToLeftSideMenu("Profile", FontImage.MATERIAL_WEB,new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {

                }
            });
        
            tb.addMaterialCommandToLeftSideMenu("Feedback", FontImage.MATERIAL_WEB,new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    
                    afficheUser aff = new afficheUser();
                    try {
                        aff.get().show();
                    } catch (IOException ex) {
                       
                    }
                    
                    

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
             
              f2.getToolbar().addCommandToRightBar("Logout",null,e->{Display.getInstance().exitApplication();});

               tb.addMaterialCommandToLeftSideMenu("Complaints", FontImage.MATERIAL_WEB,new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {

                }
            });



                       Label lab = new Label ("WELCOME COMPANY");
                       f2.add(lab);
        }

    
}
