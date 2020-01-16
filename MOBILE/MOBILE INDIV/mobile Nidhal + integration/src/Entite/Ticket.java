/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class Ticket {

    private int id;
    private String offre;
    private String service;
    private Categorie categorie;
    private String motifreclamation;
    private String image;

    public Ticket() {
    }

    public Ticket(int id, String offre, String service, Categorie categorie, String motifreclamation, String image) {
        this.id = id;
        this.offre = offre;
        this.service = service;
        this.categorie = categorie;
        this.motifreclamation = motifreclamation;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOffre() {
        return offre;
    }

    public void setOffre(String offre) {
        this.offre = offre;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public String getMotifreclamation() {
        return motifreclamation;
    }

    public void setMotifReclamation(String motifReclamation) {
        this.motifreclamation = motifReclamation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Ticket{" + "id=" + id + ", offre=" + offre + ", service=" + service + ", categorie=" + categorie + ", motifreclamation=" + motifreclamation + ", image=" + image + '}';
    }

    

   





  
    
}
