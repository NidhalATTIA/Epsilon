/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;

import Entity.User;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Yasser Bel Haj Ali
 */
public class ServiceClient {
    
    
    
    
    
    
    
    
    
    public ArrayList<User> getList1() {
        ArrayList<User> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        
        con.setUrl("http://localhost/SmartStart_test/web/app_dev.php/Affichermobile");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                   // System.out.println(tasks);
                    //System.out.println(tasks);
                   
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    for (Map<String, Object> obj : list) {
                        User task = new User();
                       
                         
                      
                       float id = Float.parseFloat(obj.get("id").toString());
                       
                       task.setId((int) id);
                       task.setUsername(obj.get("username").toString());
                       

                       //task.setMail(obj.get("password").toString());

                       //task.setPassword("oussama");
                       task.setEmail(obj.get("email").toString());
                       task.setTypeuser(obj.get("typeUser").toString());
                       //******************************
                       
                            //System.out.println(map.get("timestamp"));
                       //*******************
                     //  System.out.println("eeee"+task.getEmail()+"ddd"+task.getId()+"task."+task.getNom()+"erererer"+task.getPrenom()+"ererrerer"+task.getUsername()+"rrr"+task.getPassword());
                      // hm.put(obj.get("username").toString(),obj.get("mail").toString());
                     // System.out.println("service"+task);
                        listTasks.add(task);
                      

                    }
                     //   System.out.println(listTasks);
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        
        return listTasks;
    }
  
    
}
