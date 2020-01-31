package com.inventrix.bank;

import java.util.Scanner;

public class Bank {
	 static  int balance;
	 static int previousTransactions;
	private String customerId;
	private String customerName;

	 
      Bank(String cName,String id){
		this.customerName = cName;
		this.customerId = id;
	}

}

