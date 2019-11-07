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
    private String descriptionComany;

    public Client() {
    }

    public Client(int id, String nom, String prenom, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
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

    public String getDescriptionComany() {
        return descriptionComany;
    }

    public void setDescriptionComany(String descriptionComany) {
        this.descriptionComany = descriptionComany;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", nationalite=" + nationalite + ", nom_Company=" + nom_Company + ", motDePass=" + motDePass + ", descriptionComany=" + descriptionComany + '}';
    }

    public void getId(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    
}
