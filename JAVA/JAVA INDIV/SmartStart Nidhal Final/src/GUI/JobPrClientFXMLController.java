/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Client;
import Entite.Freelancer;
import Entite.Job;
import Entite.Skills;
import Service.ServiceAuthentification;
import Service.ServiceClient;
import Service.ServiceFreelancer;
import Service.ServiceJob;
import Service.ServiceSkills;
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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
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
public class JobPrClientFXMLController implements Initializable {

    @FXML
    private Text nomUser;
    @FXML
    private ImageView imageUser;
    @FXML
    private Text titreJob;
    @FXML
    private TextArea Descriptionarea;
    @FXML
    private ImageView picFree;
    @FXML
    private Text NomFr;
    @FXML
    private Text Email;
    Skills sk = new Skills();
    ServiceSkills ssk = new ServiceSkills();
    Image card2=null;
    BufferedImage image2;
    Client a = new Client();
    Client b = new Client();
    ServiceClient sc = new ServiceClient();
    Freelancer f = new Freelancer();
    ServiceJob sj= new ServiceJob();
    ServiceFreelancer sf = new ServiceFreelancer();
    Job j = new Job();
    @FXML
    private Text Skill;
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
            nomUser.setText(a.getNom());
            
            try {
                 image=ImageIO.read(new ByteArrayInputStream(a.getImage()));
                  card= SwingFXUtils.toFXImage(image, null );
            } catch (IOException ex) {
                Logger.getLogger(AcceuilfreelancerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            imageUser.setImage(card);
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilAdminFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            j = sj.recherche(ServiceJob.idjob);
            f= sf.recherche(j.getIdFreelancer());
            sk = ssk.recherche(j.getSkill());
            
        } catch (SQLException ex) {
            Logger.getLogger(JobPrClientFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        titreJob.setText(j.getTitre());
        Descriptionarea.setText(j.getDESCRIPTION());
         try {
                 image2=ImageIO.read(new ByteArrayInputStream(f.getImage()));
                  card2= SwingFXUtils.toFXImage(image2, null );
            } catch (IOException ex) {
                Logger.getLogger(AcceuilfreelancerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            picFree.setImage(card2);
            NomFr.setText(f.getPrenom() +" " +f.getNom());
            Email.setText(f.getEmail());
            Skill.setText(sk.getContenu());
            
    }    

    @FXML
    private void goproffree(MouseEvent event) throws IOException {
       ServiceFreelancer.selectedfr=f.getId();
        URL url = new File("src/gui/FreelancerPrClientFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        picFree.getScene().setRoot(root);
    }
    
}
