package com.inventrix.bank;

import java.util.Scanner;

public class BankAccount {
	

	public static int balance;
	private static int previousTransactions;

	public static void showmenu() {
		
		BankApp bankapp= new BankApp();
		Bank obj = new Bank(bankapp.getcName(),bankapp.getId());
		char option = '\0';
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String customerName =scan.nextLine();
		System.out.println("welcome"+customerName);
		String customerId = scan.nextLine();
		System.out.println("Id number"+customerId);
		BankBo.search(customerName, customerId);
		//System.out.println("enter your balance amount");
		//balance=scan.nextInt();
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
			 BankApp bank = new BankApp();
			 balance=bank.getBalance();
			System.out.println("Balance="+balance);
			System.out.println("\n");
			break;
		 case 'B':
		
				System.out.println("enter deposit amount");
				int amount = scan.nextInt();
				deposit(amount);
				System.out.println("\n");
				break;	
		 case 'C':
		
				System.out.println("enter withdraw amount");
				int amount1 = scan.nextInt();
				withdraw(amount1);
				System.out.println("\n");
				break;
			
		 case 'D':
			
			 getPreviousTransactions();
			 System.out.println("\n");
			 break;
		 case 'E':
		
			 break;
			 
		default:
			System.out.println("Invalid option");
			break;
			
		}
	   }while(option!='E');
		System.out.println("Thankyou for using our services");
		
	}

	private static void withdraw(int amount1) {
		if (amount1 != 0) {
			   
			  balance = balance - amount1;
			  previousTransactions = -amount1;
		  }
		 }
		
	

	private static void getPreviousTransactions() {
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

	private static void deposit(int amount) {
		 if (amount != 0) {
			  balance = balance + amount;
			  previousTransactions = amount;
		  }
		
	} 
	
	
	
	
    
}
