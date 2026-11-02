package UserFeedback;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;

public class AlertMessages {

    public static void showAlert(String message) {
    	
    	//create alert object
        Alert alert = new Alert(Alert.AlertType.NONE);
        
        //sets message (done when setting alert)
        alert.setContentText(message);
        
        //adds OK button
        alert.getButtonTypes().add(ButtonType.OK);
        
        //retrieve dialogPane (needed to styling)
        DialogPane pane = alert.getDialogPane();
        
        //pane styling
        pane.setStyle("-fx-background-color: #123D2A;" +
        			  "-fx-padding: 20px;");
        
        //message styling
        pane.lookup(".content.label").setStyle("-fx-text-fill: DARKSEAGREEN; " +
        									   "-fx-alignment: CENTER;" +
        									  "-fx-font-size: 16px;" +
        									  "-fx-font-weight: BOLD;");
        //Ok button styling
        pane.lookupButton(ButtonType.OK).setStyle("-fx-background-color: GOLDENROD;" +
        									  	  "-fx-text-fill: #123D2A;" +
        										  "-fx-font-size: 14px;" +
        									  	  "-fx-font-weight: BOLD;" +
        										  "-fx-background-radius: 10px;");

        
        //displays pop up and waits for OK button to be pressed
        alert.showAndWait();
    }
}