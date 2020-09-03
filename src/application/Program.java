package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import service.ContractService;
import service.PaypalService;

public class Program {
	
	public static void main(String[] agrs) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter contract data: ");
		System.out.print("number: ");
		int number = sc.nextInt();
		System.out.print("Date: ");
		Date date = sdf.parse(sc.next());
		System.out.print("Total value: ");
		double totalValue = sc.nextDouble();
		
		Contract contract = new Contract(number, date, totalValue);
			
		System.out.print("Enter number of installment: ");
		int n = sc.nextInt();
		
		ContractService contractservice = new ContractService(new PaypalService());
		
		contractservice.processContract(contract, n);
		
		System.out.println();
		for(Installment  x : contract.getInstallments()) {
			System.out.println(x);
		}
		
		sc.close();
	}

}
