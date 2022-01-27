package flashcards;

import java.io.*;
import java.util.*;

public class Import {
    String importFile = "";
    Map<String, String> map;
    int keysCount;
    String subMap = "=";
    String subHard = "&";

    public Import(Map<String, String> map) {

        this.map = map;
    }

    public Import (String userFile, Map<String, String> map) {

        this.importFile = userFile;
        this.map = map;
    }

    public void impCard() {

        if ("".equals(importFile)) {
            IOLog.println("File name:");
            this.importFile = IOLog.nextLine();
        }
        File file = new File(this.importFile);
        try (Scanner inF = new Scanner(file)) {
            while (inF.hasNext()) {
                String importString = inF.nextLine();
                if (importString.contains(this.subMap)) {
                    String[] tmp = importString.split("=");
                    map.put(tmp[0], tmp[1]);
                    this.keysCount++;
                } else if (importString.contains(this.subHard)) {
                    String[] tmp = importString.split("&");
                    HardestCard.hardCard.put(tmp[0], Integer.valueOf(tmp[1]));
                    this.keysCount++;
                }
            }
            String out = String.format("%d cards have been loaded.\n", keysCount);
            IOLog.println(out);
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            IOLog.println("File not found.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
