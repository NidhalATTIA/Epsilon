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
import com.mycompany.Entite.Categorie_Skills;
import com.mycompany.Entite.Skills;
import com.mycompany.Entite.FreelancerSkills;
import com.mycompany.Entite.SujetForum;
import com.mycompany.Entite.fos_user;
import static com.mycompany.gui.authentification.iduser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author Arzack
 */
public class ServiceSkills {
    
        public ArrayList<FreelancerSkills> getList1(int id) {
        ArrayList<FreelancerSkills> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        id = iduser;
        con.setUrl("http://localhost/SmartStart_test/web/app_dev.php/skills/"+id);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                   
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                for (Map<String, Object> obj : list) {
                        FreelancerSkills task = new FreelancerSkills();

                       float id = Float.parseFloat(obj.get("id").toString());
                       
                     task.setID((int) id );  
                     task.setContenu(obj.get("contenu").toString());
                
                     
                     
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
    



    
    
    
    

