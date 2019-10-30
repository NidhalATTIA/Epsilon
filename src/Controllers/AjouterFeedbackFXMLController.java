/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entite.Note;
import Entite.Client;
import Entite.Feedback;
import Service.ServiceFeedback;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import Entite.Freelancer;
import Controllers.afficheFeedbackFreelancerFXML;
import Service.ServiceAuthentification;
import Service.ServiceClient;
import Service.ServiceNote;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.Rating;




/**
 * FXML Controller class
 *
 *
 */
public class AjouterFeedbackFXMLController implements Initializable {

   
   

    @FXML
    private TextArea contenu;

    @FXML
    private Label reponce;
    @FXML
    private Button back;
    @FXML
    private Rating rating;
    @FXML
    private Label rang;

    /**
     * Initializes the controller class.
     */
    Feedback f = new Feedback();
    Client c =new Client();
    
    ServiceFeedback service1 = new ServiceFeedback();
    ServiceClient sc = new ServiceClient();
    ServiceNote sn = new ServiceNote();
    Note note = new Note();
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        
       
        // TODO
       
        rating.ratingProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> obs, Number old, Number newT) {
                rang.setText("Rating:"+newT);
                
                
                note.setNote(newT.intValue());
                note.setIdClient(ServiceAuthentification.cli);
                note.toString();
         
             
                   try {
                    sn. ajouterNote(note);
                } catch (SQLException ex) {
                    Logger.getLogger(AjouterFeedbackFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
     
               
                
              
              
            }
        });
        } 
        
        
        
        
          
       
       
       

    @FXML
    private void ajouterFeedback(ActionEvent event) throws IOException {
        
      
      //Image img = new Image("src/image/iconV.png");
   
       try {
        
           
       
        if (contenu.getText().isEmpty()) {
            reponce.setText("entrez votre Feedback");}
            else {
            
            
            afficheFeedbackFreelancerFXML feed = new afficheFeedbackFreelancerFXML();
               f = feed.fstat; 

           f.setContenu(contenu.getText());
           f.setIdClient(ServiceAuthentification.cli);
            reponce.setText("");
            service1.ajouterFeedback(f);
             Image image = new Image("/image/iconV.png");

            Notifications notificationBuilder =Notifications.create()
                    .title("Feedback Ajouter")
                    .text("saved to home")
                    .graphic(new ImageView(image)) 
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_RIGHT)
                    .onAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println("hello");}
                   });
            notificationBuilder.showConfirm();
            }
        URL url = new File("C:/Users/Yasser Bel Haj Ali/Documents/NetBeansProjects/ProjetPi/src/GUI/affichefeedbackduFreelancerFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        back.getScene().setRoot(root);
        } catch (SQLException ex) {
            Logger.getLogger(AjouterFeedbackFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void back_affichage(ActionEvent event) throws MalformedURLException, IOException {
        
           URL url = new File("C:/Users/Yasser Bel Haj Ali/Documents/NetBeansProjects/ProjetPi/src/GUI/affichefeedbackduFreelancerFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        back.getScene().setRoot(root);
    }
   
   
    
    
}

