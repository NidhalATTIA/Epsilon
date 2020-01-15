/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Yasser Bel Haj Ali
 */
public class User {
    
    int id ;
    String username ;
    String email ;
    String Typeuser;
    String Password;
    

    public User() {
    }

    public User(int id, String username, String email, String Typeuser) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.Typeuser = Typeuser;
    }

    public User(int id, String username, String email, String Typeuser, String Password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.Typeuser = Typeuser;
        this.Password = Password;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeuser() {
        return Typeuser;
    }

    public void setTypeuser(String Typeuser) {
        this.Typeuser = Typeuser;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    
}
