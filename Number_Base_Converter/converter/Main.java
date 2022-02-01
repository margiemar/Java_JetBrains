package converter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Enter two numbers in format: {source base} {target base} (To quit type /exit)  ");
            String answer = in.nextLine();

            if (answer.equals("/exit")) {
                System.exit(0);
            }

            BigIntConverter userTask = new BigIntConverter(answer);
            userTask.converter();
        }


        //FOR "TO DECIMAL - FROM DECIMAL" ONLY
            //String action = in.nextLine();
            //switch (action) {
            //    case "/from":
            //        FromDecimal fromD = new FromDecimal();
            //        fromD.converter();
            //        break;
            //    case "/to": ToDecimal toD = new ToDecimal();
            //        toD.converter();
            //        break;
            //    case "/exit": System.exit(0);
            //        break;

            //}

         //}

    }
}
