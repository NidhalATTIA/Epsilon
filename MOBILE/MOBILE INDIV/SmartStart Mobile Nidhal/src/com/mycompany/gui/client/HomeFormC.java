/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui.client;

import com.mycompany.gui.freelancer.*;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.mycompany.Services.ServiceTask;
import com.mycompany.Entities.Task;

/**
 *
 * @author Arzack
 */
public class HomeFormC {

    Form f;
    TextField tnom;
    TextField tetat;
    Button btnajout,btnaff,btns;

    public HomeFormC() {
        f = new Form("Login");
        tnom = new TextField("","nom");
        tetat = new TextField("","état");
        btnajout = new Button("ajouter");
        btnaff=new Button("Affichage");
        btns= new Button ("Sujet");
        f.add(tnom);
        f.add(tetat);
        f.add(btnajout);
        f.add(btnaff);
        f.add(btns);
        btnajout.addActionListener((e) -> {
            ServiceTask ser = new ServiceTask();
            Task t = new Task(0, tnom.getText(), tetat.getText());
            ser.ajoutTask(t);
            

        });
        btnaff.addActionListener((e)->{
        Affichage a=new Affichage();
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

}
