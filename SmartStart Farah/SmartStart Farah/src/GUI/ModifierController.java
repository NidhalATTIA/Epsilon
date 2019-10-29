/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Freelancer;
import Service.ServiceFreelancer;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;



/**
 * FXML Controller class
 *
 * @author LENOVO
 */


public class ModifierController implements Initializable {

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
    private TextField tfID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void ModifierFree(ActionEvent event) {
        Freelancer F = new Freelancer();
        F.setID(Integer.valueOf(tfID.getText()));
        F.setNom(tfNom.getText());
        F.setPrenom(tfPrenom.getText());
        F.setEmail(tfEmail.getText());
        F.setMotDePasse(tfMotDePasse.getText());
        F.setNationalite(tfNationalite.getText());
        F.setCV(tfCV.getText());
        F.setDescription(tfDescription.getText());

        ServiceFreelancer sf = new ServiceFreelancer();
        try {
            sf.ModifierFree(F);
        } catch (SQLException ex) {
            Logger.getLogger(ModifierController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
