package flashcards;

import java.util.*;

public class HardestCard {

    static Map<String, Integer> hardCard = new HashMap();     //map of errored card
    List<Integer> errCountList;                               // only counts of errors
    List<String> hardestList = new ArrayList<>();             //only hardest terms
    int maxCount;

    void reset() {
        hardCard.clear();
        IOLog.println("Card statistics have been reset.");
    }

    void printHardest() {

        if (this.hardCard.isEmpty()) {
            IOLog.println("There are no cards with errors.");
        }  else {

            //Getting max error
            this.errCountList = new ArrayList<>(this.hardCard.values());
            Collections.sort(this.errCountList);
            this.maxCount = this.errCountList.get(this.errCountList.size() - 1);

            //Getting of hardest card with max err
            for (var entry : this.hardCard.entrySet()) {
                if (entry.getValue() == this.maxCount) {
                    this.hardestList.add(entry.getKey());
                }
            }

            if (this.hardestList.size() == 1) {

                String out = String.format("The hardest card is \"%s\". You have %d errors answering it.",
                        this.hardestList.get(0), maxCount);
                IOLog.println(out);

            } else {

                String terms = "";                                                 //String of hardest terms
                String lastEl = this.hardestList.get(this.hardestList.size() - 1);
                this.hardestList.remove(this.hardestList.size() - 1);

                for (int i = 0; i < hardestList.size(); i++) {
                    terms = terms + String.format(" \"%s\",", hardestList.get(i));
                }

                terms = terms + String.format(" \"%s\"", lastEl);
                String out = String.format("The hardest cards are %s. You have %d errors answering them.", terms, maxCount);
                IOLog.println(out);
            }
        }

    }
}
