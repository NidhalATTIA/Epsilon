/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.mycompany.Entite.CategorieFormation;
import com.mycompany.Entite.Formation;
import com.mycompany.Service.ServiceCategorie;
import com.mycompany.Service.ServiceFormation;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Loua
 */
public class AjoutCategorie {
    
    Form ajout = new Form("Ajouter une Categorie", BoxLayout.y());
    
     public void AjoutFormation () {
    
    Container cnt1 = new Container(BoxLayout.y());
        cnt1.setScrollableY(true);
   
    TextField tf1 = new TextField();
    Label l1 = new Label("Categorie");
    
    
    Button btn =new Button("Save");
   
    btn.addActionListener((e)->{
   
    ServiceCategorie sf = new ServiceCategorie();
    
   
    
    
            CategorieFormation t = new CategorieFormation();
         //   t.setIdCategorieF(cat.getSelectedItem().toString());
            t.setCategorief(tf1.getText());
           
       
            sf.ajoutCategorie(t);
            
            
             Categories tt = new Categories();
               
                ArrayList<CategorieFormation> list = new ArrayList();
                        sf.getlistcat();
            
                try {
                    tt.afficher();
                } catch (IOException ex) {
                    
                }
              
                                          
                                
                tt.getc().show();
    
    });
    
    
    
    
       
    cnt1.add(l1);cnt1.add(tf1); cnt1.add(btn);
    ajout.add(cnt1);
    
    
   
    
    ajout.getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               FormationClient t = new FormationClient();
                ServiceCategorie sf = new ServiceCategorie();
                ArrayList<CategorieFormation> list = new ArrayList();
                        sf.getlistcat();
            
                try {
                    t.afficher();
                } catch (IOException ex) {
                    
                }                
                t.getT().show();

            }
        });
    
    
    
    
    }
         
      public Form getA() {
        return ajout;
    }      
         
         
         
    
}
