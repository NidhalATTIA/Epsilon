/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.File;
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
public class AcceuilFXMLController implements Initializable {

    @FXML
    private Button r;
    @FXML
    private Button BajouterFreelancer;
    @FXML
    private Button BajouterClient;
    @FXML
    private Button BajouterAdmin;
    @FXML
    private Button BaboutUs; 
    @FXML
    private Button BcontactUs;   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void g(ActionEvent event) throws IOException {
        URL url = new File("src/gui/LoginFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
        r.getScene().setRoot(root);
    }

    @FXML
    private void addClient(ActionEvent event) throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("InscriptionClientFXML.fxml"));
        BajouterClient.getScene().setRoot(root);
    }

    @FXML
    private void addFreelancer(ActionEvent event) throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("InscriptionFreelancerFXML.fxml"));
       BajouterFreelancer.getScene().setRoot(root);
    }

    @FXML
    private void addAdmin(ActionEvent event) throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("InscriptionAdminFXML.fxml"));
        BajouterAdmin.getScene().setRoot(root);   
    }

    @FXML
    private void AboutUs(ActionEvent event) {
    }

    @FXML
    private void ContactUs(ActionEvent event) {
    }
    
    
}
