/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Freelancer;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import Entite.Sujet_forum;
import Service.ServiceAuthentification;
import Service.ServiceFreelancer;
import Service.ServiceSujet_forum;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
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
public class AcceuilForumFXMLController implements Initializable {

    @FXML
    private Button Logoutbutt;
    @FXML
    private ImageView profpicf;
    @FXML
    private Text namef;
    @FXML
    private Button contactUs;
    @FXML
    private Button Aboutus;
    @FXML
    private ListView<Sujet_forum> Listesujet;
     Freelancer f  = new Freelancer();
      private final ObservableList<Sujet_forum> data= FXCollections.observableArrayList();
      Image card2=null;
      BufferedImage image2;
    @FXML
    private Button AddnewSubject;
    @FXML
    private TextField searchf;
    @FXML
    private Button btnSearch;
    @FXML
    private ImageView logo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ServiceFreelancer sf = new ServiceFreelancer();
         ServiceSujet_forum ssf= new ServiceSujet_forum();
       BufferedImage image;
       Image card=null;
        try {
            f= sf.recherche(ServiceAuthentification.idf);
            System.out.println(f.getNom());
            namef.setText(f.getNom());
            
            try {
                 image=ImageIO.read(new ByteArrayInputStream(f.getImage()));
                  card= SwingFXUtils.toFXImage(image, null );
            } catch (IOException ex) {
                Logger.getLogger(AcceuilfreelancerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            profpicf.setImage(card);
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilfreelancerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
         data.clear();
        try {
            if (ServiceSujet_forum.s.isEmpty()){
                data.addAll(ssf.readAll());}else{
            data.addAll(ssf.readAllr(ServiceSujet_forum.s));}
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilfreelancerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Listesujet.setCellFactory(new Callback<ListView<Sujet_forum>,ListCell<Sujet_forum>>(){
            @Override
            public ListCell<Sujet_forum> call(ListView<Sujet_forum> param) {
               ListCell<Sujet_forum> res = new ListCell<Sujet_forum>(){
               @Override
               protected void updateItem(Sujet_forum free, boolean bln){
               super.updateItem(free, bln);
               if (free!=null){
                    StackPane st=new StackPane();
                     StackPane st2=new StackPane();
                     StackPane st3=new StackPane();
                    StackPane stack_pane=new StackPane();
                    Freelancer fp=null;
                    
                   try {
                       fp = sf.recherche(free.getIdFreelancer());
                   } catch (SQLException ex) {
                       Logger.getLogger(AcceuilForumFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   try {
                       image2=ImageIO.read(new ByteArrayInputStream(fp.getImage()));
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
                  String k = fp.getNom() +"\n"+ fp.getPrenom();
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
        Listesujet.setItems(data);
        Listesujet.setOnMouseClicked(e->{
        Sujet_forum.idsf = Listesujet.getSelectionModel().getSelectedItem().getId();
        
         URL url2 = null;
             try {
                 url2 = new File("src/gui/SujetForumFXML.fxml").toURI().toURL();
             } catch (MalformedURLException ex) {
                 Logger.getLogger(AcceuilForumFXMLController.class.getName()).log(Level.SEVERE, null, ex);
             }
        Parent root = null;
             try {
                 root = FXMLLoader.load(url2);
             } catch (IOException ex) {
                 Logger.getLogger(AcceuilForumFXMLController.class.getName()).log(Level.SEVERE, null, ex);
             }
        Listesujet.getScene().setRoot(root);
        
        });
        
        
    }    

    @FXML
    private void AddnewS(ActionEvent event) throws MalformedURLException, IOException {
           URL url = new File("src/gui/AddSubjectFFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        AddnewSubject.getScene().setRoot(root);
    }

    @FXML
    private void search(ActionEvent event) throws IOException {
        ServiceSujet_forum.s = searchf.getText();
        URL url = new File("src/gui/AcceuilForumFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        btnSearch.getScene().setRoot(root);
    }

    @FXML
    private void LogoR(MouseEvent event) throws IOException {
         URL url = new File("src/gui/AcceuilfreelancerFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        logo.getScene().setRoot(root);
    }
    
}
