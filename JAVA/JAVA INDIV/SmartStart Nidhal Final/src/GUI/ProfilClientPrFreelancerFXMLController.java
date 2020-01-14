/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Client;
import Entite.Freelancer;
import Entite.Subscription;
import Service.ServiceAuthentification;
import Service.ServiceClient;
import Service.ServiceFreelancer;
import Service.ServiceSubscription;
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
 * @author Arzack
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
       Subscription sb= new Subscription();
       ServiceSubscription ssb = new ServiceSubscription();
    @FXML
    private ImageView logo;
       
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
        try {
            sb = ssb.recherche(f.getId(), c.getId());
        } catch (SQLException ex) {
            Logger.getLogger(ProfilClientPrFreelancerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (sb==null){
           
                Subscribebtn.setText("Subscribe");
          }else {
                Subscribebtn.setText("Unsubscribe");
               
                }   
        
    }    

    @FXML
    private void changePP(MouseEvent event) {
    }

    @FXML
    private void Subscribe(ActionEvent event) throws SQLException, IOException {
     if (sb==null){
                      
            Subscription sb2 = new Subscription(0,c.getId(),f.getId());
            
            ssb.ajouterFreelancerSkills(sb2);
             URL url = new File("src/gui/AfficherClientPrFreelancerFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Subscribebtn.getScene().setRoot(root);
          }else {
               
                ssb.supprimerSkill(sb.getID());
                 URL url = new File("src/gui/AfficherClientPrFreelancerFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Subscribebtn.getScene().setRoot(root);
                }   
    }

    @FXML
    private void Logo(MouseEvent event) throws IOException {
       Parent root3 = FXMLLoader.load(getClass().getResource("AcceuilfreelancerFXML.fxml"));
       logo.getScene().setRoot(root3);
    }

    
}
