/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import Entite.Ticket;
import Service.ServiceTicket;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author houssembaazoug
 */
public class Recherche {
      private Resources theme;
    
   
    Label login1;
    Label login2;
    Image im2;
    
    Label login3;
    Label login4;
    Button back;
    Label login;
    Button affsujet;
    ImageViewer im;
    Container cnt1;
    Container cnt2;
    Container cnt3;
     Container cnt4;
     Form f;
    SpanLabel lb;
     Image img;
    TextField Sea;
     ServiceTicket serviceTicket=new ServiceTicket();
     Container cnt7;
     Button search;
     ArrayList<Ticket> l;
    public Recherche() {
        
        
        
        f = new Form("Hi World", BoxLayout.y());
        lb = new SpanLabel();
        cnt2 = new Container(BoxLayout.y());
         cnt7 = new Container(BoxLayout.x());
       f.getToolbar().addCommandToOverflowMenu("Add Subject", null, e->{TicketR h=new TicketR();
             h.getF().show();
            }); 
       Sea = new TextField("", "serach", 17, 1);
       
        try {
            im2 = Image.createImage("/search.png");
        } catch (IOException ex) {
           
        }
        search = new Button(im2);
        
       
        f.add(cnt7);
        
     
      //   l = serviceTicket.getList(Sea.getText());
          System.out.println(l);
        for (Ticket s : l){
          
            System.out.println(s);
            f.add(addItem(s));
           }
           
          f.getToolbar().addCommandToRightBar("back", null, (ev)->{Accueil h=new Accueil();
          
          h.getF().show();
          });
    }

    public Form getF() {
        return f;
    }
    
    public void setF(Form f) {
        this.f = f;
    }
     public Container addItem(Ticket p) {
        cnt1 = new Container(BoxLayout.x());
        cnt3 =new Container(BoxLayout.y());
       
        try {
            img = Image.createImage("/1.png");
        } catch (IOException ex) {
           
        }
        login = new Label(p.getOffre());
        affsujet=new Button("afficher");
        
        affsujet.addActionListener((e)->{
         ServiceTicket.idsuj=p.getId();
         
         System.out.println(ServiceTicket.idsuj);
           TicketR a=new TicketR();
             a.getF().show();
             
        });
        
        
        Container centered3 = BorderLayout.west(affsujet);
       
        cnt1.add(img);
        cnt3.add(login);
        cnt3.add(centered3);
        cnt1.add(cnt3);
        cnt1.setLeadComponent(affsujet);
        return cnt1;
    }
}
