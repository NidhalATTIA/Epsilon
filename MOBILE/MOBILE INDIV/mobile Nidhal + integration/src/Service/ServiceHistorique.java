/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;


import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import Entite.Historique;
import Entite.Ticket;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author LENOVO
 */
public class ServiceHistorique {


public ArrayList<Ticket> getAllT() {
        ArrayList<Ticket> listT = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();

        con.setUrl("http://localhost/SmartStart_test/web/app_dev.php/tickets/all1");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    Map<String, Object> formations = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) formations.get("root");

                    for (Map<String, Object> obj : list) {
                        
                       Ticket form=new Ticket(); 
                         
                         
                            
                              
                        
               //       float categorie = Float.parseFloat(obj.get("categorie").toString());                                                       
                 //       form.setCategorie((int) categorie);
                        float id = Float.parseFloat(obj.get("id").toString());                                                       
                        form.setId((int) id);
                        form.setMotifReclamation(obj.get("motifreclamation").toString()); 
                       
                        System.out.println(form);
                        listT.add(form);

                    }

                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        System.out.println(listT);
        return listT;
    }


    
    public ArrayList<Historique> getlist() {
        ArrayList<Historique> listformations = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();

        con.setUrl("http://localhost/SmartStart_test/web/app_dev.php/historique/all3");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    Map<String, Object> formations = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) formations.get("root");

                    for (Map<String, Object> obj : list) {
                        
                       Historique form=new Historique(); 
 
                            
                              
                        
               //       float categorie = Float.parseFloat(obj.get("categorie").toString());                                                       
                 //       form.setCategorie((int) categorie);
                        float id = Float.parseFloat(obj.get("id").toString());                                                       
                        form.setId((int) id);
                        form.setAttribution(obj.get("attribution").toString()); 
                        float gsm = Float.parseFloat(obj.get("gsm").toString());                                                       
                        form.setGsm((int) gsm);
                        float etat = Float.parseFloat(obj.get("etat").toString());                                                       
                        form.setEtat((int) etat);
                       
                        
                        
                    
                        
                 form.setId((int) Float.parseFloat(obj.get("id").toString())); 
                     form.setAttribution(obj.get("attribution").toString()); 
                   form.setGsm((int) Float.parseFloat(obj.get("gsm").toString())); 
                   
                   
                   
                   //Motif Recl
                      
                        Map<String, Object> listTicket= (Map<String, Object>) obj.get("motifreclamation");
               
               
                Ticket cat = new Ticket();
                cat.setId((int) Float.parseFloat(listTicket.get("id")+""));
                cat.setOffre(listTicket.get("offre")+"");
                cat.setService(listTicket.get("service")+"");
                cat.setMotifReclamation(listTicket.get("motifreclamation")+"");
                
                form.setMotifreclamation(cat);
                
                
                Map<String, Object> listDate = (Map<String, Object>) obj.get("datecreation");
                SimpleDateFormat sourceFormat = new SimpleDateFormat("d/m/Y");
                Date d = new Date((long) (double) listDate.get("timestamp") * 1000);
               
                form.setDatecreation(d);
                
                ///
                       
                        System.out.println(form);
                        
                
                         
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
    

    }
  
      
      
      

        
   
         
 
         
         
         
         
         
         
         
         
   

   

     

     
    
    

