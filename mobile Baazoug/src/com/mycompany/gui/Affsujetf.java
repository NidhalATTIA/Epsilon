/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.Entite.Commentaire;
import com.mycompany.Entite.SujetForum;
import com.mycompany.Entite.Task;
import com.mycompany.Service.ServiceCommentaire;
import com.mycompany.Service.ServiceSujetForum;
import com.mycompany.Service.ServiceTask;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author houssembaazoug
 */
public class Affsujetf {
     Form f;
    TextArea t ;
    TextField tnom;
    TextField tetat;
    Container cnt2;
    TextArea con ;
    TextField login;
    Button btnajout,btnaff,btns;
    Label l ;
    Button del;
     Image img;
    Container cnt1;
    ArrayList<SujetForum> sujf;
     ArrayList<Commentaire> sujcomms;
     Label com= new Label();
      ServiceSujetForum serv = new ServiceSujetForum();
       ServiceCommentaire commserv = new ServiceCommentaire();
    public Affsujetf() {
        f = new Form("Un sujet", BoxLayout.y());
        l=new Label();
        
      
        sujf =serv.getList();
        sujcomms = commserv.getList2();
         t = new TextArea("",4,29);
         
         btns = new Button("Write a Comment");
      System.out.println(sujf);  
      System.out.println(sujcomms);
       for (SujetForum s : sujf){
            System.out.println(s);
            f.add(addItem(s));
           }
       l.setText("Comments");
       
       Container centered = BorderLayout.centerAbsolute(l);
        Container centered2 = BorderLayout.centerAbsolute(t);
       f.add(centered);
       f.add(centered2);
       f.add(btns);
       if(sujcomms.isEmpty()){
           System.out.println("no comms");
           com.setText("no Comments");
           f.add(com);
       }
       btns.addActionListener((e)->{
       Commentaire c = new Commentaire();
       c.setIdFreelancer(1);
       c.setidSujet(ServiceSujetForum.idsuj);
       c.setContenu(t.getText());
       c.setId(0);
       commserv.ajoutTask(c);
         Affsujetf a=new Affsujetf();
             a.getF().show();
       });
       f.getToolbar().addCommandToOverflowMenu("Edit Subject", null, e->{EditSujetForum h=new EditSujetForum();
             h.getF().show();
            }); 
       f.getToolbar().addCommandToOverflowMenu("Delete Subject", null, e->{  
           serv.suppTask();
          
           Dialog.show("Deleted", "you Just deleted this subject", "OK", null);
            SujetForumGUI h = new SujetForumGUI(); h.getF().show();
            }); 
       
        for(Commentaire c :sujcomms){
             f.add(affcomm(c));
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

    public TextField getTnom() {
        return tnom;
    }

    public void setTnom(TextField tnom) {
        this.tnom = tnom;
    }
    public Container addItem(SujetForum p) {
        cnt1 = new Container(BoxLayout.y());
        

        login = new TextField(p.getTitre());
        con= new TextArea(p.getContenu(),6,29);
        Container centered = BorderLayout.centerAbsolute(login);
        Container centered2 = BorderLayout.centerAbsolute(con);
        con.setEditable(false);
        login.setEditable(false);
        cnt1.add(centered);
        cnt1.add(centered2);
       
        return cnt1;
    }
    public Container affcomm(Commentaire p) {
        cnt1 = new Container(BoxLayout.x());
        cnt2 = new Container(BoxLayout.y());
        del = new Button("Delete");
             try {
            img = Image.createImage("/1.png");
        } catch (IOException ex) {
           
        }
       TextArea comm = new TextArea(p.getContenu(),4,29);
       comm.setEditable(false);
         Container centered = BorderLayout.centerAbsolute(del);
        cnt1.add(img);
        cnt1.add(comm);
        cnt2.add(cnt1);
        cnt2.add(centered);
       del.addActionListener((e)->{
           ServiceCommentaire.idcomm=p.getId();
       commserv.suppTask();
        Affsujetf a=new Affsujetf();
             a.getF().show();
       });
       
        return cnt2;
    }
}
