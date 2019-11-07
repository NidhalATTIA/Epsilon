/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Annonce;
import Entite.Client;
import Entite.FeedMessage;
import Entite.Skills;
import Service.ServiceAnnonce;
import Service.ServiceAuthentification;
import Service.ServiceClient;
import Service.ServiceSkills;
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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javax.imageio.ImageIO;
import Entite.Feed;
import Service.RSSFeedWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;


/**
 * FXML Controller class
 *
 * @author houssembaazoug
 */
public class VuAnnonceClientFXMLController implements Initializable {

    @FXML
    private Text nomUser;
    @FXML
    private ImageView imageUser;
    @FXML
    private TextArea Descriptiontext;
    @FXML
    private ListView<Skills> skillliste;
    @FXML
    private Button btnadd;
    @FXML
    private TextField titletext;
    private final ObservableList<Skills> data= FXCollections.observableArrayList();
    Client a = new Client();
    Annonce an = new Annonce ();
    ServiceAnnonce san = new ServiceAnnonce ();
    ServiceClient sc = new ServiceClient();
    ServiceSkills sff = new ServiceSkills();
    int selected;
    List<Annonce> annonces = null;
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
            nomUser.setText(a.getNom());
            
            try {
                 image=ImageIO.read(new ByteArrayInputStream(a.getImage()));
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
            data.addAll(sff.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilfreelancerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        skillliste.setCellFactory(new Callback<ListView<Skills>,ListCell<Skills>>(){
            @Override
            public ListCell<Skills> call(ListView<Skills> param) {
               ListCell<Skills> res = new ListCell<Skills>(){
               @Override
               protected void updateItem(Skills free, boolean bln){
               super.updateItem(free, bln);
               if (free!=null){
                    StackPane st=new StackPane();
                       
                  
               
                  
                  Text name_txt=new Text();
                  name_txt.setFill(Color.RED);
                  name_txt.setFont(Font.font("castellar",FontWeight.BOLD,18));
                  name_txt.setText(free.getContenu());
                 
                  StackPane.setAlignment(name_txt, Pos.TOP_CENTER);
                  StackPane.setMargin(name_txt,new Insets(15,0,0,5));
                  
                  st.getChildren().addAll(name_txt);
                  setGraphic(st);
       
               }
               }
               };
                
                return res;
                
            }
        });
        skillliste.setItems(data);
        skillliste.setOnMouseClicked(e ->{
        selected= skillliste.getSelectionModel().getSelectedItem().getId();
        
        });
        
    }    

    @FXML
    private void createad(ActionEvent event) throws SQLException, IOException {
        an.setDESCRIPTION(Descriptiontext.getText());
        an.setTitre(titletext.getText());
        an.setId_client(a.getId());
        an.setSkills(selected);
        san.ajouterAnnonce(an);
        annonces = san.readAll();
        String copyright = "Copyright hold by SmartStart";
        String title = "Ads Rss Feed for freelancers";
        String description = "This is an rss feed for ads";
        String language = "en";
        String link = "https://www.SmartStart/";
        Calendar cal = new GregorianCalendar();
        Date creationDate = cal.getTime();
        SimpleDateFormat date_format = new SimpleDateFormat(
                "EEE', 'dd' 'MMM' 'yyyy' 'HH:mm:ss' 'Z", Locale.US);
        String pubdate = date_format.format(creationDate);
        Feed rssFeeder = new Feed(title, link, description, language,
                copyright, pubdate);
        for(Annonce i:annonces){
        FeedMessage feed = new FeedMessage();
                    feed.setTitle(i.getTitre());
                    feed.setDescription(i.getDESCRIPTION());
                        Client w = new Client();
                        w = sc.recherche(i.getId_client());
                       feed.setAuthor(w.getNom_company());
                       feed.setGuid("https://www.SmartStart/RSSFeed");
                        feed.setLink("https://www.SmartStart/RSSFeed");
                        rssFeeder.getMessages().add(feed);
                        RSSFeedWriter writer = new RSSFeedWriter(rssFeeder, "/Users/houssembaazoug/sites/articles.rss");
                        try {
                          writer.write();
                   } catch (Exception e) {
                          e.printStackTrace();
                     }}
        URL url = new File("src/gui/AnnonceClientFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        btnadd.getScene().setRoot(root);
    }

    
}
