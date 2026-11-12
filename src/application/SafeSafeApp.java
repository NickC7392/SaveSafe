package application;

import UserFeedback.AlertMessages;
import home_screen.MainMenu;
import income_screens.AddIncome;
import income_screens.EditIncome;
import income_screens.ViewIncome;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import objects.Income;
import transaction_screens.AddTransaction;
import transaction_screens.EditTransaction;
import transaction_screens.ViewTransaction;


public class SafeSafeApp extends Application{
	
	public void start(Stage stage) {
		
		
		MainMenu main = new MainMenu();
		AddIncome addIncome = new AddIncome();
		ViewIncome viewIncome = new ViewIncome();
		EditIncome editIncome = new EditIncome();
		AddTransaction addTransaction = new AddTransaction();
		ViewTransaction viewTransaction = new ViewTransaction();
		EditTransaction editTransaction = new EditTransaction();

		
		//uses getLayout method from MainMenu class to return its pane
		Scene scene = new Scene(main.getLayout(),1200,800);
		
		//####################### INCOME SCREENS NAVIGATION ################################//
		
		//Add Income button in MainMenu; MainMenu -> AddIncome
		main.getAddIncome().setOnAction(e -> {
			scene.setRoot(addIncome.getLayout());
		});
		
		//Return Home button in AddIncome; AddIncome -> MainMenu
		addIncome.getReturnHome().setOnAction(e -> {
			scene.setRoot(main.getLayout());
		});
		
		//View Income button in MainMenu; MainMenu -> ViewIncome
		main.getViewIncome().setOnAction(e -> {
			viewIncome.loadIncomeRecords(); //loads income records to incomeTable every time screen opens
			scene.setRoot(viewIncome.getLayout());
		});
		
		//Return Home button in ViewIncome; ViewIncome -> MainMenu
		viewIncome.getReturnHome().setOnAction(e -> {
			scene.setRoot(main.getLayout());
		});
		
		//Edit button in ViewIncome; ViewIncome -> EditIncome
		viewIncome.getEditButton().setOnAction(e -> {
			//retrieves selected income record from incomeTable in viewIncome
			Income selectedIncome = viewIncome.getSelectedIncome();
			if(selectedIncome == null) {
				AlertMessages.showAlert("Please select an income record to edit.");
				return;
			}
			//loads selected income record from IncomeTable into editIncome screen
			editIncome.setIncome(selectedIncome);
			scene.setRoot(editIncome.getLayout());
			
		});
		
		//Save changes button in EditIncome; EditIncome -> ViewIncome
		//handles saving and returning to viewIncome
		editIncome.getSaveChangesButton().setOnAction(e -> {
			//saves changes and checks if update was successful
			if(editIncome.saveIncomeChanges()) {
				//refreshes incomeTable with updated record
				viewIncome.loadIncomeRecords();
				//returns to viewIncome screen
				scene.setRoot(viewIncome.getLayout());
			}
			
		});
		
		//Cancel button in EditIncome; EditIncome -> ViewIncome
		editIncome.getCancelButton().setOnAction(e -> {
			scene.setRoot(viewIncome.getLayout());
		});
		
		//####################### TRANSACTION SCREENS NAVIGATION ################################//
		
		//Add Transaction button in MainMenu; MainMenu -> AddTransaction
		main.getAddTransaction().setOnAction(e -> {
			scene.setRoot(addTransaction.getLayout());
		});
		
		//Return Home button in AddTransaction; AddTransaction -> MainMenu
		addTransaction.getReturnHome().setOnAction(e -> {
			scene.setRoot(main.getLayout());
		});
		
		//View Transaction button in MainMenu; MainMenu -> ViewTransaction
		main.getViewTransaction().setOnAction(e -> {
			scene.setRoot(viewTransaction.getLayout());
		});
		
		//Return Home button in ViewTransaction; ViewTransaction -> MainMenu
		viewTransaction.getReturnHome().setOnAction(e -> {
			scene.setRoot(main.getLayout());
		});
		
		//Edit button in ViewTransaction; ViewTransaction -> EditTransaction
		viewTransaction.getEditTransaction().setOnAction(e -> {
			scene.setRoot(editTransaction.getLayout());
		});
		
		//Cancel button in EditTransaction; EditTransaction -> ViewTransaction
		editTransaction.getCancelButton().setOnAction(e -> {
			scene.setRoot(viewTransaction.getLayout());
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
