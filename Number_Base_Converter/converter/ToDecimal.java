package converter;

import java.util.Scanner;

public class ToDecimal {
    Scanner in = new Scanner(System.in);

    void converter() {
        System.out.print("Enter source number: ");
        String n = in.nextLine();
        System.out.print("Enter source base: ");
        int base = in.nextInt();

        System.out.println("Conversion to decimal result: " + Integer.parseInt(n, base));
    }
}
