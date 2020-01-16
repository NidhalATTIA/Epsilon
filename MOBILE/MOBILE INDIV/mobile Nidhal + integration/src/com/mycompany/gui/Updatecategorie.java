/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.ImageIO;
import com.codename1.ui.util.Resources;
import com.codename1.util.Base64;
import com.mycompany.Entite.CategorieFormation;
import com.mycompany.Entite.Formation;
import com.mycompany.Service.ServiceCategorie;
import com.mycompany.Service.ServiceFormation;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author SouhaiKr
 */
public class Updatecategorie {
    Form f;
    Resources theme;
     public Form getF() {
        return f;
    }

    public Updatecategorie() throws IOException {
        theme = UIManager.initFirstTheme("/theme");
        Toolbar.setGlobalToolbar(true);
      
        f = new Form("Modifier Categorie");

        Button btn = new Button("Save");
        Label ltitre = new Label("Categorie");
        TextField id = new TextField();
        TextField titre = new TextField();
        
        ServiceCategorie sf = new ServiceCategorie();
        Categories z = new Categories();
        
        //int a = (int) data.get("id");
        
       // titre.setText((String) data.get("Titre"));
      
       titre.setText(z.aa);
       id.setText(String.valueOf(z.bb));
       
       
        Container c = new Container(BoxLayout.y());
        c.setScrollableY(true);
       
       
        c.add(ltitre);
        c.add(titre);
        c.add(btn);
        f.add(c);
        f.show();
        

        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

                if (titre.getText().trim().equals("")) {
                    Dialog.show("champs vide", "Veuiller remplir ce champ", "ok", "cancel");
 
                } else {

                    InfiniteProgress ip = new InfiniteProgress();
                    Dialog dlg = ip.showInifiniteBlocking();
                    ServiceCategorie ser = new ServiceCategorie();
    
                    CategorieFormation r = new CategorieFormation();
                    
                   // r.setId((int) data.get("id"));
                   
                   r.setId(Integer.parseInt(id.getText()));
                    
                   r.setCategorief(titre.getText());
            
                    ser.updatec(r);
                   
                    Categories tt = new Categories();
                    ArrayList<CategorieFormation> list = new ArrayList();
                    sf.getlistcat();
                     try {
                        tt.afficher();
                    } catch (IOException ex) {
                   }
                   tt.getc().show();
                    
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
                Categories tt = new Categories();
               
                ArrayList<CategorieFormation> list = new ArrayList();
                        sf.getlistcat();
            
                try {
                    tt.afficher();
                } catch (IOException ex) {
                    
                }
              
                                          
                                
                tt.getc().show();
                   
            }});              
}
}
