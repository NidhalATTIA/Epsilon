/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author houssembaazoug
 */
public class Skills {
    private int id;
    private String contenu;
    public static int idSelected;
    public Skills() {
        
    }

    public Skills(int id,String contenu) {
        this.id =id;
        this.contenu= contenu;
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "id=" + id +  ", Contenu="+ contenu+'}';
    }
}

