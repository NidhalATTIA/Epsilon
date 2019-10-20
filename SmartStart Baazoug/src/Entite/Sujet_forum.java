/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;


public class Sujet_forum {
    private int id,idFreelancer;
    private String titre,contenu;

    public Sujet_forum() {
    }

    public Sujet_forum(int id,int idFreelancer, String titre, String contenu) {
        this.id =id;
        this.idFreelancer = idFreelancer;
        this.titre = titre;
        this.contenu= contenu;
    }

    public Sujet_forum(int idFreelancer) {
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

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @Override
    public String toString() {
        return "Sujet_forum{" + "id=" + id + ", idFreelancer=" + idFreelancer + ", Titre=" + titre + ", Contenu="+ contenu+'}';
    }
    
}
