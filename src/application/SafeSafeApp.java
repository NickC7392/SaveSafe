package application;

import home_screen.MainMenu;
import income_screens.AddIncome;
import income_screens.ViewIncome;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class SafeSafeApp extends Application{
	
	public void start(Stage stage) {
		
		//creates main menu object from MainMenu class
		MainMenu main = new MainMenu();
		AddIncome addIncome = new AddIncome();
		ViewIncome viewIncome = new ViewIncome();
		
		
		//uses getLayout method from MainMenu class to return its pane
		Scene scene = new Scene(main.getLayout(),1200,800);
		
		//connects AddIncome screen to Add Income button in MainMenu
		main.getAddIncome().setOnAction(e -> {
			scene.setRoot(addIncome.getLayout());
		});
		
		//connects MainMenu screen to cancel button in AddIncome
		addIncome.getCancelButton().setOnAction(e -> {
			scene.setRoot(main.getLayout());
		});
		
		//connects ViewIncome screen to View Income button in MainMenu
		main.getViewIncome().setOnAction(e -> {
			scene.setRoot(viewIncome.getLayout());
		});
		
		viewIncome.getReturnHome().setOnAction(e -> {
			scene.setRoot(main.getLayout());
		});
		
		//sets scene to be displayed inside stage
		stage.setScene(scene);
		stage.show();

	}
	
	//launches application
	public static void main(String[] args) {
		launch(args);
	}


}
