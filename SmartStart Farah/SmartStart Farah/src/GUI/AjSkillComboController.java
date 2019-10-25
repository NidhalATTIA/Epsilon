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
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AjSkillComboController implements Initializable {

    @FXML
    private ComboBox<String> C1;
    @FXML
    private ComboBox<String> C2;
    @FXML
    private ComboBox<String> C3;
    @FXML
    private ComboBox<String> C4;
    @FXML
    private ComboBox<String> C5;
ObservableList<String> list = FXCollections.observableArrayList("JAVA","php","web","JEE","python");

/**
     * Initializes the controller class.
     */
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        C1.setItems(list);
        C2.setItems(list);
        C3.setItems(list);
        C4.setItems(list);
        C5.setItems(list);
    }    
    
}
