/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI1;


import Entite.Client;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import Entite.Feedback;
import Entite.Freelancer;
import Service.ServiceFeedback;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;

   
/**
 * FXML Controller class
 *
 * @author Yasser Bel Haj Ali
 */
public class AfficherfeedbackFXMLController implements Initializable {

    @FXML
    private TableView<Feedback> table;
    @FXML
    private TableColumn<Feedback, Integer > idClient;
    @FXML
    private TableColumn<Feedback, Integer> idfreelancer;
    @FXML
    private TableColumn<Feedback, String > review;
    
    ObservableList<Feedback> data =FXCollections.observableArrayList();
      List<Feedback> feedback = new ArrayList<>();
    @FXML
    private Button ajouter;
      
     
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
         ServiceFeedback service1 = new ServiceFeedback();
        try {
            feedback = service1.readAll();
          
            data.addAll(feedback);
           
            
            
         idClient.setCellValueFactory(new PropertyValueFactory<Feedback,Integer>("id"));
         idfreelancer.setCellValueFactory(new PropertyValueFactory<Feedback,Integer>("id"));
         review.setCellValueFactory(new PropertyValueFactory<Feedback,String>("Contenu"));
         table.setItems(data);
         
         
         } catch (SQLException ex) {
            Logger.getLogger(AfficherfeedbackFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }    

    @FXML
    private void GO_add(ActionEvent event) throws IOException {
        URL url = new File("C:/Users/Yasser Bel Haj Ali/Documents/NetBeansProjects/ProjetPi/src/GUI/FXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        ajouter.getScene().setRoot(root);

        
        
    }
    
}
