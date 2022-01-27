package flashcards;

import java.util.*;

class Add {
    String term;
    String definition;
    Map<String, String> map;

    public Add(Map<String, String> map) {
        this.map = map;
    }

    public void addCard() {
        IOLog.println("The card:");
        this.term = IOLog.nextLine();
        if (map.containsKey(this.term)) {
            String out = String.format("The card \"%s\" already exists.", this.term);
            IOLog.println(out);
        } else {
            IOLog.println("The definition of the card:");
            this.definition = IOLog.nextLine();
            if (map.containsValue(definition)) {
                String out = String.format("The definition \"%s\" already exists.", this.definition);
                IOLog.println(out);
            } else {
                map.put(this.term, this.definition);
                String out = String.format("The pair (\"%s\":\"%s\") has been added.", this.term, this.definition);
                IOLog.println(out);
            }
        }
    }
}
