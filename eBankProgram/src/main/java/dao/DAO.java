package dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import hibernate.util.HibernateUtil;
import net.codejava.eBankProgram.Account;
//import net.codejava.eBankProgram.Manager;
import net.codejava.eBankProgram.Customer;

public class DAO {

	public void createCustomerwithAccounts(Customer customer, List<Account> accounts) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(customer);

		for(Account account: accounts){
			account.setCustomerID(customer.getCustID());
			session.save(account);
		}

		session.getTransaction().commit();
		session.close();
	}

	public String fetchCustomerCredentials(String username) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		String hql = "SELECT E.custPass FROM Customer E WHERE E.custUName = :custUname";
		Query query = session.createQuery(hql);
		query.setParameter("custUname", username);
		List results = query.getResultList();
		if(results ==null || results.isEmpty())
			return null;
		else
			return results.get(0).toString();
	}

	public String fetchManagerCredentials(String uname) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		String hql = "SELECT E.managerPass FROM Manager E WHERE E.managerUName = :managerUname";
		Query query = session.createQuery(hql);
		query.setParameter("managerUname", uname);
		List results = query.getResultList();
		if(results == null || results.isEmpty())
			return null;
		else
			return results.get(0).toString();
	}
}
