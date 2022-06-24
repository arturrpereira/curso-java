import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Payers;
import entities.Individual;
import entities.Company;

public class App {
    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Payers> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        for (int i=1; i<=n; i++) {
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Anual income: ");
            Double anualIncome = sc.nextDouble();

            if(ch == 'i') {

                System.out.print("Health expenditures: ");
                Double healthExpenditures = sc.nextDouble();
                list.add(new Individual(name, anualIncome, healthExpenditures));
            }
            else {
                System.out.print("Number of employees: ");
                Integer numberOfEmployees = sc.nextInt();
                list.add(new Company(name, anualIncome, numberOfEmployees));
            }
        }
        
        System.out.println();
        System.out.println("TAXES PAID:");
        for (Payers payers: list) {
            System.out.println(payers.getName() + ": $ " + String.format("%.2f", payers.totalTaxes()));
        }

        Double totalTaxes = 0.00;
        System.out.println();
        for (Payers payers : list) {
            totalTaxes += payers.totalTaxes();
        }

        System.out.println("TOTAL TAXES: $ " + String.format("%2.f", totalTaxes));

        sc.close();
    }
}
