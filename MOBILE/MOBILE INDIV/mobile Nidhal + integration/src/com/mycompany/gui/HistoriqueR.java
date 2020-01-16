/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import Entite.Historique;
import Entite.Ticket;
import Service.ServiceHistorique;
import Service.ServiceTicket;
import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.MultiList;
import com.codename1.ui.spinner.Picker;
import static com.mycompany.gui.authentification.Farah;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author LENOVO
 */
public class HistoriqueR {

    ServiceTicket serviceTicket = new ServiceTicket();
    ServiceHistorique cf = new ServiceHistorique();
    Form f;

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public HistoriqueR() {
        f = new Form("Historique des reclamations", BoxLayout.y());
        f.getToolbar().addCommandToRightBar("back", null, (ev) -> {
            AcceuilFreelancer h = new AcceuilFreelancer();
            h.acceuil(Farah);
            h.getF1().show();
        });

        ArrayList<Historique> Form = new ArrayList<>();

        ServiceHistorique sc = new ServiceHistorique();
        System.out.println(sc.getlist());
        //      Form = sc.getlist();
        for (Historique c : sc.getlist()) {

            Container gridLay = new Container(new GridLayout(2, 2));
            ArrayList<Map<String, Object>> data = new ArrayList<>();
            DefaultListModel<Map<String, Object>> mdl = new DefaultListModel<>(data);
            MultiList ml = new MultiList(mdl);

            Container ct = new Container(new BoxLayout(BoxLayout.Y_AXIS));

            Container ct1 = new Container(new BoxLayout(BoxLayout.X_AXIS));

            Label l1 = new Label("attribution : "+c.getAttribution());

            Label l3 = new Label("gsm: "+c.getGsm());

            Label l4 = new Label("etat: "+c.getEtat());

           

         
            Picker p = new Picker();
            Historique t = new Historique();

            f.add(l1);

            f.add(l3);
            f.add(l4);
            
f.add(p);
            f.addComponent(ct);
            f.addComponent(ct1);
        }

        Button btajout = new Button("Ajouter");
        btajout.addActionListener((e) -> {/*
                       AjoutRec a = new AjoutRec();
                a.getF().show();
             */
        });
        f.add(btajout);

    }

}
