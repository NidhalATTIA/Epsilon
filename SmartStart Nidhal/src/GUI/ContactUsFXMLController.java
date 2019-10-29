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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Arzack
 */
public class ContactUsFXMLController implements Initializable {

    @FXML
    private TextField tfmail;
    private Button back1;
    private Button logout4;
    private Button BaboutUs;
    @FXML
    private Button BcontactUs;
    @FXML
    private Button logout3;
    @FXML
    private Button Bprofile;
    @FXML
    private Button Bmaps;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void GoToAccueil1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AccueilFXML.fxml"));
        back1.getScene().setRoot(root);
    }

    private void GoToSignIn4(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
        logout4.getScene().setRoot(root);
    }

    private void AboutUs(ActionEvent event) throws IOException {
               Parent root = FXMLLoader.load(getClass().getResource("AboutUSFXML.fxml"));
       BaboutUs.getScene().setRoot(root);
    }

    @FXML
    private void ContactUs(ActionEvent event) throws IOException {
               Parent root = FXMLLoader.load(getClass().getResource("ContactUSFXML.fxml"));
       BcontactUs.getScene().setRoot(root);
    }

    @FXML
    private void Connexion(ActionEvent event) throws IOException {
                      Parent root = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
       logout3.getScene().setRoot(root);
    }

    @FXML
    private void Profile(ActionEvent event) {
    }

    @FXML
    private void Maps(ActionEvent event) throws IOException {
                       Parent root = FXMLLoader.load(getClass().getResource("C:\\Users\\Arzack\\Documents\\GitHub\\Epsilon\\SmartStart Nidhal\\src\\com\\lynden\\gmapsexampleapp\\com.lynden.gmapsexampleapp.FXML.fxml"));
       Bmaps.getScene().setRoot(root);
    }
}
