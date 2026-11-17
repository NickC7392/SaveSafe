package transaction_screens;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;

import UserFeedback.AlertMessages;
import database.TransactionDB;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import objects.Transaction;


public class ViewTransaction {
	
	private Pane layout;
	
	private Label pageTitle;
	private Label pageName;
	private Label pageInstruction;
	
	private Line separator;
	
	private TableView<Transaction> transactionTable;
	
	private Button editTransaction;
	private Button deleteTransaction;
	private Button returnHome;
	
	public ViewTransaction() {
		
		//Layout
		layout = new Pane();
		//Styling
		layout.setStyle("-fx-background-color: #123D2A;");
		
		//Title for page label
		pageTitle = new Label("View Transactions");
		//Styling
		pageTitle.setFont(new Font(70));
		pageTitle.setPrefWidth(1200); //set width to whole screen
		pageTitle.setAlignment(Pos.CENTER); //align within whole screens width
		pageTitle.setStyle("-fx-text-fill: GOLDENROD; -fx-font-weight: BOLD;");
		
		//Name for page label
		pageName = new Label("Transaction");
		//Styling
		pageName.setFont(new Font(25));
		pageName.setStyle("-fx-text-fill: DARKSEAGREEN");
		pageName.setPrefWidth(1200); //set screenName box to width of whole window
		pageName.setAlignment(Pos.TOP_RIGHT); //move to top right of that width
		pageName.setLayoutX(-40); //make incremental adjustments
		pageName.setLayoutY(20);
		
		//Separation line
		separator = new Line(30,110,1170,110); //(x start, y start, x end, y end)
		//Styling
		separator.setStyle("-fx-stroke: WHITE"); //makes line white
		
		//Page instruction label
		pageInstruction = new Label("Manage Transaction Records");
		//Styling
		pageInstruction.setPrefWidth(1200); //sets width of label same size as whole screen
		pageInstruction.setAlignment(Pos.CENTER); //centers text within that width
		pageInstruction.setLayoutY(140); //y coordinate
		pageInstruction.setStyle("-fx-font-size: 35px;" + 
				  				 "-fx-text-fill: WHITE;" + 
								 "-fx-font-weight: BOLD;");
		
		//Transaction table
		transactionTable = new TableView<Transaction>();
		
		TableColumn<Transaction, BigDecimal> amountColumn = new TableColumn<>("Amount($)");
		amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
		amountColumn.setPrefWidth(225);
		amountColumn.setStyle("-fx-alignment: CENTER;" +
							  "-fx-font-size: 20px;" +
							  "-fx-font-weight: BOLD;");
		
		TableColumn<Transaction, String> categoryColumn = new TableColumn<>("Category");
		categoryColumn.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
		categoryColumn.setPrefWidth(225);
		categoryColumn.setStyle("-fx-alignment: CENTER;" +
							   "-fx-font-size: 20px;" +
							   "-fx-font-weight: BOLD;");
		
		TableColumn<Transaction, String> descriptionColumn = new TableColumn<>("Description");
		descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
		descriptionColumn.setPrefWidth(225);
		descriptionColumn.setStyle("-fx-alignment: CENTER;" +
							       "-fx-font-size: 20px;" +
							       "-fx-font-weight: BOLD;");
		
		TableColumn<Transaction, LocalDate> dateColumn = new TableColumn<>("Date");
		dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
		dateColumn.setPrefWidth(225);
		dateColumn.setStyle("-fx-alignment: CENTER;" +
							"-fx-font-size: 20px;" +
							"-fx-font-weight: BOLD;");
		
		transactionTable.getColumns().addAll(
				amountColumn,
				categoryColumn,
				descriptionColumn,
				dateColumn);
		
		 //Styling
		transactionTable.setPrefSize(900, 350); //size of incomeTable
		transactionTable.setLayoutX(150); //x coordinate
		transactionTable.setLayoutY(210); //y coordinate
		transactionTable.setStyle("-fx-background-color: #F1EBDD;");
		
		//Edit transaction button
		editTransaction = new Button("Edit Transaction");
		//Styling
		editTransaction.setPrefSize(260, 60); //size of editIncome button
		editTransaction.setLayoutX(320); //x coordinate
		editTransaction.setLayoutY(590); //y coordinate
		editTransaction.setStyle("-fx-background-color: GOLDENROD;" +
							"-fx-text-fill: #123D2A;" +
							"-fx-font-size: 25px;" +
							"-fx-font-weight: BOLD;" +
							"-fx-background-radius: 15px;"); //soft corners
		
		//Delete Transaction button
		deleteTransaction = new Button("Delete Transaction");
		//Styling
		deleteTransaction.setPrefSize(260,60); //size of deleteIncome button
		deleteTransaction.setLayoutX(620); //x coordinate
		deleteTransaction.setLayoutY(590); //y coordinate
		deleteTransaction.setStyle("-fx-background-color: #A94442;" +
							  "-fx-text-fill: WHITE;" +
							  "-fx-font-size: 25px;" +
							  "-fx-font-weight: BOLD;" +
							  "-fx-background-radius: 15px;"); //soft corners
		//functionality for deleteTransaction button
		deleteTransaction.setOnAction(e -> deleteSelectedTransaction());
		
		//Return to MainMenu button
		returnHome = new Button("Return Home");
		//Styling
		returnHome.setPrefSize(300, 60); //size of returnHome button
		returnHome.setLayoutX(450); //x coordinate
		returnHome.setLayoutY(680); //y coordinate
		returnHome.setStyle("-fx-background-color: #123D2A;" +
							"-fx-text-fill: WHITE;" +
							"-fx-font-size: 25px;" +
							"-fx-font-weight: BOLD;" +
							"-fx-background-radius: 15px;" + //soft corners
							"-fx-border-color: DARKSEAGREEN;" +
							"-fx-border-width: 2px;" +
							"-fx-border-radius: 15px;"); //soft corners		
		
		layout.getChildren().addAll(pageTitle, pageName, pageInstruction, separator, transactionTable,
									editTransaction, deleteTransaction, returnHome);	
				
	}
	
