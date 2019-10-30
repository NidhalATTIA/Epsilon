/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import Entity.Annonce;
import Entity.Client;
import Entity.Skills;
import Service.ServiceAnnonce;
import Service.ServiceSkills;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author MED HOUSSEM KAFFEL
 */
public class AjouterAnnonceController implements Initializable {

    @FXML
    private TextField feTitre;
    @FXML
    private ListView<Skills> listeSkills;
    @FXML
    private TextArea feDescription;
    @FXML
    private Button tfreturn;
    
    int selected= 0;
    Skills selected2 = null;
    Skills selected3 =null; 
     private final ObservableList<Skills> data= FXCollections.observableArrayList();
     ServiceSkills sff = new ServiceSkills();
    @FXML
    private Button logout;
    @FXML
    private Button aboutus1;
    @FXML
    private Button contactus1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            data.addAll(sff.readAll10());
        } catch (SQLException ex) {
            Logger.getLogger(AfficherAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        listeSkills.setCellFactory(new Callback<ListView<Skills>,ListCell<Skills>>(){
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
         listeSkills.setItems(data);
         listeSkills.setOnMouseClicked(e->{
        Skills.idSelected = listeSkills.getSelectionModel().getSelectedItem().getId();
        System.out.println(listeSkills.getSelectionModel().getSelectedItem());});
        // TODO
    }
    
    

    @FXML
    private void ajouterAnnonce(ActionEvent event) throws SQLException {
        Annonce s = new Annonce();
       if (feTitre.getText().trim().isEmpty() || feDescription.getText().trim().isEmpty()) {

          JOptionPane.showMessageDialog(null, "Champ vide.");
        }else{
        selected= listeSkills.getSelectionModel().getSelectedItem().getId();

        System.out.println(selected);
        s.setTitre(feTitre.getText());
        s.setDESCRIPTION(feDescription.getText());
        s.setSkills(selected);
        //s.setId_client(Integer.valueOf(idclient.getText()));
        s.setId_client(Client.idcnt);
        
        
        
        ServiceAnnonce sp = new ServiceAnnonce();
        try {
            sp.ajouterAnnonce2(s);
        } catch (SQLException ex) {
            Logger.getLogger(AjouterAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    @FXML
    private void returnhome(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("AfficherAnnonce.fxml"));
      
      
          tfreturn.getScene().setRoot(root1);
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
    

