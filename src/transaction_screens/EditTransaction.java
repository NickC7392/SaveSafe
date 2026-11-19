package transaction_screens;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;

import UserFeedback.AlertMessages;
import database.TransactionDB;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import objects.Transaction;

public class EditTransaction {
	
	private Pane layout;
	
	private Label pageTitle;
	private Label pageName;
	private Label pageInstruction;
	private Label transactionAmount;
	private Label dateReceived;
	private Label transactionDescription;
	private Label dollarSign;
	private Label category;
	
	private Line separator;
	
	private TextField transactionField;
	private TextArea description;
	
	private DatePicker transactionDate;
	
	private ComboBox<String> transactionCategory; //TEMP
	
	private Button saveChanges;
	private Button cancel;
	
	private Transaction selectedTransaction;
	
	
	public EditTransaction() {
		
		//Layout
		layout = new Pane();
		//Styling
		layout.setStyle("-fx-background-color: #123D2A;");
		
		//Title for page label
		pageTitle = new Label("Edit Transaction");
		//Styling
		pageTitle.setFont(new Font(70));
		pageTitle.setPrefWidth(1200); //set width to whole screen
		pageTitle.setAlignment(Pos.CENTER); //align within whole screens width
		pageTitle.setStyle("-fx-text-fill: GOLDENROD; -fx-font-weight: BOLD;");
		
		//page name label (top right)
		pageName = new Label("Transaction");
		//Styling
		pageName.setFont(new Font(25));
		pageName.setStyle("-fx-text-fill: DARKSEAGREEN");
		pageName.setPrefWidth(1200); //set screenName box to width of whole window
		pageName.setAlignment(Pos.TOP_RIGHT); //move to top right of that width
		pageName.setLayoutX(-40); //make incremental adjustments
		pageName.setLayoutY(20); // ^^
		
		//Separation line
		separator = new Line(30,110,1170,110); //(x start, y start, x end, y end)
		//Styling
		separator.setStyle("-fx-stroke: WHITE"); //makes line white
		
		//Enter transaction details label
		pageInstruction = new Label("Update Selected Transaction Record");
		//Styling
		pageInstruction.setLayoutY(160); // y coordinate
		pageInstruction.setPrefWidth(1200); // set width to whole screen
		pageInstruction.setAlignment(Pos.CENTER); //align within whole screens width
		pageInstruction.setStyle("-fx-font-size: 35px;" + 
								 "-fx-text-fill: WHITE;" + 
								 "-fx-font-weight: BOLD;");
		
		//Transaction amount Label
		transactionAmount = new Label("Update Transaction Amount:");
		//Styling
		transactionAmount.setLayoutX(150); //x coordinate
		transactionAmount.setLayoutY(250); //y coordinate
		transactionAmount.setStyle("-fx-font-size: 25px;" +
							  "-fx-text-fill: DARKSEAGREEN;");
		
		//Transaction amount text field
		transactionField = new TextField();
		transactionField.setPromptText("0.00"); //set prompt text
		//Styling
		transactionField.setFocusTraversable(false); //make it so text field is not selected by default
		transactionField.setAlignment(Pos.CENTER); //set text to center of TextField
		transactionField.setPrefSize(400, 75); //size of text field
		transactionField.setLayoutX(150); //x coordinate
		transactionField.setLayoutY(290); //y coordinate
		transactionField.setStyle("-fx-font-size: 25px;" +
							      "-fx-text-fill: BLACK;");
		
		// $ label
		dollarSign = new Label("$");
		//Styling
		dollarSign.setLayoutX(155); //x coordinate
		dollarSign.setLayoutY(303); //y coordinate
		dollarSign.setStyle("-fx-font-size: 30px;" +
							"-fx-font-weight: BOLD;" +
							"-fx-text-fill: BLACK;");
		
		//Date received label
		dateReceived = new Label("Update Transaction Date:");
		//Styling
		dateReceived.setLayoutX(650); //x coordinate
		dateReceived.setLayoutY(250); //y coordinate
		dateReceived.setStyle("-fx-font-size: 25px;" +
							  "-fx-text-fill: DARKSEAGREEN;");
		
		//Date picker
		transactionDate = new DatePicker();
		transactionDate.setPromptText("Select a date"); //prompt text
		//Styling
		transactionDate.setPrefSize(400, 75); //size of DatePicker
		transactionDate.getEditor().setAlignment(Pos.CENTER); //centers text  within DatePicker
		transactionDate.setFocusTraversable(false); //make it so text field is not selected by default
		transactionDate.setLayoutX(650); //x coordinate
		transactionDate.setLayoutY(290); //y coordinate
		transactionDate.setStyle("-fx-font-size: 25px;" +
								 "-fx-text-fill: BLACK;");
		
		//Transaction details label
		transactionDescription = new Label("Update Description (Optional):");
		//Styling
		transactionDescription.setLayoutX(650); //x coordinate
		transactionDescription.setLayoutY(400); //y coordinate
		transactionDescription.setStyle("-fx-font-size: 25px;" +
									    "-fx-text-fill: DARKSEAGREEN;");
		
		//Description textfield
		description = new TextArea();
		//Styling
		description.setFocusTraversable(false); //make it so text field is not selected by default
		description.setWrapText(true);
		description.setPrefSize(400, 100); //size of text field
		description.setLayoutX(650); //x coordinate
		description.setLayoutY(440); //y coordinate
		description.setStyle("-fx-font-size: 25px;" +
							  "-fx-text-fill: BLACK;");
		
		//Category label
		category = new Label("Update Category:");
		//Styling
		category.setLayoutX(150);
		category.setLayoutY(400);
		category.setStyle("-fx-font-size: 25px;" +
						  "-fx-text-fill: DARKSEAGREEN;");
		
		//Transaction Category dropdown
		transactionCategory = new ComboBox<String>();
		transactionCategory.setPromptText("Select Category:");
		transactionCategory.getItems().addAll(
				"Food",
				"Bills",
				"Memberships",
				"Transportation",
				"Shopping",
				"Entertainment",
				"Other");
		//Styling
		transactionCategory.setPrefSize(400, 75);
		transactionCategory.setLayoutX(150);
		transactionCategory.setLayoutY(440);
		transactionCategory.setStyle("-fx-font-size: 25px;" +
									 "-fx-text-fill: BLACK;" +
									 "-fx-alignment: CENTER;");
		
		//save changes button
		saveChanges = new Button("Save Changes");
		//styling
		saveChanges.setPrefSize(200, 60); //size of saveIncome button
		saveChanges.setLayoutX(382.5); //x coordinate
		saveChanges.setLayoutY(600); //y coordinate
		saveChanges.setStyle("-fx-font-size: 25px;" +
							"-fx-font-weight: BOLD;" +
							"-fx-text-fill: #123D2A;" +
							"-fx-background-color: GOLDENROD;" +
							"-fx-background-radius: 15px;"); //soft corners for button		
		
		//cancel button
		cancel = new Button("Cancel");
		//styling
		cancel.setPrefSize(200, 60); //size of cancel button
		cancel.setLayoutX(617.5); //x coordinate
		cancel.setLayoutY(600); //y coordinate
		cancel.setStyle("-fx-font-size: 25px;" +
						"-fx-font-weight: BOLD;" +
						"-fx-text-fill: WHITE;" +
						"-fx-background-color: #123D2A;" +
						"-fx-border-color: DARKSEAGREEN;" +
						"-fx-border-width: 2px;" +
						"-fx-border-radius: 15px;" + //soft corners for border to match button
						"-fx-background-radius: 15px;"); //soft corners for button
		
		
		layout.getChildren().addAll(pageTitle, pageName, pageInstruction, transactionAmount, dateReceived, transactionDescription,
									category, separator, transactionField, description, transactionDate, transactionCategory,
									saveChanges, cancel, dollarSign);

		
		
		
	}
	//method to make layout accessible to application class
	public Pane getLayout() {
		return layout;
	}
	//make cancel button accessible to application class for screen switching
	//EditTransaction -> ViewTransaction
	public Button getCancelButton() {
		return cancel;
	}
	//makes saveChanges button accessible to application class for screen switching
	public Button getSaveChangesButton() {
		return saveChanges;
	}
	//loads selected transaction from transactionTable into edit fields
	public void setTransaction(Transaction transaction) {
		//stores selected transaction record
		selectedTransaction = transaction;
		
		transactionField.setText(transaction.getAmount().toString()); //displays selected amount
		transactionDate.setValue(transaction.getDate()); //displays selected date
		transactionCategory.setValue(transaction.getCategoryName()); //displays selected category
		description.setText(transaction.getDescription()); //displays selecteddescription (if any)
		
	}
	//saves changes to selected transaction record
	public boolean saveTransactionChanges() {
		
		try{
			//checks if transaction amount field is empty
			if(transactionField.getText().isEmpty()) {
				AlertMessages.showAlert("Please enter a new transaction amount.");
				return false;
			}
			//retrieves selected amount
			BigDecimal amount = new BigDecimal(transactionField.getText());
			//retrieves selected date from datePicker
			LocalDate date = transactionDate.getValue();
			//retrieves selected category fromn comboBox
			int categoryID = transactionCategory.getSelectionModel().getSelectedIndex() + 1;
			//retrieves selected description and trims off unwanted space
			String description = this.description.getText().trim();
			
			//checks if transaction amount is greater than 0
			if(amount.compareTo(BigDecimal.ZERO) <= 0) {
				AlertMessages.showAlert("Amount must be greater than $0.00.");
				return false;
			}
			//checks if date field is empty
			if(date == null) {
				AlertMessages.showAlert("Please select a new transaction date.");
				return false;
			}
			//checks if combobox has anything selected
			if(transactionCategory.getValue() == null) {
				AlertMessages.showAlert("Please select a new transaction category.");
				return false;
			}
			//checks for null or empty string description
			if(description.isEmpty()) {
				description = null;
			}
				
			//updates selectedTransaction with newly entered info
			selectedTransaction.setAmount(amount);
			selectedTransaction.setDate(date);
			selectedTransaction.setCategoryID(categoryID);
			selectedTransaction.setCategoryName(transactionCategory.getValue());
			selectedTransaction.setDescription(description);
			
			//create transactionDB object
			TransactionDB transactionDB = new TransactionDB();
			//updates selected transaction record in DB
			transactionDB.updateTransaction(selectedTransaction);
			
			AlertMessages.showAlert("Transaction record successfully updated.");
			
			return true;
			
			
		  //handles invalid input (ex. abc)
		} catch (NumberFormatException e) {
			
			AlertMessages.showAlert("Please enter a valid transaction amount.");
			return false;
		  //handles DB errors
		} catch (SQLException e) {
			
			AlertMessages.showAlert("Unable to update transaction record.");
			e.printStackTrace();
			return false;
			
		}
		
		
	}
		
		
		
		
}
	


