package view;

import java.util.List;

import model.TaxPayer;
import service.Menu;

public class main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        List<TaxPayer> payers = menu.readTaxPayerData();
        menu.showTaxes(payers);
    }
}
