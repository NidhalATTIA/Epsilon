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
public class Commentaire {
    
 private int id,idFreelancer, idSujet;
    private String contenu;

    public Commentaire() {
    }

    public Commentaire(int id,int idSujet,int idFreelancer, String contenu) {
        this.id =id;
        this.idFreelancer = idFreelancer;
        this.idSujet = idSujet;
        this.contenu= contenu;
    }

    public Commentaire(int idFreelancer) {
        this.idFreelancer = idFreelancer;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
     public int getIdFreelancer() {
        return idFreelancer;
    }

    public void setIdFreelancer(int idFreelancer) {
        this.idFreelancer = idFreelancer;
    }

    public int getidSujet() {
        return idSujet;
    }

    public void setidSujet(int idSujet) {
        this.idSujet = idSujet;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "id=" + id + ", idSujet=" + idSujet + ", IdFreelancer=" + idFreelancer + ", Contenu="+ contenu+'}';
    }
    
}

