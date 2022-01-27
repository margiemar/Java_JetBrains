package flashcards;

import java.util.Scanner;

public class IOLog {

    static Scanner in = new Scanner(System.in);


    static String nextLine () {
        String line = in.nextLine();
        Log.log.add(line);
        return line;
    }

    static int nextInt () {
        int nextN = in.nextInt();
        String nextNS = String.valueOf(nextN);
        Log.log.add(nextNS);
        return nextN;
    }

    static void println (String oS) {
        System.out.println(oS);
        Log.log.add(oS);
    }

}


