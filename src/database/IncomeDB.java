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
	
	//adds income record to DB
	public void addIncome(Income income) throws SQLException {
		
		//sql statement to insert amount & date
		String sql = "INSERT INTO Income (income_amount, income_date) VALUES (?, ?)"; //first placeholder(?) = amount
																					  //second placeholder(?) = date
		
		//prepares sql query
		PreparedStatement statement = db.getConnection().prepareStatement(sql);
		
		//sets amount to first placeholder
		statement.setBigDecimal(1, income.getAmount());
		//sets date to second placeholder
		statement.setDate(2, java.sql.Date.valueOf(income.getDate()));
		
		//executes command
		statement.executeUpdate(); //since INSERT adds information use .executeUpdate()
		//closes sql statement
		statement.close();
		//close db connection
		db.close();
	}
	//for edit income
	public void updateIncome(Income income) throws SQLException {
		
		//sql statement for updating income record (using incomeID)
		String sql = "UPDATE Income SET income_amount = ?, income_date = ? WHERE income_id = ?";
		//prepares sql query
		PreparedStatement statement = db.getConnection().prepareStatement(sql);
		//sets updated amount
		statement.setBigDecimal(1, income.getAmount());
		//sets updated date
		statement.setDate(2, java.sql.Date.valueOf(income.getDate()));
		//gets incomeID to identify which record to update
		statement.setInt(3, income.getIncomeID());
		//executes command
		statement.executeUpdate(); //since UPDATE adds information use .executeUpdate()
		//closes sql statement
		statement.close();
		//closes db connection
		db.close();
		
	}
	
	
	//used for retrieving all income records from DB for viewing in incomeField table
	public ArrayList<Income> getAllIncome() throws SQLException {
		
		//ArrayList to store income records
		ArrayList<Income> incomeList = new ArrayList<>();
		
		//sql statement for retrieving income records
		//ORDER BY income_id DESC so that newest income record is at top of table (would have been opposite otherwise)
		String sql = "SELECT * FROM Income ORDER BY income_id DESC";
		
		//prepares sql query
		PreparedStatement statement = db.getConnection().prepareStatement(sql);
		//execute query
		ResultSet results = statement.executeQuery(); //since SELECT retrieves records use .executeQuery()
		
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
		//close db connection
		db.close();
		//return arraylist containing income record(s)
		return incomeList;
		
	}
	
	//used for deleting selected income from incomeField table
	public void deleteIncome(int incomeID) throws SQLException {
		
		//sql statement for deleting an income record
		String sql = "DELETE FROM Income WHERE income_id = ?";
		//prepare sql query
		PreparedStatement statement = db.getConnection().prepareStatement(sql);
		
		//sets incomeID to placeholder
		statement.setInt(1, incomeID);
		statement.executeUpdate(); //since DELETE removes record use .executeUpdaye()
		//close statement
		statement.close();
		//close db connection
		db.close();
		
		
		
	}

}
