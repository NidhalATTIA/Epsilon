/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import Service.ServiceAuthentification;
import Entite.Freelancer;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.text.Text;


/**
 * FXML Controller class
 *
 * @author houssembaazoug
 */
public class LoginFXMLController implements Initializable {

    @FXML
    private TextField Email;
    @FXML
    private TextField Password;
    @FXML
    private Button Login;
    @FXML
    private Text indis;
  
           

           
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Authentification(ActionEvent event) throws MalformedURLException, IOException, SQLException {
        String e =Email.getText();
        String lien = "";
        String p = Password.getText();
       
        Freelancer f = null;
   ServiceAuthentification sa = new ServiceAuthentification();
     
      
             f = sa.rechercheFreelancerByName_Mdp(e, p);
            if (f.getNom()!= null){
                  lien = "src/GUI/AcceuilfreelancerFXML.fxml";
                ServiceAuthentification.idf= f.getId();
                 URL url = new File(lien).toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Login.getScene().setRoot(root);
           
        }
    }}
        
        
     
    

