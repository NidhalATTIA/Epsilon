/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entities;

/**
 *
 * @author Arzack
 */
public class Skills {
    private int id,idFreelancer, idSujet;
    private String contenu;

    public Skills() {
    }

    public Skills(int id,int idSujet,int idFreelancer, String contenu) {
        this.id =id;
        this.idFreelancer = idFreelancer;
        this.idSujet = idSujet;
        this.contenu= contenu;
    }

    public Skills(int idFreelancer) {
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
