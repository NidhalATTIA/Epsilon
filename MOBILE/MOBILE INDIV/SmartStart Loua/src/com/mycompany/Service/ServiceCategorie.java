/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import com.mycompany.Entite.CategorieFormation;
import com.mycompany.Entite.Formation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Loua
 */
public class ServiceCategorie {
     public ArrayList<CategorieFormation> getlistcat() {
        ArrayList<CategorieFormation> listformations = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();

        con.setUrl("http://localhost/PiSmartStart/web/app_dev.php/Formation/allcat");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    Map<String, Object> formations = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) formations.get("root");

                    for (Map<String, Object> obj : list) {
                        
                       CategorieFormation form=new CategorieFormation(); 
                      
                        float id = Float.parseFloat(obj.get("id").toString());                                                       
                        form.setId((int) id);
                        
                        form.setCategorief(obj.get("categorief").toString()); 
                   
                        System.out.println(form);
                        listformations.add(form);

                    }

                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        System.out.println(listformations);
        return listformations;
    }
     
     public void ajoutCategorie(CategorieFormation r) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/PiSmartStart/web/app_dev.php/Formation/addcat?" + "categorieF=" + r.getCategorief();
        con.setUrl(Url);

        System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
     public void deletec(int id) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PiSmartStart/web/app_dev.php/Formation/suppcat/" + id);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
     
     public void updatec(CategorieFormation r) {
        ConnectionRequest conn = new ConnectionRequest();
   
         String Url = "http://localhost/PiSmartStart/web/app_dev.php/Formation/modifcat/"+r.getId()+"?categorieF=" + r.getCategorief();
         
        conn.setUrl(Url);

        conn.addResponseListener((e) -> {
            String str = new String(conn.getResponseData());

        });
        NetworkManager.getInstance().addToQueueAndWait(conn);
    }
}
