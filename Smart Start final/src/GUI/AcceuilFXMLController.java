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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author houssembaazoug
 */
public class AcceuilFXMLController implements Initializable {

    @FXML
    private Button r;
    @FXML
    private Button btnadmini;
    @FXML
    private Button btnClient;
    @FXML
    private Button freelancerbtn;
    @FXML
    private ImageView logo;

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
    private void inscriadmin(ActionEvent event) throws IOException {
         URL url = new File("src/gui/InscriptionAdminFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        btnadmini.getScene().setRoot(root);
    }

    @FXML
    private void Addclient(ActionEvent event) throws IOException {
          URL url = new File("src/gui/InscriptionClientFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        btnClient.getScene().setRoot(root);
    }

    @FXML
    private void FreelancerAction(ActionEvent event) throws IOException {
        URL url = new File("src/gui/InscriptionFreelancerFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        btnClient.getScene().setRoot(root);
    }

    @FXML
    private void LogoR(MouseEvent event) {
    }
    
}
