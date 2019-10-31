/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Freelancer;
import Service.ServiceAuthentification;
import Service.ServiceFreelancer;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author houssembaazoug
 */
public class InscriptionFreelancerFXMLController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfMotDePass;
    @FXML
    private TextField tfCv;
    @FXML
    private TextArea tfDescription;
    @FXML
    private TextField tfNationalite;
    @FXML
    private Button Bconnexion;
    @FXML
    private Button bAboutUs;
    @FXML
    private Button BcontactUS;
    @FXML
    private Button BajouterFreelancer;
    @FXML
    private Button Bback;
       Freelancer f = new Freelancer();
       ServiceFreelancer sf = new ServiceFreelancer();
          final FileChooser fileChooser = new FileChooser();
    byte[] imagep=null;
      Image card=null;
       BufferedImage image;
    @FXML
    private ImageView fAvatar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Connexion(ActionEvent event) {
    }

    @FXML
    private void AboutUs(ActionEvent event) {
    }

    @FXML
    private void ContactUs(ActionEvent event) {
    }

    @FXML
    private void ajouterFreelancer(ActionEvent event) throws IOException {
         f.setNom(tfNom.getText());
        f.setPrenom(tfPrenom.getText());
        f.setMotDePass(tfMotDePass.getText());
        f.setEmail(tfEmail.getText());
        f.setNationalite(tfNationalite.getText());      
        f.setCv(tfCv.getText());
        f.setDescription(tfDescription.getText());
         try {
            sf.ajouterFree(f);
            f= sf.recherche(f.getEmail());
            ServiceAuthentification.idf=f.getId();
        } catch (SQLException ex) {
            Logger.getLogger(InscriptionFreelancerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
         URL url = new File("src/gui/AcceuilfreelancerFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        BajouterFreelancer.getScene().setRoot(root);
         
    }

    @FXML
    private void Back(ActionEvent event) {
    }

    @FXML
    private void addfreeIm(MouseEvent event) throws FileNotFoundException, IOException {
         File file = fileChooser.showOpenDialog(null);
        String filename =file.getAbsolutePath();
        File images= new File(filename);
        FileInputStream fis = new FileInputStream (images);
        ByteArrayOutputStream bis = new ByteArrayOutputStream();
        byte []buf = new byte[1024];
        for (int i;(i=fis.read(buf))!=-1;){
        bis.write(buf, 0, i);
        }
        imagep=bis.toByteArray();
                 if (imagep!=null){
                     System.out.println(imagep);
                     f.setImage(imagep);
                     
                    try {
                 image=ImageIO.read(new ByteArrayInputStream(f.getImage()));
                  card= SwingFXUtils.toFXImage(image, null );
            } catch (IOException ex) {
                Logger.getLogger(AcceuilfreelancerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            fAvatar.setImage(card);
    }
    }
    
}
