package objects;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {
	
	private int transactionID; //variable stores transaction ID
	private BigDecimal amount; //variable stores transaction amount
	private int categoryID; //variable stores transaction category ID
	private String description; //variable stores transaction description
	private LocalDate date; //variable stores transaction date
	private String categoryName;
	
	//initalizes transaction objects variables
	public Transaction(int transactionID, BigDecimal amount, int categoryID, String description, LocalDate date) {
		this.transactionID = transactionID;
		this.amount = amount;
		this.categoryID = categoryID;
		this.description = description;
		this.date = date;
		
	}
	
	//getters used for saving/retrieving info
	
	public int getTransactionID() {
		return transactionID;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public int getCategoryID() {
		return categoryID;
	}
	
	public String getDescription() {
		return description;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	
	//setters used for updating exisiting info
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	

}
