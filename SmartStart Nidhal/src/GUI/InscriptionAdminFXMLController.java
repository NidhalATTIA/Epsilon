/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Admin;
import Service.ServiceAdmin;
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
public class InscriptionAdminFXMLController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfMotDePass;
    @FXML
    private TextField tfFonction;
    @FXML
    private TextField tfNationalite;
    @FXML
    private Button Bconnexion;
    @FXML
    private Button BaboutUs;
    @FXML
    private Button BcontactUs;
    @FXML
    private Button BajouterAdmin;
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
    private void AboutUs(ActionEvent event) {
    }

    @FXML
    private void ContactUs(ActionEvent event) {
    }

    @FXML
    private void ajouterAdmin(ActionEvent event) {
            Admin a = new Admin();
        a.setNom(tfNom.getText());
        a.setPrenom(tfPrenom.getText());
        a.setMotdepass(tfMotDePass.getText());
        a.setEmail(tfEmail.getText());
        a.setNationalite(tfNationalite.getText());      
        a.setFonction(tfFonction.getText());
       
        
        ServiceAdmin sp = new ServiceAdmin();
        try {
            sp.ajouterAdmin(a);
        } catch (SQLException ex) {
            Logger.getLogger(InscriptionAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Back(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("AccueilFXML.fxml"));     
        Bback.getScene().setRoot(root1);
    }
    
}
