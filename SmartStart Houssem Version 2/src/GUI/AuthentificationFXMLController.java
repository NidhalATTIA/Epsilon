/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.ServiceClient;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author MED HOUSSEM KAFFEL
 */
public class AuthentificationFXMLController implements Initializable {

    @FXML
    private Button aboutus1;
    @FXML
    private Button contactus1;
    @FXML
    private TextField tfemail;
    @FXML
    private TextField tfpwd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void GoToAboutus1(ActionEvent event) {
    }

    @FXML
    private void GoToAContactus1(ActionEvent event) {
    }

    @FXML
    private void Login(ActionEvent event) throws IOException {
                ServiceClient us = new ServiceClient();
       if( us.login(tfemail.getText(),tfpwd.getText())==true)
       { 
            
            //JOptionPane.showMessageDialog(null, "Welcome !");
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("AfficherAnnonce.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            //This line gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();
       }
       else{JOptionPane.showMessageDialog(null, "Invalid Email or Password.");}
             

    }
    
}
