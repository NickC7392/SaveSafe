package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	
	//variable to hold connection
	private Connection connection;
	
	//throws exception in case of database connection error
	public Database() throws SQLException {
		
		//DB location & login info
		String url = "jdbc:mysql://localhost:3306/expense_tracker";
		String username = "root";
		String password = "Points@2005";
		
		//attempts to make connection to DB based on info above
		connection = DriverManager.getConnection(url, username, password);	
	}
	
	//allows other classes to retrieve connection
	public Connection getConnection() {
		//returns existing connection
		return connection;
	}
	
	//closes connection when no longer needed
	//throws exception in case of error when closing connection
	public void close() throws SQLException {
		
		//checks that a connection exists & is still open
		if (connection != null && !connection.isClosed()) {
		
			//closes connection
			connection.close();
		}
	}

}
