package database;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import objects.Income;

public class IncomeDB {
	
	//variable to access DB connection
	private Database db;
	
	//Creates DB object to establish connection
	public IncomeDB() throws SQLException {
		db = new Database();
	}
	
	//adds income information to DB
	public void addIncome(Income income) throws SQLException {
		
		//sql statement to insert into Income table in DB
		String sql = "INSERT INTO Income (income_amount, income_date) VALUES (?, ?)"; //first placeholder(?) = amount
																					  //second placeholder(?) = date
		
		//prepares query
		PreparedStatement statement = db.getConnection().prepareStatement(sql);
		
		//sets amount to be added into first SQL placeholder (amount)
		statement.setBigDecimal(1, income.getAmount());
		//sets date to be added into second SQL placeholder (date)
		statement.setDate(2, java.sql.Date.valueOf(income.getDate()));
		
		//saves income record
		statement.executeUpdate();
		//closes statement
		statement.close();
	}
	
	
	//retrieves income records from db for incomeTable in ViewIncome
	public ArrayList<Income> getAllIncome() throws SQLException {
		
		//create arrayList "incomeList"
		ArrayList<Income> incomeList = new ArrayList<>();
		
		//sql statement for retrieving income records
		//ORDER BY income_id DESC so that newest income records is at top of table
		String sql = "SELECT * FROM Income ORDER BY income_id DESC";
		
		//prepares query
		PreparedStatement statement = db.getConnection().prepareStatement(sql);
		//execute query
		ResultSet results = statement.executeQuery();
		
		//loop through income records
		while (results.next()) {
			
			int incomeID = results.getInt("income_id"); //retrieve income_id
			BigDecimal amount = results.getBigDecimal("income_amount"); //retrieve income_amount
			LocalDate date = results.getDate("income_date").toLocalDate(); //retrieve income_date
			
			//create income object with retrieved info
			Income income = new Income(incomeID, amount, date);
			//add income object to arraylist
			incomeList.add(income);
			
		}
		//close resultset
		results.close();
		//closes statement
		statement.close();
		//return arraylist
		return incomeList;
		
	}

}
