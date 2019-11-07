/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Admin;
import Entite.Freelancer;
import Entite.Skills;
import Service.ServiceAdmin;
import Service.ServiceAuthentification;
import Service.ServiceSkills;
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
public class modifierOrSupprimerSkillsFXMLController implements Initializable {

    @FXML
    private Text nomAd;
    @FXML
    private ImageView imageAd;
    @FXML
    private TextField skillText;
    @FXML
    private Button btnadds;
    @FXML
    private ListView<Skills> listeSkills;
    private final ObservableList<Skills> data= FXCollections.observableArrayList();
    Image card2=null;
    BufferedImage image2;
    Admin a = new Admin();
    ServiceAdmin sa = new ServiceAdmin();
    Freelancer f = new Freelancer();
    ServiceSkills sf = new ServiceSkills();
    Skills seleced = null;
    @FXML
    private Button delbtn;
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
            
            a = sa.recherche(ServiceAuthentification.ida);
            nomAd.setText(a.getNom());
            
            try {
                 image=ImageIO.read(new ByteArrayInputStream(a.getImage()));
                  card= SwingFXUtils.toFXImage(image, null );
            } catch (IOException ex) {
                Logger.getLogger(AcceuilfreelancerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            imageAd.setImage(card);
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilAdminFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        data.clear();
        try {
            data.addAll(sf.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilfreelancerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        listeSkills.setCellFactory(new Callback<ListView<Skills>,ListCell<Skills>>(){
            @Override
            public ListCell<Skills> call(ListView<Skills> param) {
               ListCell<Skills> res = new ListCell<Skills>(){
               @Override
               protected void updateItem(Skills free, boolean bln){
               super.updateItem(free, bln);
               if (free!=null){
                    StackPane st=new StackPane();
                       
                  
               
                  
                  Text name_txt=new Text();
                  name_txt.setFill(Color.RED);
                  name_txt.setFont(Font.font("castellar",FontWeight.BOLD,18));
                  name_txt.setText(free.getContenu());
                 
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
        listeSkills.setItems(data);
        
        try {
            seleced = sf.recherche(Skills.idSelected);
        } catch (SQLException ex) {
            Logger.getLogger(modifierOrSupprimerSkillsFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        skillText.setText(seleced.getContenu());
    }    

    @FXML
    private void modifierSkill(ActionEvent event) throws SQLException, MalformedURLException, IOException {
        seleced.setContenu(skillText.getText());
        System.out.println(Skills.idSelected);
        sf.modifierSkill(seleced);
         URL url = new File("src/gui/AddSkillsFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        btnadds.getScene().setRoot(root);
        
    }

    @FXML
    private void DeleteS(ActionEvent event) throws MalformedURLException, IOException, SQLException {
        
        sf.supprimerSkill(Skills.idSelected);
         URL url = new File("src/gui/AddSkillsFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        delbtn.getScene().setRoot(root);
        
    }

    @FXML
    private void LogoR(MouseEvent event) throws IOException {
         URL url = new File("src/gui/AcceuilAdminFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        logo.getScene().setRoot(root);
    }
    
}
