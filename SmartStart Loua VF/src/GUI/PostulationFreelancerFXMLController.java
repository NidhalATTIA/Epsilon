/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Annonce;
import Entite.Client;
import Entite.Freelancer;
import Entite.Postulation;
import Entite.Skills;
import Service.ServiceAnnonce;
import Service.ServiceAuthentification;
import Service.ServiceClient;
import Service.ServiceFreelancer;
import Service.ServiceJob;
import Service.ServicePostulation;
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
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author houssembaazoug
 */
public class PostulationFreelancerFXMLController implements Initializable {

    @FXML
    private Text nomUser;
    @FXML
    private ImageView imageUser;
    @FXML
    private TextArea Descriptiontext;
    @FXML
    private TextField titletext;
    @FXML
    private Button btnSubmit;
    ServiceFreelancer sf = new ServiceFreelancer();
    Freelancer f = new Freelancer();
    ServiceAnnonce sa = new ServiceAnnonce();
    Annonce a = new Annonce();
    ServicePostulation sp =new ServicePostulation(); 
    Postulation p = new Postulation();
    Postulation p2 = new Postulation();
    Client c = new Client();
    ServiceClient sc = new ServiceClient();
    @FXML
    private TextArea textposs;
    @FXML
    private ImageView imageClient;
    @FXML
    private Text textclientup;
    @FXML
    private Text Skill;
    ServiceSkills ss = new ServiceSkills();
    Skills s=new Skills();
     BufferedImage image2;
       Image card2=null;
       int idclient ;
    @FXML
    private Button btnDelete;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
           
            a= sa.recherche(ServiceAnnonce.idan);
            c= sc.recherche(a.getId_client());
            s= ss.recherche(a.getSkills());
        } catch (SQLException ex) {
            Logger.getLogger(PostulationFreelancerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
       ServiceJob sj = new ServiceJob();
       BufferedImage image;
       Image card=null;
        try {
            
            f= sf.recherche(ServiceAuthentification.idf);
            System.out.println(f.getNom());
            nomUser.setText(f.getNom());
            
            try {
                 image2=ImageIO.read(new ByteArrayInputStream(c.getImage()));
                 image=ImageIO.read(new ByteArrayInputStream(f.getImage()));
                  card= SwingFXUtils.toFXImage(image, null );
                   card2= SwingFXUtils.toFXImage(image2, null );
            } catch (IOException ex) {
                Logger.getLogger(AcceuilfreelancerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            imageUser.setImage(card);
            imageClient.setImage(card2);
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilfreelancerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        textclientup.setText(c.getNom_company());
        Descriptiontext.setText(a.getDESCRIPTION());
        titletext.setText(a.getTitre());
        Skill.setText(s.getContenu());
        try {
            p = sp.recherche(ServiceAuthentification.idf, a.getID());
        } catch (SQLException ex) {
            Logger.getLogger(PostulationFreelancerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (p!= null){
        textposs.setText(p.getContenu());
        p.setIdAnnonce(a.getID());
        p.setIdFreelancer(f.getId());
        btnSubmit.setText("Edit Submition");
        }
        
    }    

    @FXML
    private void submitapp(ActionEvent event) throws SQLException, IOException {
        p = sp.recherche(ServiceAuthentification.idf, a.getID());
       
        if (p == null){
        
            if (textposs.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Attention ! il faut remplir ce champs !");}
            else{
            p2.setIdAnnonce(a.getID());
            p2.setIdFreelancer(f.getId());
        
            p2.setContenu(textposs.getText());

            sp.ajouterPostulation(p2);}}
       
        else {
            if (textposs.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Attention ! il faut remplir ce champs !");}
            else{
            p.setContenu(textposs.getText());
            sp.modifierPostulation(p);
            }
        
        }
        URL url = new File("src/gui/AcceuilFreelancerFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        btnSubmit.getScene().setRoot(root);
        
    }

    @FXML
    private void goprofilClient(MouseEvent event) throws IOException {
        ServiceClient.idcli=c.getId();
         URL url = new File("src/gui/AfficherClientPrFreelancerFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        btnSubmit.getScene().setRoot(root);
    }

    @FXML
    private void deleteapp(ActionEvent event) {
        
    }
    
}
