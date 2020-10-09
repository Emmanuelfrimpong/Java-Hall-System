package Controllers;

import Helper_Functions.helperFuctions;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author emman
 */
public class containerController implements Initializable {

    @FXML
    private ImageView btn_minimize;
    @FXML
    private ImageView btn_close;

    @FXML
    private StackPane container;
    private helperFuctions hf = new helperFuctions();
    @FXML
    private HBox pane;
    @FXML
    private Label btn_newAccount;
    @FXML
    private Text topTitle;

    private void getNewAccountPage() {
        hf.switchPage(container, "/Design/NewAccountPage.fxml", pane);
        topTitle.setText("SETUP");
    }

    private void getDefaultPage() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Design/LoginPage.fxml"));
            container.getChildren().remove(pane);
            container.getChildren().add(root);
        } catch (IOException ex) {
            Logger.getLogger(containerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getLoginPage() {
        topTitle.setText("SIGN IN");
        hf.switchPage(container, "/Design/LoginPage.fxml", pane);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        getDefaultPage();

        btn_minimize.setOnMouseClicked((Event event) -> {
            Stage thisStage = (Stage) btn_minimize.getScene().getWindow();
            thisStage.setIconified(true);
        });
        btn_close.setOnMouseClicked((Event event) -> {
            hf.closeWindow(event);
        });

        btn_newAccount.setOnMouseClicked((Event event) -> {
            if ("Sign In".equals(btn_newAccount.getText())) {
                btn_newAccount.setText("Setup Account");
                getLoginPage();
            } else {
                btn_newAccount.setText("Sign In");
                getNewAccountPage();
            }
        });

    }

}
