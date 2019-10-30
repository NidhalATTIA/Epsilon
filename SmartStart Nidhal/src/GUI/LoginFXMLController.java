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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Arzack
 */
public class LoginFXMLController implements Initializable {

    @FXML
    private TextField Email;
    @FXML
    private TextField Password;
    @FXML
    private Text indis;
    @FXML
    private Button Baccueil;
    @FXML
    private Button BcontactUs1;
    @FXML
    private Button BaboutUs1;
    @FXML
    private Button Login;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Authentification(ActionEvent event) throws MalformedURLException, IOException, SQLException {
            
   try {
      
      ServiceAuthentification tache = new ServiceAuthentification();
      Freelancer f1= new Freelancer() ;
      Client c1= new Client() ;
      Admin a1= new Admin() ;
     a1 = tache.rechercheAdminByName_Mdp(Email.getText(),Password.getText());
       c1 = tache.rechercheClientByName_Mdp(Email.getText(),Password.getText());
        f1 = tache.rechercheFreelancerByName_Mdp(Email.getText(),Password.getText());
        if (Email.getText().isEmpty() ) {
            indis.setText("entrez vos donner");
        }
       else if(f1.getMotDePass()== null && c1.getMotdepass()== null && a1.getMotDePass()== null )  {
            indis.setText("error");
        }  
       else if(f1.getMotDePass()!= null && c1.getMotdepass()== null && a1.getMotDePass()== null )  {
          //.reponce.setText("Freelancer");
           ServiceAuthentification.idf=f1.getId();
         
            
         URL url = new File("AcceuilFreelancerFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Login.getScene().setRoot(root);
        
        
        
       }
       
        else if(f1.getMotDePass() == null && c1.getMotdepass()!= null && a1.getMotDePass()== null )  {
     
             
        
            URL url = new File("AcceuilClientFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Login.getScene().setRoot(root);
       //.reponce.setText("Client");
         ServiceAuthentification.idc=c1.getId();
      
       }
        else if(f1.getMotDePass() == null && c1.getMotdepass()== null && a1.getMotDePass()!= null )  {
        
             URL url = new File("C:/Users/Arzack/Documents/GitHub/Epsilon/SmartStart Nidhal/src/GUI/AcceuilAdminFXML.fxml").toURI().toURL();
           Parent root = FXMLLoader.load(url);
           Login.getScene().setRoot(root);
           ServiceAuthentification.ida=a1.getID();
         //.reponce.setText("Admin");
       
       
        }
       
        
          } catch (SQLException ex) {
            Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } ;}

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
        Parent root = FXMLLoader.load(getClass().getResource("/src/GUI/AboutUSFXML.fxml"));
        BaboutUs1.getScene().setRoot(root);
    }

}
