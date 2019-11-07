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
public class Freelancerskills {

    private int ID, idFreelancer, skill1, skill2, skill3, skill4, skill5;

    public Freelancerskills() {
    }

    public Freelancerskills(int ID, int idFreelancer, int skill1, int skill2, int skill3, int skill4, int skill5) {
        this.ID = ID;
        this.idFreelancer = idFreelancer;
        this.skill1 = skill1;
        this.skill2 = skill2;
        this.skill3 = skill3;
        this.skill4 = skill4;
        this.skill5 = skill5;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIdFreelancer() {
        return idFreelancer;
    }

    public void setIdFreelancer(int idFreelancer) {
        this.idFreelancer = idFreelancer;
    }

    public int getSkill1() {
        return skill1;
    }

    public void setSkill1(int skill1) {
        this.skill1 = skill1;
    }

    public int getSkill2() {
        return skill2;
    }

    public void setSkill2(int skill2) {
        this.skill2 = skill2;
    }

    public int getSkill3() {
        return skill3;
    }

    public void setSkill3(int skill3) {
        this.skill3 = skill3;
    }

    public int getSkill4() {
        return skill4;
    }

    public void setSkill4(int skill4) {
        this.skill4 = skill4;
    }

    public int getSkill5() {
        return skill5;
    }

    public void setSkill5(int skill5) {
        this.skill5 = skill5;
    }

    @Override
    public String toString() {
        return "Freelancerskills{" + "ID=" + ID + ", idFreelancer=" + idFreelancer + ", skill1=" + skill1 + ", skill2=" + skill2 + ", skill3=" + skill3 + ", skill4=" + skill4 + ", skill5=" + skill5 + '}';
    }

}
