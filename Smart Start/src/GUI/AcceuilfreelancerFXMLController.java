/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import Service.ServiceAuthentification;
import javafx.scene.text.Text;
import Entite.Freelancer;
import Entite.Job;
import Service.ServiceFreelancer;
import Service.ServiceJob;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Callback;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author houssembaazoug
 */
public class AcceuilfreelancerFXMLController implements Initializable {

    @FXML
    private Button forumb;
    @FXML
    private Text nomAcceuil;
     Freelancer f  = new Freelancer();
    @FXML
    private ImageView ImageFreelancer;
    @FXML
    private ListView<Job> Listeview;
    private final ObservableList<Job> data= FXCollections.observableArrayList();
    Image card2=null;
    BufferedImage image2;
    @FXML
    private Button jobsforS;
    @FXML
    private Button adsbtn;
    @FXML
    private Button Complaintsbtn;
    @FXML
    private Button jobs;
    @FXML
    private Button Subscription;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println(ServiceAuthentification.idf);
        ServiceFreelancer sf = new ServiceFreelancer();
        ServiceJob sj = new ServiceJob();
       BufferedImage image;
       Image card=null;
        try {
            f= sf.recherche(ServiceAuthentification.idf);
            System.out.println(f.getNom());
            nomAcceuil.setText(f.getNom());
            
            try {
                 image=ImageIO.read(new ByteArrayInputStream(f.getImage()));
                  card= SwingFXUtils.toFXImage(image, null );
            } catch (IOException ex) {
                Logger.getLogger(AcceuilfreelancerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            ImageFreelancer.setImage(card);
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilfreelancerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        data.clear();
        try {
            data.addAll(sj.readAllf(f.getId()));
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilfreelancerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Listeview.setCellFactory(new Callback<ListView<Job>,ListCell<Job>>(){
            @Override
            public ListCell<Job> call(ListView<Job> param) {
               ListCell<Job> res = new ListCell<Job>(){
               @Override
               protected void updateItem(Job free, boolean bln){
               super.updateItem(free, bln);
               if (free!=null){
                    StackPane st=new StackPane();
                    StackPane stack_pane=new StackPane();
                     StackPane st2=new StackPane();
                     StackPane st3=new StackPane();
                    
                    
                   try {
                       f=sf.recherche(ServiceAuthentification.idf);
                   } catch (SQLException ex) {
                       Logger.getLogger(AcceuilClientFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   try {
                       image2=ImageIO.read(new ByteArrayInputStream(f.getImage()));
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
                  String k = f.getNom() +"\n"+ f.getPrenom();
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
                  if (free.getDESCRIPTION().length() > 150){
                  name_txt.setText(free.getDESCRIPTION().substring(0, 200)+ "...");}
                  else {name_txt.setText(free.getDESCRIPTION());}
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
        Listeview.setItems(data);
        Listeview.setOnMouseClicked(e->{
        System.out.println(Listeview.getSelectionModel().getSelectedItem());
        });
        
        
    }    

    @FXML
    private void goforum(ActionEvent event) throws MalformedURLException, IOException {
            URL url = new File("src/gui/AcceuilForumFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        forumb.getScene().setRoot(root);
    }

    @FXML
    private void goprofiln(MouseEvent event) throws MalformedURLException, IOException {
            URL url = new File("src/gui/ProfilFreelancerFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        nomAcceuil.getScene().setRoot(root);
    }

    @FXML
    private void goprofilp(MouseEvent event) throws MalformedURLException, IOException {
            URL url = new File("src/gui/ProfilFreelancerFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        nomAcceuil.getScene().setRoot(root);
    }

    @FXML
    private void jobsBySkill(ActionEvent event) throws IOException {
          URL url = new File("src/gui/JobsBySkillsFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        adsbtn.getScene().setRoot(root);
        
    }

    @FXML
    private void Adsbtn(ActionEvent event) throws IOException {
         URL url = new File("src/gui/AnnonceFreelancerAllFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        adsbtn.getScene().setRoot(root);
        
    }

    @FXML
    private void Complaintsbtn(ActionEvent event) throws MalformedURLException, IOException {
          URL url = new File("src/gui/ComplaintsFreelancerFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        nomAcceuil.getScene().setRoot(root);
    }

    @FXML
    private void Jobsbtn(ActionEvent event) throws MalformedURLException, IOException {
        URL url = new File("src/gui/AcceuilfreelancerFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        nomAcceuil.getScene().setRoot(root);
    }

    @FXML
    private void Subscriptionbtn(ActionEvent event) throws IOException {
        URL url = new File("src/gui/SubscribtionFreelancerFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        nomAcceuil.getScene().setRoot(root);
    }
    
}
