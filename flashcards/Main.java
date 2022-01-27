package flashcards;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, String> argsMap = new HashMap();
        String FinExportFile = "";

        if (args.length == 0) {
            App app = new App(FinExportFile);
            app.run();
        } else {
            for (int i = 0; i < args.length; i = i + 2) {
                argsMap.put(args[i], args[i + 1]);
            }

            if (argsMap.containsKey("-export")) {
                FinExportFile = argsMap.get("-export");
            }

            if (argsMap.containsKey("-import")) {
                App app = new App(FinExportFile);
                app.startImport(argsMap.get("-import"));
                app.run();
            } else {
                App app = new App(FinExportFile);
                app.run();
            }
        }
    }
}