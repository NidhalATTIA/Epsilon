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
public class Freelancer {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String MotDePass;
    private String Nationalite; 
    private String CV; 
    private String Description; 
    private String ImageFreelancer;
    private String Date_inscri;

    public Freelancer() {
    }

    public Freelancer(int id, String nom, String prenom, String email, String MotDePass, String Nationalite, String CV, String Description, String ImageFreelancer, String Date_inscri) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.MotDePass = MotDePass;
        this.Nationalite = Nationalite;
        this.CV = CV;
        this.Description = Description;
        this.ImageFreelancer = ImageFreelancer;
        this.Date_inscri = Date_inscri;
    }

    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePass() {
        return MotDePass;
    }

    public void setMotDePass(String MotDePass) {
        this.MotDePass = MotDePass;
    }

    public String getNationalite() {
        return Nationalite;
    }

    public void setNationalite(String Nationalite) {
        this.Nationalite = Nationalite;
    }

    public String getCV() {
        return CV;
    }

    public void setCV(String CV) {
        this.CV = CV;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getImageFreelancer() {
        return ImageFreelancer;
    }

    public void setImageFreelancer(String ImageFreelancer) {
        this.ImageFreelancer = ImageFreelancer;
    }

    public String getDate_inscri() {
        return Date_inscri;
    }

    public void setDate_inscri(String Date_inscri) {
        this.Date_inscri = Date_inscri;
    }

    @Override
    public String toString() {
        return "Freelancer{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", MotDePass=" + MotDePass + ", Nationalite=" + Nationalite + ", CV=" + CV + ", Description=" + Description + ", ImageFreelancer=" + ImageFreelancer + ", Date_inscri=" + Date_inscri + '}';
    }
    
    
    
    
}
