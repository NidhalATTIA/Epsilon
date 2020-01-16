/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.CENTER;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.mycompany.Entite.CategorieFormation;
import com.mycompany.Entite.Formation;
import com.mycompany.Service.ServiceFormation;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Loua
 */
public class FormationFreelancer {
    String username;
    Form form = new Form("Trainings", BoxLayout.y());
    
     public Form getForm() {
        return form;
    } 
    
    
    public void afficher () throws IOException{
     ArrayList<Formation> Form = new ArrayList<>();
        CategorieFormation cf = new CategorieFormation();
     
         ServiceFormation sa=new ServiceFormation();
         Form = sa.getlist();
         Container gridLay = new Container(new GridLayout(2,2));
         for(Formation c:Form)
            {  
        Label l1= new Label();
        l1.setText("Titre:" + c.getTitre());
       
        Label l2= new Label();
        l2.setText("Categorie:" + c.getIdCategorieF().getCategorief());
       
        Label l3= new Label();
        l3.setText("Lieu:" + c.getLieu());      
        Container cx2=new Container( new FlowLayout(CENTER,CENTER));
        
       
        Button btn =new Button("show more");
        cx2.add(btn);
        
        btn.addActionListener((e)->{
      
                        DetailFormationFreelancer dr;                      
                            dr = new DetailFormationFreelancer(c.getId());
                            dr.getD().show();

                    }); 
        
       form.add(l2);form.add(l1);form.add(l3);form.add(cx2);
       
            }     
       Container c = new Container(new FlowLayout(Component.CENTER));
         

      
      form.getToolbar().addCommandToOverflowMenu("About Trainings", null, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    ChartForm ch = new ChartForm();
                    ch.getF().show();
                }
            });

   }
    
    
    
    
    

    
}
