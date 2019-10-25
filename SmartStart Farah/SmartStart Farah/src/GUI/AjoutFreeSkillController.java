/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Freelancerskills;
import Service.ServiceFreelancerskills;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AjoutFreeSkillController implements Initializable {

    @FXML
    private TextField tfSkill1;
    @FXML
    private TextField tfSkill2;
    @FXML
    private TextField tfSkill3;
    @FXML
    private TextField tfSkill4;
    @FXML
    private TextField tfSkill5;
    @FXML
    private TextField tfIdFreelancer;
    @FXML
    private Button Goo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void AjouterFreeS(ActionEvent event) {
        {
            Freelancerskills S = new Freelancerskills();
            S.setIdFreelancer(Integer.valueOf(tfIdFreelancer.getText()));
            S.setSkill1(Integer.valueOf(tfSkill1.getText()));
            S.setSkill2(Integer.valueOf(tfSkill2.getText()));
            S.setSkill3(Integer.valueOf(tfSkill3.getText()));
            S.setSkill4(Integer.valueOf(tfSkill4.getText()));
            S.setSkill5(Integer.valueOf(tfSkill5.getText()));

            ServiceFreelancerskills sf = new ServiceFreelancerskills();
            try {
                sf.AjouterFreeS(S);
            } catch (SQLException ex) {
                Logger.getLogger(AjouterController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void GoToAff(ActionEvent event)  throws MalformedURLException, IOException {
                       Parent root = FXMLLoader.load(getClass().getResource("AfficherFreeSkills.fxml"));
        
        Goo.getScene().setRoot(root);
    }

}
