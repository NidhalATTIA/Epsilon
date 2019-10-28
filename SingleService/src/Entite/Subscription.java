/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author houssembaazoug
 */
public class Subscription {
    private int ID,ID_client,ID_Freelancer;
    public Subscription(){
    }
    public Subscription(int ID, int ID_client,int ID_Freelancer){
    this.ID=ID;
    this.ID_client=ID_client;
    this.ID_Freelancer=ID_Freelancer;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID_client() {
        return ID_client;
    }

    public void setID_client(int ID_client) {
        this.ID_client = ID_client;
    }

    public int getID_Freelancer() {
        return ID_Freelancer;
    }

    public void setID_Freelancer(int ID_Freelancer) {
        this.ID_Freelancer = ID_Freelancer;
    }

    @Override
    public String toString() {
        return "Subscription{" + "ID=" + ID + ", ID_client=" + ID_client + ", ID_Freelancer=" + ID_Freelancer + '}';
    }
    
    
}
