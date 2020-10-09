package Main;

import Helper_Functions.helperFuctions;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author emman
 */
public class HallSystem extends Application {
    helperFuctions hf=new helperFuctions();
    
    @Override
    public void start(Stage stage) throws Exception {
       hf.showNormalStage("/Design/container.fxml");
    }

    public static void main(String[] args) {
        launch(args);
    }

}
