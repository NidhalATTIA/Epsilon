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
import Service.ServiceFreelancer;
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
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
    private ListView<Freelancer> Listeview;
    private final ObservableList<Freelancer> data= FXCollections.observableArrayList();
    Image card2=null;
    BufferedImage image2;
    @FXML
    private Button jobsforS;
    @FXML
    private Button adsbtn;
    @FXML
    private Button Complaintsbtn;

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
        
        data.clear();
        try {
            data.addAll(sf.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilfreelancerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Listeview.setCellFactory(new Callback<ListView<Freelancer>,ListCell<Freelancer>>(){
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
                       Logger.getLogger(AcceuilfreelancerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
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
    private void jobsBySkill(ActionEvent event) {
    }

    @FXML
    private void Adsbtn(ActionEvent event) {
    }

    @FXML
    private void Complaintsbtn(ActionEvent event) throws MalformedURLException, IOException {
          URL url = new File("src/gui/ComplaintsFreelancerFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        nomAcceuil.getScene().setRoot(root);
    }
    
}
