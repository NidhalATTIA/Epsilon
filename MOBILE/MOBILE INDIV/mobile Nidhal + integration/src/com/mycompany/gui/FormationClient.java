/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.CENTER;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.MultiList;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.Entite.CategorieFormation;
import com.mycompany.Entite.Formation;
import com.mycompany.Service.ServiceCategorie;
import com.mycompany.Service.ServiceFormation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;


/**
 *
 * @author Loua
 */
public class FormationClient {

    String username;
    Form training = new Form("Trainings", BoxLayout.y());
    
    
    public void afficher () throws IOException{
     ArrayList<Formation> Form = new ArrayList<>();
        CategorieFormation cf = new CategorieFormation();
     
         ServiceFormation sa=new ServiceFormation();
         Form = sa.getlist();
         Container gridLay = new Container(new GridLayout(2,2));
       
         for(Formation c:Form)
            {  
                    Label l1= new Label();
                    l1.setText("Titre:" + c.getTitre());

                    Label l2= new Label();
                    l2.setText("Categorie:" + c.getIdCategorieF().getCategorief());

                    Label l3= new Label();
                    l3.setText("Lieu:" + c.getLieu());      

                    Container cx2=new Container( new FlowLayout(CENTER,CENTER));
                    Button btn =new Button("show more");
                    cx2.add(btn);
                    btn.addActionListener((e)->{
      
                    DetailFormation dr;                      
                        dr = new DetailFormation(c.getId());
                        dr.getD().show();

                    }); 
       
       training.add(l2);training.add(l1);training.add(l3);
     
       training.add(cx2);
       
       
        }     
    
       
       
        training.getToolbar().addCommandToOverflowMenu("Gerer les categories", null, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                   Categories t = new Categories();
                ServiceCategorie sf = new ServiceCategorie();
                ArrayList<CategorieFormation> list = new ArrayList();
                        sf.getlistcat();
            
                try {
                    t.afficher();
                } catch (IOException ex) {
                    
                }                                                                                     
                t.getc().show();
                }
            });
       
       
       
 
       
       Button but = new Button("ajouter une formation");
               but.addActionListener((e)->{
            AjoutFormation t = new AjoutFormation();
            
            t.AjoutFormation();
                                                        
                t.getA().show();
        });
         training.add(but);
         
 
         
         
          training.getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               AcceuilClient t = new AcceuilClient();
               
               t.acceuil(username);                             
                t.getF2().show();

            }
        });
   }
    
    

      public Form getT() {
        return training;
    } 
}
