import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        Map<String, Integer> cookies = new LinkedHashMap<>();

        System.out.print("Enter file full path: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {

                String[] fields = line.split(",");

                if(cookies.containsKey(fields[0])) {

                    cookies.put(fields[0], cookies.get(fields[0]) + Integer.parseInt(fields[1]));          
                }
                else {

                    cookies.put(fields[0], Integer.parseInt(fields[1]));

                }

                line = br.readLine();
            }

            for (String key : cookies.keySet()) {

                System.out.println(key + ": " + cookies.get(key));
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } 

        sc.close();

    }
}
