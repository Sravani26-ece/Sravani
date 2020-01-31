package com.inventrix.bank;

import java.util.Arrays;
import java.util.List;

public class BankApp {

	private String cName;
	private String gender;
	private String id;
	private int balance;
	
	public String toString() {
		String data = "name:"+this.cName+"gender:"+this.gender+"id:"+this.id+"InitialBalance:"+this.balance;
		return data;
		
	}
	
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}


	

}
}
