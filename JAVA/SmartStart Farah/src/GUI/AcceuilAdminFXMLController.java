/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import Entite.Admin;
import Entite.Freelancer;
import GUI.LoginFXMLController;
import Service.ServiceAdmin;
import Service.ServiceAuthentification;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import Service.ServiceAuthentification;
import Service.ServiceFreelancer;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
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
 * @author LENOVO
 */
public class AcceuilAdminFXMLController implements Initializable {

    @FXML
    private ImageView imageA;
    @FXML
    private Button logoutadmin;
    @FXML
    private Button Aboutus;
    @FXML
    private Button Contactus;
    @FXML
    private Button btnFreelancers;
    @FXML
    private Button btnClients;
    @FXML
    private Button btnSkills;
    @FXML
    private Button Complaints;
    @FXML
    private ListView<Freelancer> ListePra;
    private final ObservableList<Freelancer> data= FXCollections.observableArrayList();
    Image card2=null;
    BufferedImage image2;
    Admin a = new Admin();
    ServiceAdmin sa = new ServiceAdmin();
    Freelancer f = new Freelancer();
    ServiceFreelancer sf = new ServiceFreelancer();
    @FXML
    private Text nomAdmin;
    @FXML
    private Button Complaintsfree;
    
    
  
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        BufferedImage image;
        Image card=null;
        try {
            
            a = sa.recherche(ServiceAuthentification.ida);
            nomAdmin.setText(a.getNom());
            
            try {
                 image=ImageIO.read(new ByteArrayInputStream(a.getImage()));
                  card= SwingFXUtils.toFXImage(image, null );
            } catch (IOException ex) {
                Logger.getLogger(AcceuilAdminFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            imageA.setImage(card);
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilAdminFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        data.clear();
        try {
            data.addAll(sf.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilAdminFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ListePra.setCellFactory(new Callback<ListView<Freelancer>,ListCell<Freelancer>>(){
            @Override
            public ListCell<Freelancer> call(ListView<Freelancer> param) {
               ListCell<Freelancer> res = new ListCell<Freelancer>(){
               @Override
               protected void updateItem(Freelancer free, boolean bln){
               super.updateItem(free, bln);
               if (free!=null){
                    StackPane st=new StackPane();
                    StackPane stack_pane=new StackPane();
                   try {
                       image2=ImageIO.read(new ByteArrayInputStream(free.getImage()));
                   } catch (IOException ex) {
                       Logger.getLogger(AcceuilAdminFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                   }
                  card2= SwingFXUtils.toFXImage(image2, null );
                  ImageView imvi= new ImageView(card2);
                  imvi.setFitHeight(64);
                  imvi.setFitWidth(64);
                  imvi.setSmooth(true);
                  stack_pane.setMaxWidth(64);
                  stack_pane.setMaxHeight(64);
                  stack_pane.setId("image_pane");
                  stack_pane.getChildren().add(imvi);
                  Text status_txt=new Text();
                  status_txt.setFill(Color.RED);
                  status_txt.setFont(Font.font("arial",15));
                  status_txt.setWrappingWidth(500);
                  status_txt.setText(free.getNom());
                  Text name_txt=new Text();
                  name_txt.setFill(Color.DEEPSKYBLUE);
                  Reflection ref=new Reflection();
                  ref.setFraction(0.8);
                  ref.setTopOffset(0.5);
                  name_txt.setEffect(ref);
                  name_txt.setFont(Font.font("castellar",FontWeight.BOLD,18));
                  name_txt.setText(free.getEmail());
                  StackPane.setAlignment(stack_pane, Pos.TOP_LEFT);
                  StackPane.setMargin(stack_pane,new Insets(15,0,0,5));
                  StackPane.setAlignment(name_txt, Pos.TOP_CENTER);
                  StackPane.setMargin(name_txt,new Insets(15,0,0,5));
                  StackPane.setAlignment(status_txt, Pos.TOP_LEFT);
                  StackPane.setMargin(status_txt,new Insets(75,0,0,5));
                 
                  st.getChildren().addAll(stack_pane,status_txt,name_txt);
                  setGraphic(st);
       
               }
               }
               };
                
                return res;
                
            }
        });
        ListePra.setItems(data);
        ListePra.setOnMouseClicked(e->{
            ServiceAdmin.idfselected=ListePra.getSelectionModel().getSelectedItem().getId();
            System.out.println(ServiceAdmin.idfselected);
        URL url2 = null;
            try {
                url2 = new File("src/gui/FreelancerPradminFXML.fxml").toURI().toURL();
            } catch (MalformedURLException ex) {
                Logger.getLogger(AcceuilAdminFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        Parent root = null;
            try {
                root = FXMLLoader.load(url2);
            } catch (IOException ex) {
                Logger.getLogger(AcceuilAdminFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        ListePra.getScene().setRoot(root);
        
        });
 
    }   

    @FXML
    private void ShowFreelancers(ActionEvent event) throws MalformedURLException, IOException {
         URL url = new File("src/gui/AcceuilAdminFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        btnFreelancers.getScene().setRoot(root);
    }

    @FXML
    private void ShowCients(ActionEvent event) throws MalformedURLException, IOException {
        URL url = new File("src/gui/AcceuilAdminClientsFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        btnClients.getScene().setRoot(root);
    }

    @FXML
    private void addSkills(ActionEvent event) throws MalformedURLException, IOException {
        URL url = new File("src/gui/AddSkillsFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        btnSkills.getScene().setRoot(root);
    }

    @FXML
    private void ShowComplaints(ActionEvent event) throws MalformedURLException, IOException {
        URL url = new File("src/gui/AcceuilAdminReclamationFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Complaints.getScene().setRoot(root);
    }

    @FXML
    private void ShowCpmplaintsf(ActionEvent event) throws MalformedURLException, IOException {
        URL url = new File("src/gui/AcceuilAdminReclamationfFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Complaintsfree.getScene().setRoot(root);
    }

    @FXML
    private void profiladp(MouseEvent event) throws IOException {
         URL url = new File("src/gui/ProfilAdminFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Complaintsfree.getScene().setRoot(root);
    }

    @FXML
    private void profilad(MouseEvent event) throws IOException {
          URL url = new File("src/gui/ProfilAdminFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Complaintsfree.getScene().setRoot(root);
    }
    
    
}
