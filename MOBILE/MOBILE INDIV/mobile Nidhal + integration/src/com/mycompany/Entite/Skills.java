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
public class Skills {
    static  int ID;
    private int id_categorie;
    private String Skill;


    public Skills() {
    }

    public Skills(int ID, int id_categorie, String Skill) {
        this.ID = ID;
        this.id_categorie = id_categorie;
        this.Skill = Skill;

    }

    public static int getID() {
        return ID;
    }

    public static void setID(int ID) {
        Skills.ID = ID;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getSkill() {
        return Skill;
    }

    public void setSkill(String Skill) {
        this.Skill = Skill;
    }

    @Override
    public String toString() {
        return "Skills{" + "id_categorie=" + id_categorie + ", Skill=" + Skill + '}';
    }


    
    
}
