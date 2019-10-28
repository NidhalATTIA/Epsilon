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
import javafx.scene.input.MouseEvent;
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
public class ComplaintsFreelanecerFXMLController implements Initializable {

    @FXML
    private Button forumb;
    @FXML
    private Text nomAcceuil;
    @FXML
    private ImageView ImageFreelancer;
    @FXML
    private Button jobsforS;
    @FXML
    private ListView<Reclamation> Listeview;
    Freelancer f  = new Freelancer();
    Freelancer b  = new Freelancer();
    private final ObservableList<Reclamation> data= FXCollections.observableArrayList();
    @FXML
    private Button adsbtn;
    @FXML
    private Button Complaintsbtn;
    ServiceFreelancer sc = new ServiceFreelancer();
    ServiceReclamation sr = new ServiceReclamation();
    Image card2=null;
    BufferedImage image2;
    @FXML
    private Button CreateC;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println(ServiceAuthentification.idf);
        ServiceFreelancer sf = new ServiceFreelancer();
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
         try {
            data.addAll(sr.readAllf(ServiceAuthentification.idf));
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilfreelancerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Listeview.setCellFactory(new Callback<ListView<Reclamation>,ListCell<Reclamation>>(){
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
                       b=sc.recherche(ServiceAuthentification.idf);
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
        Listeview.setItems(data);
        Listeview.setOnMouseClicked(e->{
        Reclamation.idrf=Listeview.getSelectionModel().getSelectedItem().getId();
          URL url2 = null;
             try {
                 url2 = new File("src/gui/ModifReclamationFFXML.fxml").toURI().toURL();
             } catch (MalformedURLException ex) {
                 Logger.getLogger(AcceuilForumFXMLController.class.getName()).log(Level.SEVERE, null, ex);
             }
        Parent root = null;
             try {
                 root = FXMLLoader.load(url2);
             } catch (IOException ex) {
                 Logger.getLogger(AcceuilForumFXMLController.class.getName()).log(Level.SEVERE, null, ex);
             }
        Listeview.getScene().setRoot(root);
        });
    }    

    @FXML
    private void goforum(ActionEvent event) {
    }

    @FXML
    private void goprofiln(MouseEvent event) {
    }

    @FXML
    private void goprofilp(MouseEvent event) {
    }

    @FXML
    private void jobsBySkill(ActionEvent event) {
    }

    @FXML
    private void Adsbtn(ActionEvent event) {
    }

    @FXML
    private void Complaintsbtn(ActionEvent event) {
    }

    @FXML
    private void CreateComp(ActionEvent event) throws MalformedURLException, IOException {
          URL url = new File("src/gui/AddReclamationFFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        nomAcceuil.getScene().setRoot(root);
    }
    
}
