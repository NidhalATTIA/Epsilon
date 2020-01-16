/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;

import com.mycompany.Entite.fos_user;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Oussama
 */
public class ServiceParticipation {
     public void participer(int IdFormation, int IdFreelancer) throws IOException{
         ConnectionRequest con = new ConnectionRequest();
        String url = "http://localhost/PiSmartStart/web/app_dev.php/Formation/participer?idformation=" + IdFormation + "&id=" + IdFreelancer;
       
        con.setUrl(url);
            con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    Map<String, Object> annonces = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) annonces.get("root");
                    System.out.println(list);
                    if(list==null){
                        Dialog.show("Confirmation", "tu as déjà participé", "Ok", "Annuler");
                    }else{
                          Dialog.show("Confirmation", "Felicitation! vous etes désormais membre de cette formation", "Ok", "Annuler");
                    }
                  

                } catch (IOException ex) {
                }
           }
        });
            NetworkManager.getInstance().addToQueueAndWait(con);
    
    
}
     
     public void annuler(int IdFormation, int IdFreelancer) throws IOException{
         ConnectionRequest con = new ConnectionRequest();
        String url = "http://localhost/PiSmartStart/web/app_dev.php/Formation/annulerparticipation?idformation=" + IdFormation + "&id=" + IdFreelancer;
       
        con.setUrl(url);
            con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    Map<String, Object> annonces = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) annonces.get("root");
                    System.out.println(list);
                    if(list==null){
                        Dialog.show("Confirmation", "tu as déjà participé", "Ok", "Annuler");
                    }else{
                          Dialog.show("Confirmation", "Felicitation! vous etes désormais membre de cette formation", "Ok", "Annuler");
                    }
                  

                } catch (IOException ex) {
                }
           }
        });
            NetworkManager.getInstance().addToQueueAndWait(con);
    
    
}
     
     
}