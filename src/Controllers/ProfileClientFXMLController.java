/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entite.Admin;
import Entite.Client;
import Entite.Freelancer;
import Service.ServiceAuthentification;
import Service.ServiceClient;
import java.awt.image.BufferedImage;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Yasser Bel Haj Ali
 */
public class ProfileClientFXMLController implements Initializable {

    @FXML
    private Button deconnexion;
    @FXML
    private Button Accueil;
    @FXML
    private Label name;
    @FXML
    private Label lastname;

    /**
     * Initializes the controller class.
     */
    ServiceClient service = new ServiceClient() ;
    @FXML
    private ImageView photo;
    @FXML
    private Label Nationalite;
    @FXML
    private Label ComanyName;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Client a = new Client () ;
      
        
      
        
        
        
        
        
        try {
            a=service.chercher_connexte(ServiceAuthentification.cli);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileClientFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        a.toString();
        Image card2 = new Image("/image/"+a.getImage());
             name.setText(a.getNom());
         lastname.setText(a.getPrenom());
          photo.setImage(card2);
          Nationalite.setText(a.getNationalite());
          ComanyName.setText(a.getNom_Company());
    }    

    @FXML
    private void Deco(ActionEvent event) throws IOException {
        
        Client a = new Client () ;
      ServiceClient ser = new ServiceClient() ;
       
           
           
      
          URL url = new File("C:/Users/Yasser Bel Haj Ali/Documents/NetBeansProjects/ProjetPi/src/GUI/AuthentificationFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        deconnexion.getScene().setRoot(root); 
    }

    @FXML
    private void Client_Accueil(ActionEvent event) throws IOException {
         URL url = new File("C:/Users/Yasser Bel Haj Ali/Documents/NetBeansProjects/ProjetPi/src/GUI/AccueilClientFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Accueil.getScene().setRoot(root);
    }

 
}
