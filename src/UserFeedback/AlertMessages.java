package UserFeedback;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;

public class AlertMessages {

    public static void showAlert(String message) {
    	
        Alert alert = new Alert(Alert.AlertType.NONE);
        
        //sets message (done when setting alert)
        alert.setContentText(message);
        
        //adds OK button
        alert.getButtonTypes().add(ButtonType.OK);
        
        DialogPane pane = alert.getDialogPane();
        
        //styling
        pane.setStyle("-fx-background-color: #123D2A;");
        pane.lookup(".content.label").setStyle("-fx-text-fill: GOLDENROD; " +
        									  "-fx-font-size: 16px;" +
        									  "-fx-font-weight: BOLD;");
        pane.lookupButton(ButtonType.OK).setStyle("-fx-background-color: GOLDENROD;" +
        									  	  "-fx-text-fill: #123D2A;" +
        										  "-fx-font-size: 14px;" +
        									  	  "-fx-font-weight: BOLD;" +
        										  "-fx-background-radius: 10px;");
              
        
        //displays pop up and waits for OK button to be pressed
        alert.showAndWait();
    }
}