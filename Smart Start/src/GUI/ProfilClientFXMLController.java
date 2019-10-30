/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Admin;
import Entite.Client;
import Service.ServiceAdmin;
import Service.ServiceAuthentification;
import Service.ServiceClient;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author houssembaazoug
 */
public class ProfilClientFXMLController implements Initializable {

    @FXML
    private Text nomUser;
    @FXML
    private ImageView imageUser;
    @FXML
    private ImageView imageFP;
    @FXML
    private TextField EmailM;
    @FXML
    private Text nomM;
    @FXML
    private Text prenomM;
    @FXML
    private Button btnsave;
    @FXML
    private Button deletebtn;
    @FXML
    private Text fonctiontxt;
     final FileChooser fileChooser = new FileChooser();
    int s =0;
    byte[] imagep=null;
    ServiceClient sf = new ServiceClient();
     BufferedImage image;
       Image card=null;
       Client f =new Client();
    @FXML
    private TextArea textDesc;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         try {
            f= sf.recherche(ServiceAuthentification.idc);
            nomM.setText(f.getNom());
            prenomM.setText(f.getPrenom());
            EmailM.setText(f.getEmail());
            fonctiontxt.setText(f.getNom_company());
            textDesc.setText(f.getDescription_company());
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
    private void changePP(MouseEvent event) throws FileNotFoundException, IOException, SQLException {
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")        
                          
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
                    sf.modifierFree(f);
                    try {
                 image=ImageIO.read(new ByteArrayInputStream(f.getImage()));
                  card= SwingFXUtils.toFXImage(image, null );
            } catch (IOException ex) {
                Logger.getLogger(AcceuilfreelancerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            imageFP.setImage(card);
        }
    
    }

    @FXML
    private void saveChanges(ActionEvent event) throws SQLException, MalformedURLException, IOException {
          f.setNom(nomM.getText());
        f.setPrenom(prenomM.getText());
            f.setEmail(EmailM.getText());
            f.setNom_company(fonctiontxt.getText());
            f.setDescription_company(textDesc.getText());
              sf.modifierFree(f);
        URL url = new File("src/gui/ProfilClientFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        btnsave.getScene().setRoot(root);
        
    }

    @FXML
    private void DeleteAccount(ActionEvent event) throws SQLException, MalformedURLException, IOException {
         sf.supprimerFree(f.getId());
         URL url = new File("src/gui/AcceuilFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        deletebtn.getScene().setRoot(root);
    }
    
}
