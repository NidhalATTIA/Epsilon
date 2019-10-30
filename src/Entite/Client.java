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
public class Client {
    
    private int id ;
    private String nom ;
    private String prenom ;
    private String email ;
    private String nationalite ;
    private String nom_Company ;
    private String motDePass ;
    private String description_Company;
    private int etat ;
    private String Image;

    public Client() {
    }

    public Client(int id, String nom, String prenom, String email, String nationalite, String nom_Company, String motDePass, String description_Company, int etat, String Image) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.nationalite = nationalite;
        this.nom_Company = nom_Company;
        this.motDePass = motDePass;
        this.description_Company = description_Company;
        this.etat = etat;
        this.Image = Image;
    }

   

    public Client(int id, String nom, String prenom, String email,int etat) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
          this.etat = etat;
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

    public String getNom_Company() {
        return nom_Company;
    }

    public void setNom_Company(String nom_Company) {
        this.nom_Company = nom_Company;
    }

    public String getMotDePass() {
        return motDePass;
    }

    public void setMotDePass(String motDePass) {
        this.motDePass = motDePass;
    }

    public String getDescription_Company() {
        return description_Company;
    }

    public void setDescription_Company(String description_Company) {
        this.description_Company = description_Company;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }
    

    public Client(int id, String nom, String prenom, String email, String nationalite, String nom_Company, String motDePass, String description_Company, int etat) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.nationalite = nationalite;
        this.nom_Company = nom_Company;
        this.motDePass = motDePass;
        this.description_Company = description_Company;
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", nationalite=" + nationalite + ", nom_Company=" + nom_Company + ", motDePass=" + motDePass + ", description_Company=" + description_Company + ", etat=" + etat + ", Image=" + Image + '}';
    }

   


  

    
}
