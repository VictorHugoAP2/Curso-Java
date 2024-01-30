import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entities.Product;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o caminho do arquivo CSV: ");
        String strPath = sc.nextLine();

        List<Product> products = new ArrayList<>();
        String pathParent = new File(strPath).getParent();
        
        List<String> outputLines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(strPath))){
            String line = br.readLine();
            while(line != null){
                String dados[] = line.split(",");
                products.add(new Product(dados[0], Double.parseDouble(dados[1].trim()), Integer.parseInt(dados[2])));
                line = br.readLine();
            }

            for(Product p: products){
                outputLines.add(p.getName() + "," + p.totalCalculate());
            }

            new File(pathParent + "\\subdir").mkdir();

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathParent + "\\subdir\\summary.csv"))){
                for (String outLine : outputLines){
                    bw.write(outLine);
                    bw.newLine();
                }
            }catch(IOException e){
                System.out.println(e.getMessage());
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }finally {
            if(sc != null){
                sc.close();
            }
        }
    }
}
