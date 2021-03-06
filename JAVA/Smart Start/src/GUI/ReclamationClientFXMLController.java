/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Client;
import Entite.Freelancer;
import Entite.Job;
import Entite.Reclamation;
import Service.ServiceAuthentification;
import Service.ServiceClient;
import Service.ServiceFreelancer;
import Service.ServiceJob;
import Service.ServiceReclamation;
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
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
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
 * @author Arzack
 */
public class ReclamationClientFXMLController implements Initializable {

    @FXML
    private Button logoutadmin;
    @FXML
    private ImageView imageA;
    @FXML
    private Text nomAdmin;
    @FXML
    private Button Aboutus;
    @FXML
    private Button Contactus;
    @FXML
    private ListView<Reclamation> ListePra;
    @FXML
    private Button Jobs;
    @FXML
    private Button btnClients;
    @FXML
    private Button btnSkills;
    @FXML
    private Button Complaints;
    Image card2=null;
    BufferedImage image2;
    Client a = new Client();
    Client b = new Client();
    ServiceClient sc = new ServiceClient();
    ServiceReclamation sr = new ServiceReclamation();
    
    private final ObservableList<Reclamation> data= FXCollections.observableArrayList();
    @FXML
    private Button CreateC;

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
            nomAdmin.setText(a.getNom());
            
            try {
                 image=ImageIO.read(new ByteArrayInputStream(a.getImage()));
                  card= SwingFXUtils.toFXImage(image, null );
            } catch (IOException ex) {
                Logger.getLogger(AcceuilfreelancerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            imageA.setImage(card);
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilAdminFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        data.clear();
         try {
            data.addAll(sr.readAllc(ServiceAuthentification.idc));
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilfreelancerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ListePra.setCellFactory(new Callback<ListView<Reclamation>,ListCell<Reclamation>>(){
            @Override
            public ListCell<Reclamation> call(ListView<Reclamation> param) {
               ListCell<Reclamation> res = new ListCell<Reclamation>(){
               @Override
               protected void updateItem(Reclamation free, boolean bln){
               super.updateItem(free, bln);
               if (free!=null){
                    StackPane st=new StackPane();
                    StackPane stack_pane=new StackPane();
                     StackPane st2=new StackPane();
                     StackPane st3=new StackPane();
                    
                    
                   try {
                       b=sc.recherche(ServiceAuthentification.idc);
                   } catch (SQLException ex) {
                       Logger.getLogger(AcceuilClientFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   try {
                       image2=ImageIO.read(new ByteArrayInputStream(b.getImage()));
                   } catch (IOException ex) {
                       Logger.getLogger(AcceuilfreelancerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                   }
                  card2= SwingFXUtils.toFXImage(image2, null );
                  ImageView imvi= new ImageView(card2);
                  imvi.setFitHeight(64);
                  imvi.setFitWidth(64);
                  imvi.setSmooth(true);
                  stack_pane.setMaxWidth(64);
                  stack_pane.setMaxHeight(64);
                  st3.setMaxWidth(15);
                  st3.setMaxHeight(15);
                  stack_pane.setId("image_pane");
                  stack_pane.getChildren().add(imvi);
                  st2.setMaxHeight(25);
                  
                  st2.setBackground(new Background(new BackgroundFill(Color.rgb(0, 0, 0), CornerRadii.EMPTY, Insets.EMPTY)));
                  
                  Text status_txt=new Text();
                  Text nom=new Text();
                  status_txt.setFill(Color.RED);
                  status_txt.setFont(Font.font("arial",15));
                  nom.setFill(Color.BLACK);
                  nom.setFont(Font.font("arial",12));
                  String k = b.getNom() +"\n"+ b.getPrenom();
                  nom.setText(k);
                  status_txt.setWrappingWidth(500);
                  status_txt.setText(free.getTitre());
                  st2.getChildren().add(status_txt);
                  TextArea name_txt=new TextArea();
                  name_txt.setStyle("-fx-text-fill: Black;");
                  name_txt.setDisable(true);
                  name_txt.setMaxHeight(100);
                  name_txt.setWrapText(true);
                  st3.getChildren().add(nom);
                  name_txt.setFont(Font.font("castellar",FontWeight.BOLD,18));
                  if (free.getContenu().length() > 150){
                  name_txt.setText(free.getContenu().substring(0, 200)+ "...");}
                  else {name_txt.setText(free.getContenu());}
                  StackPane.setAlignment(stack_pane, Pos.TOP_LEFT);
                  StackPane.setMargin(stack_pane,new Insets(25,0,0,5));
                  StackPane.setAlignment(name_txt, Pos.TOP_LEFT);
                  StackPane.setMargin(name_txt,new Insets(25,0,0,95));
                  StackPane.setAlignment(st2, Pos.TOP_LEFT);
                  StackPane.setMargin(st2,new Insets(0,0,0,5));
                  StackPane.setAlignment(st3, Pos.BOTTOM_LEFT);
                  StackPane.setMargin(st3,new Insets(0,0,0,5));
                  st.getChildren().addAll(st2,stack_pane,name_txt,st3);
                  setGraphic(st);
       
               }
               }
               };
               
                
                return res;
                
            }
        });
        ListePra.setItems(data);
        ListePra.setOnMouseClicked(e->{
        Reclamation.idrc=ListePra.getSelectionModel().getSelectedItem().getId();
         URL url2 = null;
            try {
                url2 = new File("src/gui/ModifReclamationCFXML.fxml").toURI().toURL();
            } catch (MalformedURLException ex) {
                Logger.getLogger(ReclamationClientFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        Parent root = null;
            try {
                root = FXMLLoader.load(url2);
            } catch (IOException ex) {
                Logger.getLogger(ReclamationClientFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        ListePra.getScene().setRoot(root);
        });
        
    }    

    @FXML
    private void ShowJobs(ActionEvent event) throws MalformedURLException, IOException {  
        URL url = new File("src/gui/AcceuilClientFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Jobs.getScene().setRoot(root);
        
    }

    @FXML
    private void ShowAnnonce(ActionEvent event) throws MalformedURLException, IOException {
        URL url = new File("src/gui/AnnonceClientFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        btnClients.getScene().setRoot(root);
    }

    @FXML
    private void addFreelancers(ActionEvent event) throws MalformedURLException, IOException {
         URL url = new File("src/gui/FreelancersClientFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        btnSkills.getScene().setRoot(root);
    }

    @FXML
    private void ShowComplaints(ActionEvent event) throws MalformedURLException, IOException {
        URL url = new File("src/gui/ReclamationClientFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Complaints.getScene().setRoot(root);
    }

    @FXML
    private void CreateC(ActionEvent event) throws MalformedURLException, IOException {
         URL url = new File("src/gui/AddReclamationcFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        CreateC.getScene().setRoot(root);
    }
    
}
