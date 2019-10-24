/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author arzack
 */
public class AccueilClientFXMLController implements Initializable {

    @FXML
    private Button profile;
    @FXML
    private Button deconnexion;
    @FXML
    private Button feed;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void profile_client(ActionEvent event) throws MalformedURLException, IOException {
         URL url = new File("C:/Users/Yasser Bel Haj Ali/Documents/NetBeansProjects/ProjetPi/src/GUI7/ProfileClientFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        profile.getScene().setRoot(root); 
    }

    @FXML
    private void deco_client(ActionEvent event) throws IOException {
       URL url = new File("C:/Users/Yasser Bel Haj Ali/Documents/NetBeansProjects/ProjetPi/src/GUI3/AuthentificationFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        deconnexion.getScene().setRoot(root); 
    }

    @FXML
    private void feedback(ActionEvent event) throws MalformedURLException, IOException {
         URL url = new File("C:/Users/Yasser Bel Haj Ali/Documents/NetBeansProjects/ProjetPi/src/GUI1/AfficherfeedbackFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        feed.getScene().setRoot(root); 
    }
    
}
