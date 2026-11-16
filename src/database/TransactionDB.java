package database;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

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
	
	public ArrayList<Transaction> getAllTransaction() throws SQLException {
		
		//ArrayList to store transaction records
		ArrayList<Transaction> transactionList= new ArrayList<>();
		
		//sql statement for retreiving transaction records
		//ORDER BY transaction_id DESC so that newest transaction record is at top of table
		String sql = "SELECT * FROM transactions JOIN category USING (category_id) ORDER BY transaction_id DESC";
		
		//prepares sql query
		PreparedStatement statement = db.getConnection().prepareStatement(sql);
		//execute query
		ResultSet results = statement.executeQuery(); //since SELECT retrieves records use .executeQuery()
		
		//loop through transaction records
		while(results.next()) {
			
			int transactionID = results.getInt("transaction_id"); //retrieve transaction_id
			BigDecimal amount = results.getBigDecimal("transaction_amount"); //retrieve transaction_amount
			int categoryID = results.getInt("category_id"); //retrieve category_id
			String description = results.getString("transaction_desc"); //retrieve transaction_desc
			LocalDate date = results.getDate("transaction_date").toLocalDate(); //retrieve transaction_date
			
			//create new transaction object with retrieved info
			Transaction transaction = new Transaction(transactionID, amount, categoryID, description, date);
			//gets category name from DB
			String categoryName = results.getString("category_name");
			//sets category name in transaction object
			transaction.setCategoryName(categoryName);
			//add newly created object to ArrayList
			transactionList.add(transaction);
			
		}
		
		results.close(); //close resultset
		statement.close(); //close statement
		db.close(); //close db connection
		return transactionList; //return arraylist containing transaction record(s)
		
		
		
	}
	

}