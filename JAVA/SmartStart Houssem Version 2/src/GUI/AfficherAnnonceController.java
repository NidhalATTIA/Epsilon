/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.ServiceAnnonce;
import GUI.AfficherDetailsController;

import Entity.Annonce;
import Entity.Client;
import Entity.Skills;
import Service.ServiceClient;
import Service.ServiceSkills;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author MED HOUSSEM KAFFEL
 */
public class AfficherAnnonceController implements Initializable {

   
    
    
    static public Annonce Annoncesel1;

    
    List<Annonce> st = new ArrayList<>();
    @FXML
    private Button details;
    @FXML
    private Button tfadd;
    private int idAskService;
    private int tfshit;
    @FXML
    private Button aboutus1;
    @FXML
    private Button contactus1;
    @FXML
    private ListView<Annonce> ListAnnonce;
        Annonce annonce=new Annonce();

    Image card2=null;
    BufferedImage image2;
 Client a = new Client();
 Client b = new Client();
ServiceAnnonce sp = new ServiceAnnonce();
ServiceSkills ss = new ServiceSkills();
ServiceClient sc = new ServiceClient();
         Skills s = new Skills();
        private final ObservableList<Annonce> data = FXCollections.observableArrayList();
    @FXML
    private Button logout;
    @FXML
    private Label count;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
         try {
            countannonce();
        } catch (SQLException ex) {
            Logger.getLogger(AfficherAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
        }
            try {
            data.addAll(sp.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(AfficherAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ListAnnonce.setCellFactory(new Callback<ListView<Annonce>,ListCell<Annonce>>(){
            @Override
            public ListCell<Annonce> call(ListView<Annonce> param) {
               ListCell<Annonce> res = new ListCell<Annonce>(){
               @Override
               protected void updateItem(Annonce free, boolean bln){
               super.updateItem(free, bln);
               if (free!=null){
                    StackPane st=new StackPane();
                    StackPane stack_pane=new StackPane();
                     StackPane st2=new StackPane();
                     StackPane st3=new StackPane();
                     StackPane st4=new StackPane();
                   try {
                       s= ss.recherche(free.getSkills());
                   } catch (SQLException ex) {
                       Logger.getLogger(AfficherAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
                   }
                  try {
                       b=sc.recherche(free.getId_client());
                   } catch (SQLException ex) {
                       Logger.getLogger(AfficherAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
                   }
                  try {
                       image2=ImageIO.read(new ByteArrayInputStream(b.getImage()));
                   } catch (IOException ex) {
                       Logger.getLogger(AfficherAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
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
                  st4.setMaxWidth(15);
                  st4.setMaxHeight(15);
                  stack_pane.setId("image_pane");
                  stack_pane.getChildren().add(imvi);
                  st2.setMaxHeight(25);
                  
                  st2.setBackground(new Background(new BackgroundFill(Color.rgb(0, 0, 0), CornerRadii.EMPTY, Insets.EMPTY)));
                  
                  Text status_txt=new Text();
                  Text nom=new Text();
                  Text skill = new Text();
                   skill.setFill(Color.RED);
                  skill.setFont(Font.font("arial",12));
                  skill.setText(s.getContenu());
                  st4.getChildren().add(skill);
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
                  StackPane.setAlignment(st4, Pos.BOTTOM_LEFT);
                  StackPane.setMargin(st4,new Insets(0,0,0,60));
                  st.getChildren().addAll(st2,stack_pane,name_txt,st3,st4);
                  setGraphic(st);
       
               }
               }
               };
               
                
                return res;
                
            }
        });
        ListAnnonce.setItems(data);
    }    

        

    @FXML
    private void showdetails(ActionEvent event) throws IOException {
           Annoncesel1 = ListAnnonce.getSelectionModel().getSelectedItem();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherDetails.fxml"));
        Parent root;

        root = loader.load();
        details.getScene().setRoot(root);
        
    }

    @FXML
    private void SupprimerAnnonce(ActionEvent event) throws SQLException {
        ServiceAnnonce ms = new ServiceAnnonce();
        ObservableList<Annonce> ll, ttmission;
        ttmission = ListAnnonce.getItems();
        // ta3tina les lignes selectionnés 
        ll = ListAnnonce.getSelectionModel().getSelectedItems();

        for (Annonce m : ll) {
            ttmission.remove(m);
            ms.supprimerAnnonce(m.getID());
        }
        JOptionPane.showMessageDialog(null, "supprimer");
    }

    @FXML
    private void roadToajout(ActionEvent event) throws MalformedURLException, IOException {
       Parent root1 = FXMLLoader.load(getClass().getResource("AjouterAnnonce.fxml"));
      
      
          tfadd.getScene().setRoot(root1);
    }


    @FXML
    private void GoToAboutus1(ActionEvent event) {
    }

    @FXML
    private void GoToAContactus1(ActionEvent event) {
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("Authentification.fxml"));
      
      
          logout.getScene().setRoot(root1);
    }
 private void countannonce() throws SQLException {
     
     count.setText("les nombres des annonces: " + sp.CountAnnonce());
       
             }
       
 
}
