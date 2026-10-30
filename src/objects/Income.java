package objects;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Income {
	
	private int incomeID; //variable stores income ID
	private BigDecimal amount; //variable stores income amount
	private LocalDate date; //variable stores income date
	
	public Income(int incomeID, BigDecimal amount, LocalDate date) {
		this.incomeID = incomeID;
		this.amount = amount;
		this.date = date;
	}
	
	public int getIncomeID() {
		return incomeID;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public LocalDate getDate() {
		return date;
	}

}
