/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entite.Client;
import Entite.Feedback;
import Controllers.afficheFeedbackFreelancerFXML;
import Service.ServiceAuthentification;
import Service.ServiceClient;
import Service.ServiceFeedback;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Yasser Bel Haj Ali
 */
public class ModifierFeedbackFXMLController implements Initializable {

    @FXML
    private TextArea modifcontenu;
    @FXML
    private Button send;
    @FXML
    private Button accueil;
      Feedback f = new Feedback();
    @FXML
    private Button Suprimer;
    /**
     * Initializes the controller class.
     */
    ServiceFeedback sf = new ServiceFeedback();
    @FXML
    private Button Deconnexion;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      afficheFeedbackFreelancerFXML feed = new afficheFeedbackFreelancerFXML();
      
        f = feed.fstat;
        modifcontenu.setText(f.getContenu());
        // TODO
        
    }    

    @FXML
    private void Modifie(ActionEvent event) throws SQLException, MalformedURLException, IOException {
        f.setContenu(modifcontenu.getText());
        
        sf.modifierFeedback(f);
        URL url = new File("C:/Users/Yasser Bel Haj Ali/Documents/NetBeansProjects/ProjetPi/src/GUI/affichefeedbackduFreelancerFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        send.getScene().setRoot(root);
                
                
           
    }

    @FXML
    private void accueil(ActionEvent event) throws IOException {
        URL url = new File("C:/Users/Yasser Bel Haj Ali/Documents/NetBeansProjects/ProjetPi/src/GUI/AccueilClientFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        accueil.getScene().setRoot(root);
    }

    @FXML
    private void Suprimer(ActionEvent event) throws MalformedURLException, IOException, SQLException {
        
        sf.supprimerFeedback(f.getId());
        
        URL url = new File("C:/Users/Yasser Bel Haj Ali/Documents/NetBeansProjects/ProjetPi/src/GUI/affichefeedbackduFreelancerFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Suprimer.getScene().setRoot(root);
    }

    @FXML
    private void Deconnexion(ActionEvent event) throws IOException {
         URL url = new File("C:/Users/Yasser Bel Haj Ali/Documents/NetBeansProjects/ProjetPi/src/GUI/AuthentificationFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Deconnexion.getScene().setRoot(root); 
    }
    
}
