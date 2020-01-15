/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;

import Entity.Feedbackc;
import Entity.Note;
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
public class ServiceNote {
   float notes = 0 ;
     float moyenne = 0 ;
    public float getlisteNote(int id) {
        ArrayList<Note> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        
        con.setUrl("http://localhost/SmartStart_test/web/app_dev.php/lesnoteparclient?idfreelancer="+id);
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
                        Note task = new Note();
                       
                         
                      
                       float id = Float.parseFloat(obj.get("id").toString());
                       float note = Float.parseFloat(obj.get("note").toString());
                       notes =note+ notes ;
                       moyenne++;
                       
                       task.setNote((int) note);
                       
                       task.setId((int) id);
                       //task.setNote((int) ("note"));
                   
                       
                 

                       //task.setMail(obj.get("password").toString());
                    
                       
                       //******************************
                       
                            //System.out.println(map.get("timestamp"));
                       //*******************
                     //  System.out.println("eeee"+task.getEmail()+"ddd"+task.getId()+"task."+task.getNom()+"erererer"+task.getPrenom()+"ererrerer"+task.getUsername()+"rrr"+task.getPassword());
                      // hm.put(obj.get("username").toString(),obj.get("mail").toString());
                     // System.out.println("service"+task);
                        listTasks.add(task);
                      

                    }
                    
                    notes=notes/moyenne;
                    
                    System.out.println("moyennnnnne"+notes);
                     //   System.out.println(listTasks);
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        
        return notes;
    }
    
    
    
}
