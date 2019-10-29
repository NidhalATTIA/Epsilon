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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Arzack
 */
public class InscriptionFreelancerFXMLController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfMotDePass;
    @FXML
    private TextField tfCv;
    @FXML
    private TextField tfNationalite;
    @FXML
    private Button Bconnexion;
    @FXML
    private Button BaboutUs;
    @FXML
    private Button BcontactUS;
    @FXML
    private Button BajouterFreelancer;
    @FXML
    private Button Bback;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Connexion(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));     
        Bconnexion.getScene().setRoot(root1);
    }

   @FXML
    private void AboutUs(ActionEvent event) throws IOException {
               Parent root = FXMLLoader.load(getClass().getResource("AboutUSFXML.fxml"));
       BaboutUs.getScene().setRoot(root);
    }

    @FXML
    private void ContactUs(ActionEvent event) throws IOException {
               Parent root = FXMLLoader.load(getClass().getResource("ContactUSFXML.fxml"));
       BcontactUS.getScene().setRoot(root);
    }

    @FXML
    private void ajouterFreelancer(ActionEvent event) {
            Freelancer f = new Freelancer();
        f.setNom(tfNom.getText());
        f.setPrenom(tfPrenom.getText());
        f.setMotdepass(tfMotDePass.getText());
        f.setEmail(tfEmail.getText());
        f.setNationalite(tfNationalite.getText());      
        f.setCv(tfCv.getText());
       
        
        ServiceFreelancer sp = new ServiceFreelancer();
        try {
            sp.ajouterFree(f);
        } catch (SQLException ex) {
            Logger.getLogger(InscriptionFreelancerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Back(ActionEvent event) throws IOException {
               Parent root = FXMLLoader.load(getClass().getResource("AccueilFXML.fxml"));
       BcontactUS.getScene().setRoot(root);
        Bback.getScene().setRoot(root);
    }
    
}
    
