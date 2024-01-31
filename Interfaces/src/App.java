import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Vehicle;
import model.entities.VehicleRental;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Entre com os dados do aluguel");
        System.out.println("Modelo do carro: ");
        String carModel = sc.nextLine();
        System.out.println("Retirada (dd/MM/YYYY hh:mm): ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
        System.out.println("Retorno (dd/MM/YYYY hh:mm): ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);

        VehicleRental rental = new VehicleRental(start, finish, new Vehicle(carModel));

        System.out.println("Entre com o preço por hora: ");
        Double pricePerHour = sc.nextDouble();
        System.out.println("Entre com o preço por dia: ");
        Double pricePerDay = sc.nextDouble();

        RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
        rentalService.processInvoice(rental);

        System.out.println("Fatura");
        System.out.println("Pagamento basico: " + rental.getInvoice().getBasicPayment());
        System.out.println("Imposto: " + rental.getInvoice().getTax());
        System.out.println("Pagamento Total: " + rental.getInvoice().getTotalPayment());
    }
}
