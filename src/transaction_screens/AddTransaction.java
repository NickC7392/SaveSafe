package transaction_screens;

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

public class AddTransaction {
	
	private Pane layout;
	
	private Label pageTitle;
	private Label pageName;
	private Label pageInstruction;
	private Label transactionAmount;
	private Label dateReceived;
	private Label transactionDescription;
	private Label dollarSign;
	
	private Line separator;
	
	private TextField transactionField;
	private TextArea description;
	
	private DatePicker transactionDate;
	
	private ComboBox<?> transactionCategory; //TEMP
	
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
		transactionAmount.setLayoutX(200); //x coordinate
		transactionAmount.setLayoutY(260); //y coordinate
		transactionAmount.setStyle("-fx-font-size: 25px;" +
							  "-fx-text-fill: DARKSEAGREEN;");
		
		//Transaction amount text field
		transactionField = new TextField();
		transactionField.setPromptText("0.00"); //set prompt text
		//Styling
		transactionField.setFocusTraversable(false); //make it so text field is not selected by default
		transactionField.setAlignment(Pos.CENTER); //set text to center of TextField
		transactionField.setPrefSize(400, 75); //size of text field
		transactionField.setLayoutX(120); //x coordinate
		transactionField.setLayoutY(300); //y coordinate
		transactionField.setStyle("-fx-font-size: 25px;" +
							      "-fx-text-fill: BLACK;");
		
		// $ label
		dollarSign = new Label("$");
		//Styling
		dollarSign.setLayoutX(130); //x coordinate
		dollarSign.setLayoutY(315); //y coordinate
		dollarSign.setStyle("-fx-font-size: 30px;" +
							"-fx-font-weight: BOLD;" +
							"-fx-text-fill: BLACK;");
		
		//Date received label
		dateReceived = new Label("Date Received:");
		//Styling
		dateReceived.setLayoutX(795); //x coordinate
		dateReceived.setLayoutY(260); //y coordinate
		dateReceived.setStyle("-fx-font-size: 25px;" +
							  "-fx-text-fill: DARKSEAGREEN;");
		
		//Date picker
		transactionDate = new DatePicker();
		transactionDate.setPromptText("Select a date"); //prompt text
		//Styling
		transactionDate.setPrefSize(400, 75); //size of DatePicker
		transactionDate.getEditor().setAlignment(Pos.CENTER); //centers text  within DatePicker
		transactionDate.setFocusTraversable(false); //make it so text field is not selected by default
		transactionDate.setLayoutX(680); //x coordinate
		transactionDate.setLayoutY(300); //y coordinate
		transactionDate.setStyle("-fx-font-size: 25px;" +
								 "-fx-text-fill: BLACK;");
		
		//Transaction details label
		transactionDescription = new Label("Description (Optional):");
		//Styling
		transactionDescription.setLayoutX(755); //x coordinate
		transactionDescription.setLayoutY(410); //y coordinate
		transactionDescription.setStyle("-fx-font-size: 25px;" +
									    "-fx-text-fill: DARKSEAGREEN;");
		
		//Description textfield
		description = new TextArea();
		//Styling
		description.setFocusTraversable(false); //make it so text field is not selected by default
		description.setWrapText(true);
		description.setPrefSize(400, 100); //size of text field
		description.setLayoutX(680); //x coordinate
		description.setLayoutY(450); //y coordinate
		description.setStyle("-fx-font-size: 25px;" +
							  "-fx-text-fill: BLACK;");
		
		//Transaction Category dropdown
		transactionCategory = new ComboBox<>();
		transactionCategory.setPromptText("Select Category:");
		//Styling
		transactionCategory.setPrefSize(400, 75);
		transactionCategory.setLayoutX(120);
		transactionCategory.setLayoutY(450);
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
									transactionCategory, dollarSign);
		
		
		
		
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
	


}
