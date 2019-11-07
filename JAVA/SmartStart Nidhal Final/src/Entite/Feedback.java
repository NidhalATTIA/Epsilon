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
public class Feedback {
    private int id ; 
    private int idClient;
    private int idfreelancer;
    private String Contenu ;
    public Feedback() {
        
   
    }

    public Feedback(int id, int idclient, int idfreelancer, String Contenu) {
        this.id = id;
        this.idClient = idclient;
        this.idfreelancer = idfreelancer;
        this.Contenu = Contenu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClient() {
        return idClient;
    }

    public void setClient(int client) {
        this.idClient = client;
    }

    public int getidFreelancer() {
        return idfreelancer;
    }

    public void setFreelancer(int idfreelancer) {
        this.idfreelancer = idfreelancer;
    }

    public String getContenu() {
        return Contenu;
    }

    public void setContenu(String Contenu) {
        this.Contenu = Contenu;
    }

    @Override
    public String toString() {
        return "Feedback{" + "id=" + id + ", client=" + idClient + ", freelancer=" + idfreelancer + ", Contenu=" + Contenu + '}';
    }

  

   
}