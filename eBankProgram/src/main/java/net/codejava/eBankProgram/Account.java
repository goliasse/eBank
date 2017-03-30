package net.codejava.eBankProgram;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.Set;
import javax.persistence.*;

//@Entity and @Table before the class map it to the table in the database. 
@Entity 
@Table(name = "account")
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
	private LocalDate createDate; 
	private String accountType;
	
	
	/*@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "accountID")
	private Set<User> user; 
	public Account() {
	}	
	
	
	public long getAccountID() {
		return accountID; 
	}*/
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
	public void setAccountType(String accountType){
		this.accountType = accountType; 
	}
	 
	public String getAccountType() {
		return accountType;
	}
	
	
	/*public Set<User> getUser() {
		return user;
	}

	public void setUsers(Set<User> user) {
		this.user = user;
	}*/


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
	
	public void createAccount(){
		Scanner scanner = new Scanner( System.in );
		
		//Collects and sets the customer account information
		try {	
			
			setAccountID(0);	
			//getAccountID();
			
			System.out.print("Are you opening a Checking or Savings Account:"); 
			String type = scanner.nextLine();
			setAccountType(type); 
			
			System.out.print("What is the opening account balance?"); 
			String amount = scanner.nextLine(); 
			double amountResult = Double.parseDouble(amount);
			setAccountBalance(amountResult);
			
			setCreateDate(); 
			
		} finally{
			scanner.close();
		}
	}
}
