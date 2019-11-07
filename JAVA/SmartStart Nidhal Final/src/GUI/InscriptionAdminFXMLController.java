/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Admin;
import Service.ServiceAdmin;
import Service.ServiceAuthentification;
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
public class InscriptionAdminFXMLController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfMotDePass;
    @FXML
    private TextField tfFonction;
    @FXML
    private TextField tfNationalite;
    @FXML
    private Button Bconnexion;
    @FXML
    private Button BaboutUs;
    @FXML
    private Button BcontactUs;
    @FXML
    private Button BajouterAdmin;
    @FXML
    private Button back;
    @FXML
    private ImageView Bavatar;
    
    Admin a = new Admin();
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
    private void ajouterAdmin(ActionEvent event) throws IOException {
        a.setNom(tfNom.getText());
        a.setPrenom(tfPrenom.getText());
        a.setMotDePass(tfMotDePass.getText());
        a.setEmail(tfEmail.getText());
        a.setNationalite(tfNationalite.getText());      
        a.setFonction(tfFonction.getText());
       
        
        ServiceAdmin sp = new ServiceAdmin();
        try {
            sp.ajouterAdmin(a);
            a =sp.recherche(a.getEmail());
            ServiceAuthentification.ida=a.getID();
        } catch (SQLException ex) {
            Logger.getLogger(InscriptionAdminFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Parent root5 = FXMLLoader.load(getClass().getResource("AcceuilFXML.fxml"));     
        BajouterAdmin.getScene().setRoot(root5);
        
    }
    
    @FXML
    private void Connexion(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));     
        Bconnexion.getScene().setRoot(root1);
    }

   @FXML
    private void AboutUs(ActionEvent event) throws IOException {
               Parent root2 = FXMLLoader.load(getClass().getResource("AboutUSFXML.fxml"));
       BaboutUs.getScene().setRoot(root2);
    }

    @FXML
    private void ContactUs(ActionEvent event) throws IOException {
               Parent root3 = FXMLLoader.load(getClass().getResource("ContactUSFXML.fxml"));
       BcontactUs.getScene().setRoot(root3);
    }

    @FXML
    private void Back(ActionEvent event) throws IOException {
        Parent root4 = FXMLLoader.load(getClass().getResource("AcceuilFXML.fxml"));     
        back.getScene().setRoot(root4);
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
                     a.setFonction(imagep);
                    try {
                 image=ImageIO.read(new ByteArrayInputStream(a.getImage()));
                  card= SwingFXUtils.toFXImage(image, null );
            } catch (IOException ex) {
                Logger.getLogger(AcceuilFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Bavatar.setImage(card);
    }
    
    }
}
