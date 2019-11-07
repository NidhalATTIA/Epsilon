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
public class Note {
    private int id;
    private int note ;
    private int idClient;
    private int idFreelancer;

    public Note(int note, int idClient, int idFreelancer) {
        this.note = note;
        this.idClient = idClient;
        this.idFreelancer = idFreelancer;
    }
    public Note(int id,int note, int idClient, int idFreelancer) {
        this.id = id;
        this.note = note;
        this.idClient = idClient;
        this.idFreelancer = idFreelancer;
    }
    public int getId(){
    return id;
    }
    public void setId(int id){
    this.id = id;
    }
    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
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

    @Override
    public String toString() {
        return "Note{" + "note=" + note + ", idClient=" + idClient + ", idFreelancer=" + idFreelancer + '}';
    }
    
}    