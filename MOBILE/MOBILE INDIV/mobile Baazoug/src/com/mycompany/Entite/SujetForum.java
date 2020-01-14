/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

import java.util.Map;

/**
 *
 * @author houssembaazoug
 */
public class SujetForum {
      private int id;
  
    private String titre,contenu;
   
     
    public static int idsf;
    public SujetForum() {
    }

    public SujetForum(int id, String titre, String contenu) {
        this.id =id;
      
        this.titre = titre;
        this.contenu= contenu;
    }

    public SujetForum(Map<String, Object> idFreelancer) {
      
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   

   

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
   

   
    
    @Override
    public String toString() {
        return "Sujet_forum{" + "id=" + id + ", Titre=" + titre + ", Contenu="+ contenu+'}';
    }
}
