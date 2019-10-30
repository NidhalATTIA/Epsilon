/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import Service.ServiceAuthentification;
import Entite.Admin;
import Entite.Client;
import Entite.Freelancer;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.text.Text;


/**
 * FXML Controller class
 *
 * @author houssembaazoug
 */
public class LoginFXMLController implements Initializable {

    @FXML
    private TextField Email;
    @FXML
    private TextField Password;
    @FXML
    private Button Login;
    @FXML
    private Text indis;
    @FXML
    private Button Baccueil;
    @FXML
    private Button BcontactUs1;
    @FXML
    private Button BaboutUs1;
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Authentification(ActionEvent event) throws MalformedURLException, IOException, SQLException {
        String e =Email.getText();
        String lien = "";
        String p = Password.getText();
        Client c= null;
        Freelancer f = null;
        Admin a = null;
        ServiceAuthentification sa = new ServiceAuthentification();
        a = sa.rechercheAdminByName_Mdp(e, p);
        if (a.getNom()!= null){lien = "src/GUI/AcceuilAdminFXML.fxml";
        ServiceAuthentification.ida= a.getID();
         URL url = new File(lien).toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Login.getScene().setRoot(root);
        }
        else {
            f = sa.rechercheFreelancerByName_Mdp(e, p);
            if (f.getNom()!= null){
                lien = "src/GUI/AcceuilFreelancerFXML.fxml";
                ServiceAuthentification.idf= f.getId();
                 URL url = new File(lien).toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Login.getScene().setRoot(root);
            }else {
            c =sa.rechercheClientByName_Mdp(e, p);
                if (c.getNom()!= null){
                       lien ="src/GUI/AcceuilClientFXML.fxml";
                       ServiceAuthentification.idc= c.getId();
                        URL url = new File(lien).toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Login.getScene().setRoot(root);
                     }
                else {
                        indis.setText("Wrong Email and password ");
                            }
                 }
        }
        
        
         
        
    }

    @FXML
    private void accueil(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AcceuilFXML.fxml"));
        Baccueil.getScene().setRoot(root);
    }

    @FXML
    private void ContactUs1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ContactUSFXML.fxml"));
        BcontactUs1.getScene().setRoot(root);
    }

    @FXML
    private void AboutUs1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AboutUSFXML.fxml"));
        BaboutUs1.getScene().setRoot(root);
    }
    
}
