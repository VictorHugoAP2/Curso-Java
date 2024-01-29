import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        try{
            System.out.println("Enter account data");
            System.out.println("Number: ");
            Integer number = sc.nextInt();
            System.out.println("Holder: ");
            String holder = sc.nextLine();
            System.out.println("Initial balance: ");
            Double initialBalance = sc.nextDouble();
            System.out.println("Withdraw Limit");
            Double withdrawLimit = sc.nextDouble();
    
            Account acc = new Account(number, holder, initialBalance, withdrawLimit);
    
            System.out.println("Enter amount for withdraw: ");
            acc.withdraw(sc.nextDouble());
        }catch(DomainException e){
            System.out.println(e.getMessage());
        }catch(RuntimeException e){
            System.out.println("Unexpected error");
        }
    }
}
