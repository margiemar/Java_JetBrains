package flashcards;

import java.util.*;

public class Remove {

    String term;
    Map<String, String> map;

    public Remove(Map<String, String> map) {
        this.map = map;
    }

    void remCard() {
        IOLog.println("Which card?");
        this.term = IOLog.nextLine();
        if (!map.containsKey(this.term)) {
            String out = String.format("Can't remove \"%s\": there is no such card.\n", this.term);
            IOLog.println(out);
        } else {
            map.remove(this.term);
            IOLog.println("The card has been removed.");
        }
    }
}
