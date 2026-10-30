package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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
		
		//prepares sql statement
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

}
