/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import Entity.Feedbackc;

import com.codename1.charts.util.ColorUtil;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;

import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.mycompany.Service.ServiceFeed;
import com.mycompany.Service.ServiceNote;
import static com.mycompany.gui.afficheUser.idFreelancer;

import static com.mycompany.gui.authentification.idFinal;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Yasser Bel Haj Ali
 */ 
 
public class affichagefeed {
      Slider starRank;
 
    Form affAnn = new Form("Feedback", BoxLayout.y());
  
    
    public void alleven(int id) throws IOException{
         ArrayList<Feedbackc> Produits = new ArrayList<>();
       
         ServiceFeed sa=new ServiceFeed();
         Produits = sa.getList1(id);
         Container gridLay = new Container(new FlowLayout(Component.CENTER, Component.CENTER));
         for(Feedbackc c:Produits)
            {  
               affichersingle(c);
            }
          Label note= new Label();
         gridLay.add(note);
             
              
       
              
             
                
                
                 ServiceNote NoteService = new ServiceNote();
        note.setText("La note:"+NoteService.getlisteNote(idFreelancer));
        
        
        
        /////////
        
        
       

          
      
         

    
          Button Ajouter = new Button("ajouter");
    TextField contenufeed = new TextField("", "votre feedback");
  
    
   gridLay.addAll(contenufeed,Ajouter);
    
   

          //  RatingWidget.bindRatingListener();
           // RatingWidget.bindRatingListener();
        
      // showStarPickingForm();
       // showSplashAnimation();
   
   
   Ajouter.addActionListener(new ActionListener() {

       @Override
       public void actionPerformed(ActionEvent evt) {
                    ConnectionRequest req2 = new ConnectionRequest();

             ConnectionRequest req = new ConnectionRequest();
            req.setUrl("http://localhost/SmartStart_test/web/app_dev.php/ajouterFeedbackMobile?contenu=" + contenufeed.getText() + "&idFreelancer="+ idFreelancer+"&idUser="+idFinal+"");

           req.addResponseListener(new ActionListener<NetworkEvent>() {

               @Override
               public void actionPerformed(NetworkEvent evt) {
                   byte[] data = (byte[]) evt.getMetaData();
                   String s = new String(data);
                   
                      req2.setUrl("http://localhost/SmartStart_test/web/app_dev.php/Ajouternoteparclient?note=" +  starRank.getProgress() + "&idFreelancer="+ idFreelancer+"&idUser="+idFinal+"");
                      
                      
           req2.addResponseListener(new ActionListener<NetworkEvent>() {

               @Override
               public void actionPerformed(NetworkEvent evt) {
                   byte[] data = (byte[]) evt.getMetaData();
                   String s = new String(data);
                
                       Dialog.show("Confirmation", "ajout effectuer avec succée", "Ok", null);
                       
                       afficheUser affiche = new afficheUser();
                   try {
                      
                       affiche.get().show();
                      
                   } catch (IOException ex) {
                   }
                   
                   
               }
           });
                   
                   
                   
                       
                   
               NetworkManager.getInstance().addToQueue(req2);    
               }
           });

           NetworkManager.getInstance().addToQueue(req);


       }
   });
         

           
        
         affAnn.add(FlowLayout.encloseCenter(createStarRankSlider()));///// ajouter la fonction stars dans la from
        
        affAnn.add(gridLay);
        
        
      ////   
    }
    //////////////////////
    
    
    
    
    
    
    
    private void initStarRankStyle(Style s, Image star) {
    s.setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
    s.setBorder(Border.createEmpty());
    s.setBgImage(star);
    s.setBgTransparency(0);
}

private Slider createStarRankSlider() {
     starRank = new Slider();
    starRank.setEditable(true);
    starRank.setMinValue(0);
    starRank.setMaxValue(10);
     
    Font fnt = Font.createTrueTypeFont("native:MainLight", "native:MainLight").
            derive(Display.getInstance().convertToPixels(5, true), Font.STYLE_PLAIN);
    Style s = new Style(0xffff33, 0, fnt, (byte)0);
    Image fullStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
    s.setOpacity(100);
    s.setFgColor(0);
    System.out.println("yasssssss les note "+ starRank.getProgress());
    Image emptyStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
    initStarRankStyle(starRank.getSliderEmptySelectedStyle(), emptyStar);
    initStarRankStyle(starRank.getSliderEmptyUnselectedStyle(), emptyStar);
    initStarRankStyle(starRank.getSliderFullSelectedStyle(), fullStar);
    initStarRankStyle(starRank.getSliderFullUnselectedStyle(), fullStar);
    
    
    
    Label Note = new Label("Note");
    Container pagenote = new Container(new FlowLayout(Component.CENTER, Component.CENTER));
    pagenote.add(Note);
    starRank.addActionListener(e->{Note.setText("N°"+starRank.getProgress());});
    affAnn.add(pagenote);
    
    
    starRank.setPreferredSize(new Dimension(fullStar.getWidth() * 5, fullStar.getHeight()));
    return starRank;
}
    
    
    
    
    
    
    
    
    
   ////////////////////////// 
         
         public void affichersingle(Feedbackc c) {
         Container RegC = new Container(BoxLayout.y());
            
        
         Label l1= new Label();
         
         
        l1.setText("*"+c.getContenu()+"*");
        l1.setScrollAnimationSpeed(50);
  
         
         
       
        
        
      

                    
                    

         
       
        RegC.add(l1);
       
    
      
        
        affAnn.add(RegC);
        
     
    }
    
          public  Form get() throws IOException{
          
          return affAnn;}
          
          
          
          
       

  
    
    
    
    
    
    
}
