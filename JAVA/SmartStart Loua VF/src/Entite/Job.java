/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author houssembaazoug
 */
public class Job {
   private int ID,id_client,Skill,IdFreelancer;
   private String Titre;
   private String DESCRIPTION ;

    public Job(int ID, String Titre, String DESCRIPTION,int id_client, int Skill, int IdFreelancer ) {
        this.ID = ID;
        this.id_client = id_client;
        this.Skill = Skill;
        this.IdFreelancer = IdFreelancer;
        this.Titre = Titre;
        this.DESCRIPTION = DESCRIPTION;
    }
    public Job (){
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getSkill() {
        return Skill;
    }

    public void setSkill(int Skill) {
        this.Skill = Skill;
    }

    public int getIdFreelancer() {
        return IdFreelancer;
    }

    public void setIdFreelancer(int IdFreelancer) {
        this.IdFreelancer = IdFreelancer;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    @Override
    public String toString() {
        return "Job{" + "ID=" + ID + ", id_client=" + id_client + ", Skill=" + Skill + ", IdFreelancer=" + IdFreelancer + ", Titre=" + Titre + ", DESCRIPTION=" + DESCRIPTION + '}';
    }
   
   
}
