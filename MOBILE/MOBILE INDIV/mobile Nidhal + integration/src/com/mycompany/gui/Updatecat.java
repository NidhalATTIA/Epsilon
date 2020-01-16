/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import Entite.Categorie;
import Service.ServiceCategorie;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
class Updatecat {
          Form f;
    
     public Form getF() {
        return f;
    }

    public Updatecat() throws IOException {
     
        Toolbar.setGlobalToolbar(true);
      
        f = new Form("Modifier Categorie");

        Button btn = new Button("Save");
        Label ltitre = new Label("Categorie");
        TextField id = new TextField();
        TextField categorier = new TextField();
        
        ServiceCategorie sf = new ServiceCategorie();
        CategorieR z = new CategorieR();
        
        //int a = (int) data.get("id");
        
       // titre.setText((String) data.get("Titre"));
      
      categorier.setText(z.aa);
      id.setText(String.valueOf(z.bb));
       
       
        Container c = new Container(BoxLayout.y());
        c.setScrollableY(true);
       
       
        c.add(ltitre);
        c.add(categorier);
        c.add(btn);
        f.add(c);
        f.show();
        

        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

                if (categorier.getText().trim().equals("")) {
                    Dialog.show("champs vide", "Veuiller remplir ce champ", "ok", "cancel");
 
                } else {

                    InfiniteProgress ip = new InfiniteProgress();
                    Dialog dlg = ip.showInifiniteBlocking();
                    ServiceCategorie ser = new ServiceCategorie();
    
                    Categorie r = new Categorie();
                    
                   // r.setId((int) data.get("id"));
                   
                   r.setId(Integer.parseInt(id.getText()));
                    
                   r.setCategorier(categorier.getText());
            
                    ser.updatecat(r);
                   
                    CategorieR tt = new CategorieR();
                    ArrayList<Categorie> list = new ArrayList();
                    sf.getlist();
                 //   tt.CategorieR();
                   tt.getF().show();
                    
                    ToastBar.Status status = ToastBar.getInstance().createStatus();
                    status.setMessage("Catégorie modifiée");
                    status.showDelayed(50);
                    status.setExpires(3000);
                }
            }
        });
        
            
f.getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                CategorieR tt = new CategorieR();
               
                ArrayList<Categorie> list = new ArrayList();
                        sf.getlist();
            
                      //  tt.CategorieR();
              
                                          
                                
                tt.getF().show();
                   
            }});  
   
   
             
}
}