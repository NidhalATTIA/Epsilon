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
    private Client client;
    private Freelancer freelancer;
    private String Contenu ;
    public Feedback() {
        
   
    }

    public Feedback(int id, Client client, Freelancer freelancer, String Contenu) {
        this.id = id;
        this.client = client;
        this.freelancer = freelancer;
        this.Contenu = Contenu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Freelancer getFreelancer() {
        return freelancer;
    }

    public void setFreelancer(Freelancer freelancer) {
        this.freelancer = freelancer;
    }

    public String getContenu() {
        return Contenu;
    }

    public void setContenu(String Contenu) {
        this.Contenu = Contenu;
    }

    @Override
    public String toString() {
        return "Feedback{" + "id=" + id + ", client=" + client + ", freelancer=" + freelancer + ", Contenu=" + Contenu + '}';
    }

  

   
}

   