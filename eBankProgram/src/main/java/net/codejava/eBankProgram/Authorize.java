package net.codejava.eBankProgram;

import dao.DAO;

public class Authorize {

	public boolean authorizeCustomer(String username, String password){
		DAO dao = new DAO();
		String actualPassword = dao.fetchCredentials(username);
		if(actualPassword.equals(password))
			return true;
		else
			return false;
	}
}
