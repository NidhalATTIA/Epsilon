/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Freelancer;
import Service.ServiceFreelancer;
import Service.ServiceAuthentification;
import static Service.ServiceSujet_forum.s;
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
import javafx.scene.control.Label;
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
 * @author Arzack
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
    private TextField tfNationalite;
    @FXML
    private Button Bconnexion;
    @FXML
    private Button BcontactUS;
    @FXML
    private Button BajouterFreelancer;
    @FXML
    private Button Bback;
    @FXML
    private TextArea tfDescription;
    @FXML
    private Button bAboutUs;
    @FXML
    private ImageView Bavatar;

    
    Freelancer f = new Freelancer();
    Image card=null;
    BufferedImage image;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
       
        
        ServiceFreelancer sp = new ServiceFreelancer();
        try {
            sp.ajouterFree(f);
        } catch (SQLException ex) {
            Logger.getLogger(InscriptionFreelancerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Parent root5 = FXMLLoader.load(getClass().getResource("AcceuilFXML.fxml"));     
        BajouterFreelancer.getScene().setRoot(root5);
    }
    
    @FXML
    private void Connexion(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));     
        Bconnexion.getScene().setRoot(root1);
    }

   @FXML
    private void AboutUs(ActionEvent event) throws IOException {
               Parent root = FXMLLoader.load(getClass().getResource("AboutUSFXML.fxml"));
       bAboutUs.getScene().setRoot(root);
    }

    @FXML
    private void ContactUs(ActionEvent event) throws IOException {
               Parent root = FXMLLoader.load(getClass().getResource("ContactUSFXML.fxml"));
       BcontactUS.getScene().setRoot(root);
    }

    @FXML
    private void Back(ActionEvent event) throws IOException {
               Parent root = FXMLLoader.load(getClass().getResource("AcceuilFXML.fxml"));
       BcontactUS.getScene().setRoot(root);
        Bback.getScene().setRoot(root);
    }

//imagep def
    
final FileChooser fileChooser = new FileChooser();
byte[] imagep=null;


    @FXML
    private void Avatar(MouseEvent event) throws FileNotFoundException, IOException {
        final FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
 //             new FileChooser.ExtensionFilter("JPG", ".jpg"),
   //             new FileChooser.ExtensionFilter("PNG", ".png")

        );
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
                Logger.getLogger(AcceuilFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Bavatar.setImage(card);
    }
    }
    
}
    
