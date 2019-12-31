/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.SujetForum;
import com.mycompany.Service.ServiceSujetForum;
import com.mycompany.Service.ServiceTask;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author houssembaazoug
 */
public class SujetForumGUI {
    
    private Resources theme;
    
   
    Label login1;
    Label login2;
    ImageViewer im2= new ImageViewer();

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
    
     ServiceSujetForum serviceTask=new ServiceSujetForum();
     
    public SujetForumGUI() {
        
        
        
        f = new Form("Hi World", BoxLayout.y());
        lb = new SpanLabel();
        cnt2 = new Container(BoxLayout.y());
       f.getToolbar().addCommandToOverflowMenu("Add Subject", null, e->{AjouterSujetForum h=new AjouterSujetForum();
             h.getF().show();
            }); 
       
          ArrayList<SujetForum> l = serviceTask.getList2();
          System.out.println(l);
        for (SujetForum s : l){
          
            System.out.println(s);
            f.add(addItem(s));
           }
           
          f.getToolbar().addCommandToRightBar("back", null, (ev)->{HomeForm h=new HomeForm();
          
          h.getF().show();
          });
    }

    public Form getF() {
        return f;
    }
    
    public void setF(Form f) {
        this.f = f;
    }
     public Container addItem(SujetForum p) {
        cnt1 = new Container(BoxLayout.x());
        cnt3 =new Container(BoxLayout.y());
       
        try {
            img = Image.createImage("/1.png");
        } catch (IOException ex) {
           
        }
        login = new Label(p.getTitre());
        affsujet=new Button("afficher");
        
        affsujet.addActionListener((e)->{
         ServiceSujetForum.idsuj=p.getId();
         
         System.out.println(ServiceSujetForum.idsuj);
           Affsujetf a=new Affsujetf();
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
