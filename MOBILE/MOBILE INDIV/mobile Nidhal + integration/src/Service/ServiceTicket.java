/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Categorie;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import Entite.Ticket;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.mycompany.gui.TicketR;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author LENOVO
 */
public class ServiceTicket {
public static int idsuj;
Form f;
ArrayList<Ticket> listTicket = new ArrayList<>();

 

   
 

   

   
public ArrayList<Categorie> getAllCategorie() {
        ArrayList<Categorie> listCategorie = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();

        con.setUrl("http://localhost/SmartStart_test/web/app_dev.php/categorie/all2");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    Map<String, Object> formations = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) formations.get("root");

                    for (Map<String, Object> obj : list) {
                        
                       Categorie form=new Categorie(); 
                         
                         
                            
                              
                        
               //       float categorie = Float.parseFloat(obj.get("categorie").toString());                                                       
                 //       form.setCategorie((int) categorie);
                        float id = Float.parseFloat(obj.get("id").toString());                                                       
                        form.setId((int) id);
                        form.setCategorier(obj.get("categorier").toString()); 
                       
                      //  System.out.println(form);
                        listCategorie.add(form);

                    }

                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        System.out.println(listCategorie);
        return listCategorie;
    }


    
    public ArrayList<Ticket> getlist() {
        ArrayList<Ticket> listformations = new ArrayList<>();
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
                        form.setOffre(obj.get("offre").toString()); 
                        form.setService(obj.get("service").toString());
                        form.setMotifReclamation(obj.get("motifreclamation").toString());
                        form.setImage(obj.get("image").toString());
                         
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
    
     
     public void ajoutRec(Ticket t) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/SmartStart_test/web/app_dev.php/ticket/new1?offre=" + t.getOffre();
        con.setUrl(Url);

        System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
     public void suppRec(int id) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/SmartStart_test/web/app_dev.php/delete/"+id;// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
    

    public ArrayList<Ticket> parseListTaskJson(String json){
  
         
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/SmartStart_test/web/app_dev.php/tickets/find1");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
              
                listTicket =parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTicket;
    }

  
    
     public void ajouterTicket(Ticket ticket) {
        ConnectionRequest req = new ConnectionRequest();

        String url = "http://localhost/SmartStart_test/web/app_dev.php/ticket/new1?"
                + "offre="+ticket.getOffre()+"&service="+ticket.getService()
                +"&motifReclamation="+ticket.getMotifreclamation()+"&categorier="+ticket.getCategorie().getCategorier();
                          
        req.setUrl(url);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                byte[] data = (byte[]) evt.getMetaData();
                String s = new String(data);
                System.out.println(s);

                Dialog.show("Confirmation", "Reclamation est ajoutée Avec Succès ", "Ok", null);
                    TicketR h=new TicketR();
                h.getF().show();

            }
        });

        NetworkManager.getInstance().addToQueue(req);
    }


    
    
    
    
}
    
    

