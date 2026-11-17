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

public class AddTransaction {
	
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
	
	private Button saveTransaction;
	private Button returnHome;
	
	
	public AddTransaction() {
		
		//Layout
		layout = new Pane();
		//Styling
		layout.setStyle("-fx-background-color: #123D2A;");
		
		//Title for page label
		pageTitle = new Label("Add Transaction");
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
		pageInstruction = new Label("Enter Transaction Details");
		//Styling
		pageInstruction.setLayoutY(160); // y coordinate
		pageInstruction.setPrefWidth(1200); // set width to whole screen
		pageInstruction.setAlignment(Pos.CENTER); //align within whole screens width
		pageInstruction.setStyle("-fx-font-size: 35px;" + 
								 "-fx-text-fill: WHITE;" + 
								 "-fx-font-weight: BOLD;");
		
		//Transaction amount Label
		transactionAmount = new Label("Transaction Amount:");
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
		dateReceived = new Label("Date Received:");
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
		transactionDescription = new Label("Description (Optional):");
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
		category = new Label("Category:");
		//Styling
		category.setLayoutX(150);
		category.setLayoutY(400);
		category.setStyle("-fx-font-size: 25px;" +
						  "-fx-text-fill: DARKSEAGREEN;");
		
		//Transaction Category dropdown
		transactionCategory = new ComboBox<>();
		transactionCategory.setPromptText("Select Category:");
		//add categories to combobox (in same order as DB)
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
		
		//Save transaction button
		saveTransaction = new Button("Save Transaction");
		//Styling
		saveTransaction.setPrefSize(400, 60); //size of saveIncome button
		saveTransaction.setLayoutX(400); //x coordinate
		saveTransaction.setLayoutY(590); //y coordinate
		saveTransaction.setStyle("-fx-font-size: 25px;" +
							"-fx-font-weight: BOLD;" +
							"-fx-text-fill: #123D2A;" +
							"-fx-background-color: GOLDENROD;" +
							"-fx-background-radius: 15px;"); //soft corners for button
		
		saveTransaction.setOnAction(e -> saveTransaction());
			
		
		//return home button
		returnHome = new Button("Return Home");
		//Styling
		returnHome.setPrefSize(400, 60);
		returnHome.setLayoutX(400);
		returnHome.setLayoutY(680);
		returnHome.setStyle("-fx-font-size: 25px;" +
						"-fx-font-weight: BOLD;" +
						"-fx-text-fill: WHITE;" +
						"-fx-background-color: #123D2A;" +
						"-fx-border-color: DARKSEAGREEN;" +
						"-fx-border-width: 2px;" +
						"-fx-border-radius: 15px;" + //soft corners for border to match button
						"-fx-background-radius: 15px;"); //soft corners for button);
		
		layout.getChildren().addAll(pageTitle, pageName, pageInstruction, transactionAmount,
									separator, transactionField, transactionDate, saveTransaction,
									returnHome, dateReceived, description, transactionDescription,
									transactionCategory, dollarSign, category);
		
		
		
		
	}
	//method to make layout accessible to application class
	public Pane getLayout() {
		return layout;
	}
	//make returnHome button accessible to application class for screen switching
	//ViewIncome -> MainMenu navigation
	public Button getReturnHome() {
		return returnHome;
	}
	
	
	private void saveTransaction() {
		
		try {
			
			//checks if amount field is empty
			if(transactionField.getText().isEmpty()) {
				//pop up for user feedback
				AlertMessages.showAlert("Please enter a transaction amount.");
				return;
			}
			//convert amount into bigdecimal
			BigDecimal amount = new BigDecimal(transactionField.getText());
			
			//checks if amount is greater than 0
			if(amount.compareTo(BigDecimal.ZERO) <= 0) {
				//pop up for user feedback
				AlertMessages.showAlert("Transaction amount must be greater than $0.00.");
				return;
			}
			//gets selected category from dropdown
			String category = transactionCategory.getValue();
			//checks to see if category was selected
			if(category == null) {
				//pop up for user feedback
				AlertMessages.showAlert("Please seleect a transaction category.");
				return;
			}
			//gets categoryID based on dropdown (each category has unique ID in DB)
			int categoryID = transactionCategory.getSelectionModel().getSelectedIndex() + 1; //+1 since comboBox starts at index 0
			//optional description
			String transactionDescription = description.getText().trim();
			//sets description to null if left empty (since optional)
			if(transactionDescription.isEmpty()) {
				transactionDescription = null;
			}
			//gets selected date
			LocalDate date = transactionDate.getValue();
			//checks if user selected date
			if(date == null) {
				//pop up for user feedback
				AlertMessages.showAlert("Please select a transaction date.");
				return;
			}
			//create transaction object
			Transaction transaction = new Transaction(0, amount, categoryID, transactionDescription, date);
			//create DB object
			TransactionDB transactionDB = new TransactionDB();
			//save transaction object
			transactionDB.addTransaction(transaction);
			//pop up for user feedback
			AlertMessages.showAlert("Transaction successfully added.");
			
			//clear input fields after successful save
			transactionField.clear();
			transactionCategory.setValue(null);
			description.clear();
			transactionDate.setValue(null);
			
		  //catches when amount entered is not a valid number
		} catch (NumberFormatException e) {
			AlertMessages.showAlert("Please enter a valid transaction amount.");
		  //catches DB erroes
		} catch (SQLException e) {
			AlertMessages.showAlert("Unable to save transaction.");
			//display DB errors in console
			e.printStackTrace();
			
		}
		
		
	}
	


}
