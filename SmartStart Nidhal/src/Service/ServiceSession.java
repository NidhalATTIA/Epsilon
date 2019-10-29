/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import Entite.Admin;
import Entite.Client;
import Entite.Freelancer;

/**
 *
 * @author ARzack
 */
public class ServiceSession {
    Client c = null;
    public ServiceSession(Client c){
    this.c=c;
    }
    
    public void setC(Client c){
    this.c = c;
    }
    public Client getC(Client c){
    return c;
    }
}
