package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import objects.Transaction;

public class TransactionDB {
	
	private Database db;


	//Creates DB object to establish connection
	public TransactionDB() throws SQLException {
		db = new Database();
	
	}
	//add transaction record to DB
	public void addTransaction(Transaction transaction) throws SQLException {
		
		//sql statement to insert amount, categoryID, description & date
		String sql = "INSERT INTO transactions (transaction_amount, category_id, transaction_desc, transaction_date) VALUES(?,?,?,?)";
		
		//prepares sql query
		PreparedStatement statement = db.getConnection().prepareStatement(sql);
		//sets amount to 1st placeholder
		statement.setBigDecimal(1, transaction.getAmount());
		//sets catecoryID to 2nd placeholder
		statement.setInt(2, transaction.getCategoryID());
		//sets description to 3rd placeholder
		statement.setString(3, transaction.getDescription());
		//sets date to 4th placeholder
		statement.setDate(4, java.sql.Date.valueOf(transaction.getDate()));
		//executes command
		statement.executeUpdate(); //since INSERT adds information use .executeUpdate()
		//closes sql statement
		statement.close();
		//closes db connection
		db.close();
		
		
	}
	
	public void updateTransaction(Transaction transaction) throws SQLException {
		
		//sql statement for updating transaction record (using transactionID)
		String sql = "UPDATE transactions SET transaction_amount = ?, category_id = ?, transaction_desc = ?, transaction_date = ? WHERE transaction_id = ?";
		
		PreparedStatement statement = db.getConnection().prepareStatement(sql);
		
		//sets amount to 1st placeholder
		statement.setBigDecimal(1, transaction.getAmount());
		//sets catecoryID to 2nd placeholder
		statement.setInt(2, transaction.getCategoryID());
		//sets description to 3rd placeholder
		statement.setString(3, transaction.getDescription());
		//sets date to 4th placeholder
		statement.setDate(4, java.sql.Date.valueOf(transaction.getDate()));
		//gets transactionID to identify which record to update
		statement.setInt(5, transaction.getTransactionID());
		//executes command
		statement.executeUpdate(); //since UPDATE adds information use .executeUpdate
		//closes sql statement
		statement.close();
		//closes db connection
		db.close();
		
	}
	

}