package application;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.stage.Stage;
import screens.MainMenu;

public class SafeSafeApp extends Application{
	
	public void start(Stage stage) {
		
		//creates main menu object from MainMenu class
		MainMenu main = new MainMenu();
		
		//uses getLayout method from MainMenu class to return its pane
		Scene scene = new Scene(main.getLayout(),1200,800);
	
		//sets scene to be displayed inside stage
		stage.setScene(scene);
		stage.show();

	}
	
	//launches application
	public static void main(String[] args) {
		launch(args);
	}


}
