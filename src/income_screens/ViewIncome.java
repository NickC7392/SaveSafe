package income_screens;

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

import database.IncomeDB;
import objects.Income;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;

import UserFeedback.AlertMessages;

public class ViewIncome {
	
	private Pane layout;
	
	private Label pageTitle;
	private Label pageName;
	private Label pageInstruction;
	
	private Line separator;
	
	private TableView<Income> incomeTable;
	
	private Button editIncome;
	private Button deleteIncome;
	private Button returnHome;
	
	
	
	public ViewIncome() {
		
		//Layout
		layout = new Pane();
		//Styling
		layout.setStyle("-fx-background-color: #123D2A;");
		
		//Title for page label
		pageTitle = new Label("View Income");
		//Styling
		pageTitle.setFont(new Font(70));
		pageTitle.setPrefWidth(1200); //set width to whole screen
		pageTitle.setAlignment(Pos.CENTER); //align within whole screens width
		pageTitle.setStyle("-fx-text-fill: GOLDENROD; -fx-font-weight: BOLD;");
		
		//Name for page label
		pageName = new Label("Income");
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
		pageInstruction = new Label("Manage Income Records");
		//Styling
		pageInstruction.setPrefWidth(1200); //sets width of label same size as whole screen
		pageInstruction.setAlignment(Pos.CENTER); //centers text within that width
		pageInstruction.setLayoutY(140); //y coordinate
		pageInstruction.setStyle("-fx-font-size: 35px;" + 
				  				 "-fx-text-fill: WHITE;" + 
								 "-fx-font-weight: BOLD;");
		
		//View income table
		incomeTable = new TableView<Income>();
		
		//Amount column
		TableColumn<Income, BigDecimal> amountColumn = new TableColumn<>("Amount");
		amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
		//Styling
		amountColumn.setPrefWidth(450);
		amountColumn.setStyle("-fx-alignment: CENTER;" +
							  "-fx-font-size: 20px;" +
							  "-fx-font-weight: BOLD;");
		
		//Date column
		TableColumn<Income, LocalDate> dateColumn = new TableColumn<>("Date");
		dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
		//Styling
		dateColumn.setPrefWidth(450);
		dateColumn.setStyle("-fx-alignment: CENTER;" +
							"-fx-font-size: 20px;" +
							"-fx-font-weight: BOLD;");
	
		//add columns to table
		incomeTable.getColumns().addAll(dateColumn, amountColumn);
 	
		 //Styling
		incomeTable.setPrefSize(900, 350); //size of incomeTable
		incomeTable.setLayoutX(150); //x coordinate
		incomeTable.setLayoutY(210); //y coordinate
		incomeTable.setStyle("-fx-background-color: #F1EBDD;");
		//Edit income button
		editIncome = new Button("Edit Income");
		//Styling
		editIncome.setPrefSize(220, 60); //size of editIncome button
		editIncome.setLayoutX(360); //x coordinate
		editIncome.setLayoutY(590); //y coordinate
		editIncome.setStyle("-fx-background-color: GOLDENROD;" +
							"-fx-text-fill: #123D2A;" +
							"-fx-font-size: 25px;" +
							"-fx-font-weight: BOLD;" +
							"-fx-background-radius: 15px;"); //soft corners
		
		//Delete Income button
		deleteIncome = new Button("Delete Income");
		//Styling
		deleteIncome.setPrefSize(220,60); //size of deleteIncome button
		deleteIncome.setLayoutX(620); //x coordinate
		deleteIncome.setLayoutY(590); //y coordinate
		deleteIncome.setStyle("-fx-background-color: #A94442;" +
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
		
		
		//add all elements to layout
		layout.getChildren().addAll(pageTitle, pageName, pageInstruction, separator, incomeTable,
									editIncome, deleteIncome, returnHome);
		
		
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
	
	//makes editIncome button accessible to application class for screen switching
	//ViewIncome -> EditIncome navigation
	public Button getEditButton() {
		return editIncome;
	}
	
	//load income records from sql into incomeTable
	public void loadIncomeRecords() {
		
		try {
			//create incomeDB object
			IncomeDB incomeDB = new IncomeDB();
			//retrieve records and populate incomeTable
			incomeTable.setItems(FXCollections.observableArrayList(incomeDB.getAllIncome()));
			//calls getAllIncome from incomeDB
			//converts arraylist to observaleArrayList
			//obserableArrayList to incomeTable
			
			
		} catch (SQLException e) {
			//user feedback incase of sql issue
			AlertMessages.showAlert("Unable to retrieve income records.");
			//display DB error details in console
			e.printStackTrace();
			
		}
	}
}
