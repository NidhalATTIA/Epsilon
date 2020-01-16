/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.mycompany.Entite.CategorieFormation;
import com.mycompany.Entite.Formation;
import com.mycompany.Service.ServiceCategorie;
import com.mycompany.Service.ServiceFormation;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author Loua
 */
public class Categories {
    public static String aa;
    public static int bb;
    Form categ = new Form("Categories", BoxLayout.y());
    
    public Form getc(){
        return categ;
    }
    
    public void afficher () throws IOException{
  
                
        ArrayList<CategorieFormation> Form = new ArrayList<>();
    
         ServiceCategorie sc = new ServiceCategorie();
         Form = sc.getlistcat();
         Container gridLay = new Container(new GridLayout(2,2));
         
         
         
         // Label l = new Label("Categories"); 
         for(CategorieFormation c:Form)
         {  
            Label l1= new Label();
            l1.setText( c.getCategorief());

             categ.add(l1);
             
           FloatingActionButton fabD = FloatingActionButton.createFAB(FontImage.MATERIAL_DELETE_OUTLINE);
            RoundBorder rbD = (RoundBorder) fabD.getUnselectedStyle().getBorder();
            rbD.uiid(true);
            fabD.addActionListener((e)->{
                
                if (Dialog.show("Confirmer", "Voulez-vous supprimer cette categorie?", "Ok", "Cancel")) {
                        //ServiceFormation s =new ServiceFormation();
                        sc.deletec(c.getId());
                        
                        
                          Categories t = new Categories();                    
                          ArrayList<CategorieFormation> list = new ArrayList();
                          sc.getlistcat();
            
                try {
                    t.afficher();
                } catch (IOException ex) {
                    
                }                                                                                     
                t.getc().show();
                       
                        ToastBar.Status status = ToastBar.getInstance().createStatus();
                        status.setMessage("Categorie supprimée");
                        status.showDelayed(50);
                        status.setExpires(3000);
                    }
           
        });
            //categ.add(fabD);
            
            
           FloatingActionButton fabU = FloatingActionButton.createFAB(FontImage.MATERIAL_EDIT);
      RoundBorder rbU = (RoundBorder) fabU.getUnselectedStyle().getBorder();
            rbD.uiid(true);
            fabU.addActionListener((e)->{
                aa= c.getCategorief();
                bb=c.getId();
                    Updatecategorie up;
                try {
                    
                    up = new Updatecategorie();
                    up.getF().show();
                } catch (IOException ex) {
                   
                }
                   
              
              
        });
       
         //categ.add(fabU);
         
          Container ct1 = new Container(BoxLayout.xCenter()); 
   ct1.add(fabU);ct1.add(fabD); categ.add(ct1);
       }
       
        Button but = new Button("ajouter une categorie");
            but.addActionListener((e)->{
          
                 AjoutCategorie t = new AjoutCategorie();  
                 t.AjoutFormation();                                      
                 t.getA().show();
        });
        
         
       categ.add(but);
       
       categ.getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                FormationClient t = new FormationClient();
                ServiceFormation sf = new ServiceFormation();
                ArrayList<Formation> list = new ArrayList();
                        sf.getlist();
            
                try {
                    t.afficher();
                } catch (IOException ex) {
                    
                }                
                t.getT().show();

            }
        });
      

}
}