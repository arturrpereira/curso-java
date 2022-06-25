import java.util.Locale;
import java.util.Scanner;

import models.entities.Account;
import models.exceptions.DomainExceptions;

public class App {
    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter account data");
            System.out.print("Number: ");
            Integer number = sc.nextInt();
            System.out.print("Holder: ");
            sc.nextLine();
            String holder = sc.nextLine();
            System.out.print("Initial balance: ");
            Double balance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            Double withDrawLimit = sc.nextDouble();
            Account account = new Account(number, holder, balance, withDrawLimit);

            System.out.println();
            System.out.print("Enter amount for withdraw: ");
            Double amount = sc.nextDouble();
            account.withdraw(amount);
            System.out.println("New balance: " + account.getBalance());
        }
        catch (DomainExceptions e) {
            System.out.println("Withdraw error: " + e.getMessage());
        }
        sc.close();
    }
}
