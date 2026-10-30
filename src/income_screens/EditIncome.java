package income_screens;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

public class EditIncome {

	private Pane layout;
	
	private Label pageTitle;
	private Label pageName;
	private Label pageInstruction;
	private Label editAmount;
	private Label editDate;
	private Label dollarSign;
	
	private Line separator;
	
	private TextField incomeField;
	private DatePicker incomeDate;
	
	private Button saveChanges;
	private Button cancel;
	
	
	public EditIncome() {
		
		//layout
		layout = new Pane();
		
		//styling
		layout.setStyle("-fx-background-color: #123D2A;");
		
		//page title label
		pageTitle = new Label("Edit Income");
		
		//Styling
		pageTitle.setFont(new Font(70));
		pageTitle.setPrefWidth(1200); //set width to whole screen
		pageTitle.setAlignment(Pos.CENTER); //align within whole screens width
		pageTitle.setStyle("-fx-text-fill: GOLDENROD; -fx-font-weight: BOLD;");
		
		//page name label (top right)
		pageName = new Label("Income");
		
		//styling
		pageName.setFont(new Font(25));
		pageName.setStyle("-fx-text-fill: DARKSEAGREEN");
		pageName.setPrefWidth(1200); //set screenName box to width of whole window
		pageName.setAlignment(Pos.TOP_RIGHT); //move to top right of that width
		pageName.setLayoutX(-40); //make incremental adjustments
		pageName.setLayoutY(20); // ^^
		
		//separator line
		separator = new Line(30,110,1170,110); //(x start, y start, x end, y end)
		
		//Styling
		separator.setStyle("-fx-stroke: WHITE"); //makes line white
		
		//page instruction label
		pageInstruction = new Label("Update Selected Income Record");
		
		//styling
		pageInstruction.setLayoutY(160); // y coordinate
		pageInstruction.setPrefWidth(1200); // set width to whole screen
		pageInstruction.setAlignment(Pos.CENTER); //align within whole screens width
		pageInstruction.setStyle("-fx-font-size: 35px;" + 
								 "-fx-text-fill: WHITE;" + 
								 "-fx-font-weight: BOLD;");
		
		//edit income amount label
		editAmount = new Label("Update Income Amount:");
		
		//Styling
		editAmount.setLayoutX(400); //x coordinate
		editAmount.setLayoutY(260); //y coordinate
		editAmount.setStyle("-fx-font-size: 25px;" +
							  "-fx-text-fill: DARKSEAGREEN;");	
		
		//income amount text field
		incomeField = new TextField();
		incomeField.setPromptText("selected income will be here"); //TEMPORARY
		
		//styling
		incomeField.setFocusTraversable(false); //make it so text field is not selected by default
		incomeField.setAlignment(Pos.CENTER); //set text to center of TextField
		incomeField.setPrefSize(400, 75); //size of text field
		incomeField.setLayoutX(400); //x coordinate
		incomeField.setLayoutY(300); //y coordinate
		incomeField.setStyle("-fx-font-size: 25px;" +
							  "-fx-text-fill: BLACK;");
		
		//dollar sign label for income amount text field
		dollarSign = new Label("$");
		
		//styling
		dollarSign.setLayoutX(410); //x coordinate
		dollarSign.setLayoutY(315); //y coordinate
		dollarSign.setStyle("-fx-font-size: 30px;" +
							"-fx-font-weight: BOLD;" +
							"-fx-text-fill: BLACK;");
		
		//edit date label
		editDate = new Label("Update Income Date:");
		
		//styling
		editDate.setLayoutX(400); //x coordinate
		editDate.setLayoutY(435); //y coordinate
		editDate.setStyle("-fx-font-size: 25px;" +
							  "-fx-text-fill: DARKSEAGREEN;");		
		
		//date picker for income date
		incomeDate = new DatePicker();
		incomeDate.setPromptText("selected date will be here"); //TEMPORARY
		
		//styling
		incomeDate.setFocusTraversable(false); //make it so date picker is not selected by default
		incomeDate.setPrefSize(400, 75); //size of DatePicker
		incomeDate.getEditor().setAlignment(Pos.CENTER); //centers text within DatePicker
		incomeDate.setLayoutX(400); //x coordinate
		incomeDate.setLayoutY(475); //y coordinate
		incomeDate.setStyle("-fx-font-size: 25px;" +
							"-fx-text-fill: BLACK;");
		
		//save changes button
		saveChanges = new Button("Save Changes");
		
		//styling
		saveChanges.setPrefSize(200, 60); //size of saveIncome button
		saveChanges.setLayoutX(400); //x coordinate
		saveChanges.setLayoutY(600); //y coordinate
		saveChanges.setStyle("-fx-font-size: 25px;" +
							"-fx-font-weight: BOLD;" +
							"-fx-text-fill: #123D2A;" +
							"-fx-background-color: GOLDENROD;" +
							"-fx-background-radius: 15px;"); //soft corners for button		
		
		//cancel button
		cancel = new Button("Cancel");
		
		//styling
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
		
		
		layout.getChildren().addAll(pageTitle, pageName, separator, pageInstruction, editAmount, incomeField,
									editDate, incomeDate, saveChanges, cancel, dollarSign);
		
		
		
		
	}
	//method to make layout accessible to application class
	public Pane getLayout() {
		return layout;
	}
	
	//makes cancel button accessible to application class for screen switching
	//EditIncome -> ViewIncome navigation
	public Button getCancelButton() {
		return cancel;
	}

}
