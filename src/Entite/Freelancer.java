/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author Yasser Bel Haj Ali
 */
public class Freelancer {
    private int id ;
    private String nom ;
    private String prenom ;
    private String email ;
    private String nationalite ;
    private String cv ;
    private String motDePass ;
    private String Image ; 
    

    public Freelancer() {
    }

    public Freelancer(int id, String nom, String prenom, String email, String nationalite, String cv, String motDePass, String Image) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.nationalite = nationalite;
        this.cv = cv;
        this.motDePass = motDePass;
        this.Image = Image;
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

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    @Override
    public String toString() {
        return "Freelancer{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", nationalite=" + nationalite + ", cv=" + cv + ", motDePass=" + motDePass + ", Image=" + Image + '}';
    }
    

 
 

    public void getId(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
