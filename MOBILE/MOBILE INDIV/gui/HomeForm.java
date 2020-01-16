/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import Service.ServiceTask;
import Entite.Task;

/**
 *
 * @author bhk
 */
public class HomeForm {

    Form f;
    TextField tnom;
    TextField tetat;
    Button btnajout,btnaff,btns;
    Label lab;
    public HomeForm() {
        f = new Form("Login");
        tnom = new TextField("","Email");
        tetat = new TextField("","Password");
        btnajout = new Button("Login");
        lab = new Label();
      
        f.add(tnom);
        f.add(tetat);
        f.add(btnajout);
        f.add(lab);
        
        btnajout.addActionListener((e) -> {
            ServiceTask ser = new ServiceTask();
           
           String res =  ser.ajoutTask(tnom.getText(), tetat.getText());
           System.out.println(tnom.getText());
           
           System.out.println(tetat.getText());
           System.out.println(res);
           if(res.equals("\"success\"")){
               Accueil a=new Accueil();
                 a.getF().show();
           }else{
               lab.setText("invalid cordentials");
           }
        });
      
       
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public TextField getTnom() {
        return tnom;
    }

    public void setTnom(TextField tnom) {
        this.tnom = tnom;
    }

}
