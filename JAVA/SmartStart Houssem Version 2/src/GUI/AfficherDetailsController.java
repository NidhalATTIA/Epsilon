/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.AfficherAnnonceController.Annoncesel1;
import Service.ServiceAnnonce;
import Entity.Annonce;
import Entity.Skills;
import Service.ServiceSkills;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author MED HOUSSEM KAFFEL
 */
public class AfficherDetailsController implements Initializable {
       
    private Annonce selectedAnnonce;
    
    @FXML
    private TextField tftitle;
    @FXML
    private TextArea tfdescription;
    @FXML
     private ListView<Skills> tfskills;
    
     public int AnnonceID;
     private static String Titre;
    
    ServiceAnnonce SA;
    Annonce annonce=new Annonce();
    @FXML
    private Label idannonce;
    @FXML
    private Button tfreturn;
    int selected= 0;
    Skills selected2 = null;
    Skills selected3 =null; 
    ServiceSkills sff = new ServiceSkills();

    private final ObservableList<Skills> data = FXCollections.observableArrayList();
    @FXML
    private Button logout;
    @FXML
    private Button aboutus1;
    @FXML
    private Button contactus1;

    public AfficherDetailsController() throws SQLException {
        this.SA = new ServiceAnnonce();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            afficher_detail();
        } catch (SQLException ex) {
            Logger.getLogger(AfficherDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            data.addAll(sff.readAll10());
        } catch (SQLException ex) {
            Logger.getLogger(AfficherDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tfskills.setCellFactory(new Callback<ListView<Skills>,ListCell<Skills>>(){
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
         tfskills.setItems(data);
         tfskills.setOnMouseClicked(e->{
        Skills.idSelected = tfskills.getSelectionModel().getSelectedItem().getId();
        System.out.println(tfskills.getSelectionModel().getSelectedItem());});
        // TODO
    }
    
       
        


        // TODO

    private void afficher_detail() throws SQLException {
        
        int idd = AfficherAnnonceController.Annoncesel1.getID();
        this.idannonce.setText(String.valueOf(idd));
        annonce=SA.Get_Annonce_by_id(idd);

        
        idannonce.setText(String.valueOf(annonce.getID()));
        tftitle.setText(annonce.getTitre());
        //tfskills.setText(String.valueOf(annonce.getSkills()));
        tfdescription.setText(annonce.getDESCRIPTION());     }
       

  
    @FXML
    private void ModifierAnnonce(ActionEvent event) throws SQLException {
       List<Annonce> list = new ArrayList<>();
     int idd = AfficherAnnonceController.Annoncesel1.getID();
       selected= tfskills.getSelectionModel().getSelectedItem().getId();

                        
          System.out.println(selected);
          Annonce s = new Annonce();
          ServiceAnnonce sa = new ServiceAnnonce();
          list=sa.Get_Annonce_by_Id(idd);
          s=list.get(0);
          
        s.setTitre(tftitle.getText());
        s.setDESCRIPTION(tfdescription.getText());
        s.setSkills(selected);
        
        
        
        ServiceAnnonce sp = new ServiceAnnonce();
        try {
            sp.modifierAnnonce(s);
        } catch (SQLException ex) {
        }
    }

    @FXML
    private void homereturn(ActionEvent event) throws IOException {
         Parent root1 = FXMLLoader.load(getClass().getResource("AfficherAnnonce.fxml"));
      
      
          tfreturn.getScene().setRoot(root1);
    }

    @FXML
    private void publierAnnonce(ActionEvent event) {
        String f ;
             f=(tftitle.getText());
              String accessToken="EAAf21yKarZC8BAHI4m0aS42Y2MBL6WigM49ZAxEky7Q4ITUKuuNXoU4QJ2PIcx3mz45WZBagZBjJaX564SOWR36trWTTDIRZCraq1qS3hAZAOSwb07V99rZAyj694K4nOPInbnnHtfsznkhoQpAaufEVR6OQw0JNyXNoisQeJrRaDZBPk8stlbrZAYYSsDleBrT48fQ1vtwlk3gZDZD";
        FacebookClient fbClient= new DefaultFacebookClient(accessToken);
    FacebookType response= fbClient.publish("me/feed",FacebookType.class,Parameter.with("message",f));
   System.out.println("fb.com/"+response.getId());
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
         Parent root1 = FXMLLoader.load(getClass().getResource("Authentification.fxml"));
      
      
          logout.getScene().setRoot(root1);
    }

    @FXML
    private void GoToAboutus1(ActionEvent event) {
    }

    @FXML
    private void GoToAContactus1(ActionEvent event) {
    }
    
}
