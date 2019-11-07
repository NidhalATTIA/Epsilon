/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import Entite.Skills;
import Service.ServiceSkills;
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
public class AjouterSkillsController implements Initializable {

    @FXML
    private TextField tfSkill;
    @FXML
    private Button show;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterSkills(ActionEvent event) {
                Skills S  = new Skills();
        S.setSkill(tfSkill.getText());
         ServiceSkills ss = new ServiceSkills();
        try {
            ss.AjouterSkills(S);
        }
        catch (SQLException ex) {
            Logger.getLogger(AjouterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void GoToAffiche(ActionEvent event) throws MalformedURLException, IOException {
               Parent root = FXMLLoader.load(getClass().getResource("AfficherSkills.fxml"));
        
        show.getScene().setRoot(root);
    }

    }
    
