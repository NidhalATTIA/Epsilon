/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import Entity.Feedbackc;

import com.codename1.charts.util.ColorUtil;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.util.UIBuilder;
import com.mycompany.Service.ServiceFeed;
import static com.mycompany.gui.authentification.idFinal;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Yasser Bel Haj Ali
 */
public class afficheMesFeed {

    Form monfeed = new Form("Mes Feedback", new FlowLayout(Component.CENTER, Component.CENTER));
  public static int idfeedback;

    Feedbackc eventToEdit;
    public void alleven(int id) throws IOException {
        ArrayList<Feedbackc> Produits = new ArrayList<>();
        ServiceFeed sa = new ServiceFeed();
        Produits = sa.getMesFeed(id);

        for (Feedbackc c : Produits) {
            affichersingle(c);
        }
    }

    public void affichersingle(Feedbackc c) {
        Container RegC = new Container(new FlowLayout(Component.CENTER));

        Button supprime = new Button();
        supprime.getAllStyles().setFgColor(ColorUtil.rgb(10, 100, 0));
        supprime.setIcon(FontImage.createMaterial(FontImage.MATERIAL_SETTINGS, supprime.getUnselectedStyle()));

        supprime.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

                ConnectionRequest req = new ConnectionRequest();
                req.setUrl("http://localhost/SmartStart_test/web/app_dev.php/supprime?id=" + c.getId() + "&idUser=" + idFinal + "");

                req.addResponseListener(new ActionListener<NetworkEvent>() {
                            
                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        byte[] data = (byte[]) evt.getMetaData();
                                idfeedback = c.getId() ;
                        Dialog.show("Confirmation", "etes vous sur de vouloir supprimer", "Ok", null);

                    }
                });

                NetworkManager.getInstance().addToQueue(req);
                monfeed.refreshTheme();

            }
        });

        //////////////Modif
        Button btModif = new Button("modifier");

        btModif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                Form formModifEvent = new Form();

                UIBuilder ui = new UIBuilder();
                //formModifEvent = ui.createContainer(theme, "ModifEvent").getComponentForm();
                formModifEvent.setTitle("Modifier Stand ");
                /*  formModifEvent.getToolbar().addCommandToLeftBar("Back", img1, new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent evt) {
                                    fo.show();
                                }
                            });*/

                //  System.out.println(Integer.parseInt(lb0.getText()));
                TextField contenu = new TextField(c.getContenu());
                TextField test = new TextField("test");
                        

                Container ct = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                ct.add(contenu);
               

                Button btModifEvent = new Button("Modifer Stand");

                ct.add(btModifEvent);

                btModifEvent.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {

                        eventToEdit = new Feedbackc();

                        eventToEdit.setContenu(contenu.getText());

                        System.out.println(eventToEdit);
                        ServiceFeed evenementDAO = new ServiceFeed();
                        evenementDAO.ModifierStand(eventToEdit,c.getId());
                    }
                });
                
            
                
                formModifEvent.getToolbar().addCommandToLeftBar("Back", null, ev->{monfeed.show();});
                formModifEvent.addComponent(ct);
                formModifEvent.show();

            }
        });

        Label l1 = new Label();
        l1.setText(c.getContenu());
        l1.setScrollAnimationSpeed(50);
        RegC.addAll(l1, supprime);

        monfeed.addAll(RegC,btModif);

    }

    public Form get() {

        return monfeed;
    }

}
