/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui.client;

import com.mycompany.gui.freelancer.*;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Form;
import com.mycompany.Services.ServiceTask;

/**
 *
 * @author Arzack
 */
public class ReclamationClient {

    Form f;
    SpanLabel lb;
  
    public ReclamationClient() {
        
        f = new Form();
        lb = new SpanLabel("");
        f.add(lb);
        ServiceTask serviceTask=new ServiceTask();
        lb.setText(serviceTask.getList2().toString());
        
          f.getToolbar().addCommandToRightBar("back", null, (ev)->{HomeFormC h=new HomeFormC();
          h.getF().show();
          });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
