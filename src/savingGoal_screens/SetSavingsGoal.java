package savingGoal_screens;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

public class SetSavingsGoal {
	
	private Pane layout;
	
	private Label pageTitle;
	private Label pageName;
	private Label pageInstruction;
	private Label savingsAmount;
	private Label date;
	private Label dollarSign;
	
	private Line separator;
	
	private TextField savingsField;
	
	private DatePicker savingsDate;
	
	private Button setSavings;
	private Button returnHome;
	
	
	public SetSavingsGoal() {
		
		//Layout
		layout = new Pane();
		//Styling
		layout.setStyle("-fx-background-color: #123D2A;");
		
		//Title for page label
		pageTitle = new Label("Add Savings Goal");
		//Styling
		pageTitle.setFont(new Font(70));
		pageTitle.setPrefWidth(1200); //set width to whole screen
		pageTitle.setAlignment(Pos.CENTER); //align within whole screens width
		pageTitle.setStyle("-fx-text-fill: GOLDENROD; -fx-font-weight: BOLD;");
		
		//page name label (top right)
		pageName = new Label("Savings Goal");
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
		pageInstruction = new Label("Enter Savings Goal Details");
		//Styling
		pageInstruction.setLayoutY(160); // y coordinate
		pageInstruction.setPrefWidth(1200); // set width to whole screen
		pageInstruction.setAlignment(Pos.CENTER); //align within whole screens width
		pageInstruction.setStyle("-fx-font-size: 35px;" + 
								 "-fx-text-fill: WHITE;" + 
								 "-fx-font-weight: BOLD;");
		
		//Savings amount label
		savingsAmount = new Label("Savings Goal Amount:");
		//Styling
		savingsAmount.setLayoutX(400); //x coordinate
		savingsAmount.setLayoutY(260); //y coordinate
		savingsAmount.setStyle("-fx-font-size: 25px;" +
							  "-fx-text-fill: DARKSEAGREEN;");	
		
		//Saving amount text field
		savingsField = new TextField();
		savingsField.setPromptText("0.00");
		//Styling
		savingsField.setFocusTraversable(false); //make it so text field is not selected by default
		savingsField.setAlignment(Pos.CENTER); //set text to center of TextField
		savingsField.setPrefSize(400, 75); //size of text field
		savingsField.setLayoutX(400); //x coordinate
		savingsField.setLayoutY(300); //y coordinate
		savingsField.setStyle("-fx-font-size: 25px;" +
							  "-fx-text-fill: BLACK;");
		
		//dollar sign label for income amount text field
		dollarSign = new Label("$");
		//styling
		dollarSign.setLayoutX(410); //x coordinate
		dollarSign.setLayoutY(315); //y coordinate
		dollarSign.setStyle("-fx-font-size: 30px;" +
							"-fx-font-weight: BOLD;" +
							"-fx-text-fill: BLACK;");
		
		//savings goal date label
		date = new Label("Date for Savings Goal:");
		//Styling
		date.setLayoutX(400); //x coordinate
		date.setLayoutY(435); //y coordinate
		date.setStyle("-fx-font-size: 25px;" +
					  "-fx-text-fill: DARKSEAGREEN;");	
		
		//DatePicker
		savingsDate = new DatePicker();
		//Styling
		savingsDate.setPrefSize(400, 75); //size of DatePicker
		savingsDate.getEditor().setAlignment(Pos.CENTER); //centers text  within DatePicker
		savingsDate.setFocusTraversable(false); //make it so text field is not selected by default
		savingsDate.setLayoutX(400); //x coordinate
		savingsDate.setLayoutY(475); //y coordinate
		savingsDate.setStyle("-fx-font-size: 25px;" +
							"-fx-text-fill: BLACK;");	
		
		//save savings button
		setSavings = new Button("Set Savings Goal");
		//Styling
		setSavings.setPrefSize(400, 60); //size of saveIncome button
		setSavings.setLayoutX(400); //x coordinate
		setSavings.setLayoutY(590); //y coordinate
		setSavings.setStyle("-fx-font-size: 25px;" +
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
		
		layout.getChildren().addAll(pageTitle, separator, savingsField, pageName, setSavings, pageInstruction,
									savingsAmount, date, savingsDate, dollarSign, returnHome);
			
	}
	
	//make layout accessible to application class
	public Pane getLayout() {
		return layout;
	}
	
	//make returnHome button accessible to application class for screen switching
	public Button getReturnHome() {
		return returnHome;
	}
	
}
