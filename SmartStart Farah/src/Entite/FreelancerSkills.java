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
public class FreelancerSkills {
    private int id,idFreelancer,skill5;
    
    public FreelancerSkills(){
    
    }
    public FreelancerSkills(int id,int idFreelancer,int skill5){
    this.id=id;
    this.idFreelancer=idFreelancer;

    this.skill5=skill5;
    }
    public int getId(){
    return this.id;
    }
    public void setId(int id){
    this.id=id;
    }
     public int getIdFreelancer(){
    return this.idFreelancer;
    }
    public void setIdFreelancer(int idFreelancer){
    this.idFreelancer=idFreelancer;
    }
     
       public int getSkill5(){
    return this.skill5;
    }
    public void setSkill5(int skill5){
    this.skill5=skill5;
    }
    
    @Override
    public String toString() {
        return "FreelancerSkills{" + "id=" + id + ", idFreelancer=" + idFreelancer + ", Skill=" + skill5 +  '}';
    }
}
