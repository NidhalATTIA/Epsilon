/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Freelancer;
import Service.ServiceFreelancer;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AjouterController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfMotDePasse;
    @FXML
    private TextField tfNationalite;
    @FXML
    private TextField tfCV;
    @FXML
    private TextField tfDescription;
    @FXML
    private Button show;



   

    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterFree(ActionEvent event) {
        Freelancer F  = new Freelancer();
        F.setNom(tfNom.getText());
        F.setPrenom(tfPrenom.getText());
        F.setEmail(tfEmail.getText());
        F.setMotDePasse(tfMotDePasse.getText());
        F.setNationalite(tfNationalite.getText());
        F.setCV(tfCV.getText());
        F.setDescription(tfDescription.getText());
        ServiceFreelancer sf = new ServiceFreelancer();
        try {
            sf.AjouterFree(F);
        }
        catch (SQLException ex) {
            Logger.getLogger(AjouterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void GoToAfficher(ActionEvent event) throws MalformedURLException, IOException{
                Parent root = FXMLLoader.load(getClass().getResource("Afficher.fxml"));
        
        show.getScene().setRoot(root);
    }

    
    
}
