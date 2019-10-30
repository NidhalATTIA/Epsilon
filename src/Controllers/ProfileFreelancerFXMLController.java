/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import ConnexionBD.Connexion;
import Entite.Client;
import Entite.Note;
import Service.ServiceClient;
import Service.ServiceNote;
import com.sun.jmx.snmp.IPAcl.SnmpAcl;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Yasser Bel Haj Ali
 */
public class ProfileFreelancerFXMLController implements Initializable {

    @FXML
    private Button commentaire;
    @FXML
    private ImageView imageview;
    @FXML
    private Button Deconnexion;
    @FXML
    private Button Accueil;
    @FXML
     private BarChart<String, Double> Satisfaction;
    @FXML
    private NumberAxis note;
    @FXML
    private CategoryAxis name;
    private Connection connexion;
    

ServiceClient sc = new ServiceClient();
    /**
     * Initializes the controller class.
     */
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Image image = new Image("/image/iconV.png");
        imageview.setImage(image);
        ServiceNote sn = new ServiceNote();
      
       
        
        
        ResultSet res;
            String query = "Select Nom , note from note n join client c on c.ID=n.idClient";
           XYChart.Series<String,Double> set1 = new XYChart.Series<>();
        
        
        try {
             connexion = Connexion.getInstance().getConnection();
           
            res = connexion.createStatement().executeQuery(query);
            
            
            
            
           while(res.next()){
         set1.getData().add(new XYChart.Data(res.getString(1),res.getDouble(2)));
         System.out.println(set1.toString());
          
         } Satisfaction.getData().add(set1);
           
          } catch (SQLException ex) {
              
        
        }
       

        
        
        
        
        
        
        // TODO
    } 

    @FXML
    private void comme(ActionEvent event) throws IOException {
          URL url = new File("C:/Users/Yasser Bel Haj Ali/Documents/NetBeansProjects/ProjetPi/src/GUI/affichefeedbackduFreelancerFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        commentaire.getScene().setRoot(root); 
        
    }

    @FXML
    private void Deconnexion(ActionEvent event) throws IOException {
           URL url = new File("C:/Users/Yasser Bel Haj Ali/Documents/NetBeansProjects/ProjetPi/src/GUI/AuthentificationFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Deconnexion.getScene().setRoot(root);
    }

    @FXML
    private void Accueil(ActionEvent event) throws IOException {
        URL url = new File("C:/Users/Yasser Bel Haj Ali/Documents/NetBeansProjects/ProjetPi/src/GUI/AccueilClientFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
         Accueil.getScene().setRoot(root);
    }
    
   
    
}
