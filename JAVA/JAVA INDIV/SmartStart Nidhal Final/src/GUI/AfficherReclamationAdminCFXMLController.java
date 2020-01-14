/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Admin;
import Entite.Reclamation;
import Service.ServiceAdmin;
import Service.ServiceAuthentification;
import Service.ServiceClient;
import Service.ServiceReclamation;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
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
 * @author houssembaazoug
 */
public class AfficherReclamationAdminCFXMLController implements Initializable {

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
    private Button Deletbtn;
    Image card2=null;
    BufferedImage image2;
    Admin a = new Admin();
    ServiceAdmin sa = new ServiceAdmin();
    ServiceClient sc = new ServiceClient();
    ServiceReclamation sr = new ServiceReclamation();
    Reclamation r = new Reclamation();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        BufferedImage image;
        Image card=null;
        try {
            
            a = sa.recherche(ServiceAuthentification.ida);
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
         try {
           r= sr.recherche(Reclamation.idrc);
           System.out.println(r);
        } catch (SQLException ex) {
            Logger.getLogger(ModifReclamationCFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        title.setText(r.getTitre());
        contenu.setText(r.getContenu());
    }    


    @FXML
    private void Delete(ActionEvent event) throws MalformedURLException, IOException, SQLException {
        sr.supprimerReclamation(r.getId());
        URL url = new File("src/gui/AcceuilAdminReclamationFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Deletbtn.getScene().setRoot(root);
    }
    
}
