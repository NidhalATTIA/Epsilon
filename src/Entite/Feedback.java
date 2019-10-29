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
    private int idFreelancer;
    private String Contenu ;
    public Feedback() {
        
   
    }

    public Feedback(int id, int idClient, int idFreelancer, String Contenu) {
        this.id = id;
        this.idClient = idClient;
        this.idFreelancer = idFreelancer;
        this.Contenu = Contenu;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdFreelancer() {
        return idFreelancer;
    }

    public void setIdFreelancer(int idFreelancer) {
        this.idFreelancer = idFreelancer;
    }

   

    public String getContenu() {
        return Contenu;
    }

    public void setContenu(String Contenu) {
        this.Contenu = Contenu;
    }

    @Override
    public String toString() {
        return "Feedback{" + "id=" + id + ", idClient=" + idClient + ", idFreelancer=" + idFreelancer + ", Contenu=" + Contenu + '}';
    }



  

}

   