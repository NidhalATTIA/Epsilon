
package Controllers;

import Entite.Client;
import Entite.Feedback;
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
import Service.ServiceClient;
import Service.ServiceFeedback;
import com.jfoenix.controls.JFXButton;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
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
public class afficheFeedbackFreelancerFXML implements Initializable {

    private Button forumb;
    private Text nomAcceuil;
     Freelancer f  = new Freelancer();
    @FXML
    private ListView<Feedback> Listeview;
    private final ObservableList<Feedback> data= FXCollections.observableArrayList();
  //  Image card2=null;
    BufferedImage image2;
   //  ImageView imvi;
    @FXML
    private AnchorPane pass;
    @FXML
    private AnchorPane anchorPaneA;
    @FXML
    private ScrollPane scrollPaneAnnonce;
    @FXML
    private JFXButton stat;
    public static Feedback fstat ;
    @FXML
    private Button ajouter;
    @FXML
    private Button back;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        ServiceFeedback sf = new ServiceFeedback();
        ServiceClient sc=new ServiceClient();
       Image card2 =null;
      
        
      
        try {
            data.addAll(sf.readAll());
             System.out.println("data "+data.toString());
        } catch (SQLException ex) {
            Logger.getLogger(afficheFeedbackFreelancerFXML.class.getName()).log(Level.SEVERE, null, ex);
        }

      Listeview.setCellFactory(new Callback<ListView<Feedback>,ListCell<Feedback>>(){
            @Override
            public ListCell<Feedback> call(ListView<Feedback> param) {
                
               ListCell<Feedback> res = new ListCell<Feedback>(){
               @Override
               protected void updateItem(Feedback free, boolean bln){
               super.updateItem(free, bln);
              
               if (free!=null){
                    StackPane st=new StackPane();
                    StackPane stack_pane=new StackPane();
                  Client c = new Client();

                   try {
                       
                       c= sc.chercher_connexte(free.getIdClient());
                       //System.out.println("cliennnnt "+free.getId());
                   } catch (SQLException ex) {
                     Logger.getLogger(afficheFeedbackFreelancerFXML.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   
                    Image card2 = new Image("/image/"+c.getImage());
                   
                    ImageView imvi= new ImageView(card2);
                  
                  //reglage image
                  imvi.setFitHeight(64);
                  imvi.setFitWidth(64);
                  imvi.setSmooth(true);
                  stack_pane.setMaxWidth(64);
                  stack_pane.setMaxHeight(64);
                  stack_pane.setId("image_pane");
                  stack_pane.getChildren().add(imvi);
                  //reglage Nom et Prenom
                  Text status_txt=new Text();
                  status_txt.setFill(Color.RED);
                  status_txt.setFont(Font.font("Arial Black",15));
                  status_txt.setWrappingWidth(500);
                  status_txt.setText(c.getNom()+" "+c.getPrenom());
                  // reglage Contenu
                  Text name_txt=new Text();
                  name_txt.setFill(Color.BLACK);
                  name_txt.setFont(Font.font("Arial Rounded MT Bold",FontWeight.BOLD,18));
                  name_txt.setText(free.getContenu());
                  
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
        Listeview.setOnMouseClicked((MouseEvent e)->{
        System.out.println(Listeview.getSelectionModel().getSelectedItem());
        fstat = Listeview.getSelectionModel().getSelectedItem();
        System.out.println(ServiceAuthentification.cli);
       if ( Listeview.getSelectionModel().getSelectedItem().getIdClient() == ServiceAuthentification.cli){
        Pane newLoadedPaneExp;
            try {
                newLoadedPaneExp = FXMLLoader.load(getClass().getResource("../GUI/ModifierFeedbackFXML.fxml"));
            
        pass.getChildren().clear();
        pass.getChildren().add(newLoadedPaneExp);} 
        catch (Exception ex) {
                Logger.getLogger(afficheFeedbackFreelancerFXML.class.getName()).log(Level.SEVERE, null, ex);
            }}
         });
        
        
    }

    private void goforum(ActionEvent event) throws MalformedURLException, IOException {
            URL url = new File("src/gui/AcceuilForumFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        forumb.getScene().setRoot(root);
    }

    private void goprofiln(MouseEvent event) throws MalformedURLException, IOException {
            URL url = new File("src/gui/ProfilFreelancerFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        nomAcceuil.getScene().setRoot(root);
    }

    private void goprofilp(MouseEvent event) throws MalformedURLException, IOException {
            URL url = new File("src/gui/ProfilFreelancerFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        nomAcceuil.getScene().setRoot(root);
    }

    @FXML
    private void stat(ActionEvent event) {
    }

    @FXML
    private void ajouter(ActionEvent event) throws MalformedURLException, IOException {
        URL url = new File("C:/Users/Yasser Bel Haj Ali/Documents/NetBeansProjects/ProjetPi/src/GUI/FXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        ajouter.getScene().setRoot(root);
        
        
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        URL url = new File("C:/Users/Yasser Bel Haj Ali/Documents/NetBeansProjects/ProjetPi/src/GUI/ProfileFreelancerFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        back.getScene().setRoot(root);
    }
    
}
