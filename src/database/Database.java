package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	
	private Connection connection;
	
	//throws exception in case of error
	public Database() throws SQLException {
		
		//DB location and login
		String url = "jdbc:mysql://localhost:3306/expense_tracker";
		String username = "root";
		String password = "Points@2005";
		
		//attempts to make connection to DB based on info above
		connection = DriverManager.getConnection(url, username, password);	
	}
	
	public Connection getConnection() {
		
		//returns existing connection
		return connection;
	}
	
	//closes connection when no longer needed
	//throws exception in case of error
	public void close() throws SQLException {
		
		//checks that a connection exists & that is not already closed
		if (connection != null && !connection.isClosed()) {
		
			//closes connection
			connection.close();
		}
	}

}
