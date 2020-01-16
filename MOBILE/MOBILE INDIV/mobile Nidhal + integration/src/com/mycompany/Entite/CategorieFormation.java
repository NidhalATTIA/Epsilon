/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

/**
 *
 * @author Loua
 */
public class CategorieFormation {
    private int id;
    private String categorief;

    public CategorieFormation() {
    }
    
    

    public CategorieFormation(int id, String categorief) {
        this.id = id;
        this.categorief = categorief;
    }

    public String getCategorief() {
        return categorief;
    }

    public void setCategorief(String categorief) {
        this.categorief = categorief;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CategorieFormation{" + "id=" + id + ", categorief=" + categorief + '}';
    }
    
    
    
}
