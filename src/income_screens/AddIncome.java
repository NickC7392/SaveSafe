package income_screens;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

public class AddIncome {
	
	private Pane layout;
	
	private Label pageTitle;
	private Label pageName;
	private Label pageInstruction;
	private Label incomeAmount;
	private Label dateReceived;
	
	private Line separator;
	
	private TextField incomeField;
	
	private DatePicker incomeDate;
	
	private Button saveIncome;
	private Button cancel;
	
	
	public AddIncome() {
		
		//Layout
		layout = new Pane();
		
		//Styling
		layout.setStyle("-fx-background-color: #123D2A;");
		
		//Title for page label
		pageTitle = new Label("Add Income");
		
		//Styling
		pageTitle.setFont(new Font(70));
		pageTitle.setPrefWidth(1200); //set width to whole screen
		pageTitle.setAlignment(Pos.CENTER); //align within whole screens width
		pageTitle.setStyle("-fx-text-fill: GOLDENROD; -fx-font-weight: BOLD;");
		
		//page name label (top right)
		pageName = new Label("Income");
		
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
		
		//Enter income details label
		pageInstruction = new Label("Enter Income Details");
		
		//Styling
		pageInstruction.setLayoutY(160); // y coordinate
		pageInstruction.setPrefWidth(1200); // set width to whole screen
		pageInstruction.setAlignment(Pos.CENTER); //align within whole screens width
		pageInstruction.setStyle("-fx-font-size: 35px;" + 
								 "-fx-text-fill: WHITE;" + 
								 "-fx-font-weight: BOLD;");
		
		//Income amount Label
		incomeAmount = new Label("Income Amount:");
		
		//Styling
		incomeAmount.setLayoutX(400); //x coordinate
		incomeAmount.setLayoutY(260); //y coordinate
		incomeAmount.setStyle("-fx-font-size: 25px;" +
							  "-fx-text-fill: DARKSEAGREEN;");
			
		
		//Income amount text field
		incomeField = new TextField();
		incomeField.setPromptText("0.00"); //set prompt text
		
		//Styling
		incomeField.setFocusTraversable(false); //make it so text field is not selected by default
		incomeField.setAlignment(Pos.CENTER); //set text to center of TextField
		incomeField.setPrefSize(400, 75); //size of text field
		incomeField.setLayoutX(400); //x coordinate
		incomeField.setLayoutY(300); //y coordinate
		incomeField.setStyle("-fx-font-size: 25px;" +
							  "-fx-text-fill: BLACK;");
		
		//Date received label
		dateReceived = new Label("Date Received:");
		
		//Styling
		dateReceived.setLayoutX(400); //x coordinate
		dateReceived.setLayoutY(435); //y coordinate
		dateReceived.setStyle("-fx-font-size: 25px;" +
							  "-fx-text-fill: DARKSEAGREEN;");
		
		//Date picker
		incomeDate = new DatePicker();
		incomeDate.setPromptText("Select a date"); //prompt text
		
		//Styling
		incomeDate.setPrefSize(400, 75); //size of DatePicker
		incomeDate.getEditor().setAlignment(Pos.CENTER); //centers text  within DatePicker
		incomeDate.setLayoutX(400); //x coordinate
		incomeDate.setLayoutY(475); //y coordinate
		incomeDate.setStyle("-fx-font-size: 25px;" +
							"-fx-text-fill: BLACK;");
		

		//Save income button
		saveIncome = new Button("Save Income");
		
		//Styling
		saveIncome.setPrefSize(185, 60); //size of saveIncome button
		saveIncome.setLayoutX(400); //x coordinate
		saveIncome.setLayoutY(600); //y coordinate
		saveIncome.setStyle("-fx-font-size: 25px;" +
							"-fx-font-weight: BOLD;" +
							"-fx-text-fill: #123D2A;" +
							"-fx-background-color: GOLDENROD;" +
							"-fx-background-radius: 15px;"); //soft corners for button
		
		//Cancel button
		cancel = new Button("Cancel");
		
		//Styling
		cancel.setPrefSize(185, 60); //size of cancel button
		cancel.setLayoutX(615); //x coordinate
		cancel.setLayoutY(600); //y coordinate
		cancel.setStyle("-fx-font-size: 25px;" +
						"-fx-font-weight: BOLD;" +
						"-fx-text-fill: WHITE;" +
						"-fx-background-color: #123D2A;" +
						"-fx-border-color: DARKSEAGREEN;" +
						"-fx-border-width: 2px;" +
						"-fx-border-radius: 15px;" + //soft corners for border to match button
						"-fx-background-radius: 15px;"); //soft corners for button
		
		
		layout.getChildren().addAll(pageTitle, separator, incomeField, pageName, cancel, saveIncome, pageInstruction
									, incomeAmount, incomeDate, dateReceived);
		
		
	}
	
	//method to make layout accessible to application class
	public Pane getLayout() {
		return layout;	
	}	
	
	//makes cancel button accessible to application class for screen switching
	public Button getCancelButton() {
		return cancel;	
	}
	
	
	
	
}
	
	






