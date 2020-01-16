/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;


import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;

import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;

import com.mycompany.Entite.FreelancerSkills;

import com.mycompany.Service.ServiceSkills;
import static com.mycompany.gui.AcceuilFreelancer.userr;
import static com.mycompany.gui.authentification.iduser;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author houssembaazoug
 */
public class AfficherSkills {
       Form affAnn = new Form("Your skills", BoxLayout.y());
       public static int idskills ; 
       
       
   
    
    
  
 
   // Container gridLay = new Container(new FlowLayout(Component.CENTER, Component.CENTER));
    //  public static int idFreelancer;
      // Form feedAjout = new Form();
    
   //  private Resources theme;
    public void alleven(int id) throws IOException{
         ArrayList<FreelancerSkills> Produits = new ArrayList<>();
       
         ServiceSkills sa=new ServiceSkills();
         Produits = sa.getList1(id);
         
          Label l11= new Label("Your skills :");
          
          
          
          
          
          
       
    

  
     
   
   
             

          
      
         Container pageAjout = new Container(new FlowLayout(Component.CENTER, Component.CENTER));

    
          Button Ajouter = new Button("ajouter");
    TextField contenufeed = new TextField("", "votre feedback");
  
    
   pageAjout.addAll(contenufeed,Ajouter);
    
   affAnn.add(pageAjout);

          //  RatingWidget.bindRatingListener();
           // RatingWidget.bindRatingListener();
        
      // showStarPickingForm();
       // showSplashAnimation();
   
   
   Ajouter.addActionListener(new ActionListener() {

       @Override
       public void actionPerformed(ActionEvent evt) {
                    ConnectionRequest req2 = new ConnectionRequest();

             ConnectionRequest req = new ConnectionRequest();
            req.setUrl("http://localhost/SmartStart_test/web/app_dev.php/skillsAjouter?contenu=" + contenufeed.getText() + "&idFreelancer="+ iduser+"");

           req.addResponseListener(new ActionListener<NetworkEvent>() {

               @Override
               public void actionPerformed(NetworkEvent evt) {
                   byte[] data = (byte[]) evt.getMetaData();
                   String s = new String(data);
          
                       Dialog.show("Confirmation", "ajout effectuer avec succée", "Ok", null);
          
          }
           });

           NetworkManager.getInstance().addToQueue(req);


       }
   });
         

           

          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
            affAnn.getToolbar().addCommandToOverflowMenu("Back", null, e->{AcceuilFreelancer h=new AcceuilFreelancer();
            h.acceuil(userr);
             h.getF1().show();
            });  
          
         affAnn.add(l11);
         //affAnn.add(gridLay);
         for(FreelancerSkills c:Produits)
            {  
              
               affichersingle(c);
               
            }}
    
    
    public void affichersingle(FreelancerSkills c) {
        Container cnt1 = new Container(BoxLayout.y());
        Container cnt2 = new Container(BoxLayout.x());
   
        
        
        //theme = UIManager.initFirstTheme("/theme");
        //ImageViewer img = new ImageViewer(theme.getImage("a.png"));
        //EncodedImage enc = EncodedImage.createFromImage(("user-picture.png"),false);
        //String url ="http://localhost/assets/user-picture.png";
        //Image image = URLImage.createToStorage(enc,"user-picture.png",url,URLImage.RESIZE_SCALE);
        
  
       

        Label l1= new Label();
        l1.setText(c.getContenu());
        Button supprimer = new Button("supprimer");
        Button ajouter = new Button("ajouter");
        supprimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
              ConnectionRequest req = new ConnectionRequest();
                req.setUrl("http://localhost/SmartStart_test/web/app_dev.php/skillsDelete?ID=" + c.getID() +"");

                req.addResponseListener(new ActionListener<NetworkEvent>() {
                            
                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        byte[] data = (byte[]) evt.getMetaData();
                                idskills = c.getID();
                        Dialog.show("Confirmation", "etes vous sur de vouloir supprimer", "Ok", null);

                    }
                });

                NetworkManager.getInstance().addToQueue(req);
                affAnn.refreshTheme();

            }
        });

        
          
        
         
          
          
        
           cnt1.addAll(l1,supprimer);
      // cnt2.add(img);
       cnt2.add(cnt1);
       

       
        
        affAnn.addAll(cnt2);
    }
      
    

    public  Form get() throws IOException{
      
     return affAnn;
    
    
    }
}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
    
    
  