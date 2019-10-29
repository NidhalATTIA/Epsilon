/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
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
 * @author Arzack
 */
public class AboutUSFXMLController implements Initializable {

    private Button back;
    @FXML
    private Button logout3;
    @FXML
    private Button BaboutUs;
    @FXML
    private Button BcontactUs;
    @FXML
    private Button Baccueil;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void GoToAccueil(ActionEvent event) throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("AccueilFXML.fxml"));
 
        back.getScene().setRoot(root);
    }

    @FXML
    private void GoToSignIn3(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
        logout3.getScene().setRoot(root);
    }

     @FXML
    private void AboutUs(ActionEvent event) throws IOException {
               Parent root = FXMLLoader.load(getClass().getResource("AboutUSFXML.fxml"));
       BaboutUs.getScene().setRoot(root);
    }

    @FXML
    private void ContactUs(ActionEvent event) throws IOException {
               Parent root = FXMLLoader.load(getClass().getResource("ContactUSFXML.fxml"));
       BcontactUs.getScene().setRoot(root);
    }

}
    

