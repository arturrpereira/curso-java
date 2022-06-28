import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("How many students for course A? ");
        Integer n1 = sc.nextInt(); 

        Set<Integer> set = new HashSet<>();

        for(int i=1; i<=n1; i++) {
            Integer aluno = sc.nextInt();
            set.add(aluno);
        }

        System.out.print("How many students for course B? ");        
        Integer n2 = sc.nextInt(); 

        for(int i=1; i<=n2; i++) {
            Integer aluno = sc.nextInt();
            set.add(aluno);
        }

        System.out.print("How many students for course C? ");
        Integer n3 = sc.nextInt(); 

        for(int i=1; i<=n3; i++) {
            Integer aluno = sc.nextInt();
            set.add(aluno);
        }

        System.out.println("Total students: " + set.size());
        sc.close();
    }
}
