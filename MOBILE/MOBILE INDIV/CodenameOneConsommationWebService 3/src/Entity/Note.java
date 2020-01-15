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
public class Note {
    
    public int note ;
    public int id ;
    public User idFreelancer ;
    public User idClient;

    public Note() {
    }

    public Note(int note, int id, User idFreelancer, User idClient) {
        this.note = note;
        this.id = id;
        this.idFreelancer = idFreelancer;
        this.idClient = idClient;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getIdFreelancer() {
        return idFreelancer;
    }

    public void setIdFreelancer(User idFreelancer) {
        this.idFreelancer = idFreelancer;
    }

    public User getIdClient() {
        return idClient;
    }

    public void setIdClient(User idClient) {
        this.idClient = idClient;
    }

    @Override
    public String toString() {
        return "Note{" + "note=" + note + ", id=" + id + ", idFreelancer=" + idFreelancer + ", idClient=" + idClient + '}';
    }
            
    
    
    
}
