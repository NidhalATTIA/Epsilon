/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;


public class Reclamation {
    
  private int id,idFreelancer, idClient;
    private String contenu, titre;

    public Reclamation() {
    }

    public Reclamation(int id,String titre,String contenu,int idFreelancer,int idClient) {
        this.id =id;
        this.idFreelancer = idFreelancer;
        this.idClient = idClient;
        this.titre = titre;
        this.contenu= contenu;
    }
    public Reclamation(String titre,String contenu,int idFreelancer,int idClient) {
        
        this.idFreelancer = idFreelancer;
        this.idClient = idClient;
        this.titre = titre;
        this.contenu= contenu;
    }

    public Reclamation(int idFreelancer) {
        this.idFreelancer = idFreelancer;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
     public int getIdFreelancer() {
        return idFreelancer;
    }

    public void setIdFreelancer(int idFreelancer) {
        this.idFreelancer = idFreelancer;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdclient(int idClient) {
        this.idClient = idClient;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
     public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", Titre="+ titre+", Contenu="+ contenu+ ", idFreelancer=" + idFreelancer + ", IdClient=" + idClient + '}';
    }
    
}
