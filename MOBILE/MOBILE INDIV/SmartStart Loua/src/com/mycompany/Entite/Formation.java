/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

//import java.sql.Date;

/**
 *
 * @author Loua
 */
public class Formation {
    private int id;
    private fos_user idClient;
    private CategorieFormation idCategorieF;
    private String Titre;
    private String description;
    private String lieu;
    private int prix;
    private int nbParticipants;
    private String dateDebut;
    private String dateFin;
    
 
    
    public Formation() {
    }

    public Formation(int id, fos_user idClient, CategorieFormation idCategorieF, String Titre, String description, String lieu, int prix, int nbParticipants) {
        this.id = id;
        this.idClient = idClient;
        this.idCategorieF = idCategorieF;
        this.Titre = Titre;
        this.description = description;
        this.lieu = lieu;
        this.prix = prix;
        this.nbParticipants = nbParticipants;
    }

    public Formation(int id, fos_user idClient, CategorieFormation idCategorieF, String Titre, String description, String lieu, int prix, int nbParticipants, String dateDebut, String dateFin) {
        this.id = id;
        this.idClient = idClient;
        this.idCategorieF = idCategorieF;
        this.Titre = Titre;
        this.description = description;
        this.lieu = lieu;
        this.prix = prix;
        this.nbParticipants = nbParticipants;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public fos_user getIdClient() {
        return idClient;
    }

    public void setIdClient(fos_user idClient) {
        this.idClient = idClient;
    }

    public CategorieFormation getIdCategorieF() {
        return idCategorieF;
    }

    public void setIdCategorieF(CategorieFormation idCategorieF) {
        this.idCategorieF = idCategorieF;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getNbParticipants() {
        return nbParticipants;
    }

    public void setNbParticipants(int nbParticipants) {
        this.nbParticipants = nbParticipants;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public String toString() {
        return "Formation{" + "id=" + id + ", idClient=" + idClient + ", idCategorieF=" + idCategorieF + ", Titre=" + Titre + ", description=" + description + ", lieu=" + lieu + ", prix=" + prix + ", nbParticipants=" + nbParticipants + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + '}';
    }

 
    
    

    
}
