import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;
import model.service.Menu;

public class App {
    public static void main(String[] args) {
        Menu menu = new Menu();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try{
            int number = menu.readInteger("Room number: ");
            Date checkIn = sdf.parse(menu.readNext("Check-in date (dd/MM/yyyy)"));
            Date checkOut = sdf.parse(menu.readNext("Check-out date (dd/MM/yyyy)"));
    
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println(reservation);
    
            System.out.println();
            System.out.println("Enter date to update the reservation: ");
            checkIn = sdf.parse(menu.readNext("Check-in date (dd/MM/yyyy)"));
            checkOut = sdf.parse(menu.readNext("Check-out date (dd/MM/yyyy)"));
    
           reservation.updateDates(checkIn, checkOut);
           System.out.println(reservation);
        }
        catch(ParseException e){
            System.out.println("Invalid date format");
        }
        catch(DomainException e){
            System.out.println(e.getMessage());
        }
        catch(RuntimeException e){
            System.out.println("Unexpected error");
        }
    }
}