	//method to make layout accessible to application class
	public Pane getLayout() {
		return layout;
	}
		
	//make returnHome button accessible to application class for screen switching
	//ViewTransaction -> MainMenu 
	public Button getReturnHome() {
		return returnHome;
	}
	
	//make editTransaction button accessible to application class for screen switching
	//ViewTransaction -> EditTransaction
	public Button getEditTransaction() {
		return editTransaction;
	}
	//returns currently selected record inside of transactionTable
	//used for passing to editTransaction screen
	public Transaction getSelectedTransaction() {
		Transaction selectedTransaction = transactionTable.getSelectionModel().getSelectedItem();
		return selectedTransaction;
	}
	
	//load transaction records from sql into transactionTable
	public void loadTransactionRecords() {
		
		try {
			//create transactionDB object
			TransactionDB transactionDB = new TransactionDB();
			//retrieve transaction records and populate table
			transactionTable.setItems(FXCollections.observableArrayList(transactionDB.getAllTransaction()));
			
		  //catch DB errors
		} catch (SQLException  e) {
			//user feedback incase of SQL error
			AlertMessages.showAlert("Unable to retrieve transaction records.");
			//display error details in console
			e.printStackTrace();
			
		}	
	}
	
	//used for deleting transaction records from transactionTable with delete button
	public void deleteSelectedTransaction() {
		
		Transaction selectedTransaction = transactionTable.getSelectionModel().getSelectedItem();
		//checks to see if any record has been selected in transactionTable
		if(selectedTransaction == null) {
			//if not, pop up for feedback:
			AlertMessages.showAlert("Please select a transaction record to delete.");
			return;
		}
		//checks if user confirms delete (clicks delete button on alertMessage)
		if(AlertMessages.confirmDelete("Are you sure you want to delete this transaction record?")) {
			
			try {
				//create transactionDB object
				TransactionDB transactionDB = new TransactionDB();
				//deletes selected transaction record using ID
				transactionDB.deleteTransaction(selectedTransaction.getTransactionID());
				//reloads records in table to deleted record isn't there anymore
				loadTransactionRecords();
				//pop up for confirmation
				AlertMessages.showAlert("Transaction record successfully deleted.");
			  //catch DB errors
			} catch (SQLException e) {
				//pop up incase of DB error
				AlertMessages.showAlert("Unable to delete transaction record");
				//display db errors
				e.printStackTrace();
			}
		}	
	}
				

}
