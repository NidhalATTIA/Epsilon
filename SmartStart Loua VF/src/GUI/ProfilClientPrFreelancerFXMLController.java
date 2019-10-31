/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Client;
import Entite.Freelancer;
import Service.ServiceAuthentification;
import Service.ServiceClient;
import Service.ServiceFreelancer;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author houssembaazoug
 */
public class ProfilClientPrFreelancerFXMLController implements Initializable {

    @FXML
    private Text nomUser;
    @FXML
    private ImageView imageUser;
    @FXML
    private ImageView imageFP;
    @FXML
    private Text nomM;
    @FXML
    private Text prenomM;
    @FXML
    private Text fonctiontxt;
    @FXML
    private TextArea textDesc;
    @FXML
    private Button Subscribebtn;
    @FXML
    private Text Emsilc;
    Client c = new Client();
    ServiceClient sc = new ServiceClient();
     BufferedImage image;
       Image card=null;
       Freelancer f = new Freelancer();
       ServiceFreelancer sf = new ServiceFreelancer();
       
    @FXML
    private ImageView logo;
    @FXML
    private Button back;
       
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            c = sc.recherche(ServiceClient.idcli);
            f = sf.recherche(ServiceAuthentification.idf);
       nomM.setText(c.getNom());
            prenomM.setText(c.getPrenom());
            Emsilc.setText(c.getEmail());
            fonctiontxt.setText(c.getNom_company());
            textDesc.setText(c.getDescription_company());
            
            try {
                 image=ImageIO.read(new ByteArrayInputStream(c.getImage()));
                  card= SwingFXUtils.toFXImage(image, null );
            } catch (IOException ex) {
                Logger.getLogger(AcceuilfreelancerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            imageFP.setImage(card);
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilfreelancerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        
    }    

    @FXML
    private void changePP(MouseEvent event) {
    }

    @FXML
    private void Subscribe(ActionEvent event) throws SQLException, IOException {
  
    }

    @FXML
    private void LogoR(MouseEvent event) {
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AnnonceFreelancerAllFXML.fxml"));
       back.getScene().setRoot(root);
    }

    
}
