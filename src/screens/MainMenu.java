package screens;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;



public class MainMenu {
	
	private Pane layout;
	
	private Label appName; 
	private Label pageName;
	private Label startHere;
	
	private Line separator;
	
	private Button addIncome;
	private Button setSavings;
	private Button addTransaction;
	private Button viewIncome;
	private Button viewSavings;
	private Button viewTransaction;
	private Button financialSummary;
	private Button spendingByCategory;
	
	
	public MainMenu() {
		
		//Layout
		layout = new Pane();
		//Styling
		layout.setStyle("-fx-background-color: #123D2A;");
		
		
		//Title of screen Label
		appName = new Label("$ave$afe");
		
		//Styling
		appName.setFont(new Font(70)); 
		appName.setStyle("-fx-text-fill: GOLDENROD; -fx-font-weight: BOLD;");
		appName.setPrefWidth(1200); //set appName box to width of whole window
		appName.setAlignment(Pos.CENTER); //center within that width (easier than coordinates)
		
		//Screen Name Label
		pageName = new Label("Home");
		
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
		separator.setStyle("-fx-stroke: WHITE");
		
		//Start here Label
		startHere = new Label("Start Here!");
		
		//Styling
		startHere.setFont(new Font(30));
		startHere.setStyle("-fx-text-fill: GOLDENROD");
		startHere.setLayoutX(282); //x coordinate
		startHere.setLayoutY(255); //y coordinate

		//Add buttons
		addIncome = new Button("Add Income");
		setSavings = new Button("Set Savings Goal");
		addTransaction = new Button("Add Transactions");
		
		//Add Buttons Styling
		addIncome.setPrefSize(300, 60); //size of button
		addIncome.setLayoutX(200); //x coordinate
		addIncome.setLayoutY(295); //y coordinate
		addIncome.setStyle("-fx-font-size: 25px;" +
						   "-fx-font-weight: BOLD;" +
						   "-fx-text-fill: #123D2A;" +
						   "-fx-background-radius: 15px");
		
		setSavings.setPrefSize(300, 60); //size of button
		setSavings.setLayoutX(200); //x coordinate
		setSavings.setLayoutY(405); //y coordinate
		setSavings.setStyle("-fx-font-size: 25px;" +
							"-fx-font-weight: BOLD;" +
							"-fx-text-fill: #123D2A;" +
							"-fx-background-radius: 15px");
		
		addTransaction.setPrefSize(300, 60); //size of button
		addTransaction.setLayoutX(200); //x coordinate
		addTransaction.setLayoutY(515); //y coordinate
		addTransaction.setStyle("-fx-font-size: 25px;" +
								"-fx-font-weight: BOLD;" +
								"-fx-text-fill: #123D2A;" +
								"-fx-background-radius: 15px");
		
		//View Buttons
		viewIncome = new Button("View Income");
		viewTransaction = new Button("View Transactions");
		viewSavings = new Button("View Savings");
		financialSummary = new Button("Financial Summary");
		spendingByCategory = new Button("Spending by Category");
		
		//View Buttons Styling	
		viewIncome.setPrefSize(300, 60); //size of button
		viewIncome.setLayoutX(700); //x coordinate
		viewIncome.setLayoutY(185); //y coordinate
		viewIncome.setStyle("-fx-font-size: 25px;" +
							"-fx-font-weight: BOLD;" +
							"-fx-text-fill: #123D2A;" +
							"-fx-background-radius: 15px");
		
		viewSavings.setPrefSize(300, 60); //size of button
		viewSavings.setLayoutX(700); //x coordinate
		viewSavings.setLayoutY(295); //y coordinate
		viewSavings.setStyle("-fx-font-size: 25px;" + 
							 "-fx-font-weight: BOLD;" +
							 "-fx-text-fill: #123D2A;" +
							 "-fx-background-radius: 15px");
		
		viewTransaction.setPrefSize(300, 60); //size of button
		viewTransaction.setLayoutX(700); //x coordinate
		viewTransaction.setLayoutY(405); //y coordinate
		viewTransaction.setStyle("-fx-font-size: 25px;" +
								 "-fx-font-weight: BOLD;" +
								 "-fx-text-fill: #123D2A;" +
								 "-fx-background-radius: 15px");
		
		financialSummary.setPrefSize(300, 60); //size of button
		financialSummary.setLayoutX(700); //x coordinate
		financialSummary.setLayoutY(515); //y coordinate
		financialSummary.setStyle("-fx-font-size: 25px;" +
								  "-fx-font-weight: BOLD;" +
								  "-fx-text-fill: #123D2A;" +
								  "-fx-background-radius: 15px");
		
		spendingByCategory.setPrefSize(300, 60); //size of button
		spendingByCategory.setLayoutX(700); //x coordinate
		spendingByCategory.setLayoutY(625); //y coordinate
		spendingByCategory.setStyle("-fx-font-size: 25px;" +
									"-fx-font-weight: BOLD;" +
									"-fx-text-fill: #123D2A;" +
									"-fx-background-radius: 15px");
		
		//Add all elements to layout
		layout.getChildren().addAll(appName, pageName, startHere, addIncome, setSavings, addTransaction,
									viewIncome, viewTransaction, viewSavings,financialSummary,
									spendingByCategory, separator);
		
	}
	
	//method to make layout accessible to application class
	public Pane getLayout() {
		return layout;
		
	}

}
