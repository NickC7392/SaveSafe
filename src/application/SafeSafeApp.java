package application;

import home_screen.MainMenu;

import income_screens.AddIncome;
import income_screens.ViewIncome;
import income_screens.EditIncome;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class SafeSafeApp extends Application{
	
	public void start(Stage stage) {
		
		
		MainMenu main = new MainMenu();
		AddIncome addIncome = new AddIncome();
		ViewIncome viewIncome = new ViewIncome();
		EditIncome editIncome = new EditIncome();

		
		//uses getLayout method from MainMenu class to return its pane
		Scene scene = new Scene(main.getLayout(),1200,800);
		
		//Add Income button in MainMenu; MainMenu -> AddIncome
		main.getAddIncome().setOnAction(e -> {
			scene.setRoot(addIncome.getLayout());
		});
		
		//Cancel Button in AddIncome; AddIncome -> MainMenu
		addIncome.getCancelButton().setOnAction(e -> {
			scene.setRoot(main.getLayout());
		});
		
		//View Income button in MainMenu; MainMenu -> ViewIncome
		main.getViewIncome().setOnAction(e -> {
			scene.setRoot(viewIncome.getLayout());
		});
		
		//Return Home button in ViewIncome; ViewIncome -> MainMenu
		viewIncome.getReturnHome().setOnAction(e -> {
			scene.setRoot(main.getLayout());
		});
		
		//Edit button in ViewIncome; ViewIncome -> EditIncome
		viewIncome.getEditButton().setOnAction(e -> {
			scene.setRoot(editIncome.getLayout());
		});
		
		editIncome.getCancelButton().setOnAction(e -> {
			scene.setRoot(viewIncome.getLayout());
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
