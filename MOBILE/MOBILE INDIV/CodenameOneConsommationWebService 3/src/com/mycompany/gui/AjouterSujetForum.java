/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.xml.Element;
import com.mycompany.Entite.SujetForum;
import com.mycompany.Entite.Task;
import com.codename1.xml.XMLWriter;
import com.mycompany.Service.ServiceSujetForum;

import com.mycompany.Service.ServiceTask;
import java.io.IOException;
import java.io.Writer;


/**
 *
 * @author houssembaazoug
 */
public class AjouterSujetForum {
      Form f;
    TextField tnom;
    TextField tetat;
    TextArea contenu;
    Button btnajout,btnaff;

    public AjouterSujetForum() {
        f = new Form("home", BoxLayout.y());
        tnom = new TextField("","titre");
        contenu = new TextArea("",6,29);
       
        btnajout = new Button("ajouter");
        btnaff=new Button("Retour");
        
        f.add(tnom);
        f.add(contenu);
        f.add(btnajout);
        f.add(btnaff);
         f.getToolbar().addCommandToRightBar("Logout", null, (ev)->{HomeForm h=new HomeForm();
          
          h.getF().show();
          });
         f.getToolbar().addCommandToOverflowMenu("Back", null, e->{SujetForumGUI h=new SujetForumGUI();
             h.getF().show();
            }); 
        
     
        btnaff.addActionListener((e)->{
        SujetForumGUI a=new SujetForumGUI();
        a.getF().show();
        
        });
        btnajout.addActionListener((e)->{
            
        ServiceSujetForum ser = new ServiceSujetForum();
        SujetForum s = new SujetForum();
       
        s.setId(0);
        s.setContenu(contenu.getText());
        s.setTitre(tnom.getText());
        ser.ajoutTask(s);
      
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
}
