/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;

import Entity.Feedbackc;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.gui.afficheMesFeed;
import com.mycompany.gui.afficheUser;
import static com.mycompany.gui.authentification.idFinal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



/**
 *
 * @author Yasser Bel Haj Ali
 */
public class ServiceFeed {
    
   
    
    public ArrayList<Feedbackc> getList1(int id) {
        ArrayList<Feedbackc> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        
        con.setUrl("http://localhost/SmartStart_test/web/app_dev.php/Afficherfeedmobile/"+id);
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
                        Feedbackc task = new Feedbackc();
                       
                         
                      
                       float id = Float.parseFloat(obj.get("id").toString());
                       
                       task.setId((int) id);
                       task.setContenu(obj.get("contenu").toString());
                       
                       
                 

                       //task.setMail(obj.get("password").toString());
                    
                       
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
    
    
    
    
    
    
    
    
    
   
    
    public ArrayList<Feedbackc> getMesFeed(int id) {
        ArrayList<Feedbackc> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        
        con.setUrl("http://localhost/SmartStart_test/web/app_dev.php/afficherfeedparclient/"+id);
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
                        Feedbackc task = new Feedbackc();
                       
                         
                      
                       float id = Float.parseFloat(obj.get("id").toString());
                      
                       
                       
                       
                       
                       
                       
                       
                       
                       
                       task.setId((int) id);
                       task.setContenu(obj.get("contenu").toString());
                       
                    
                         

                       //task.setMail(obj.get("password").toString());
                    
                       
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
    
    
    
    
    
    
    
    
    
    
    
    
    public ArrayList<Feedbackc> getListtosup(int id) {
        ArrayList<Feedbackc> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        
        con.setUrl("http://localhost/SmartStart_test/web/app_dev.php/supprime/"+id);
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
                        Feedbackc task = new Feedbackc();
                       
                         
                      
                       float id = Float.parseFloat(obj.get("id").toString());
                       
                       task.setId((int) id);
                       task.setContenu(obj.get("contenu").toString());
                       
                    
                 

                       //task.setMail(obj.get("password").toString());
                    
                       
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
    
    
   
    public void ModifierStand(Feedbackc r, int id) {
        ConnectionRequest req = new ConnectionRequest();

        String url = "http://localhost/SmartStart_test/web/app_dev.php/Modifierfeed/"+id +"?&contenu=" + r.getContenu();
        req.setUrl(url);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                byte[] data = (byte[]) evt.getMetaData();
                String s = new String(data);
                System.out.println(s);
           

                Dialog.show("Confirmation", "Stand MODIFIE Avec Succès ", "Ok", null);
                 afficheUser evenementForm = new afficheUser();
                 afficheMesFeed feed = new afficheMesFeed();
     
              
                try {
                    feed.alleven(idFinal);
                } catch (IOException ex) {
              
                }
                    feed.get().show();
                
                   
                
            }
        });
        NetworkManager.getInstance().addToQueue(req);
    }
	
    
    
    
    
    
    
}   
