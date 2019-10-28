/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Freelancer;
import Entite.Sujet_forum;
import Service.ServiceAuthentification;
import Service.ServiceFreelancer;
import Service.ServiceSujet_forum;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author houssembaazoug
 */
public class AddSubjectFFXMLController implements Initializable {

    @FXML
    private Button buttonaddS;
    @FXML
    private TextArea content;
    @FXML
    private TextField title;
    Freelancer f = new Freelancer();
    ServiceSujet_forum ssf = new ServiceSujet_forum();
    ServiceFreelancer sf = new ServiceFreelancer();
    Sujet_forum s= new Sujet_forum();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            f= sf.recherche(ServiceAuthentification.idf);
        } catch (SQLException ex) {
            Logger.getLogger(AddSubjectFFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void AddS(ActionEvent event) throws SQLException, MalformedURLException, IOException {
        s.setIdFreelancer(f.getId());
        s.setTitre(title.getText());
        s.setContenu(content.getText());
        ssf.ajouterSujet_forum(s);
           URL url = new File("src/gui/LoginFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        buttonaddS.getScene().setRoot(root);
    }
    
}
