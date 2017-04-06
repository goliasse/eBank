package net.codejava.eBankProgram;

import dao.DAO;

public class Authorize {

	public boolean authorizeCustomer(String username, String password){
		DAO dao = new DAO();
		String actualPassword = dao.fetchCustomerCredentials(username);
		if(actualPassword == null)
			return false;
		if(actualPassword.equals(password))
			return true;
		else
			return false;
	}

	public boolean authorizeManager(String uname, String passwrd) {	
		DAO dao = new DAO();
		String actualPassword = dao.fetchManagerCredentials(uname);
		if(actualPassword == null)
			return false;
		if(actualPassword.equals(passwrd))
			return true;
		else
			return false;
	}
}
