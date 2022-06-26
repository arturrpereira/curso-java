import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class App {
    public static void main(String[] args) throws Exception {
    
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a fila path: ");
        String strPath = sc.nextLine();

        File path = new File(strPath);

        List<Product> list = new ArrayList<>();       

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            
            while (line != null) {
                String string = line;
                String[] parts = string.split(",");
                String name = parts[0];
                Double price = Double.parseDouble(parts[1]);
                Integer quantity = Integer.parseInt(parts[2]);
                Product product = new Product(name, price, quantity);
                
                list.add(product);
                line = br.readLine();
            }
       }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        new File("C:\\Users\\artuh\\OneDrive\\Documents\\exerc" + "\\out").mkdir();
        String filePath = "C:\\Users\\artuh\\OneDrive\\Documents\\exerc\\out\\summary.csv";
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Product product : list) {
                bw.write(product.getName() + "," + String.format("%.2f", product.calcTotal()));
                bw.newLine();
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}
