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
 * @author houssembaazoug
 */
public class AcceuilFXMLController implements Initializable {

    @FXML
    private Button r;
    @FXML
    private Button BaddAdmin;
    @FXML
    private Button BaddClient;
    @FXML
    private Button Baddfree;
    @FXML
    private Button au;
    @FXML
    private Button cu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void g(ActionEvent event) throws MalformedURLException, IOException {
        URL url = new File("src/gui/LoginFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        r.getScene().setRoot(root);
    }

    @FXML
    private void AddAdmin(ActionEvent event) throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("InscriptionAdminFXML.fxml"));
       BaddAdmin.getScene().setRoot(root);
    }

    @FXML
    private void AddClient(ActionEvent event) throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("InscriptionClientFXML.fxml"));
       BaddClient.getScene().setRoot(root);
    }

    @FXML
    private void AddFree(ActionEvent event) throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("InscriptionFreelancerFXML.fxml"));
       Baddfree.getScene().setRoot(root);
    }

    @FXML
    private void Au(ActionEvent event) throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("AboutUsFXML.fxml"));
       au.getScene().setRoot(root);
    }

    @FXML
    private void Cu(ActionEvent event) throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("ContactUsFXML.fxml"));
       cu.getScene().setRoot(root);
    }
    
}
