package converter;

import java.math.*;

public class Fraction {

    BigDecimal resInDecimal = new BigDecimal("0");
    String result = "";
    int sBase;
    int tBase;
    String fraction;
    BigDecimal sR;
    BigDecimal tR;

    public Fraction(String fraction, int sBase, int tBase) {
        this.sBase = sBase;
        this.tBase = tBase;
        this.sR = new BigDecimal(sBase);
        this.tR = new BigDecimal(tBase);

        if (sBase <= 10) {
            this.fraction = fraction;
        } else {
            this.fraction = fraction.toUpperCase();
        }
    }

    String converter() {
        //to decimal
        if (sBase == 10) {
            fraction = "0." + fraction;
            resInDecimal = new BigDecimal(this.fraction);
        } else if (sBase < 10) {
            double dec = 0;
            String[] fArr = fraction.split("");
            for (int i = 0; i < fArr.length; i++) {
                String bitS = fArr[i];
                int bitI = Integer.valueOf(bitS);
                dec = dec + bitI / ((double) Math.pow(sBase, i + 1));
            }

            resInDecimal = new BigDecimal(dec);

        } else {
            String[] fArr = fraction.split("");

            for (int i = 0; i < fraction.length(); i++) {

                String oneNunmer = fArr[i];
                BigDecimal fractNumber;
                String reg = "\\d";
                if (oneNunmer.matches(reg)) {
                    fractNumber = new BigDecimal(oneNunmer);
                } else {
                    //fractNumber = new BigDecimal(String.valueOf(fraction.charAt(i) - 55));
                    fractNumber = new BigDecimal(String.valueOf(Character.getNumericValue(fraction.charAt(i))));
                }
                BigDecimal iter = fractNumber.divide(sR.pow(i + 1), 6, RoundingMode.HALF_DOWN);
                resInDecimal = resInDecimal.add(iter);
                fractNumber.intValue();
            }
        }

        //to target radix
        BigDecimal reminder;
        BigDecimal rest = resInDecimal;

        for (int i = 0; i < 5; i++) {
            BigDecimal temp = rest.multiply(tR);
            reminder = temp.remainder(BigDecimal.ONE);
            int intPart = temp.intValue();

            if (intPart < 10 || tBase <= 10) {
                result = result + intPart;
            } else {
                intPart = intPart + 55;
                char c = (char) intPart;
                result = result + c;
            }
            rest = reminder;

            if (reminder.compareTo(BigDecimal.ZERO) == 0) {
                break;
            }
        }
        return "." + result.toLowerCase();
    }
}
