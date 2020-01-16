/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entite.Categorie;
import Service.ServiceCategorie;
import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.MultiList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author LENOVO
 */
public class CategorieR {
   // ServiceCategorie sc=new ServiceCategorie();
    
    ServiceCategorie cf=new ServiceCategorie();
     public static String aa;
    public static int bb;
    Form f;
     public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    public CategorieR(){
        f = new Form("Categorie", BoxLayout.y());
        f.getToolbar().addCommandToRightBar("back", null, (ev)->{Accueil h=new Accueil();
          
          h.getF().show();
          });
        
        
        ArrayList<Categorie> Form = new ArrayList<>();
    
         ServiceCategorie sc = new ServiceCategorie();
         Form = sc.getlist();
        for (Categorie c:Form) {
            
            
            
            
         Container gridLay = new Container(new GridLayout(2,2));
         ArrayList<Map<String, Object>> data = new ArrayList<>();
         DefaultListModel<Map<String, Object>> mdl = new DefaultListModel<>(data);
        MultiList ml = new MultiList(mdl);
        
        
                    
                    Button btModif = new Button("Modifier");
                    btModif.addActionListener((e)->{
                        
                        
                        aa= c.getCategorier();
                bb=c.getId();
                    Updatecat up;
                try {
                    
                    up = new Updatecat();
                    up.getF().show();
                } catch (IOException ex) {
                   
                }
                        });
                    
                    
                    
                    
                    
                    Button btsupp = new Button("Supprimer");
                    btsupp.addActionListener((e)->{ 
                        if (Dialog.show("Confirmer", "Voulez-vous supprimer cette categorie?", "Ok", "Cancel")) {
                        //ServiceFormation s =new ServiceFormation();
                        sc.suppCat(c.getId());
                        
                        
                          CategorieR t = new CategorieR();                    
                          ArrayList<CategorieR> list = new ArrayList();
                          sc.getlist();
            
                                                                                                   
                t.getF().show();
                       
                        ToastBar.Status status = ToastBar.getInstance().createStatus();
                        status.setMessage("Categorie supprimée");
                        status.showDelayed(50);
                        status.setExpires(3000);
                    }
                        });
                    
                    
                    
                    
                    
                    
                    
                     Container ct = new Container(new BoxLayout(BoxLayout.Y_AXIS));

                    Container ct1 = new Container(new BoxLayout(BoxLayout.X_AXIS));

                   Label l1= new Label();
                   
            l1.setText( c.getCategorier());

             f.add(l1);

                   
                    ct1.add(btModif);
                    ct1.add(btsupp);
                    f.addComponent(ct);
                    f.addComponent(ct1);
        }
              
        
        
        
                    Button btajout = new Button("Ajouter");
                    btajout.addActionListener((e)->{
                        AjoutCat a = new AjoutCat();
                a.getF().show();
                        });
                     f.add(btajout);
    }
    }

   

