/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Client;
import Entite.Commentaire;
import Entite.Feedback;
import Entite.Freelancer;
import Entite.Sujet_forum;
import Service.ServiceAuthentification;
import Service.ServiceClient;
import Service.ServiceFeedback;
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
 * @author houssembaazoug
 */
public class FeedbackClientFXMLController implements Initializable {

    @FXML
    private Text nomUser;
    @FXML
    private ImageView imageUser;
    @FXML
    private TextArea textFeedback;
    @FXML
    private ListView<Feedback> ListeFeedback;
    @FXML
    private Button btnFeedback;
     private final ObservableList<Feedback> data= FXCollections.observableArrayList();
      Freelancer f = new Freelancer();
    ServiceFreelancer sf = new ServiceFreelancer ();
    ServiceClient sc = new ServiceClient();
    ServiceFeedback sff = new ServiceFeedback();
    Feedback fd = new Feedback();
    Client c = new Client();
    Image card2=null;
    BufferedImage image2;
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
         data.clear();
        try {
            data.addAll(sff.readAll(f.getId()));
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilfreelancerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
         ListeFeedback.setCellFactory(new Callback<ListView<Feedback>,ListCell<Feedback>>(){
            @Override
            public ListCell<Feedback> call(ListView<Feedback> param) {
               ListCell<Feedback> res = new ListCell<Feedback>(){
               @Override
               protected void updateItem(Feedback free, boolean bln){
               super.updateItem(free, bln);
               if (free!=null){
                    StackPane st=new StackPane();
                     StackPane st2=new StackPane();
                     StackPane st3=new StackPane();
                    StackPane stack_pane=new StackPane();
                    Client fp=null;
                    
                   try {
                       fp = sc.recherche(free.getClient());
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
                  
                  
                  Text nom=new Text();
                  
                  nom.setFill(Color.BLACK);
                  nom.setFont(Font.font("arial",12));
                  String k = fp.getNom() +"\n"+ fp.getPrenom();
                  nom.setText(k);
                 
                  
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
         ListeFeedback.setItems(data);
    }    

    @FXML
    private void Submitfeedback(ActionEvent event) throws SQLException, IOException {
        fd.setContenu(textFeedback.getText());
        fd.setFreelancer(f.getId());
        fd.setClient(ServiceAuthentification.idc);
        sff.ajouterSujet_forum(fd);
          URL url = new File("src/gui/FeedbackClientFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        btnFeedback.getScene().setRoot(root);
    }

    @FXML
    private void LogoR(MouseEvent event) throws IOException {
         URL url = new File("src/gui/AcceuilClientFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        logo.getScene().setRoot(root);
    }
    
}
