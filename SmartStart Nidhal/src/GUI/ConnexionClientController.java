/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Client;
import Service.ServiceAuthentificationC;
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
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Arzack
 */
public class ConnexionClientController implements Initializable {

        @FXML
    private Button tfinscription;

    @FXML
    private TextArea tfLogin;
    
    @FXML
    private PasswordField tfPassword;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
  
    @FXML
    private void connexionClient(ActionEvent event) 
    {
         /*      
   try {
      
      connexionClient tache = new connexionClient();
      Client c1= new Client() ;
       c1 = tache.rechercheClientByName_Mdp(username.getText(),userpassword.getText());
        if (username.getText().isEmpty() ) {
            reponce.setText("Entrez vos données");}
       else if(c1.getMotDePass()== null && c1.getMotDePass()== null && c1.getMotDePass()== null )  {
            reponce.setText("error");
        }  
        else reponce.setText("valide");
          } catch (SQLException ex) {
            Logger.getLogger(ConnexionClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        */
        
        
    }
    
            @FXML
    public void inscriptionClient (ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("inscriptionClient.fxml"));
      
      
          tfinscription.getScene().setRoot(root1);
    }
}
    

