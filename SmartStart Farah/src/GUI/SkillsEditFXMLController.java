/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Freelancer;
import Entite.FreelancerSkills;
import Entite.Skills;
import Service.ServiceAuthentification;

import Service.ServiceFreelancer;
import Service.ServiceSkills;
import Service.ServiceSkillsFreelancer;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javax.imageio.ImageIO;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class SkillsEditFXMLController implements Initializable {

    @FXML
    private Text textnom;
    @FXML
    private ImageView imagep;
    @FXML
    private ListView<Skills> listeSkills;
    @FXML
    private ListView<FreelancerSkills> listeskillsfreelancer;
    @FXML
    private Button addSkill;
    @FXML
    private Button deletebtn;
    
    private final ObservableList<Skills> data= FXCollections.observableArrayList();
    private final ObservableList<FreelancerSkills> data2= FXCollections.observableArrayList();
    Image card2=null;
    BufferedImage image2;
    Freelancer f  = new Freelancer();
    ServiceSkills sff = new ServiceSkills();
    ServiceSkillsFreelancer ssf = new ServiceSkillsFreelancer();
    
    int selected= 0;
    FreelancerSkills selected2 = null;
    FreelancerSkills selected3 =null; 
    FreelancerSkills selected1 = null;
    @FXML
    private TextField count;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

        System.out.println(ServiceAuthentification.idf);
        ServiceFreelancer sf = new ServiceFreelancer();
       BufferedImage image;
       Image card=null;
        try {
            f= sf.recherche(ServiceAuthentification.idf);
            System.out.println(f.getNom());
            textnom.setText(f.getNom());
            
            try {
                 image=ImageIO.read(new ByteArrayInputStream(f.getImage()));
                  card= SwingFXUtils.toFXImage(image, null );
            } catch (IOException ex) {
                Logger.getLogger(SkillsEditFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            imagep.setImage(card);
        } catch (SQLException ex) {
            Logger.getLogger(SkillsEditFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        data.clear();
        try {
            data.addAll(sff.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(SkillsEditFXMLController.class.getName()).log(Level.SEVERE, null, ex);
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
        data2.clear();
        try {
            data2.addAll(ssf.readAll(ServiceAuthentification.idf));
        } catch (SQLException ex) {
            Logger.getLogger(SkillsEditFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        listeskillsfreelancer.setCellFactory(new Callback<ListView<FreelancerSkills>,ListCell<FreelancerSkills>>(){
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
        listeskillsfreelancer.setItems(data2);
        listeSkills.setOnMouseClicked(e->{
         selected= listeSkills.getSelectionModel().getSelectedItem().getId();
         System.out.println(selected);
             try {
                 selected2 = ssf.recherche(selected);
             } catch (SQLException ex) {
                 Logger.getLogger(SkillsEditFXMLController.class.getName()).log(Level.SEVERE, null, ex);
             }
        });
        listeskillsfreelancer.setOnMouseClicked(e->{
         selected2= listeskillsfreelancer.getSelectionModel().getSelectedItem();
         System.out.println(selected2);
        });
    }    

    @FXML
    private void addskill(ActionEvent event) throws SQLException, MalformedURLException, IOException {
        if (selected!=0){
        selected3 = new FreelancerSkills(0,ServiceAuthentification.idf,selected);
        selected1 = ssf.recherche(selected);
        System.out.println(selected1);
        if(selected1==null)
        {
        ssf.ajouterFreelancerSkills(selected3);
        Notifications notificationBuilder;
                 notificationBuilder = Notifications
                .create()
                .title("skill ajouté").text("saved")
                .hideAfter(javafx.util.Duration.seconds(5))
                .position(Pos.BOTTOM_RIGHT);
                 notificationBuilder.show();
        
        
        selected3 = null;
          URL url = new File("src/gui/SkillsEditFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        addSkill.getScene().setRoot(root);
        
        
        }else {System.out.println("existedeja");
        
                 
        
        }
        }
        
       
    }

    @FXML
    private void deleteskill(ActionEvent event) throws MalformedURLException, IOException, SQLException {
        if (selected2!=null){
            ssf.supprimerSkill(selected2.getId());
        URL url = new File("src/gui/SkillsEditFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        deletebtn.getScene().setRoot(root);
        }
    }

    @FXML
    private void count(ActionEvent event) {
    }
    
    
    

    
}
