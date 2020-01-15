/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

//import java.sql.Date;

/**
 *
 * @author Arzack
 */
public class FreelancerSkills {
    private  int ID;
    private int idCategorie;
    private int skill;
    private int idFreelancer;
    private String contenu;

    
    
    
    public FreelancerSkills(int idCategorie, int skill, int idFreelancer, String contenu) {
        this.idCategorie = idCategorie;
        this.skill = skill;
        this.idFreelancer = idFreelancer;
        this.contenu = contenu;
    }


    public FreelancerSkills() {
    }

    public FreelancerSkills(int ID, int idCategorie, int skill, int idFreelancer) {
        this.ID = ID;
        this.idCategorie = idCategorie;
        this.skill = skill;
        this.idFreelancer = idFreelancer;

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

  

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public int getIdFreelancer() {
        return idFreelancer;
    }

    public void setIdFreelancer(int idFreelancer) {
        this.idFreelancer = idFreelancer;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @Override
    public String toString() {
        return "FreelancerSkills{" + "idCategorie=" + idCategorie + ", skill=" + skill + ", idFreelancer=" + idFreelancer + ", contenu=" + contenu + '}';
    }

 

    
    
}
