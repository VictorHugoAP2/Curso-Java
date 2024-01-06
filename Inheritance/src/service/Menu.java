package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Company;
import model.Individual;
import model.TaxPayer;

public class Menu {
    public Menu(){
    }

	public List<TaxPayer> readTaxPayerData(){
		List<TaxPayer> payers = new ArrayList<>();
		int numberOfPayers = readInteger("Enter the number of tax payers: ");
		for(int i = 0; i < numberOfPayers; i++){
			System.out.println("Tax payer #" + (i + 1) + " data:");
			String typeOfPayer = "";
			do{
				typeOfPayer = readChar("Individual or company (i/c)?").toLowerCase();
				if(typeOfPayer.equals("i")){
					payers.add(readInvidualPayer());
				}else{
					if(typeOfPayer.equals("c")){
						payers.add(readCompanyPayer());
					}else{
						System.out.println("Invalid option! Please select i for Individual or c for company");
					}
				}
			}while(!typeOfPayer.equals("i") && !typeOfPayer.equals("c"));
		}
		return payers;
	}

	public void showTaxes(List<TaxPayer> payers){
		if(payers.size() > 0){
            System.out.println("\nTAXES PAID: ");
            Double sum = 0.0;
            for(TaxPayer payer: payers){
                sum += payer.tax();
                System.out.println(payer.getName() + ": $ " + payer.tax());
            }
            System.out.printf("\nTotal Taxes: $ %.2f", sum);
        }else{
            System.out.println("No there TAXES PAID");
        }
	}

	public TaxPayer readInvidualPayer(){
		TaxPayer indivual = new Individual(readString("Name: "), readDouble("Anual income: "), readDouble("Health expenditures: "));
		return indivual;
	}

	public TaxPayer readCompanyPayer(){
		TaxPayer companyPayer = new Company(readString("Name: "), readDouble("Anual income"), readInteger("Number of employees: "));
		return companyPayer;
	}

    Scanner sc = new Scanner(System.in);
	public String readString(String text) {
		System.out.println(text);
		return sc.nextLine();
	}

	public String readChar(String text) {
		System.out.println(text);
		String input = sc.next();
		sc.nextLine();
		return input;
	}
	
	public Integer readInteger(String text) {
		System.out.println(text);
		return sc.nextInt();
	}
	
	public Double readDouble(String text) {
		System.out.println(text);
		return sc.nextDouble();
	}
}
