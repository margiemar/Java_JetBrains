package converter;

import java.util.Scanner;

public class FromDecimal {
    Scanner in = new Scanner(System.in);

    void converter() {
        System.out.print("Enter number in decimal system: ");
        int tenN = in.nextInt();
        System.out.print("Enter target base:  ");
        int base = in.nextInt();

        System.out.println("Conversion result: " + Integer.toString(tenN, base));
    }
}
