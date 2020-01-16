/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.Entite.CategorieFormation;
import com.mycompany.Entite.Formation;
import com.mycompany.Entite.fos_user;
import com.mycompany.Service.ServiceFormation;
import com.mycompany.Service.ServiceParticipation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author Loua
 */
public class DetailFormationFreelancer {
   // FormationClient t = new FormationClient();
    
    Form details = new Form("Trainings", BoxLayout.y());
    
    
    public Form getD() {
        return details;
    } 
    
        

    SpanLabel cat;
    SpanLabel comp;
    SpanLabel titre;
    SpanLabel desc;
    SpanLabel lieu;
    SpanLabel nbpart;
    SpanLabel prix;
    SpanLabel dd;
    SpanLabel df;
    
   // SpanLabel cat;
   
     public DetailFormationFreelancer(int id) {
             
         
        Container c = new Container(BoxLayout.y());
        c.setScrollableY(true);

        ServiceFormation sf = new ServiceFormation();
        for (Formation re : sf.getDetails2(id)) {
        
            titre = new SpanLabel("Titre :" + re.getTitre());
            cat = new SpanLabel ("Categorie:"+re.getIdCategorieF().getCategorief());
//            comp = new SpanLabel("Organisateur"+re.getIdClient().getNom_company());
            desc = new SpanLabel("Description :" + re.getDescription());
            lieu = new SpanLabel("Lieu :" + re.getLieu());
            nbpart = new SpanLabel("Nombre de participants :" + re.getNbParticipants());
            prix = new SpanLabel("Prix :" + re.getPrix());
            dd = new SpanLabel("Date de Début :" + re.getDateDebut());
            df = new SpanLabel("Date de Fin:" + re.getDateFin());
           
            Button participer = new Button ("Participer");
            
            participer.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
               fos_user f=new fos_user();
                        f.getId();
                        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                        System.out.println(f.getId());
                        System.out.println(re.getId());
                        ServiceParticipation sp=new ServiceParticipation();
             try {
                 sp.participer(re.getId(),f.getId());
             } catch (IOException ex) {
             }
           }});
            
            Button annuler = new Button ("Annuler");
            
            annuler.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
               fos_user f=new fos_user();
                        f.getId();
                        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                        System.out.println(f.getId());
                        System.out.println(re.getId());
                        ServiceParticipation sp=new ServiceParticipation();
             try {
                 sp.annuler(re.getId(),f.getId());
             } catch (IOException ex) {
             }
           }});
                   
           
            
            c.add(cat);c.add(titre);c.add(desc);c.add(lieu);c.add(prix);c.add(nbpart);
            c.add(dd);c.add(df);c.add(participer);c.add(annuler);          
            details.add(c);    
           
              
                }  
        
     details.getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               FormationFreelancer t = new FormationFreelancer();
                ServiceFormation sf = new ServiceFormation();
                ArrayList<Formation> list = new ArrayList();
                        sf.getlist();
            
                try {
                    t.afficher();
                } catch (IOException ex) {
                    
                }
              
                                          
                                
                t.getForm().show();

            }
        });
     }
    
      
    
    
    
    
    
        
        
    
}
