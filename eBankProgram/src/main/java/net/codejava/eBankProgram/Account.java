package net.codejava.eBankProgram;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import javax.persistence.*;

//@Entity and @Table before the class map it to the table in the database. 
@Entity 
@Table(name = "CustomerAccounts")
@Access(AccessType.FIELD)
public class Account {

	//The @ID tells Hibernate that this is the ID column of the table. 
	//The @Column annotation maps the field to a column in the database table
	//The @GeneratedValue tells Hibernate that the ID column is auto-incremented. 
	//Hibernate will automatically map the other fields found in the table "account" as long as the fields have the SAME name. 
	//Therefore, we do not have to map custID, accountBalance, createDate, and accountType because 
	//we mapped accountID to the account table with the same fields. 
	@Id
	@Column(name = "accountID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long accountID; 
	private double accountBalance; 
	@Column(name ="accountCreated")
	private LocalDate createDate; 
	private String accountType;
	private long custID;
	private boolean accountActive = false;

	public boolean isAccountActive() {
		return accountActive;
	}

	public void setAccountActive(boolean accountActive) {
		this.accountActive = accountActive;
	}

	public Account(AccountEnum accountType){
		this.accountType = accountType.toString();
	}

	public Account(){
	}

	public long getCustomerID() {
		return custID;
	}

	public void setCustomerID(long customerID) {
		custID = customerID;
	}

	public long getAccountID() {
		return accountID;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public void setAccountID(long accountID) {
		this.accountID = accountID;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setCreateDate(){
		this.createDate = LocalDate.now();
	}

	public LocalDate getCreateDate(){
		return createDate;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountEnum accountType) {
		this.accountType = accountType.toString();
	}

	public void withdraw(double amount){
		if (accountBalance >= amount){
			accountBalance-=amount; 
			setAccountBalance(accountBalance);
		}
		else {
			System.err.println("Insufficient Funds.");
		}
	}

	public void deposit(double amount){
		accountBalance+=amount;
		setAccountBalance(accountBalance); 
	}

	public void transfer(Account transferTo, double amount){
		withdraw(amount);
		transferTo.deposit(amount); 
	}

	public List<Account>  createDefaultAccounts(){
		Scanner scanner = new Scanner( System.in );

		//Collects and sets the customer account information
		try {	

			setAccountID(0);	
			//getAccountID();
			Account savingsAccount = new Account(AccountEnum.Savings);
			System.out.print("What is the opening Savings account balance?"); 
			String amount = scanner.nextLine(); 
			double amountResult = Double.parseDouble(amount);
			savingsAccount.setAccountBalance(amountResult);
			savingsAccount.setCreateDate(); 

			Account checkinAccount = new Account(AccountEnum.Checking);
			System.out.print("What is the opening Checking account balance?"); 
			amount = scanner.nextLine(); 
			amountResult = Double.parseDouble(amount);
			checkinAccount.setAccountBalance(amountResult);
			checkinAccount.setCreateDate(); 

			List<Account> defaultAccounts = new LinkedList<>();
			defaultAccounts.add(savingsAccount);
			defaultAccounts.add(checkinAccount);
			
			return defaultAccounts;
			
		} finally{
			scanner.close();
		}
	}
}
