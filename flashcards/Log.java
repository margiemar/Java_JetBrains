package flashcards;

import java.io.*;
import java.util.*;

public class Log {

    String logfile;
    static List<String> log = new ArrayList<>();

    void savelog() {
        IOLog.println("File name:");
        logfile = IOLog.nextLine();

        try (OutputStream fos = new FileOutputStream(logfile)) {
            PrintWriter pw = new PrintWriter(fos, true);
            for (var s : log) {
                pw.println(s);
            }
            IOLog.println("The log has been saved.");
            pw.flush();
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
