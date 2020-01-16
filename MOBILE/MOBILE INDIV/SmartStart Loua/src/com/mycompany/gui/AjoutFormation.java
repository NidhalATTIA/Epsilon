/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.spinner.Picker;
import com.mycompany.Entite.CategorieFormation;
import com.mycompany.Entite.Formation;
import com.mycompany.Entite.fos_user;
import com.mycompany.Service.ServiceCategorie;
import com.mycompany.Service.ServiceFormation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author Loua
 */
public class AjoutFormation {
    
    Form ajout = new Form("Ajouter une Formation", BoxLayout.y());
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
    
     public void AjoutFormation () {
    
    Container cnt1 = new Container(BoxLayout.y());
        cnt1.setScrollableY(true);
   
    TextField tf1 = new TextField();
    Label l1 = new Label("Titre");
    
    Label l2 = new Label("description");
    TextField ta = new TextField();
    
    Label l3 = new Label("lieu");
    TextField tf3 = new TextField();
    
    Label l4 = new Label("prix");
    TextField tf4 = new TextField();
   
    Label l5 = new Label("nbParticipants");
    TextField tf5 = new TextField();
    
    Label l6 = new Label("Date de début");
    Picker dd=new Picker();
    Label l7 = new Label("Date de fin");
    Picker df=new Picker();
    
    
    ComboBox<String> cat=new ComboBox();
    
    
    ServiceCategorie sf = new ServiceCategorie();
    ServiceFormation sff = new ServiceFormation();
    
  
    
    for (CategorieFormation cf: sf.getlistcat()){
                       cat.addItem(cf.getCategorief());}
    Button btn =new Button("Save");
   
    
    btn.addActionListener((e)->{
   
            Formation t = new Formation();
                   CategorieFormation selectedCategorie = new CategorieFormation();
                    selectedCategorie.setCategorief(cat.getSelectedItem());
                    System.out.println("SelectedItem"+cat.getSelectedItem());
                   // t.setIdCategorieF(selectedCategorie);
            
            t.setTitre(tf1.getText());
            t.setDescription(ta.getText());
            t.setLieu(tf3.getText());
            t.setPrix(Integer.parseInt(tf4.getText()));
            t.setNbParticipants(Integer.parseInt(tf5.getText()));
           
            t.setIdCategorieF(selectedCategorie);
       
            String sDate1 = simpleDateFormat.format(dd.getDate());
        try {
            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
        } catch (ParseException ex) {
            
        }
                    t.setDateDebut(sDate1);
            
            String sDate2 = simpleDateFormat.format(df.getDate());
        try {
            Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(sDate2);
        } catch (ParseException ex) {
           
        }
            t.setDateFin(sDate2);
            System.out.println("FormationToAdd"+t.toString());
            sff.ajoutFormation(t);
    
    });
     
    cnt1.add(cat);cnt1.add(l1);cnt1.add(tf1);cnt1.add(l2);cnt1.add(ta);cnt1.add(l3);
    cnt1.add(tf3);cnt1.add(l4);cnt1.add(tf4);cnt1.add(l5);cnt1.add(tf5);
    cnt1.add(l6);cnt1.add(dd);cnt1.add(l7);cnt1.add(df); cnt1.add(btn);
    ajout.add(cnt1);
    
    
   
    
    ajout.getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {
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
         
      public Form getA() {
        return ajout;
    }      
         
         
         
    
}
