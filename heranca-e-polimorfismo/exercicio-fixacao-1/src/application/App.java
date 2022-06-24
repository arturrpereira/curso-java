package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import application.entities.ImportedProduct;
import application.entities.Product;
import application.entities.UsedProduct;

public class App {
    public static void main(String[] args) throws Exception {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> list = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for (int i=1; i<=n; i++) {
            System.out.println("Product #" + i + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Price: ");
            Double price = sc.nextDouble();

            if(ch == 'u') {

                System.out.print("Namefacture date (DD/MM/YYYY): ");
                //Date date;
                //list.add(new UsedProduct(name, price,));
            }
            else if(ch == 'i') {
                System.out.print("Customs fee: ");
                Double customsFee = sc.nextDouble();
                list.add(new ImportedProduct(name, price, customsFee));
            }
            else {
                list.add(new Product(name, price));
            }
        }
        
        System.out.println();
        System.out.println("PRICE TAGS:");
        for (Product product: list) {
            System.out.println(product.priceTag());
        }
        sc.close();
    }
}
