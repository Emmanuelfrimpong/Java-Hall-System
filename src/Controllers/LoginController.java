package Controllers;

import Helper_Functions.helperFuctions;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author emman
 */
public class LoginController implements Initializable {

    @FXML
    private StackPane container;
    @FXML
    private HBox pane;
    @FXML
    private VBox Pane;
    @FXML
    private JFXTextField tf_uid;
    @FXML
    private Label uid_error;
    @FXML
    private JFXPasswordField tf_password;
    @FXML
    private Label pass_error;
    @FXML
    private JFXButton btn_login;

    
    private helperFuctions hf = new helperFuctions();
    @FXML
    private JFXComboBox<String> cmb_category;
    private void _default(){
         cmb_category.getItems().addAll(
                "Administrator",
                "Secretary",
                "Financial Officer",
                "Hall Assistant");
        cmb_category.getSelectionModel().select(0);
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        _default();
        
        btn_login.setOnAction((ActionEvent event) -> {
            if(hf.login(cmb_category.getValue())){
                
            }
        });
    }

}
