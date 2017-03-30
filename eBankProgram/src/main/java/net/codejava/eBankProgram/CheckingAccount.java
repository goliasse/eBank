package net.codejava.eBankProgram;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity and @Table before the class map it to the table in the database. 
@Entity 
@Table(name = "feecheck")
public class CheckingAccount extends Account{
	
	//The @Column annotation maps the field to a column in the database table
	@Column(name = "monthlyfee")
	private double checkingFee;
	private Calendar cal; 
	private boolean monthlyFee; //boolean monthlyFee is stored in the database, and updated when feeCheck() is performed 
	
	public CheckingAccount() {
		//set the checking fee that occurs every month
		checkingFee = -10.00; //negative number because implementing deposit() instead of withdraw(). See deductFee() comment for more details. 
	}
	
	
	public boolean getMonthlyFee(){
		return monthlyFee; 
	}
	public void setMonthlyFee(boolean value){
		this.monthlyFee = value; 
	}
	//This method checks to see if it is the first of the month. If it is and the monthlyFee is set
	//to false (meaning that the fee hasn't already been withdrawn that day) 
	//it will deduct the fee from the customer's savings account. 
	public void feeCheck(){
		if(cal.get(Calendar.DAY_OF_MONTH) == 1 && getMonthlyFee() == false){
			deductFee();
			setMonthlyFee(true); 
		}
		else if(cal.get(Calendar.DAY_OF_MONTH) != 1 && getMonthlyFee() == true){
			setMonthlyFee(false); 
		}		
		else setMonthlyFee(true);  
	}
	//This method deducts the fee from the customer's account. 
	//It uses the deposit() method instead of the withdraw() method because the withdraw method will print 
	//out an insufficient funds message if there isn't enough funds to cover the fee. 
	//However, the fee will never be deducted. This way the fee will be deducted even if the customer does not have the funds. 
	//If they do not have the funds, their balance will display a negative amount. 
	public void deductFee(){
		deposit(checkingFee); 
	}
}