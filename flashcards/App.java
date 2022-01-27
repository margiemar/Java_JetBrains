package flashcards;

import java.util.*;

public class App {

    Map<String, String> storageMap = new LinkedHashMap<>();
    Scanner in = new Scanner(System.in);
    String finishExportFile = "";

    public App(String finishExportFile) {
        this.finishExportFile = finishExportFile;
    }



    void startImport(String StartFile) {
        Import impC = new Import(StartFile, storageMap);
        impC.impCard();
    }

    void run() {
        while (true) {
            IOLog.println("Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):");
            String action = IOLog.nextLine();
            switch (action) {
                case "add":
                    Add addC = new Add(storageMap);
                    addC.addCard();
                    break;
                case "remove":
                    Remove remC = new Remove(storageMap);
                    remC.remCard();
                    break;
                case "import":
                    Import impC = new Import(storageMap);
                    impC.impCard();
                    break;
                case "export":
                    Export expC = new Export(storageMap);
                    expC.expCard();
                    break;
                case "ask":
                    Ask askC = new Ask(storageMap);
                    askC.askCard();
                    break;
                case "log":
                    Log logC = new Log();
                    logC.savelog();
                    break;
                case "hardest card":
                    HardestCard hardC = new HardestCard();
                    hardC.printHardest();
                    break;
                case "reset stats":
                    HardestCard resetC = new HardestCard();
                    resetC.reset();
                    break;
                case "exit":
                    IOLog.println("Bye bye!");
                    if (!finishExportFile.equals("")) {
                        Export finalExport = new Export(finishExportFile, storageMap);
                        finalExport.expCard();
                    }
                    System.exit(0);
                case "printmap":
                    System.out.println(storageMap);
                case "printlog":
                    System.out.println(Log.log);
                default:
                    break;
            }
        }
    }
}