package net.codejava.eBankProgram;

import java.util.Scanner;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


//@Entity and @Table before the class map it to the table in the database. 
@Entity 
@Table(name = "customer")
//@SecondaryTable(name="account")
public class User {
	
	private long custID;
	private String lastName; 
	private String firstName;	
	private String DOB; 
	private long SSN; 
	private String Phone;
	private String Email; 
	private String Address;
	private String City;
	private String State;
	private int Zip;
	//private Account account; 
	
	public User() {
	}
	
	//The @ID tells Hibernate that this is the ID column of the table. 
		//The @Column annotation maps the field to a column in the database table
		//The @GeneratedValue tells Hibernate that the ID column is auto-incremented. 
		@Id
		@Column(name = "custID")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		
	public long getCustID() {
		return custID;
	}

	public void setCustID(long custID) {
		this.custID = custID;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public long getSSN() {
		return SSN;
	}

	public void setSSN(long sSN) {
		SSN = sSN;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public int getZip() {
		return Zip;
	}

	public void setZip(int zip) {
		Zip = zip;
	}

	/*@ManyToOne(cascade=CascadeType.ALL)
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}*/

	public void createCustomer(){
		//create account
			
		Scanner scanner = new Scanner( System.in );
		
		//Collects and sets the customer account information
		try {	
			setCustID(0);
			
			//Account accountID = new Account();
			//accountID.setAccountID(0);
			
			System.out.print("Customer's Last Name: "); 
			String last = scanner.nextLine(); 
			setLastName(last);
			
			System.out.print("Customer's First Name: "); 
			String first = scanner.nextLine(); 
			setFirstName(first); 
		
			System.out.print("Customer's SSN: "); 
			String ssn = scanner.nextLine(); 
			long ssnResult = Integer.parseInt(ssn);
			setSSN(ssnResult); 
		
			System.out.print("Customer's Date Of Birth: "); 
			String dob = scanner.nextLine(); 		
			setDOB(dob); 
		
			System.out.print("Customer's Phone: "); 
			String phone = scanner.nextLine(); 
			setPhone(phone); 
		
			System.out.print("Customer's Email: "); 
			String email = scanner.nextLine(); 
			setEmail(email); 
			
			System.out.print("Customer's Address: "); 
			String address = scanner.nextLine(); 
			setAddress(address); 
			
			System.out.print("Customer's City: "); 
			String city = scanner.nextLine(); 
			setCity(city); 
			
			System.out.print("Customer's State: "); 
			String state = scanner.nextLine(); 
			setState(state); 
			
			System.out.print("Customer's Zip: "); 
			String zip = scanner.nextLine(); 
			int zipResult = Integer.parseInt(zip);
			setZip(zipResult); 
				
		} finally{}		
	}

	public void read(){
		//fetch customer account info
	}
		
	public void update(){
		//update customer account information 
	}
	
	public void delete(){
		//delete a customer and their account
	}
	
}
