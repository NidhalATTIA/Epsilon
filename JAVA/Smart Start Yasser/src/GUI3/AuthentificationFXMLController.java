/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI3;

import Entite.Admin;
import Entite.Client;
import Entite.Freelancer;
import GUI.AjouterFeedbackFXMLController;
import Service.ServiceAuthentification;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Yasser Bel Haj Ali
 */

public class AuthentificationFXMLController implements Initializable {

        @FXML
    private TextField username;

    @FXML
    private TextField userpassword;
    
    @FXML
    private Label reponce;
    @FXML
    private Button entre;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
  
    @FXML
    private void login(ActionEvent event) throws SQLException, MalformedURLException, IOException {
       
   try {
      
      ServiceAuthentification tache = new ServiceAuthentification();
      Freelancer f1= new Freelancer() ;
      Client c1= new Client() ;
      Admin a1= new Admin() ;
     a1 = tache.rechercheAdminByName_Mdp(username.getText(),userpassword.getText());
       c1 = tache.rechercheClientByName_Mdp(username.getText(),userpassword.getText());
        f1 = tache.rechercheFreelancerByName_Mdp(username.getText(),userpassword.getText());
        if (username.getText().isEmpty() ) {
            reponce.setText("entrez vos donner");}
       else if(f1.getMotDePass()== null && c1.getMotDePass()== null && a1.getMotDePass()== null )  {
            reponce.setText("error");
        }  
       else if(f1.getMotDePass()!= null && c1.getMotDePass()== null && a1.getMotDePass()== null )  {
            //.reponce.setText("Freelancer");
   
            
         URL url = new File("C:/Users/Yasser Bel Haj Ali/Documents/NetBeansProjects/ProjetPi/src/GUI5/AccueilFreelancerFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        entre.getScene().setRoot(root);

       }
       
        else if(f1.getMotDePass() == null && c1.getMotDePass() != null && a1.getMotDePass()== null )  {
            URL url = new File("C:/Users/Yasser Bel Haj Ali/Documents/NetBeansProjects/ProjetPi/src/GUI4/AccueilClientFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        entre.getScene().setRoot(root);
       }
        else if(f1.getMotDePass() == null && c1.getMotDePass() == null && a1.getMotDePass()!= null )  {
             URL url = new File("C:/Users/Yasser Bel Haj Ali/Documents/NetBeansProjects/ProjetPi/src/GUI6/AccueilAdminFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        entre.getScene().setRoot(root);
       }
       
        
          } catch (SQLException ex) {
            Logger.getLogger(AuthentificationFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
      