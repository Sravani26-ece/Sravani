package com.inventrix.bank;

import java.util.Scanner;

public class Bank {
	 static  int balance;
	 static int previousTransactions;
	private String customerId;
	private String customerName;

	 
      Bank(String cName,String id){
		customerName = cName;
		customerId = id;
	}

	 public static void deposit (int amount){
	  if (amount != 0) {
		  balance = balance - amount;
		  previousTransactions = amount;
	  }
	 }
	 public void withdraw (int amount){
		  if (amount != 0) {
			  balance = balance + amount;
			  previousTransactions = -amount;
		  }
		 }
	 public static void getPreviousTransactions() {
		 if(previousTransactions > 0) {
			 System.out.println("Deposit:"+previousTransactions);
		 }
		 else if(previousTransactions < 0) {
			 System.out.println("Withdraw:"+Math.abs(previousTransactions));
		 }
		 else {
			 System.out.println("no any transactions occured ");
		 }
	 }
	 
	public static void showmenu() {
		char option = '\0';
		Scanner scan = new Scanner(System.in);
		String customerName = null;
		System.out.println("welcome"+customerName);
		String customerId = null;
		System.out.println("Id number"+customerId);
		System.out.println("\n");
		System.out.println("A. checkBalance");
		System.out.println("B. deposit");
		System.out.println("C. withdraw");
		System.out.println("D. previousTransactions");
		System.out.println("E. exit");
		
		do {
			System.out.println("enter an option");
			option = scan.next().charAt(0);
			System.out.println("\n");
			
		switch	(option) {
		 case 'A':
			System.out.println("- - - - - -");
			System.out.println("Balance="+balance);
			System.out.println("\n");
			break;
		 case 'B':
				System.out.println("- - - - - -");
				System.out.println("enter an amount");
				int amount = scan.nextInt();
				deposit(amount);
				System.out.println("\n");
				break;	
		 case 'C':
			    System.out.println("- - - - - -");
				System.out.println("enter withdraw amount");
				int amount1 = scan.nextInt();
				deposit(amount1);
				System.out.println("\n");
				break;
			
		 case 'D':
			 System.out.println("- - - - - -");
			 getPreviousTransactions();
			 System.out.println("- - - - - -");
			 System.out.println("\n");
			 break;
		 case 'E':
			 System.out.println("- - - - - -");
			 break;
			 
		default:
			System.out.println("Invalid option");
			break;
			
		}
	   }while(option!='E');
		System.out.println("Thankyou for using our services");
		
	}

	}


