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
import com.mycompany.Entite.FormationCat;
import com.mycompany.Entite.fos_user;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author Loua
 */
public class ServiceFormation {

    public ArrayList<Formation> getlist() {
        ArrayList<Formation> listformations = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();

        con.setUrl("http://localhost/PiSmartStart/web/app_dev.php/Formation/all");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    Map<String, Object> formations = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) formations.get("root");

                    for (Map<String, Object> obj : list) {
                        
                       Formation form=new Formation(); 
                             
                                 CategorieFormation s=new CategorieFormation ();                                         
                                 Map<String,Object> tou = (Map<String,Object>) obj.get("idcategorief");  
                            
                        float id = Float.parseFloat(obj.get("id").toString());                                                       
                        form.setId((int) id);
                        
                        form.setTitre(obj.get("titre").toString()); 
                        
                              s.setCategorief(tou.get("categorief").toString());
                              form.setIdCategorieF(s);
                         
                          
                       form.setDescription(obj.get("description").toString());
                        
                        form.setLieu(obj.get("lieu").toString());
                       
                        float prix = Float.parseFloat(obj.get("prix").toString());                    
                        form.setPrix((int) prix);
                        
                        float nbparticipants = Float.parseFloat(obj.get("nbparticipants").toString());
                        form.setNbParticipants((int) nbparticipants);
                        
                        LinkedHashMap map = ((LinkedHashMap) obj.get("datedebut"));
                        Double i = (Double) map.get("timestamp");
                        java.util.Date time = new java.util.Date((long) i.longValue() * 1000);
                        
                        LinkedHashMap map1 = ((LinkedHashMap) obj.get("datefin"));
                        Double i1 = (Double) map.get("timestamp");
                        java.util.Date time1 = new java.util.Date((long) i1.longValue() * 1000);
                        
                        DateFormat f = new SimpleDateFormat("yyyy-MM-dd");

                        form.setDateDebut(f.format(time));
                        form.setDateFin(f.format(time1));
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
    
    public Formation getFormationById(int id) {
        Formation an = new Formation();

        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PiSmartStart/web/app_dev.php/Formation/all" + Integer.toString(id));
 
        NetworkManager.getInstance().addToQueueAndWait(con);
        return an;
    }
    
    
    ArrayList<Formation> details = new ArrayList<>();

    public ArrayList<Formation> getDetails2(int id) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PiSmartStart/web/app_dev.php/Formation/find/" + id);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceFormation ser = new ServiceFormation();
                details = ser.getDetails(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return details;
    }
    
    
      private ArrayList<Formation> getDetails(String json) {
        ArrayList<Formation> details = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();

            Map<String, Object> obj = j.parseJSON(new CharArrayReader(json.toCharArray()));

            Formation form = new Formation();
                
                             CategorieFormation s=new CategorieFormation ();                                         
                             Map<String,Object> tou = (Map<String,Object>) obj.get("idcategorief");  
                           
                                fos_user fo = new fos_user();
                                Map<String,Object> lou = (Map<String,Object>) obj.get("idclient"); 
                                 
                 
                        float id = Float.parseFloat(obj.get("id").toString());
                        float prix = Float.parseFloat(obj.get("prix").toString());
                        float nbparticipants = Float.parseFloat(obj.get("nbparticipants").toString());
                        
                        form.setId((int) id);
                        
                        form.setTitre(obj.get("titre").toString());              
                       
                              s.setCategorief(tou.get("categorief").toString());
                              form.setIdCategorieF(s);
                              
                              fo.setNom_company(lou.get("nomCompany").toString());
                              form.setIdClient(fo);
                           
                                
                        form.setDescription(obj.get("description").toString());
                        form.setLieu(obj.get("lieu").toString());
                                            
                        form.setPrix((int) prix);
                        form.setNbParticipants((int) nbparticipants);
                        
                        LinkedHashMap map = ((LinkedHashMap) obj.get("datedebut"));
                        Double i = (Double) map.get("timestamp");
                        java.util.Date time = new java.util.Date((long) i.longValue() * 1000);
                        
                        LinkedHashMap map1 = ((LinkedHashMap) obj.get("datefin"));
                        Double i1 = (Double) map1.get("timestamp");
                        java.util.Date time1 = new java.util.Date((long) i1.longValue() * 1000);
                      
                        DateFormat f = new SimpleDateFormat("yyyy-MM-dd");

                        form.setDateDebut(f.format(time));
                        form.setDateFin(f.format(time1));
                        System.out.println(form);
                        details.add(form);

            

        } catch (IOException ex) {
        }
        //System.out.println(listRecettes);
        return details;

    }
    public void ajoutFormation(Formation r) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/PiSmartStart/web/app_dev.php/Formation/new?" + "Titre=" + r.getTitre()+ "&description=" + r.getDescription()
                + "&categorief=" + r.getIdCategorieF().getCategorief() + "&lieu=" + r.getLieu()+ "&prix=" + r.getPrix()+ "&nbParticipants=" + r.getNbParticipants()
                +"&dateDebut=" + r.getDateDebut()+"&dateFin=" + r.getDateFin();
       
        String url2="http://localhost/PiSmartStart/web/app_dev.php/Formation/new?Titre="+r.getTitre()+"&description="+r.getDescription()+"&categorief="+r.getIdCategorieF().getCategorief()+
                "&lieu="+r.getLieu()+"&prix="+r.getPrix()+"&nbParticipants="+r.getNbParticipants()+"&dateDebut="+r.getDateDebut()+
                "&dateFin="+r.getDateFin();
        con.setUrl(url2);

        System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
      
      
      
        public void delete(int id) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PiSmartStart/web/app_dev.php/Formation/supp/" + id);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
        
         public void update(Formation r) {
        ConnectionRequest conn = new ConnectionRequest();
        String Url = "http://localhost/PiSmartStart/web/app_dev.php/Formation/modif/"+r.getId()+"?Titre=" + r.getTitre()+ "&description=" + r.getDescription()+ "&categorief=" + r.getIdCategorieF().getCategorief() 
                + "&lieu=" + r.getLieu()+ "&prix=" + r.getPrix()+ "&nbParticipants=" + r.getNbParticipants()+ "&dateDebut=" + r.getDateDebut()
                + "&dateFin=" + r.getDateFin();
    
              
        conn.setUrl(Url);

        conn.addResponseListener((e) -> {
            String str = new String(conn.getResponseData());

        });
        NetworkManager.getInstance().addToQueueAndWait(conn);
    }
         
  /* public FormationCat getFormationCatById(int id) {
        FormationCat an = new FormationCat();

        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PiSmartStart/web/app_dev.php/Formation/search" + Integer.toString(id));
 
        NetworkManager.getInstance().addToQueueAndWait(con);
        return an;
    }*/
           
         
   
  public CategorieFormation getCategorie(String categorief) {
        CategorieFormation an = new CategorieFormation();

        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PiSmartStart/web/app_dev.php/Formation/findCategorie/"+categorief);
 
        NetworkManager.getInstance().addToQueueAndWait(con);
        return an;
    }
   
  

}
    
    
    
    

