package savingGoal_screens;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

public class ViewSavingsGoal {
	
	private Pane layout;
	
	private Label pageTitle;
	private Label pageName;
	private Label pageInstruction;
	
	private Line separator;
	
	private TableView<String> savingsGoalTable; //TEMP !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
	private Button editSavingsGoal;
	private Button deleteSavingsGoal;
	private Button returnHome;
	
	
	
	public ViewSavingsGoal() {
		
		//Layout
		layout = new Pane();
		//Styling
		layout.setStyle("-fx-background-color: #123D2A;");
		
		//Title for page label
		pageTitle = new Label("View Savings Goals");
		//Styling
		pageTitle.setFont(new Font(70));
		pageTitle.setPrefWidth(1200); //set width to whole screen
		pageTitle.setAlignment(Pos.CENTER); //align within whole screens width
		pageTitle.setStyle("-fx-text-fill: GOLDENROD; -fx-font-weight: BOLD;");
		
		//Name for page label
		pageName = new Label("Savings Goal");
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
		pageInstruction = new Label("Manage Savings Goal Records");
		//Styling
		pageInstruction.setPrefWidth(1200); //sets width of label same size as whole screen
		pageInstruction.setAlignment(Pos.CENTER); //centers text within that width
		pageInstruction.setLayoutY(140); //y coordinate
		pageInstruction.setStyle("-fx-font-size: 35px;" + 
				  				 "-fx-text-fill: WHITE;" + 
								 "-fx-font-weight: BOLD;");
		
		//View Savings Goal table
		savingsGoalTable = new TableView<String>(); //TEMP !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		 //Styling
		savingsGoalTable.setPrefSize(900, 350); //size of incomeTable
		savingsGoalTable.setLayoutX(150); //x coordinate
		savingsGoalTable.setLayoutY(210); //y coordinate
		savingsGoalTable.setStyle("-fx-background-color: #F1EBDD;");
		
		//Edit Savings Goal button
		editSavingsGoal = new Button("Edit Goal");
		//Styling
		editSavingsGoal.setPrefSize(220, 60); //size of editIncome button
		editSavingsGoal.setLayoutX(360); //x coordinate
		editSavingsGoal.setLayoutY(590); //y coordinate
		editSavingsGoal.setStyle("-fx-background-color: GOLDENROD;" +
							"-fx-text-fill: #123D2A;" +
							"-fx-font-size: 25px;" +
							"-fx-font-weight: BOLD;" +
							"-fx-background-radius: 15px;"); //soft corners
		
		//Delete Income button
		deleteSavingsGoal = new Button("Delete Goal");
		//Styling
		deleteSavingsGoal.setPrefSize(220,60); //size of deleteIncome button
		deleteSavingsGoal.setLayoutX(620); //x coordinate
		deleteSavingsGoal.setLayoutY(590); //y coordinate
		deleteSavingsGoal.setStyle("-fx-background-color: #A94442;" +
							  "-fx-text-fill: WHITE;" +
							  "-fx-font-size: 25px;" +
							  "-fx-font-weight: BOLD;" +
							  "-fx-background-radius: 15px;"); //soft corners
		
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
		
		layout.getChildren().addAll(pageTitle, pageName, pageInstruction, separator, savingsGoalTable,
									editSavingsGoal, deleteSavingsGoal, returnHome);
			
		
	}
	
	//method to make layout accessible to application class
	public Pane getLayout() {
		return layout;
	}
	
	//make returnHome button accissible to application class for screen switching
	//ViewSavingsGoal -> MainMenu
	public Button getReturnHome() {
		return returnHome;
	}

}

