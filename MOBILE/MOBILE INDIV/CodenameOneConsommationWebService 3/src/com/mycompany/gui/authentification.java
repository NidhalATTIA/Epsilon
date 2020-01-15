/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;


import com.codename1.io.CharArrayReader;
import com.mycompany.Entite.fos_user;
import com.mycompany.Service.ServiceUser;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.ParseException;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author Arzack
 */
public class authentification {
    public static String type ;
    Form f;
    String UserName;
    Resources res;
    public static int iduser;
    public static int idFinal;
    public static int Nidhal;
   
    public void authentification(){
        
        ServiceUser ser=new ServiceUser();
        f=new Form("Authentification",BoxLayout.y());
        TextField user=new TextField("","User Name");
        TextField pass=new TextField("","password",10,TextArea.PASSWORD);
      
        Button SignIn =new Button("SignIn");
        Button Login =new Button("Login");
    
      
    
        Label userl=new Label("UserName");
        Label passl=new Label("Password");	
      
       
        userl.getAllStyles().setFgColor(0x471CBD);    
        userl.getAllStyles().setTextDecoration(Style.BACKGROUND_GRADIENT_RADIAL);
        passl.getAllStyles().setFgColor(0x471CBD);    
        passl.getAllStyles().setTextDecoration(Style.BACKGROUND_GRADIENT_RADIAL);
      
        Container cx=new Container(BoxLayout.x());
        Container cx1=new Container(BoxLayout.x());
        Container cx2=new Container( new FlowLayout(CENTER,CENTER));
        
        cx.add(userl);
        cx.add(user);
        cx1.add(passl);
        cx1.add(pass);
        cx2.add(Login);
        cx2.add(SignIn);
        
        f.add(cx);
        f.add(cx1);
        f.add(cx2);
        
        Label controleuser=new Label("");
        Label controlepass=new Label("");
        Label controletext=new Label("");
        //"http://localhost/fixit/web/app_dev.php/client/login/" + user.getText() + "/" + pass.getText();
        
        
         Login.addActionListener((e) -> {
           ConnectionRequest con = new ConnectionRequest();
        
        con.setUrl("http://localhost/SmartStart_test/web/app_dev.php/loginmobile/" + user.getText() + "/" + pass.getText());
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
           
                public void actionPerformed(NetworkEvent evt) {
                    fos_user u = new fos_user();
                    
                     ArrayList<fos_user> listformations = new ArrayList<>();
                    String message = new String(con.getResponseData());
                   
                    JSONParser jsonp = new JSONParser();
                     try {
                    Map<String, Object> formations = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) formations.get("root");

                    for (Map<String, Object> obj : list) {
                        
                       fos_user form=new fos_user(); 
                             
                      

                        float id = Float.parseFloat(obj.get("id").toString());                                                       
                        form.setId((int) id);
                        form.setTypeuser(obj.get("typeUser").toString());
                        
                         type=form.getTypeuser();
                              if ((type.equals("freelancer"))) {
                          iduser=form.getId();
                              }else {
                           idFinal=form.getId();
                              }
                           Nidhal=form.getId();
                              
                        

                    }

                } catch (IOException ex) {
                }
                    
                    
                     System.out.println("yassserrrrr"+type);
                    
                    
                 
                    System.out.println(message);
                    System.out.println(message);
                    System.out.println(message);
                    System.out.println(message);

                    if (message.equals("false")) {
                        Dialog.show("ERROR !", "Wrond Login or Password", "OK", null);

                    }

                    if ((type.equals("freelancer"))) {
                        ServiceUser ser = new ServiceUser();
                        try {
                            u = ser.parseUserJson(message);
                        } catch (ParseException ex) {
                        }
                        AcceuilFreelancer a=new AcceuilFreelancer();
                        AcceuilFreelancer ac = new AcceuilFreelancer();
                                   ac.acceuil(UserName);
                                   ac.getF1().show();
                    }
                    else
                    {
                        ServiceUser ser = new ServiceUser();
                        try {
                            u = ser.parseUserJson(message);
                        } catch (ParseException ex) {
                        }
                        AcceuilClient a=new AcceuilClient();
                        AcceuilClient ac = new AcceuilClient();
                                   ac.acceuil(UserName);
                                   ac.getF2().show();
                    
                    }

                }

            });
            NetworkManager.getInstance().addToQueueAndWait(con);

        });
         
        user.addDataChangedListener((type, u) -> {
         
            controleuser.setText("");
            controletext.setText("");
            f.refreshTheme();
        });
        user.addDataChangedListener((type, index) -> {
            controlepass.setText("");
            f.refreshTheme();
        });
       f.add(controleuser);
       f.add(controletext);
       f.add(controlepass);
       
    }
    public Form getF() {
        return f;
    }
    
}

