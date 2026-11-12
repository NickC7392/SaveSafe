package transaction_screens;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;


public class ViewTransaction {
	
	private Pane layout;
	
	private Label pageTitle;
	private Label pageName;
	private Label pageInstruction;
	
	private Line separator;
	
	private TableView<String> transactionTable; //TEMP
	
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
		transactionTable = new TableView<String>();
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
	

}
