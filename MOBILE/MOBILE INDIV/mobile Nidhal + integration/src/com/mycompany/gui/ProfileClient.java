package com.mycompany.gui;



import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.mycompany.Entite.fos_user;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.Entite.Commentaire;
import com.mycompany.Service.ServiceUser;
import java.io.IOException;
import java.util.ArrayList;



/**
 *
 * @author Arzack
 */
public class ProfileClient {
    
    Button update;
    Image img;
    static fos_user s;
    Form affAnn = new Form("Your Profile", BoxLayout.y());
   // Container gridLay = new Container(new FlowLayout(Component.CENTER, Component.CENTER));
    //  public static int idFreelancer;
      // Form feedAjout = new Form();
    
   //  private Resources theme;
    public void alleven() throws IOException{
         ArrayList<fos_user> Produits = new ArrayList<>();
         ServiceUser sa=new ServiceUser();
         Produits = sa.getList1();
         
         //affAnn.add(gridLay);
         for(fos_user c:Produits)
            {  
                s=c;
               affichersingle(c);
               
            }}
    
    
    public void affichersingle(fos_user c) {
        Container cnt1 = new Container(BoxLayout.y());
        Container cnt2 = new Container(BoxLayout.x());
   
        
        
        //theme = UIManager.initFirstTheme("/theme");
        //ImageViewer img = new ImageViewer(theme.getImage("a.png"));
        //EncodedImage enc = EncodedImage.createFromImage(("user-picture.png"),false);
        //String url ="http://localhost/assets/user-picture.png";
        //Image image = URLImage.createToStorage(enc,"user-picture.png",url,URLImage.RESIZE_SCALE);
        
  
        Label l11= new Label("Your Email :");

        Label l1= new Label();
        l1.setText(c.getEmail());
       
        Label l12= new Label("Your UserName :");
        
        Label l2= new Label();
        l2.setText(c.getUsername());
        
        Label l13= new Label("Your Last Name :");
        
        Label l3= new Label();
        l3.setText(c.getNom());
        
        Label l14= new Label("Your Name :");
        
        Label l4= new Label();
        l4.setText(c.getPrenom());
        
        update = new Button("Update");
        
          affAnn.getToolbar().addCommandToRightBar("back", null, (ev)->{AcceuilClient h=new AcceuilClient();
          h.acceuil(l2.getText());
          h.getF2().show();
          });  //back
          
          update.addActionListener( (ev)->{try {
              UpdateFreelancer h=new UpdateFreelancer();
              s=c;  
              h.getF().show();
            } catch (IOException ex) {
             
            }
          });  //back
        
       cnt1.add(update);
       cnt1.addAll(l11,l1,l12,l2,l13,l3,l14,l4);
      // cnt2.add(img);
       cnt2.add(cnt1);
       

       
        
        affAnn.addAll(cnt2);/*
              Button btnTopDlt = new Button("Feedback");
                    btnTopDlt.getAllStyles().setFgColor(ColorUtil.rgb(24, 242, 0));
                    btnTopDlt.setIcon(FontImage.createMaterial(FontImage.MATERIAL_SAVE, btnTopDlt.getUnselectedStyle()));
                    btnTopDlt.addActionListener((ActionListener) (ActionEvent evt) -> {
                       affichagefeed feed = new affichagefeed();
                        ajouterFeedback ajoutFeed=new ajouterFeedback();
             try {
                 feed.get().getToolbar().addCommandToOverflowMenu("Back", null, ev->{affAnn.show();});
             } catch (IOException ex) {
             }
             try {
                 feed.get().getToolbar().addCommandToOverflowMenu("Ajouter", null, ev->{ajoutFeed.getAjout().show();});
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
                        ServiceAuthentification serAutho = new ServiceAuthentification();
                        afficheMesFeed feedm = new afficheMesFeed();
                          feedm.get().getToolbar().addCommandToOverflowMenu("Back", null, ev->{affAnn.show();});
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
 
       */
    }
      public  Form get() throws IOException{
          alleven();
     return affAnn;
    
    
    }
    
}

