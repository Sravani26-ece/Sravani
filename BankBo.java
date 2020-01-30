package com.inventrix.bank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


@SuppressWarnings("unused")
public class BankBo {
	
	public boolean storeBankDetails(BankApp bank) {
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
			String fileContent = "customer name:"+bank.getcName()+"\t customer gender:"+bank.getGender()+"\tcustomer id:"+bank.getId()+"\tcustomer balance:"+bank.getBalance()+"\n";
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
	 public static void search(String name , String id) {
			String FileName="/home/user/practice/ba.txt";
			File file=new File(FileName);
			try {
				FileReader br = new FileReader(file);
				Scanner sc = new Scanner(br);
				int i=0;
				while(sc.hasNext()) {
					String lineFromFile = sc.nextLine();
					if(lineFromFile.startsWith("customer name:"+name+"")) {
						String[] customerdetails = lineFromFile.split("	");
						String[] customerid = customerdetails[0].split(":");

						if(customerid[1].equalsIgnoreCase(name)) {
							for(int j=0;j<customerdetails.length;j++) {
								System.out.println(customerdetails[j]);
							}
						}
						i++;
					}
				}
			}
			catch(IOException e) {}
				
				
				
			}
		}


