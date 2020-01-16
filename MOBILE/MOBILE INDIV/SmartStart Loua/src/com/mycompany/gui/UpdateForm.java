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
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
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
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
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
import java.util.Date;
import java.util.Hashtable;

/**
 *
 * @author SouhaiKr
 */
public class UpdateForm {
String x;
    Form f;
    Resources theme;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    public UpdateForm(Hashtable data) throws IOException {
        theme = UIManager.initFirstTheme("/theme");
        Toolbar.setGlobalToolbar(true);
      
        f = new Form("Modifier Formation");

        Button btn = new Button("Save");
  
        Label ltitre = new Label("Titre");
        ltitre.getAllStyles().setFgColor(0xff0000);
        //ltitre.getAllStyles().setFgColor(0xa00000);
        //ltitre.getAllStyles().setBorder(Border.createEmpty());
        //ltitre.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_UNDERLINE);
        
        Label lcat = new Label("Categorie");
        lcat.getAllStyles().setFgColor(0xff0000);
        Label ldesc = new Label("description");
        ldesc.getAllStyles().setFgColor(0xff0000);
        Label llieu = new Label("lieu");
        llieu.getAllStyles().setFgColor(0xff0000);
        Label lprix = new Label("prix");
        lprix.getAllStyles().setFgColor(0xff0000);
        Label lnb = new Label("nbParticipants");
        lnb.getAllStyles().setFgColor(0xff0000);
        
        TextField titre = new TextField("", "Titre");
        TextField desc = new TextField("","description");
        TextField lieu = new TextField("", "lieu");
        TextField prix = new TextField("", "prix");
        TextField nb = new TextField("", "nbParticipants");
        
        Label l6 = new Label("Date de début");
        l6.getAllStyles().setFgColor(0xff0000);
        Picker dd=new Picker();
        Label l7 = new Label("Date de fin");
        l7.getAllStyles().setFgColor(0xff0000);
        Picker df=new Picker();
    
        ComboBox<String> cat=new ComboBox();
        
        ServiceFormation sf = new ServiceFormation();
        ServiceCategorie sc = new ServiceCategorie();
        
        int a = (int) data.get("id");
        
        titre.setText((String) data.get("Titre"));                  
        
        //cat.addItem((String) data.get("CategorieF"));
        for (CategorieFormation cf: sc.getlistcat()){
                       cat.addItem(cf.getCategorief());}
       

        desc.setText((String) data.get("description"));
        lieu.setText((String) data.get("lieu"));
        prix.setText(String.valueOf(data.get("prix")));
        nb.setText(String.valueOf(data.get("nbParticipants")));
        dd.setText(String.valueOf(data.get("dateDebut")));
        df.setText(String.valueOf(data.get("dateFin")));
       
        System.out.println(data);
   
        Container c = new Container(BoxLayout.y());
        c.setScrollableY(true);
       
        c.add(lcat);c.add(cat);
        c.add(ltitre);c.add(titre);
        c.add(ldesc);c.add(desc);
        c.add(llieu);c.add(lieu);
        c.add(lprix);c.add(prix);
        c.add(lnb);c.add(nb);
        c.add(l6);c.add(dd);
        c.add(l7);c.add(df);
  
        c.add(btn);
        f.add(c);
        

        f.show();
       

        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

                if (titre.getText().trim().equals("")) {
                    Dialog.show("champs vide", "Saisir un nom", "ok", "cancel");

                } else if (desc.getText().trim().equals("")) {
                    Dialog.show("champs vide", "Saisir un description", "ok", "cancel");

                } else if (lieu.getText().trim().equals("")) {
                    Dialog.show("champs invalide", "Saisir un lieu", "ok", "cancel");
                } else if (hasNums(prix.getText()).trim().equals("")) {
                    Dialog.show("champs invalide", "Saisir un prix", "ok", "cancel");
                } else if (hasNums(nb.getText()).trim().equals("")) {
                    Dialog.show("champs invalide", "Saisir un nombre de participants", "ok", "cancel");
                } else {

                    InfiniteProgress ip = new InfiniteProgress();
                    Dialog dlg = ip.showInifiniteBlocking();
                    ServiceFormation ser = new ServiceFormation();
    
                    Formation r = new Formation();
                    
                    
                    r.setId((int) data.get("id"));
                    
                    CategorieFormation selectedCategorie = new CategorieFormation();
                    selectedCategorie.setCategorief(cat.getSelectedItem());
                    r.setIdCategorieF(selectedCategorie);
                   
                    
                    
                    r.setTitre(titre.getText());
                    r.setDescription(desc.getText());
                    r.setLieu(lieu.getText());
                    r.setPrix(Integer.parseInt(prix.getText()));
                    r.setNbParticipants(Integer.parseInt(nb.getText()));
                    //date
                    String sDate1 = simpleDateFormat.format(dd.getDate());
                    try {
                        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
                    } catch (ParseException ex) {

                    }
                    r.setDateDebut(sDate1);
            
                    String sDate2 = simpleDateFormat.format(df.getDate());
                    try {
                        Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(sDate2);
                    } catch (ParseException ex) {

                    }

                    r.setDateFin(sDate2);      

                    
                    ser.update(r);
                    DetailFormation d;
                    d = new DetailFormation((int) data.get("id"));
                    d.getD().show();
                    
                    ToastBar.Status status = ToastBar.getInstance().createStatus();
                    status.setMessage("Formation modifiée");
                    status.showDelayed(50);
                    status.setExpires(3000);
                }
            }
        });
        
            f.getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
        
                    DetailFormation df = new DetailFormation(a);
                    ServiceFormation sf = new ServiceFormation();
                    for (Formation re : sf.getDetails2(a)) {
                    SpanLabel titre = new SpanLabel("Titre :" + re.getTitre());
                    SpanLabel cat = new SpanLabel ("Categorie:"+re.getIdCategorieF().getCategorief());
                   //  comp = new SpanLabel("Organisateur"+re.getIdClient().getNom_company());
                    SpanLabel  desc = new SpanLabel("Description :" + re.getDescription());
                    SpanLabel lieu = new SpanLabel("Lieu :" + re.getLieu());
                    SpanLabel nbpart = new SpanLabel("Nombre de participants :" + re.getNbParticipants());
                    SpanLabel  prix = new SpanLabel("Prix :" + re.getPrix());
                    SpanLabel sdd = new SpanLabel("Date de Début :" + re.getDateDebut());
                    SpanLabel sdf = new SpanLabel("Date de Fin:" + re.getDateFin());  
                    df.getD().show();      
                    }
            }});

    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public String hasNums(String str) {
        char[] nums = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] toChar = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            toChar[i] = str.charAt(i);
            for (int j = 0; j < nums.length; j++) {
                if (toChar[i] == nums[j]) {
                    return str;
                }
            }
        }
        return "None";
    }

}
