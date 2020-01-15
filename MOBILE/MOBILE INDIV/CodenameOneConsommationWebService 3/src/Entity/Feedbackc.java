/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Yasser Bel Haj Ali
 */
public class Feedbackc {
    int id;
    String Contenu ;
    User idfreelancer ; 
    User idClient ;
    
    
    
      public Feedbackc() {
    }
    

    public Feedbackc(String Contenu) {
        this.Contenu = Contenu;
    }

    public Feedbackc(int id, String Contenu) {
        this.id = id;
        this.Contenu = Contenu;
    }

    public Feedbackc(String Contenu, User idfreelancer) {
        this.Contenu = Contenu;
        this.idfreelancer = idfreelancer;
        
    }

    public Feedbackc(int id, String Contenu, User idfreelancer, User idClient) {
        this.id = id;
        this.Contenu = Contenu;
        this.idfreelancer = idfreelancer;
        this.idClient = idClient;
    }
    
    

    public String getContenu() {
        return Contenu;
    }

    public void setContenu(String Contenu) {
        this.Contenu = Contenu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getIdfreelancer() {
        return idfreelancer;
    }

    public void setIdfreelancer(User idfreelancer) {
        this.idfreelancer = idfreelancer;
    }

    public User getIdClient() {
        return idClient;
    }

    public void setIdClient(User idClient) {
        this.idClient = idClient;
    }

  
    
    
}
