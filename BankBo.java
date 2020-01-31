package com.inventrix.bank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


@SuppressWarnings("unused")
public class BankBo {

	public static BankApp bankapp;
	public static int balance;
	private static int previousTransactions;

	private static Object banking;
	public static boolean storeBankDetails(BankApp bank) {
		boolean status=false;
		BufferedWriter writer;
		String str="";
		StringBuilder fileContents=new StringBuilder(str);
		try {
			String FileName="/home/user/practice/ba.txt";
			File file=new File(FileName);
			FileReader br = new FileReader(file);
			int i;
			while((i=br.read())!=-1){
				fileContents.append((char)i);
			}
			if(file.length()>0){
				fileContents.append("\n");
			}
			String fileContent = "customerName:"+bank.getcName()+" customerGender:"+bank.getGender()+"customerId:"+bank.getId()+"customerBalance:"+bank.getBalance()+"\n";
			String totalContent=(fileContents.append(fileContent)).toString();
			writer=new BufferedWriter(new FileWriter(FileName));
			writer.write(totalContent);
			status=true;
			writer.close();
		}catch(IOException e) {
			status = false;
			e.printStackTrace();
		}
		return status;

	}
	
	public static void showTransactionsMenu() {
		
		bankapp= new BankApp();
		Bank obj = new Bank(bankapp.getcName(),bankapp.getId());
		char option;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Your id");
		String customerId = scan.nextLine();
		
		
		bankapp=BankBo.search(customerId);
		
		
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
				System.out.println("Balance="+bankapp.getBalance());
				System.out.println("\n");
				break;
			case 'B':

				System.out.println("enter deposit amount");
				int amount = scan.nextInt();
				deposit(amount,bankapp.getBalance());
				System.out.println("\n");
				break;	
			case 'C':

				System.out.println("enter withdraw amount");
				int amount1 = scan.nextInt();
				withdraw(amount1,bankapp.getBalance());
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


	private static void withdraw(int amount1, int balance) {
		if (amount1 != 0) {
			   
			  balance = balance - amount1;
			  bankapp.setBalance(balance);
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

	private static void deposit(int amount,int balance) {
		 if (amount != 0) {
			  balance = balance + amount;
			  bankapp.setBalance(balance);
			  previousTransactions = amount;
		  }
		
	} 

	public static  void showCustomerDetails() throws Exception { 
		try {
			String str="";
			StringBuilder fileContents=new StringBuilder(str);
			File file = new File("/home/user/practice/ba.txt");  
			BufferedReader br = new BufferedReader(new FileReader(file)); 

			String st; 
			while ((st = br.readLine()) != null) 
				System.out.println(st); 
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static BankApp search( String id) {
		String FileName="/home/user/practice/ba.txt";
		BankApp bankApp = new BankApp(); 
		File file=new File(FileName);
		String line = new String();
		try {
			FileReader br = new FileReader(file);
			Scanner sc = new Scanner(br);
			int i=0;
			while(sc.hasNext()) {
				line = sc.nextLine();
				bankApp = getLineObject(line);
				if(bankApp.getId().equalsIgnoreCase(id)) {
					System.out.println("These are Your Details:");
					System.out.println(bankApp);
					return bankApp;
				}
			}
			return bankApp;
		}catch(IOException e) {
			return bankApp;
		}
	}

	public static BankApp getLineObject(String line) {
		BankApp banking = new BankApp();
		String data[] = line.split(",");
		List <String> details = Arrays.asList(data);
		for(String pair :details) {
			if (pair.startsWith("customerName:")) {
				banking.setcName(pair.split(":")[1]);
			}
			if (pair.startsWith("customerGender:")) {
				banking.setGender(pair.split(":")[1]);
			}
			if (pair.startsWith("customerId:")) {
				banking.setId(pair.split(":")[1]);
			}
			if (pair.startsWith("customerBalance:")) {
				banking.setBalance(Integer.parseInt(pair.split(":")[1]));
			}
		}

		return banking;
	}

}




