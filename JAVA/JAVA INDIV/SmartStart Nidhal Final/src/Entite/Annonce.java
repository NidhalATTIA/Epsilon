/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author Arzack
 */
public class Annonce implements Comparable<Annonce>{

   private int ID,id_client,Skills;
   private String Titre;
   private String DESCRIPTION ;

    public Annonce(int ID,  String Titre, String DESCRIPTION,int id_client,int Skills) {
        this.ID = ID;
        this.id_client = id_client;
        this.Titre = Titre;
        this.Skills = Skills;
        this.DESCRIPTION = DESCRIPTION;
    }

    public Annonce(int ID) {
        this.ID = ID;
    }

  

    public Annonce(int ID, int id_client) {
        this.ID = ID;
        this.id_client = id_client;
    }

    public Annonce(String Titre, int Skills, String DESCRIPTION) {
        this.Titre = Titre;
        this.Skills = Skills;
        this.DESCRIPTION = DESCRIPTION;
    }

    public Annonce(int id_client, String Titre, int Skills, String DESCRIPTION) {
        this.id_client = id_client;
        this.Titre = Titre;
        this.Skills = Skills;
        this.DESCRIPTION = DESCRIPTION;
    }

    public Annonce(int ID, String Titre, String DESCRIPTION) {
        this.ID = ID;
        this.Titre = Titre;
        this.DESCRIPTION = DESCRIPTION;
    }

  
    

    public Annonce() {
    }

    public int getID() {
        return ID;
    }

    public int getId_client() {
        return id_client;
    }

    public String getTitre() {
        return Titre;
    }

    public int getSkills() {
        return Skills;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    public void setSkills(int Skills) {
        this.Skills = Skills;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    @Override
    public String toString() {
        return "Annonce{" + "ID=" + ID + ", id_client=" + id_client + ", Titre=" + Titre + ", Skills=" + Skills + ", DESCRIPTION=" + DESCRIPTION + '}';
    }
    @Override
    public int compareTo(Annonce emp) {
  //trions les employés selon leur age dans l'ordre croiddant
  //retroune un entier négative, zéro ou positive si l'age 
  //de cet employé est moins que, égale à ou supérieur à l'objet comparé avec
        return (this.ID - emp.ID);
 }
   
   
   
    
   
}
