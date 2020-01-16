/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import Entity.User;




import com.codename1.charts.util.ColorUtil;
import com.codename1.components.FloatingHint;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.Service.ServiceClient;
import static com.mycompany.gui.authentification.idFinal;
import java.io.IOException;
import java.util.ArrayList;





/**
 *
 * @author Yasser Bel Haj Ali
 */
public class afficheUser {
    
    Form affAnn = new Form("Freelancer", BoxLayout.y());
   // Container gridLay = new Container(new FlowLayout(Component.CENTER, Component.CENTER));
   public static int idFreelancer;
      // Form feedAjout = new Form();
    
     private Resources theme;
    public void alleven() throws IOException{
         ArrayList<User> Produits = new ArrayList<>();
         ServiceClient sa=new ServiceClient();
         Produits = sa.getList1();
         
         //affAnn.add(gridLay);
         for(User c:Produits)
            {  
               affichersingle(c);
            }}
    
    
    public void affichersingle(User c) {
        Container cnt1 = new Container(BoxLayout.y());
        Container cnt2 = new Container(BoxLayout.x());
        theme = UIManager.initFirstTheme("/theme");
          
        
        //ImageViewer img = new ImageViewer(theme.getImage("a.png"));
        
         EncodedImage enc = EncodedImage.createFromImage(theme.getImage("a.png"),false);
        String url ="http://localhost/examenmob/res/finale.png";
        Image image = URLImage.createToStorage(enc,"finale.png",url,URLImage.RESIZE_SCALE);
        ImageViewer img = new ImageViewer(image);
        
  
   
         Label l1= new Label();
        l1.setText(c.getEmail());
       
         Label l2= new Label();
        l2.setText(c.getUsername());
        
        Label l= new Label();
        l.setText(c.getTypeuser());
       cnt1.addAll(l,l2,l1);
       cnt2.add(cnt1);
       cnt2.add(img);
        
        affAnn.addAll(cnt2);
       
        
                    Button btnTopDlt = new Button("Feedback");
                    btnTopDlt.getAllStyles().setFgColor(ColorUtil.rgb(24, 242, 0));
                    btnTopDlt.setIcon(FontImage.createMaterial(FontImage.MATERIAL_SAVE, btnTopDlt.getUnselectedStyle()));
                    btnTopDlt.addActionListener((ActionListener) (ActionEvent evt) -> {
                       affichagefeed feed = new affichagefeed();
                        
             try {
                 feed.get().getToolbar().addCommandToLeftBar("Back", null, ev->{affAnn.show();});
             } catch (IOException ex) {
             }
             
                       idFreelancer=c.getId();
                        System.out.println("freelancer"+c.getId());
                        
                        
                        try {
                 feed.alleven(c.getId());
                
             } catch (IOException ex) {
             }
             try {
                 feed.get().show();
                 // ajoutFeed.feedAjout.show  ():    
             } catch (IOException ex) {
             }
                    });
                    affAnn.add(btnTopDlt);
                    
                    
                            Button plus = new Button("reglage");
                    plus.getAllStyles().setFgColor(ColorUtil.rgb(24, 242, 0));
                    plus.setIcon(FontImage.createMaterial(FontImage.MATERIAL_SETTINGS, plus.getUnselectedStyle()));
                    plus.addActionListener((ActionListener) (ActionEvent evt) -> {
                       
                        afficheMesFeed feedm = new afficheMesFeed();
                          feedm.get().getToolbar().addCommandToLeftBar("Back", null, ev->{affAnn.show();});
             try {
                 feedm.alleven(idFinal);
             } catch (IOException ex) {
                
             }
             feedm.get().show();
       
                
                 
                 //  Tousaff cat = new Tousaff();
                 //  try {
                 // cat.allcategorie(c.getId());
                 // } catch (IOException ex) {
                 
                 //  }
                 //  System.out.println(c.getId());
                 //  cat.getCat().show();
         
                        
                        
                        

                     
                    });
               
                    
                    
                   
                    affAnn.add(plus);
         
        
         
        

       
        
       
    
        
         

        
       
    }
      public  Form get() throws IOException{
          alleven();
     return affAnn;
    
    
    }
    
}
