/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Commentaire;
import Entite.Freelancer;
import Entite.Sujet_forum;
import Service.ServiceAuthentification;
import Service.ServiceCommentaire;
import Service.ServiceFreelancer;
import Service.ServiceSujet_forum;
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
 * @author houssembaazoug
 */
public class SujetForumFXMLController implements Initializable {

    @FXML
    private Text titlelbl;
    @FXML
    private ListView<Commentaire> listeviewc;
    ServiceFreelancer sf= new ServiceFreelancer();
    Sujet_forum sff = new Sujet_forum();
    ServiceSujet_forum ssf= new ServiceSujet_forum();
    Freelancer f  = new Freelancer();
    ServiceCommentaire sc = new ServiceCommentaire ();
    private final ObservableList<Commentaire> data= FXCollections.observableArrayList();
    Commentaire c = new Commentaire ();
    Image card2=null;
    BufferedImage image2;
    @FXML
    private TextArea conlbl;
    @FXML
    private Text contentlbl;
    @FXML
    private TextArea texComment;
    @FXML
    private Button Commentbtn;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            sff= ssf.recherche(Sujet_forum.idsf);
            
        } catch (SQLException ex) {
            Logger.getLogger(SujetForumFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        titlelbl.setText(sff.getTitre());
        conlbl.setText(sff.getContenu());
         data.clear();
        try {
            data.addAll(sc.readAll(Sujet_forum.idsf));
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilfreelancerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        listeviewc.setCellFactory(new Callback<ListView<Commentaire>,ListCell<Commentaire>>(){
            @Override
            public ListCell<Commentaire> call(ListView<Commentaire> param) {
               ListCell<Commentaire> res = new ListCell<Commentaire>(){
               @Override
               protected void updateItem(Commentaire free, boolean bln){
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
         listeviewc.setItems(data);
         System.out.println(data);
    }    

    @FXML
    private void Comment(ActionEvent event) throws SQLException, MalformedURLException, IOException {
        c.setContenu(texComment.getText());
        c.setIdFreelancer(ServiceAuthentification.idf);
        c.setidSujet(Sujet_forum.idsf);
        sc.ajouterCommentaire(c);
        URL url = new File("src/gui/SujetForumFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Commentbtn.getScene().setRoot(root);
        
        
    }
    
}
