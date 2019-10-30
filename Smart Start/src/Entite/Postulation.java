/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author Loua
 */
public class Postulation {
    int ID;
    int idFreelancer;
    int idAnnonce;
    String Contenu;
    public Postulation(){}
    public Postulation(int ID, int idFreelancer, int idAnnonce, String Contenu) {
        this.ID = ID;
        this.idFreelancer = idFreelancer;
        this.idAnnonce = idAnnonce;
        this.Contenu = Contenu;
    }

    public Postulation(int ID, int idFreelancer, int idAnnonce) {
        this.ID = ID;
        this.idFreelancer = idFreelancer;
        this.idAnnonce = idAnnonce;
    }
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIdFreelancer() {
        return idFreelancer;
    }

    public void setIdFreelancer(int idFreelancer) {
        this.idFreelancer = idFreelancer;
    }

    public int getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(int idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    public String getContenu() {
        return Contenu;
    }

    public void setContenu(String Contenu) {
        this.Contenu = Contenu;
    }

    @Override
    public String toString() {
        return "Postulation{" + "ID=" + ID + ", idFreelancer=" + idFreelancer + ", idAnnonce=" + idAnnonce + ", Contenu=" + Contenu + '}';
    }
    
    
    
}
    

