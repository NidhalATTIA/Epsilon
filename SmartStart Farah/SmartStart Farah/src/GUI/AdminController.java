/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
 * @author LENOVO
 */
public class AdminController implements Initializable {

    @FXML
    private Button AddSkills;
    @FXML
    private Button Go;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void GoToAddSkills(ActionEvent event) throws MalformedURLException, IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AjouterSkills.fxml"));
        
        AddSkills.getScene().setRoot(root);
    }

    @FXML
    private void GoToajouterFreelancer(ActionEvent event) throws MalformedURLException, IOException{
                Parent root = FXMLLoader.load(getClass().getResource("Ajouter.fxml"));
        
        Go.getScene().setRoot(root);
    }

}
