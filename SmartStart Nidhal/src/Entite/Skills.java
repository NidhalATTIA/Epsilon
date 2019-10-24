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
public class Skills {

    private int ID;
    private String Skill;

    public Skills() {

    }

    @Override
    public String toString() {
        return "Skills{" + "ID=" + ID + ", Skill=" + Skill + '}';
    }

    public Skills(int ID, String Skill) {
        this.ID = ID;
        this.Skill = Skill;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSkill() {
        return Skill;
    }

    public void setSkill(String Skill) {
        this.Skill = Skill;
    }

}
