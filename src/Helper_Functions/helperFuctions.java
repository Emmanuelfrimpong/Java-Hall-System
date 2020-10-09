package Helper_Functions;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author emman
 */
public class helperFuctions {

    private static double xOffset = 0;
    private static double yOffset = 0;
    
    public void openFullPage(String path,ActionEvent event){
        Node node = (Node) event.getSource();
            Stage oldStage = (Stage) node.getScene().getWindow();
            oldStage.hide();
            Parent root;
             try {
                root = FXMLLoader.load(getClass().getResource(path));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initStyle(StageStyle.UNDECORATED);
                stage.initStyle(StageStyle.TRANSPARENT);
                scene.setFill(Color.TRANSPARENT);
                Screen screen = Screen.getPrimary();
                Rectangle2D bounds = screen.getVisualBounds();
                stage.setX(bounds.getMinX());
                stage.setY(bounds.getMinY());
                stage.setWidth(bounds.getWidth());
                stage.setHeight(bounds.getHeight());
                stage.setResizable(false);
                stage.setScene(scene);
                stage.show();
                Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
                stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
                stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
            } catch (IOException ex) {
                 Logger.getLogger(helperFuctions.class.getName()).log(Level.SEVERE, null, ex);
            }
               
    } 

    public void showNormalStage(String path) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource(path));
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.initStyle(StageStyle.UNDECORATED);
            root.setOnMousePressed((MouseEvent event) -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });
            root.setOnMouseDragged((MouseEvent event) -> {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            });
            Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();
            stage.setX((bounds.getWidth() - stage.getWidth()) / 2);
            stage.setY((bounds.getHeight() - stage.getHeight()) / 2);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(helperFuctions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
    public void switchPage(StackPane container,String path,HBox pane){
         container.getChildren().clear();
        try {
         Parent root = FXMLLoader.load(getClass().getResource(path));
         Scene scene = container.getScene();
        root.translateYProperty().set(scene.getHeight());
        container.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
           
        });
        timeline.play();
        } catch (IOException ex) {
            Logger.getLogger(helperFuctions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        public void closeWindow(Event event){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to quit the System?", ButtonType.YES, ButtonType.NO);
            alert.setHeaderText(null);
            alert.setGraphic(null);
            alert.initStyle(StageStyle.UTILITY);
            alert.getDialogPane().getStylesheets().add("/Style/dialogPage.css");
            alert.getDialogPane().setMinSize(400, 100);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.close();
            } else {
                alert.close();
            }
            
        }
        
        
        public boolean login(String person){
            boolean successful=false;
            if(null!=person)switch (person) {
            case "Administrator":
                //login into adminstrator here
                successful=true;
                break;
            case "Secretary":
                //login into secretariet here
                successful=true;
                break;
            case "Financial Officer":
                //login into financial office
                successful=true;
                break;
            case "Hall Assistant":
                //login into hall assistant
                successful=true;
                break;
            default:
                break;
        }
            
            return successful;
        }

}
