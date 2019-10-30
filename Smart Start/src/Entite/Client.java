/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author houssembaazoug
 */
public class Client {
    private int ID;
    private String Nom, Prenom, Email, Nationalite, Nom_company, MotDePass, Description_company;
    byte[]image;

    public Client() 
    {
        
    }

    public Client(int id, String nom, String prenom, String email, String nationalite, String nom_company, String motdepass, String description_company, byte[] image) {
        this.ID = id;
        this.Nom = nom;
        this.Prenom = prenom;
        this.Email = email;
        this.Nationalite = nationalite;
        this.Nom_company = nom_company;
        this.MotDePass = motdepass;
        this.Description_company = description_company;
        this.image= image;
    }




    public int getId() {
        return ID;
    }

    public void setId(int id) {
        this.ID = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        this.Nom= nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        this.Prenom = prenom;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getNationalite() {
        return Nationalite;
    }

    public void setNationalite(String nationalite) {
        this.Nationalite = nationalite;
    }

    public String getNom_company() {
        return Nom_company;
    }

    public void setNom_company(String nom_company) {
        this.Nom_company = nom_company;
    }

    public String getMotdepass() {
        return MotDePass;
    }

    public void setMotdepass(String motdepass) {
        this.MotDePass = motdepass;
    }

    public String getDescription_company() {
        return Description_company;
    }

    public void setDescription_company(String description_company) {
        this.Description_company = description_company;
    }
    public byte[] getImage() {
        return image;
    }

    public void setDescription_company(byte[] image) {
        this.image = image;
    }
    
    @Override
    public String toString() {
        return "Client{" + "id=" + ID + ", nom=" + Nom + ", prenom=" + Prenom + ", email=" + Email + ", nationalite=" + Nationalite + ", nom_company=" + Nom_company + ", motdepass=" + MotDePass + ", description_company=" + Description_company + '}';
    }

    
}
