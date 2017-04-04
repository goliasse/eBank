package com.hello;

import java.util.List;
import java.util.Scanner;

import dao.DAO;
import net.codejava.eBankProgram.Account;
import net.codejava.eBankProgram.Authorize;
import net.codejava.eBankProgram.Customer;

public class Start {

	public static void main(String[] args) {

		System.out.println(" Welcome to our Ebank!!");
		System.out.println("Press 1 to Register");	
		System.out.println("Press 2 to Login as Customer");
		System.out.println("Press 3 to Login as Manager");

		Scanner scan = new Scanner(System.in);
		int option = scan.nextInt();

		if(option ==1){
			Register();
		}

		if(option == 2){
			LoginCustomer();
		}
		if(option ==3){
			LoginManager();
		}
	}

	private static void LoginManager() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome Manager! Enter Below Details to Login");

		System.out.print("Enter Manager user name: "); 
		String uname = scanner.nextLine(); 

		System.out.print("Enter password: "); 
		String passwrd = scanner.nextLine(); 

		Authorize auth = new Authorize();
		boolean isAuth = auth.authorizeManager(uname, passwrd);

		if(isAuth){
			System.out.println("Successfully Authorized!!!!");
		}else{
			System.out.println("Inavlid Credentials!!");
			LoginManager();
		}
		
	}

	private static void LoginCustomer(){
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter Below Details to Login");

		System.out.print("Enter User Name: "); 
		String uname = scanner.nextLine(); 

		System.out.print("Enter Password: "); 
		String passwrd = scanner.nextLine(); 

		Authorize auth = new Authorize();
		boolean isAuth = auth.authorizeCustomer(uname, passwrd);

		if(isAuth){
			System.out.println("Successfully Authorized!!!!");
		}else{
			System.out.println("Inavlid Credentials!!");
			LoginCustomer();
		}

	}


	private static void Register(){
		Customer customer = new Customer();
		customer.createCustomer();

		Account account = new Account();
		List<Account> defaultAccounts = account.createDefaultAccounts();

		DAO dao = new DAO();
		dao.createCustomerwithAccounts(customer, defaultAccounts);
	}
}


