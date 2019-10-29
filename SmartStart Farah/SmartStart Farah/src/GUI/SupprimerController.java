/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Freelancer;
import Service.ServiceFreelancer;
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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class SupprimerController implements Initializable {

    @FXML
    private TextField tfID;
    @FXML
    private Button Back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SupprimerFree(ActionEvent event) {
           Freelancer F = new Freelancer();
        F.setID(Integer.valueOf(tfID.getText()));
        
        ServiceFreelancer sf = new ServiceFreelancer();
        try {
            sf.SupprimerFree(F.getID());
        } catch (SQLException ex) {
            Logger.getLogger(SupprimerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void BackToAfficher(ActionEvent event)  throws MalformedURLException, IOException{
        
       Parent root = FXMLLoader.load(getClass().getResource("Afficher.fxml"));
        Back.getScene().setRoot(root);
    } 
}
