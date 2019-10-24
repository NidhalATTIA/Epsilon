/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI1;

import GUI3.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 import Service.ServiceFeedback;
import Entite.Freelancer;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;

 
public class FirstFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
                URL url = new File("C:/Users/Yasser Bel Haj Ali/Documents/NetBeansProjects/ProjetPi/src/GUI1/AfficherfeedbackFXML.fxml").toURI().toURL();
               Parent root = FXMLLoader.load(url);
               Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        launch(args);
        
      
       
    }
    
}
