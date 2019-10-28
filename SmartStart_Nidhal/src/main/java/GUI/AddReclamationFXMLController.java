/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Client;
import Entite.Reclamation;
import Service.ServiceAuthentification;
import Service.ServiceClient;
import Service.ServiceReclamation;
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
import javafx.scene.text.Text;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author Arzack
 */
public class AddReclamationFXMLController implements Initializable {

    @FXML
    private Button logoutadmin;
    @FXML
    private ImageView imageA;
    @FXML
    private Text nomAdmin;
    @FXML
    private Button Aboutus;
    @FXML
    private Button Contactus;
    @FXML
    private TextField title;
    @FXML
    private TextArea contenu;
    @FXML
    private Button btnCreate;
    Reclamation r = new Reclamation();
    ServiceReclamation sr = new ServiceReclamation();
    Client a = new Client();
    ServiceClient sc = new ServiceClient();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        BufferedImage image;
        Image card=null;
        try {
            
            a = sc.recherche(ServiceAuthentification.idc);
            nomAdmin.setText(a.getNom());
            
            try {
                 image=ImageIO.read(new ByteArrayInputStream(a.getImage()));
                  card= SwingFXUtils.toFXImage(image, null );
            } catch (IOException ex) {
                Logger.getLogger(AcceuilfreelancerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            imageA.setImage(card);
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilAdminFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

    @FXML
    private void Create(ActionEvent event) throws SQLException, IOException {
        r.setTitre(title.getText());
        r.setContenu(contenu.getText());
        r.setIdclient(ServiceAuthentification.idc);
        sr.ajouterReclamation(r);
        URL url = new File("src/gui/ReclamationClientFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        btnCreate.getScene().setRoot(root);
    }
    
}
