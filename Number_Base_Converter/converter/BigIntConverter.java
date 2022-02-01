package converter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;

public class BigIntConverter {
    Scanner in = new Scanner(System.in);
    int sBase;
    int tBase;
    String baseSet;
    String fractionPart = "";

    public BigIntConverter(String baseSet) {
        this.baseSet = baseSet;
    }

    void converter() {
        String[] Bases = baseSet.split(" ");
        sBase = Integer.parseInt(Bases[0]);
        tBase = Integer.parseInt(Bases[1]);

        while (true) {
            System.out.printf("Enter number in base %d to convert to base %d (To go back type /back) ", sBase, tBase);
            String ans = in.nextLine();
            if (ans.equals("/back")) {break;}

            String[] parts = ans.split("\\.");
            BigInteger intPart = new BigInteger(parts[0], sBase);

            if (parts.length == 1) {
                System.out.println("Conversion result: " + intPart.toString(tBase));
            } else if (parts.length == 2 && parts[1].equals("0")) {
                fractionPart = ".00000";
            } else if (parts.length == 2) {
                Fraction frPart = new Fraction(parts[1], sBase, tBase);
                fractionPart = frPart.converter();
                String result = intPart.toString(tBase) + fractionPart;
                if (tBase > 2 && tBase < 11) {
                    BigDecimal z = new BigDecimal("1.0000");
                    BigDecimal bd = new BigDecimal(result);
                    System.out.println("Conversion result: " + bd.multiply(z).setScale(5, RoundingMode.UNNECESSARY));
                } else {
                    if (fractionPart.length() < 6) {
                        int append = 6 - fractionPart.length();
                        System.out.println("Conversion result: " + result + "0".repeat(append));
                    } else {
                        System.out.println("Conversion result: " + result);
                    }
                }
            }
        }
    }
}
