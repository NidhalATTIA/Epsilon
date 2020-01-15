/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

//import java.sql.Date;

/**
 *
 * @author Arzack
 */
public class Categorie_Skills {
    static  int id_categorie;
    private String categorie;


    public Categorie_Skills() {
    }

    public Categorie_Skills(int id_categorie, String categorie) {
        this.id_categorie = id_categorie;
        this.categorie = categorie;

    }

    public static int getId_categorie() {
        return id_categorie;
    }

    public static void setId_categorie(int id_categorie) {
        Categorie_Skills.id_categorie = id_categorie;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Categorie_Skills{" + "categorie=" + categorie + '}';
    }

    
    
    
}
