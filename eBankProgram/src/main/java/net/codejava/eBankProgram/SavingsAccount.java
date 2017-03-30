package net.codejava.eBankProgram;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity and @Table before the class map it to the table in the database. 
@Entity 
@Table(name = "interestcheck")
public class SavingsAccount extends Account {
	
	//The @Column annotation maps the field to a column in the database table
	@Column(name = "maturityrate")
	
	private double monthlyInterestRate;
	private Calendar cal; 
	private boolean maturityRate; //boolean maturityRate is stored in the database, and updated when interestCheck() is performed 
	
	public SavingsAccount(){
		//monthly interest rate converted from percentage to decimal. Therefore the annualInterestRate is 1% or 0.01 
		monthlyInterestRate = 0.01/12.0; 
	}
	

	public boolean getMaturityRate(){
		return maturityRate; 
	}
	public void setMaturityRate(boolean value){
		this.maturityRate = value; 
	}
	//This method checks to see if it is the first of the month. If it is and the maturityRate is set
	//to false (meaning that the interest hasn't already been deposited that day) 
	//it will add interest to the customer's savings account. 
	public void interestCheck(){
		if(cal.get(Calendar.DAY_OF_MONTH) == 1 && getMaturityRate() == false){
			addInterest();
			setMaturityRate(true); 
		}
		else if(cal.get(Calendar.DAY_OF_MONTH) != 1 && getMaturityRate() == true){
			setMaturityRate(false); 
		}		
		else setMaturityRate(true);  
	}
	//adds monthly interest to account 
	public void addInterest(){
		double interest = getAccountBalance()* monthlyInterestRate; 
		deposit(interest); 
	}
}