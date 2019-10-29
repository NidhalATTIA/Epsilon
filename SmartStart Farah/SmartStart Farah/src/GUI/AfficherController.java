/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Freelancer;
import Service.ServiceFreelancer;
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AfficherController implements Initializable {

    @FXML
    private TableColumn<Freelancer, Number> tfID;
    @FXML
    private TableColumn<Freelancer, String> tfNom;
    @FXML
    private TableColumn<Freelancer, String> tfPrenom;
    @FXML
    private TableColumn<Freelancer, String> tfEmail;
    @FXML
    private TableColumn<Freelancer, String> tfMotDePasse;
    @FXML
    private TableColumn<Freelancer, String> tfNationalite;
    @FXML
    private TableColumn<Freelancer, String> tfCV;
    @FXML
    private TableColumn<Freelancer, String> tfDescription;
    @FXML
    private TableView<Freelancer> table;

    private ObservableList<Freelancer> data = FXCollections.observableArrayList();
    List<Freelancer> st = new ArrayList<>();
    @FXML
    private Button del;
    @FXML
    private Button Go;
    @FXML
    private Button Go2;
    @FXML
    private Button ed;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ServiceFreelancer sf = new ServiceFreelancer();
        try {
            st = sf.readAll();
            data.addAll(st);
            tfID.setCellValueFactory(new PropertyValueFactory<>("ID"));
            tfNom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
            tfPrenom.setCellValueFactory(new PropertyValueFactory<>("Prenom"));
            tfEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
            tfMotDePasse.setCellValueFactory(new PropertyValueFactory<>("MotDePasse"));
            tfNationalite.setCellValueFactory(new PropertyValueFactory<>("Nationalite"));
            tfCV.setCellValueFactory(new PropertyValueFactory<>("CV"));
            tfDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));

            table.setItems(data);

        } catch (SQLException ex) {
            Logger.getLogger(AfficherController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    /*private void SupprimerFree(ActionEvent event) throws IOException{
                Parent root = FXMLLoader.load(getClass().getResource("Supprimer.fxml"));
        
        
        del.getScene().setRoot(root);
       
 
        

    }*/

    @FXML
    private void GoToSupprimer(ActionEvent event)throws IOException {
                        Parent root = FXMLLoader.load(getClass().getResource("Supprimer.fxml"));
        
        
        del.getScene().setRoot(root);
    }

    @FXML
    private void GoToAdmin(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        
        
        Go.getScene().setRoot(root);
    }

    @FXML
    private void GoToAjout(ActionEvent event) throws IOException{
              Parent root = FXMLLoader.load(getClass().getResource("Ajouter.fxml"));
        
        
        Go2.getScene().setRoot(root);
    }

    @FXML
    private void GoToMod(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Modifier.fxml"));
        
        
        ed.getScene().setRoot(root);
    }

}
