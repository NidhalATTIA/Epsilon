/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entite.Categorie;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import Entite.Ticket;
import Service.ServiceCategorie;
import Service.ServiceTicket;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import gui.TicketR;
import java.io.IOException;
import java.util.ArrayList;





/**
 *
 * @author LENOVO
 */
public class AjoutRec {
    Form f;
 //   TextField tticket;
   Button btnajout;
   ServiceTicket serv = new ServiceTicket();
   Ticket r = new Ticket();
    Ticket ticketToAdd;
   static ArrayList<Categorie> listCat = new ArrayList<>();
   
    public AjoutRec() {
        
    f = new Form("Ajouter Reclamation", BoxLayout.y());
        TextField tfOffre = new TextField("","offre");
        f.add(tfOffre);
        TextField tfService = new TextField("","service");
        f.add(tfService);
        TextField tfmotif = new TextField("","motifreclamation");
        f.add(tfmotif);
       
        ComboBox ck = new ComboBox();
        f.add(ck);
        btnajout = new Button("ajouter");
        f.add(btnajout);
        
        
        ///ALL_CATEGORIE et n7othom fel comboBox
        
        
        ServiceCategorie serviceCategorie = new ServiceCategorie();
        ConnectionRequest con = new ConnectionRequest();

        con.setUrl("http://localhost/Baltifarah/web/app_dev.php/Ticket/categorie/all2");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                listCat = serviceCategorie.getlist();
                //System.out.println("list Cat");
                /// System.out.println(listCat);
                for (int i = 0; i < listCat.size(); i++) {
                    // System.out.println(listCat.get(i).getCategorier());
                    ck.addItem(listCat.get(i).getCategorier());
                }
            }
        });
        NetworkManager.getInstance().addToQueue(con);
        
        
        btnajout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                ticketToAdd = new Ticket();
                ticketToAdd.setOffre(tfOffre.getText());
                ticketToAdd.setService(tfService.getText());
                ticketToAdd.setMotifReclamation(tfmotif.getText());
               

               

                //categorie
                Categorie selectedCategorie = new Categorie();
                selectedCategorie.setCategorier(ck.getSelectedItem() + "");
                ticketToAdd.setCategorie(selectedCategorie);

                System.out.println(ticketToAdd);
                
                ServiceTicket serviceTicket = new ServiceTicket();

                serviceTicket.ajouterTicket(ticketToAdd);

            }
        });
      
}

 

  

    
     public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
}