package objects;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Income {
	
	private int incomeID; //variable stores income ID
	private BigDecimal amount; //variable stores income amount
	private LocalDate date; //variable stores income date
	
	//initalizes income objects variables
	public Income(int incomeID, BigDecimal amount, LocalDate date) {
		this.incomeID = incomeID;
		this.amount = amount;
		this.date = date;
		
	}
	
	//getters used for saving/retrieving info

	public int getIncomeID() {
		return incomeID;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public LocalDate getDate() {
		return date;
		
	}
	
	//setters used for updating existing info 

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
		
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}
