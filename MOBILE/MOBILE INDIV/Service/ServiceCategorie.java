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
import Entite.Categorie;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author LENOVO
 */
public class ServiceCategorie {

    
    public static int id;
     public ArrayList<Categorie> getlist() {
        ArrayList<Categorie> listformations = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();

        con.setUrl("http://localhost/Baltifarah/web/app_dev.php/Ticket/categorie/all2");
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
                             
                                
                        float id = Float.parseFloat(obj.get("id").toString());                                                       
                        form.setId((int) id);
                        
                        form.setCategorier(obj.get("categorier").toString()); 
                        
                         
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
    
   public void ajoutFormation(Categorie r) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/Baltifarah/web/app_dev.php/Ticket/cat/new2?categorier=" + r.getCategorier();
        con.setUrl(Url);

        System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
   
   public void suppCat(int id) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/Baltifarah/web/app_dev.php/Ticket/deleter/"+id;// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
   
   /*public void updatecat(Categorie r) {
        ConnectionRequest conn = new ConnectionRequest();
   
         String Url = "http://localhost/Baltifarah/web/app_dev.php/Ticket/editr/"+r.getId();;
         
        conn.setUrl(Url);

        conn.addResponseListener((e) -> {
            String str = new String(conn.getResponseData());

        });
        NetworkManager.getInstance().addToQueueAndWait(conn);
    }*/
   public void updatecat(Categorie r) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/Baltifarah/web/app_dev.php/Ticket/editr/" +id+"?categorier="+r.getCategorier();// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
   
   
}

  

