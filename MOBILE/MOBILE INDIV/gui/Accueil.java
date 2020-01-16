/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author LENOVO
 */
public class Accueil {
Form f;
 
    public Form geta(){
        return f;
    }
   
    public Accueil(){
        f = new Form("Accueil", BoxLayout.y());
        f.getToolbar().addMaterialCommandToSideMenu("Reclamation", FontImage.MATERIAL_WEB, e->{TicketR h=new TicketR();
             h.getF().show();
            }); 
        f.getToolbar().addMaterialCommandToSideMenu("Categorie", FontImage.MATERIAL_WEB, e->{CategorieR h=new CategorieR();
            h.getF().show();
            }); 
        f.getToolbar().addMaterialCommandToSideMenu("Historique", FontImage.MATERIAL_WEB, e->{HistoriqueR h=new HistoriqueR();
            h.getF().show();
            });
        
      /*  Button fbButton = new Button("se connecter avec Facebook");
        f.add(fbButton);
        fbButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                UserForm uf = new UserForm();
                uf.facebookLogin(uf);
            }
        });*/
    
      
      
    }
    
    
    
     public Form getF() {
        return f;
    }
    
    public void setF(Form f) {
        this.f = f;
    }


    

   

   
    
}
