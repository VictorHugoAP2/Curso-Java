package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import entities.enums.WorkerLevel;
import model.Department;
import model.HourContract;
import model.Worker;
import service.Menu;

public class Main {
    public static void main(String[] args) throws ParseException {
        Menu menu = new Menu();
        Worker worker = new Worker();

        worker.setDepartment(new Department(menu.readString("Type the Department name: ")));
        System.out.println("Enter Worker data:");
        worker.setName(menu.readString("Name: "));
        worker.setLevel(WorkerLevel.valueOf(menu.readLevel()));
        worker.setBaseSalary(menu.readDouble("Base salary: "));
        worker.setContracts(menu.readContracts());
        menu.showIncome(worker);
    }
}
