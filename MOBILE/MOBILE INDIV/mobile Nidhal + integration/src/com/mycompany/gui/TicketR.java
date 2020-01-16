/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import Entite.Categorie;
import Entite.Ticket;
import Service.ServiceCategorie;
import Service.ServiceTicket;
import com.codename1.components.ToastBar;
import com.codename1.io.ConnectionRequest;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.MultiList;
import com.codename1.ui.util.Resources;
import static com.mycompany.gui.authentification.Farah;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author LENOVO
 */
public class TicketR {
    private Resources theme;
    Button search;
    TextField Sea;
    Image im2;
    Container cnt7;
    ArrayList<Ticket> l;
    ServiceTicket serviceTicket=new ServiceTicket();
    ServiceCategorie cf=new ServiceCategorie();
    //ServiceCategorie sc = new ServiceCategorie();
    Form f;
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    public static String reqq="";
   public TicketR(){
       
       
       
       
       f = new Form("Reclamation", BoxLayout.y());
   f.getToolbar().addCommandToRightBar("back", null, (ev)->{AcceuilFreelancer h=new AcceuilFreelancer();
          h.acceuil(Farah);
          h.getF1().show();
          });
   
                 cnt7 = new Container(BoxLayout.x());
                     Sea = new TextField(reqq, "serach", 17, 1);
       
        try {
            im2 = Image.createImage("/search.png");
        } catch (IOException ex) {
           
        }
        search = new Button(im2);
        cnt7.add(Sea);
        cnt7.add(search);
        f.add(cnt7);
         if ("".equals(reqq)){
        //  l = ServiceTicket.getList();
         }
         
        search.addActionListener((e)->{
            reqq = Sea.getText();
        //l = ServiceTicket.getList(reqq);
        System.out.println(l);
        TicketR h=new TicketR();
             h.getF().show();
        
       
         
        });
        
             
     ArrayList<Ticket> Form = new ArrayList<>();
    
         ServiceTicket sc = new ServiceTicket();
         Form = sc.getlist();
        for (Ticket c:Form) {
            
            
            
            
         Container gridLay = new Container(new GridLayout(2,2));
         ArrayList<Map<String, Object>> data = new ArrayList<>();
         DefaultListModel<Map<String, Object>> mdl = new DefaultListModel<>(data);
        MultiList ml = new MultiList(mdl);
        
        
                    
                    Button btModif = new Button("Modifier");
                    btModif.addActionListener((e)->{
                        });
                    
                    
                    
                    
                    
                    Button btsupp = new Button("Supprimer");
                    btsupp.addActionListener((e)->{
                        if (Dialog.show("Confirmer", "Voulez-vous supprimer cette reclamation?", "Ok", "Cancel")) {
                        //ServiceFormation s =new ServiceFormation();
                        sc.suppRec(c.getId());
                        
                        
                          TicketR t = new TicketR();                    
                          ArrayList<TicketR> list = new ArrayList();
                          sc.getlist();
            
                                                                                                   
                t.getF().show();
                       
                        ToastBar.Status status = ToastBar.getInstance().createStatus();
                        status.setMessage("Categorie supprimée");
                        status.showDelayed(50);
                        status.setExpires(3000);
                    }
                        });
                    
                    
                    
                    
                    
                    
                     Container ct = new Container(new BoxLayout(BoxLayout.Y_AXIS));

                    Container ct1 = new Container(new BoxLayout(BoxLayout.X_AXIS));

                   Label l1= new Label();
                   Label l2 = new Label();
                   Label l3 = new Label();
                   Label l4 = new Label();
                   
                   ComboBox ck = new ComboBox();
             //    for (Ticket cf: serviceTicket.getlist()){
               //        ck.addItem("aa");}
               
               
                   
                    for (Categorie cf: serviceTicket.getAllCategorie()){
                    ck.addItem(cf.getCategorier());}
                  
                  
                   
            l1.setText( c.getOffre());
            l2.setText(c.getService());
            l3.setText(c.getMotifreclamation());
            l4.setText(c.getImage());
           
            

             f.add(l1);
             f.add(l2);
             f.add(l3);
             f.add(l4);
             f.add(ck);

                   
                    ct1.add(btModif);
                    ct1.add(btsupp);
                    f.addComponent(ct);
                    f.addComponent(ct1);
        }
              
        
        
        
                    Button btajout = new Button("Ajouter");
                    btajout.addActionListener((e)->{
                       AjoutRec a = new AjoutRec();
                a.getF().show();
                        });
                     f.add(btajout);
                     
                     
              
                     
    }
   
   
   
   }
   
   
 

