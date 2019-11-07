/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * 
 */
public class Free {

    private int ID;
    private String Nom, Prenom, MotDePasse, Email, Nationalite, CV,Description;

    public Free(int ID, String Nom, String Prenom, String MotDePasse, String Email, String Nationalite, String CV, String Description) {
        this.ID = ID;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.MotDePasse = MotDePasse;
        this.Email = Email;
        this.Nationalite = Nationalite;
        this.CV = CV;
        this.Description = Description;
    }

    public Free() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public String getMotDePasse() {
        return MotDePasse;
    }

    public void setMotDePasse(String MotDePasse) {
        this.MotDePasse = MotDePasse;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
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

    @Override
    public String toString() {
        return "Free{" + "ID=" + ID + ", Nom=" + Nom + ", Prenom=" + Prenom + ", MotDePasse=" + MotDePasse + ", Email=" + Email + ", Nationalite=" + Nationalite + ", CV=" + CV + ", Description=" + Description + '}';
    }




   
   
   
   
    
   
}
