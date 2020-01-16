/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author LENOVO
 */
public class Categorie {

    private int id;
    private String categorier;

    public Categorie() {
    }

    public Categorie(int id, String categorier) {
        this.id = id;
        this.categorier = categorier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategorier() {
        return categorier;
    }

    public void setCategorier(String categorier) {
        this.categorier = categorier;
    }

    @Override
    public String toString() {
        return "Categorie{" + "id=" + id + ", categorier=" + categorier + '}';
    }
}
