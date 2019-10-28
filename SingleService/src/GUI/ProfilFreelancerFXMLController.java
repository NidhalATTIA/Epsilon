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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author houssembaazoug
 */
public class ProfilFreelancerFXMLController implements Initializable {

    @FXML
    private ImageView imageFP;
     Freelancer f  = new Freelancer();
    @FXML
    private TextArea DescriptionM;
    @FXML
    private TextArea CVM;
    @FXML
    private TextField nomM;
    @FXML
    private TextField PrenomM;
    @FXML
    private TextField EmailM;
    final FileChooser fileChooser = new FileChooser();
    int s =0;
    byte[] imagep=null;
    ServiceFreelancer sf = new ServiceFreelancer();
     BufferedImage image;
       Image card=null;
    @FXML
    private Button Skills;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         
      
        try {
            f= sf.recherche(ServiceAuthentification.idf);
            nomM.setText(f.getNom());
            PrenomM.setText(f.getPrenom());
            EmailM.setText(f.getEmail());
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
    private void redirectionskills(ActionEvent event) throws MalformedURLException, IOException {
         URL url = new File("src/gui/SkillsEditFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Skills.getScene().setRoot(root);
    }

}
