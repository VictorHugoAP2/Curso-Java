package model.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public Menu(){

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

    public String readNext(String text){
        System.out.println(text);
        return sc.next();
    }
    
}
