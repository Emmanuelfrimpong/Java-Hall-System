package Controllers;

import Helper_Functions.helperFuctions;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author emman
 */
public class NewAccount_Controller implements Initializable {

    private helperFuctions hf = new helperFuctions();
    @FXML
    private StackPane container;
    @FXML
    private HBox pane;
    @FXML
    private VBox Pane;
    @FXML
    private JFXComboBox<String> cmb_category;
    @FXML
    private JFXTextField tf_uid;
    @FXML
    private Label system_id_error;
    @FXML
    private JFXTextField tf_password;
    @FXML
    private Label uid_error;
    @FXML
    private JFXTextField tf_uid1;
    @FXML
    private Label name_error;
    @FXML
    private Label pass_error;
    @FXML
    private Label confirm_error;
    @FXML
    private JFXButton btn_create;

    private void _default() {
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

    }

}
