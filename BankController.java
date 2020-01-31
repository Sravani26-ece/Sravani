package com.inventrix.bank;

import java.io.IOException;
import java.util.Scanner;

public class BankController {
	public static int balance1;
	public static void main(String args[]) throws IOException {
		
			System.out.println("WELCOME TO BANK DETAILS");
			start();
		
	}
	private static void start() throws IOException{
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("choose bank options:\n1.Add BankDetails\n2.show BankDetails\n3.show TransactionsMenu\n4.Exit");
			int switchInput = scanner.nextInt();
			switch(switchInput) {
				case 1:
					System.out.println("Enter the bankDetails\n");
	                addBankAccount();
					break;
				case 2: 
					
					BankBo.showCustomerDetails();
					start();
					break;
				case 3:
					BankBo.showTransactionsMenu();
					start();
				   break;
				case 4:
					return;
			}		  
		}catch(Exception e) {
			
		}
	
	}	
	
	
			
			public static void addBankAccount() throws IOException {
						BankApp bank = new BankApp();
						@SuppressWarnings("resource")
						Scanner scanner1 = new Scanner(System.in);
						System.out.println("Enter Customer Name");
						String cName = scanner1.nextLine();
						bank.setcName(cName);
						System.out.println("Enter Customer Gender");
						String gender = scanner1.nextLine();
						bank.setGender(gender);
						System.out.println("Enter Customer Id");
						String id= scanner1.nextLine();
						bank.setId(id);
						System.out.println("Enter Initial Balance");
						int balance= scanner1.nextInt();
						bank.setBalance(balance);
						scanner1.nextLine();
			 
						System.out.println("given input  details are correct or not?press(y or n):");
						String saveInput = scanner1.nextLine();
						if(saveInput.equalsIgnoreCase("y")||saveInput.equalsIgnoreCase("yes")) {
							BankBo BankBo = new BankBo();
							boolean isStored =BankBo.storeBankDetails(bank);
							if(isStored) {
								System.out.println("perfectly stored");
							}
								else {
									System.out.println("something went wrong");
								}
						}
							System.out.println("if you want to add some other movie details?press(y or n):");
							String addInput = scanner1.nextLine();
							if(addInput.equalsIgnoreCase("y")||addInput.equalsIgnoreCase("yes")) {
								System.out.println("\n");
								addBankAccount();
							}
								else {
									System.out.println("menu:");
									start();
								}
			
							}



			public int balance;
}
