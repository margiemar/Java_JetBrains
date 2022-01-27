package flashcards;

import java.io.*;
import java.util.*;

public class Export {
    String exportFile = "";
    Map<String, String> map;
    int count = 0;

    public Export(Map<String, String> map) {
        this.map = map;
    }
    public Export(String userFile, Map<String, String> map) {

        this.exportFile = userFile;
        this.map = map;
    }

    public void expCard() {

        if ("".equals(exportFile)) {
            IOLog.println("File name:");
            this.exportFile = IOLog.nextLine();
        }

        try (OutputStream fos = new FileOutputStream(exportFile)) {
            PrintWriter pw = new PrintWriter(fos);
            for (var entry : map.entrySet()) {
                pw.println(entry.getKey() + "=" + entry.getValue());
                this.count++;
            }
            for(var hard: HardestCard.hardCard.entrySet()) {
                pw.println(hard.getKey() + "&" + hard.getValue());
                this.count++;
            }
            String out = String.format("%d cards have been saved.\n", this.count);
            IOLog.println(out);
            pw.flush();
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
