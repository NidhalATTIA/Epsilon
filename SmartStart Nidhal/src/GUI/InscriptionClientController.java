/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Client;
import Service.ServiceClient;
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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Arzack
 */
public class InscriptionClientController implements Initializable {

    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfMotDePasse;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfConfirmer;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfNationalite;
    @FXML
    private TextField tfCompany;
    @FXML
    private TextField tfDescription;
    @FXML
    private Button tfreturn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterClient(ActionEvent event) {
                 Client s = new Client();
        s.setNom(tfNom.getText());
        s.setPrenom(tfPrenom.getText());
        s.setMotdepass(tfMotDePasse.getText());
        s.setEmail(tfEmail.getText());
        s.setNationalite(tfNationalite.getText());      
        s.setNom_company(tfCompany.getText());
        s.setDescription_company(tfDescription.getText());        
        
        ServiceClient sp = new ServiceClient();
        try {
            sp.ajouterClient(s);
        } catch (SQLException ex) {
            Logger.getLogger(InscriptionClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        @FXML
    private void returnhome(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("connexionClient.fxml"));
      
      
          tfreturn.getScene().setRoot(root1);
    }
    
}
