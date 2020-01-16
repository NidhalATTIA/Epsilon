/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.util.Date;

/**
 *
 * @author LENOVO
 */
public class Historique {

    private int id;
    private String attribution;
    private Ticket motifreclamation;
    private float gsm;
    private Date datecreation;
    private int etat;
    

    public Historique() {
    }

    public Historique(int id, String attribution,Ticket motifreclamation,float gsm,Date datecreation,int etat) {
        this.id = id;
        this.attribution = attribution;
        this.motifreclamation = motifreclamation;
        this.gsm = gsm;
        this.datecreation = datecreation;
        this.etat = etat;

  
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAttribution() {
        return attribution;
    }

    public void setAttribution(String attribution) {
        this.attribution = attribution;
    }

    public Ticket getMotifreclamation() {
        return motifreclamation;
    }

    public void setMotifreclamation(Ticket motifreclamation) {
        this.motifreclamation = motifreclamation;
    }

    public float getGsm() {
        return gsm;
    }

    public void setGsm(float gsm) {
        this.gsm = gsm;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Historique{" + "id=" + id + ", attribution=" + attribution + ", motifreclamation=" + motifreclamation + ", gsm=" + gsm + ", datecreation=" + datecreation + ", etat=" + etat + '}';
    }

 

  
}
