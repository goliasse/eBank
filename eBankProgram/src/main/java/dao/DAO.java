package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import hibernate.util.HibernateUtil;
import net.codejava.eBankProgram.Account;
//import net.codejava.eBankProgram.Manager;
import net.codejava.eBankProgram.User;
	
public class DAO {
	 public static void main(String[] args) {
		 
		 SessionFactory sf = HibernateUtil.getSessionFactory();
	     Session session = sf.openSession();
	     session.beginTransaction();
		 
	     //have interestCheck ran here when everything else is set up
	     //have feeCheck ran here ran here when everything else is set up
	     
	     User user = new User();     
	     user.createCustomer(); 
	     
	     Account account = new Account();
	     account.createAccount();
	     
	   //  user.getAccount();
	   //  user.setAccount(account);
	     
	     //Need to use merge here for the system to import the information into the database
	     session.merge(user); 
	     session.merge(account);
	     
	   /*  Manager manager = new Manager();     
	     manager.create(); 
	     session.persist(manager);*/
	    
	     session.getTransaction().commit();
	     session.close();
	 }
}
