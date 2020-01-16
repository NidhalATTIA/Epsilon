/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.Entite.CategorieFormation;
import com.mycompany.Entite.Formation;
import com.mycompany.Entite.fos_user;
import com.mycompany.Service.ServiceFormation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author Loua
 */
public class DetailFormation {
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
    
   
   
     public DetailFormation(int id) {
             
         
        Container c = new Container(BoxLayout.y());
        c.setScrollableY(true);

        ServiceFormation sf = new ServiceFormation();
        //Serviceauthentification su = new Serviceauthentification();
        for (Formation re : sf.getDetails2(id)) {
        
            titre = new SpanLabel("Titre :" + re.getTitre());
            cat = new SpanLabel ("Categorie:"+re.getIdCategorieF().getCategorief());
       
            comp = new SpanLabel("Organisateur: "+re.getIdClient().getNom_company());
            desc = new SpanLabel("Description :" + re.getDescription());
            lieu = new SpanLabel("Lieu :" + re.getLieu());
            nbpart = new SpanLabel("Nombre de participants :" + re.getNbParticipants());
            prix = new SpanLabel("Prix :" + re.getPrix());
            dd = new SpanLabel("Date de Début :" + re.getDateDebut());
            df = new SpanLabel("Date de Fin:" + re.getDateFin());
          
            
                   
       /*  details.getToolbar().addCommandToOverflowMenu("Supprimer", null, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (Dialog.show("Confirmer", "Voulez-vous supprimer cette formation?", "Ok", "Cancel")) {
                        ServiceFormation s =new ServiceFormation();
                        s.delete(id);
                        
                          FormationClient t = new FormationClient();
                          ServiceFormation sf = new ServiceFormation();
                          ArrayList<Formation> list = new ArrayList();
                          sf.getlist();
            
                try {
                    t.afficher();
                } catch (IOException ex) {
                    
                }                                                                                     
                t.getT().show();
                         
                        ToastBar.Status status = ToastBar.getInstance().createStatus();
                        status.setMessage("Formation supprimée");
                        status.showDelayed(50);
                        status.setExpires(3000);
                    }

                }
            });*/
         
  /*      details.getToolbar().addCommandToOverflowMenu("Modifier", null, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    Hashtable data = new Hashtable();
                  
                    data.put("id", re.getId());
                    data.put("CategorieF", re.getIdCategorieF().getCategorief());                                  
                    data.put("Titre", re.getTitre());
                    data.put("description", re.getDescription());
                    data.put("lieu", re.getLieu());
                    data.put("prix", re.getPrix());
                    data.put("nbParticipants", re.getNbParticipants());
                    data.put("dateDebut", re.getDateDebut());
                    data.put("dateFin", re.getDateFin());  
                                   
                     System.out.println(data);
                 
                 UpdateForm up;
                 try {
                        up = new UpdateForm(data);
                        up.getF().show();

                    } catch (IOException ex) {
                    }
                
                }
            });    */
 
    
    
         
            c.add(comp);c.add(cat);c.add(titre);c.add(desc);c.add(lieu);c.add(prix);c.add(nbpart);
            c.add(dd);c.add(df);
            
            details.add(c);  
            
            
            
            
            
            
            
            FloatingActionButton fabD = FloatingActionButton.createFAB(FontImage.MATERIAL_DELETE_OUTLINE);
            RoundBorder rbD = (RoundBorder) fabD.getUnselectedStyle().getBorder();
            rbD.uiid(true);
            fabD.addActionListener((e)->{
            if (Dialog.show("Confirmer", "Voulez-vous supprimer cette formation?", "Ok", "Cancel")) {
                        ServiceFormation s =new ServiceFormation();
                        s.delete(id);
                        
                          FormationClient t = new FormationClient();
                          ArrayList<Formation> list = new ArrayList();
                          s.getlist();
            
                try {
                    t.afficher();
                } catch (IOException ex) {
                    
                }                                                                                     
                t.getT().show();
                         
                        ToastBar.Status status = ToastBar.getInstance().createStatus();
                        status.setMessage("Formation supprimée");
                        status.showDelayed(50);
                        status.setExpires(3000);
                    }

                }
            );
    // details.add(fabD);
     
     FloatingActionButton fabU = FloatingActionButton.createFAB(FontImage.MATERIAL_EDIT);
      RoundBorder rbU = (RoundBorder) fabU.getUnselectedStyle().getBorder();
            rbD.uiid(true);
            fabU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Hashtable data = new Hashtable();
                  
                    data.put("id", re.getId());
                    data.put("CategorieF", re.getIdCategorieF().getCategorief());                                  
                    data.put("Titre", re.getTitre());
                    data.put("description", re.getDescription());
                    data.put("lieu", re.getLieu());
                    data.put("prix", re.getPrix());
                    data.put("nbParticipants", re.getNbParticipants());
                    data.put("dateDebut", re.getDateDebut());
                    data.put("dateFin", re.getDateFin());  
                                   
                     System.out.println(data);
                 
                 UpdateForm up;
                 try {
                        up = new UpdateForm(data);
                        up.getF().show();

                    } catch (IOException ex) {
                    }
                
            
            }});
           // details.add(fabU);
   // Container ct1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
   Container ct1 = new Container(BoxLayout.xCenter()); 
   ct1.add(fabU);ct1.add(fabD); details.add(ct1);
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
           
                }  
      
      
     details.getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {
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
     
     
     
     }
    
      
    
    
    
    
    
        
        
    
}
