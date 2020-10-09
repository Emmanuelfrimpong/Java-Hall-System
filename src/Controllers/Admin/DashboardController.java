package Controllers.Admin;

import Helper_Functions.helperFuctions;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Fuse Koda
 */
public class DashboardController implements Initializable {

    @FXML
    private ImageView btn_minimize;
    @FXML
    private ImageView btn_close;
    @FXML
    private StackPane container;
    private helperFuctions hf = new helperFuctions();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        btn_minimize.setOnMouseClicked((Event event) -> {
            Stage thisStage = (Stage) btn_minimize.getScene().getWindow();
            thisStage.setIconified(true);
        });
        btn_close.setOnMouseClicked((Event event) -> {
            hf.closeWindow(event);
        });

    }

}
