/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Client;
import Entite.Freelancer;
import Entite.FreelancerSkills;
import Entite.Skills;
import Service.ServiceAuthentification;
import Service.ServiceClient;
import Service.ServiceFreelancer;
import Service.ServiceSkills;
import Service.ServiceSkillsFreelancer;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author houssembaazoug
 */
public class FreelancerPrClientFXMLController implements Initializable {

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
    private TextField EmailM;
    @FXML
    private ListView<FreelancerSkills> Skills;
    private final ObservableList<FreelancerSkills> data2= FXCollections.observableArrayList();
    @FXML
    private Text nomM;
    @FXML
    private Text prenomM;
    Freelancer f = new Freelancer();
    ServiceFreelancer sf = new ServiceFreelancer ();
    ServiceClient sc = new ServiceClient();
    ServiceSkillsFreelancer ssf= new ServiceSkillsFreelancer();
    ServiceSkills sff = new ServiceSkills();
    Client c = new Client();
    Image card2=null;
    BufferedImage image2;
    @FXML
    private Button FeedBack;
    @FXML
    private ImageView logo;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         BufferedImage image;
        Image card=null;
        try {
            
            c = sc.recherche(ServiceAuthentification.idc);
            f= sf.recherche(ServiceFreelancer.selectedfr);
            nomUser.setText(c.getNom());
            
            try {
                 image=ImageIO.read(new ByteArrayInputStream(c.getImage()));
                  card= SwingFXUtils.toFXImage(image, null );
            } catch (IOException ex) {
                Logger.getLogger(AcceuilfreelancerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            imageUser.setImage(card);
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilAdminFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        nomM.setText(f.getNom());
        prenomM.setText(f.getPrenom());
        DescriptionM.setText(f.getDescription());
        CVM.setText(f.getCv());
        EmailM.setText(f.getEmail());
         try {
                 image2=ImageIO.read(new ByteArrayInputStream(f.getImage()));
                  card2= SwingFXUtils.toFXImage(image2, null );
            } catch (IOException ex) {
                Logger.getLogger(AcceuilfreelancerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            imageFP.setImage(card2);
          data2.clear();
        try {
            data2.addAll(ssf.readAll(f.getId()));
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilfreelancerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Skills.setCellFactory(new Callback<ListView<FreelancerSkills>,ListCell<FreelancerSkills>>(){
            @Override
            public ListCell<FreelancerSkills> call(ListView<FreelancerSkills> param) {
               ListCell<FreelancerSkills> res = new ListCell<FreelancerSkills>(){
               @Override
               protected void updateItem(FreelancerSkills free, boolean bln){
               super.updateItem(free, bln);
               
               if (free!=null){
                    StackPane st=new StackPane();
                   Skills s= new Skills();
                   try {
                       s=sff.recherche(free.getSkill5());
                   } catch (SQLException ex) {
                       Logger.getLogger(SkillsEditFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   
                  
                  Text name_txt=new Text();
                  name_txt.setFill(Color.RED);
                  name_txt.setFont(Font.font("castellar",FontWeight.BOLD,18));
                  name_txt.setText(s.getContenu());
                 
                  StackPane.setAlignment(name_txt, Pos.TOP_CENTER);
                  StackPane.setMargin(name_txt,new Insets(15,0,0,5));
                  
                  st.getChildren().addAll(name_txt);
                  setGraphic(st);
       
               }
               }
               };
                
                return res;
                
            }
        });
        Skills.setItems(data2);
    }    

    @FXML
    private void changePP(MouseEvent event) {
    }

    @FXML
    private void Feedback(ActionEvent event) throws IOException {
        ServiceFreelancer.selectedfr=f.getId();
        URL url = new File("src/gui/FeedbackClientFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        FeedBack.getScene().setRoot(root);
    }

    @FXML
    private void LogoR(MouseEvent event) throws IOException {
         URL url = new File("src/gui/AcceuilClientFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        logo.getScene().setRoot(root);
    }

    
}
