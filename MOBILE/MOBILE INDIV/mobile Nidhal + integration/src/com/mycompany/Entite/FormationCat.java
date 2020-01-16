/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

/**
 *
 * @author Loua
 */
public class FormationCat {
    private int id;
    private Freelancer idFreelancer;
    private Formation idFormation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Freelancer getIdFreelancer() {
        return idFreelancer;
    }

    public void setIdFreelancer(Freelancer idFreelancer) {
        this.idFreelancer = idFreelancer;
    }

    public Formation getIdFormation() {
        return idFormation;
    }

    public void setIdFormation(Formation idFormation) {
        this.idFormation = idFormation;
    }

    public FormationCat() {
    }

    public FormationCat(int id, Freelancer idFreelancer, Formation idFormation) {
        this.id = id;
        this.idFreelancer = idFreelancer;
        this.idFormation = idFormation;
    }

    @Override
    public String toString() {
        return "FormationCat{" + "id=" + id + ", idFreelancer=" + idFreelancer + ", idFormation=" + idFormation + '}';
    }
    
    
    
}
