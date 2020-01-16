/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import Entite.Categorie;
import Service.ServiceCategorie;
import com.codename1.ui.Button;
import java.io.IOException;


/**
 *
 * @author LENOVO
 */
public class AjoutCat {
    Form f;
    TextField tcategorier;
   Button btnajout;
   ServiceCategorie serv = new ServiceCategorie();
   Categorie r = new Categorie();
    public AjoutCat() {
        
    f = new Form("Ajouter Categorie", BoxLayout.y());
        tcategorier = new TextField("","categorie");
        f.add(tcategorier);
        btnajout = new Button("ajouter");
         f.add(btnajout);
       btnajout.addActionListener(e->{
           r.setCategorier(tcategorier.getText());
       serv.ajoutFormation(r);
         CategorieR a = new CategorieR();
         a.getF().show();
       });
}
     public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
}