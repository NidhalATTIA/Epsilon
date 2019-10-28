/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author Arzack
 */
public class Freelancer {
    
    private int id ;
    private String nom ;
    private String prenom ;
    private String email ;
    private String nationalite ;
    private String cv ;
    private String motDePass ;
    

    public Freelancer() {
    }

    public Freelancer(int id, String nom, String prenom, String email, String nationalite, String cv, String motDePass) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.nationalite = nationalite;
        this.cv = cv;
        this.motDePass = motDePass;
        
    }

    public Freelancer(int aInt, String string, String string0, String string1, String string2, String string3, String string4, String string5, byte[] bytes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getMotDePass() {
        return motDePass;
    }

    public void setMotDePass(String motDePass) {
        this.motDePass = motDePass;
    }

 
    @Override
    public String toString() {
        return "Freelancer{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", nationalite=" + nationalite + ", cv=" + cv + ", motDePass=" + motDePass +  '}';
    }

    public void getId(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getDescription() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public byte[] getImage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setMotdepass(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
