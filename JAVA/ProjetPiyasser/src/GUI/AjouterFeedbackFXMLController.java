/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
    private TextField idFreelancer;

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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        rating.ratingProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> obs, Number old, Number newT) {
                rang.setText("Rating:"+newT);
            }
        });
        } 
        
        
        
        
        
       

    @FXML
    private void ajouterFeedback(ActionEvent event) {
       
      Feedback f1 = new Feedback();
      
      ServiceFeedback service1 = new ServiceFeedback();
        f1.setContenu(contenu.getText());
        
        
        
      //Image img = new Image("src/image/iconV.png");
       Freelancer f = new Freelancer() ;
       try {
           
        f = service1.rechercheFreelancerByemail(idFreelancer.getText());
        if (idFreelancer.getText().isEmpty()) {
            reponce.setText("entrez votre adresse mail");}
        else if(f.getEmail() == null)  {
            reponce.setText("adresse mail intouvable");
        }
            else {
            reponce.setText(" ");
            f1.setFreelancer(f);
            service1.ajouterFeedback(f1);
            Notifications notificationBuilder =Notifications.create()
                    .title("Feedback Ajouter")
                    .text("saved to home")
                    .graphic(null) //new ImageView(img)
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_RIGHT)
                    .onAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println("hello");}
                   });
            notificationBuilder.showConfirm();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AjouterFeedbackFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void back_affichage(ActionEvent event) throws MalformedURLException, IOException {
        
           URL url = new File("C:/Users/Yasser Bel Haj Ali/Documents/NetBeansProjects/ProjetPi/src/GUI1/AfficherfeedbackFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        back.getScene().setRoot(root);
    }
   
   
    
    
}
