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
public class Admin {
    
    
    
    private String Nom ;
    private String Prenom ;
    private String Email ;
    private String MotDePass ;
    private String Nationalite ;
    private String Fonction ;

    public Admin() {
    }

    public Admin(String Nom, String Prenom, String Email, String MotDePass, String Nationalite, String Fonction) {
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Email = Email;
        this.MotDePass = MotDePass;
        this.Nationalite = Nationalite;
        this.Fonction = Fonction;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
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

    public String getFonction() {
        return Fonction;
    }

    public void setFonction(String Fonction) {
        this.Fonction = Fonction;
    }

    @Override
    public String toString() {
        return "Admin{" + "Nom=" + Nom + ", Prenom=" + Prenom + ", Email=" + Email + ", MotDePass=" + MotDePass + ", Nationalite=" + Nationalite + ", Fonction=" + Fonction + '}';
    }
    
    
}
