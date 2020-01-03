/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.Entite.Commentaire;
import com.mycompany.Entite.SujetForum;
import com.mycompany.Entite.Task;
import com.mycompany.Service.ServiceSujetForum;
import com.mycompany.Service.ServiceTask;
import java.util.ArrayList;

/**
 *
 * @author houssembaazoug
 */
public class EditSujetForum {
      Form f;
    TextField tnom;
    TextField tetat;
    Button btnajout,btnaff,btns;
    
    TextArea t ;
   
    TextArea con ;
    TextField login;
    
    Label l ;
    Container cnt1;
    ArrayList<SujetForum> sujf;
     ArrayList<Commentaire> sujcomms;
       ServiceSujetForum ser = new ServiceSujetForum();
     Label com= new Label();
    public EditSujetForum() {
        f = new Form("home");
        tnom = new TextField("","nom");
        tetat = new TextField("","état");
        btnajout = new Button("ajouter");
        btnaff=new Button("Save");
        btns= new Button ("Sujet");
        
         sujf =ser.getList();
        
        for (SujetForum s : sujf){
            System.out.println(s);
            f.add(addItem(s));
           }
        
        
        f.add(btnaff);
     
       
        btnaff.addActionListener((e)->{
          
        SujetForum s = new SujetForum();
       
        s.setContenu(con.getText());
        s.setTitre(login.getText());
        ser.modifTask(s);
        Affsujetf a=new Affsujetf();
        a.getF().show();
        });
        btns.addActionListener((e)->{
        SujetForumGUI a=new SujetForumGUI();
        a.getF().show();
        
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
        con=new TextArea(p.getContenu());
        Container centered = BorderLayout.centerAbsolute(login);
        Container centered2 = BorderLayout.centerAbsolute(con);
         
        cnt1.add(centered);
        cnt1.add(centered2);
       
        return cnt1;
    }
}
