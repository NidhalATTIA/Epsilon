/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Skills;
import Service.ServiceSkills;
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
public class AfficherSkillsController implements Initializable {

    @FXML
    private TableView<Skills> table1;
    @FXML
    private TableColumn<Skills, String> tfSkill;
       private ObservableList<Skills> data = FXCollections.observableArrayList();
    List<Skills> st = new ArrayList<>();
    @FXML
    private TableColumn<Skills, Number> tfID;
    @FXML
    private Button back;
    @FXML
    private Button choose;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                ServiceSkills sf = new ServiceSkills();
        try {
            st = sf.readAllS();
            data.addAll(st);
            tfSkill.setCellValueFactory(new PropertyValueFactory<>("Skill"));
             tfID.setCellValueFactory(new PropertyValueFactory<>("ID"));


            table1.setItems(data);

        } catch (SQLException ex) {
            Logger.getLogger(AfficherController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void BackToAdd(ActionEvent event) throws IOException {
                            Parent root = FXMLLoader.load(getClass().getResource("AjouterSkills.fxml"));
        
        
        back.getScene().setRoot(root);
    }

    @FXML
    private void GoToSkill(ActionEvent event) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("AjoutFreeSkill.fxml"));
        
        
        choose.getScene().setRoot(root);
    }
    
    }    
    
