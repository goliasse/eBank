package net.codejava.eBankProgram;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "Manager")
public class Manager {
	private String lastName; 
	private String firstName; 
	private String managerUName; 
	private String managerPass;
	@Id
	@Column(name = "managerID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long managerID;
	
	public long getManagerID() {
		return managerID;
	}
	public void setManagerID(long managerID) {
		this.managerID = managerID;
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
	public String getManagerUName() {
		return managerUName;
	}
	public void setManagerUName(String managerUName) {
		this.managerUName = managerUName;
	}
	public String getManagerPass() {
		return managerPass;
	}
	public void setManagerPass(String managerPass) {
		this.managerPass = managerPass;
	}
}
