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
import com.mycompany.Entite.Formation;
import com.mycompany.Service.ServiceFormation;
import java.io.IOException;
import java.util.ArrayList;




/**
 *
 * @author Oussama
 */
public class AcceuilClient {
    Form f;
    private Resources theme;
    public Form getF1() {
        return f;
    }
    
    
    
    public void acceuil(String username){
        theme = UIManager.initFirstTheme("/theme");

        f=new Form("Acceuil");

            System.out.println(username);

        Toolbar tb=f.getToolbar();
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
                    FormationClient t = new FormationClient();
                    ServiceFormation sf = new ServiceFormation();
                    ArrayList<Formation> list = new ArrayList();
                            sf.getlist();

                    try {
                        t.afficher();
                    } catch (IOException ex) {

                    }                                                                                     
                    t.getT().show();

                }
            });
             authentification a = new authentification();
              f.getToolbar().addCommandToRightBar("exit",null,e->{a.getF().show();});

               tb.addMaterialCommandToLeftSideMenu("Complaints", FontImage.MATERIAL_WEB,new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {

                }
            });



                       Label lab = new Label ("BIENVENUE DANS L'ESPACE CLIENT");
                       f.add(lab);
        }

    
}
