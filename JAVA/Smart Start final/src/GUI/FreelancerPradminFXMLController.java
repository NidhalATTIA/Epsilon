/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Freelancer;
import Service.ServiceAdmin;
import Service.ServiceAuthentification;
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
public class FreelancerPradminFXMLController implements Initializable {

    @FXML
    private Text nomUser;
    @FXML
    private ImageView imageUser;
    @FXML
    private ImageView imageFP;
    @FXML
    private TextArea DescriptionM;
    @FXML
    private TextArea CVM;
    @FXML
    private Text nomM;
    @FXML
    private Text prenomM;
    @FXML
    private Button Banbtn;
    @FXML
    private Text Emailt;
    Freelancer f = new Freelancer();
    ServiceFreelancer sf = new ServiceFreelancer();
    BufferedImage image;
       Image card=null;
    @FXML
    private ImageView logo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
            f= sf.recherche(ServiceAdmin.idfselected);
            nomM.setText(f.getNom());
            prenomM.setText(f.getPrenom());
            Emailt.setText(f.getEmail());
            CVM.setText(f.getCv());
            DescriptionM.setText(f.getDescription());
            System.out.println(f.getImage());
            try {
                 image=ImageIO.read(new ByteArrayInputStream(f.getImage()));
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
    private void BanAccout(ActionEvent event) throws SQLException, IOException {
          sf.supprimerFree(ServiceAdmin.idfselected);
         URL url = new File("src/gui/AcceuilAdminFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Banbtn.getScene().setRoot(root);
    }

    @FXML
    private void LogoR(MouseEvent event) {
    }

    
}
