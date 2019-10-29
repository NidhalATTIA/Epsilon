/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Freelancerskills;
import Service.ServiceFreelancerskills;
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
public class AfficherFreeSkillsController implements Initializable {

    @FXML
    private TableView<Freelancerskills> table;
    @FXML
    private TableColumn<Freelancerskills, Number> tfIdFreelancer;
    @FXML
    private TableColumn<Freelancerskills, Number> tfSkill1;
    @FXML
    private TableColumn<Freelancerskills, Number> tfSkill2;
    @FXML
    private TableColumn<Freelancerskills, Number> tfSkill3;
    @FXML
    private TableColumn<Freelancerskills, Number> tfSkill4;
    @FXML
    private TableColumn<Freelancerskills, Number> tfSkill5;
        private ObservableList<Freelancerskills> data = FXCollections.observableArrayList();
    List<Freelancerskills> st = new ArrayList<>();
    @FXML
    private Button Go;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                ServiceFreelancerskills sf = new ServiceFreelancerskills();
        try {
            st = sf.readAllF();
            data.addAll(st);
            tfIdFreelancer.setCellValueFactory(new PropertyValueFactory<>("IdFreelancer"));
            tfSkill1.setCellValueFactory(new PropertyValueFactory<>("Skill1"));
            tfSkill2.setCellValueFactory(new PropertyValueFactory<>("Skill2"));
            tfSkill3.setCellValueFactory(new PropertyValueFactory<>("Skill3"));
            tfSkill4.setCellValueFactory(new PropertyValueFactory<>("Skill4"));
            tfSkill5.setCellValueFactory(new PropertyValueFactory<>("Skill5"));

            table.setItems(data);

        } catch (SQLException ex) {
            Logger.getLogger(AfficherController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void GoToAdmin(ActionEvent event) throws IOException{
         Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        
        
        Go.getScene().setRoot(root);
    }
    
    
}
