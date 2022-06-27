import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.service.ContractService;
import model.service.PaypalService;
import model.entities.Installment;

public class App {
    public static void main(String[] args) throws Exception {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter contract data");
        System.out.print("Number: ");
        Integer number = sc.nextInt();
        System.out.print("Date (dd/MM/yyyy):");
        Date date = sdf.parse(sc.next());
        System.out.print("Contract value: ");
        sc.nextLine();
        Double totalValue = sc.nextDouble();
        System.out.print("Enter number of installments: ");
        Integer months = sc.nextInt();

        System.out.println(months);
        Contract contract = new Contract(number, date, totalValue);
        ContractService contractService = new ContractService(new PaypalService());
        contractService.processContract(contract, months);

        System.out.println("Installments:");
        for (Installment installment : contract.getInstallments()) {
            System.out.println(sdf.format(installment.getDueDate()) + " - " + String.format("%.2f", installment.getAmount()));
        }
        sc.close();
    }
}
