package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.HourContract;
import model.Worker;

public class Menu {
    public Menu(){

    }

    public List<HourContract> readContracts() throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        int contractsQuantity = readInteger("How many contracts to this worker? ");
        List<HourContract> contractsList = new ArrayList<>();
        for(int i = 0; i < contractsQuantity; i++){
            System.out.println("Enter contract #" + (i + 1) + " data");
            HourContract hourContract = new HourContract();
            System.out.print("Date (DD/MM/YYYY): ");
			hourContract.setDate(sdf.parse(sc.next()));
            hourContract.setValuePerHour(readDouble("Value per hour: "));
            hourContract.setHours(readInteger("Duration (hours): "));
            contractsList.add(hourContract);
        }
        return contractsList;
    }

    public void income(Worker worker){
        System.out.print("Enter month and year to calculate income:");
        Integer year = readInteger("Type the year (YYYY): ");
		Integer month = readInteger("Type the month (m) or (mm): ");
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment());
        System.out.println("Income for " + month + "/" + year + ": " + String.format("%.2f", worker.income(year, month)));
    }

    Scanner sc = new Scanner(System.in);
	public String readString(String text) {
		System.out.println(text);
		return sc.nextLine();
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
