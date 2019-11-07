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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

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
    @FXML
    private ImageView logo;
    @FXML
    private Text textAdvertisment;
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
        if (title.getText().length()> 50){textAdvertisment.setText("Your title is over 50 characters ");}else{
        s.setTitre(title.getText());
        if (content.getText().length()> 300){
        textAdvertisment.setText("Your title is over 300 characters ");
        }else {s.setContenu(content.getText());
        ssf.ajouterSujet_forum(s);
         URL url = new File("src/gui/AcceuilForumFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        buttonaddS.getScene().setRoot(root);
        
        }}
        
          
    }

    @FXML
    private void LogoR(MouseEvent event) throws IOException {
         URL url = new File("src/gui/AcceuilfreelancerFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        logo.getScene().setRoot(root);
    }
    
}
