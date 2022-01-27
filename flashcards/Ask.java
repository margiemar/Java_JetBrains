package flashcards;

import java.util.Map;

public class Ask {

    Map<String, String> map;
    int number = 0;
    String empty;
    String answer;
    String[] defs;
    String keyForAnswer = "";

    public Ask(Map<String, String> map) {
        this.map = map;
    }

    public void askCard() {
        IOLog.println("How many times to ask?");
        number = IOLog.nextInt();
        empty = IOLog.nextLine();
        defs = map.keySet().toArray(new String[0]);
        for (int i = 0; i < number; i++) {
            String out = String.format("Print the definition of \"%s\":", defs[i]);
            IOLog.println(out);
            answer = IOLog.nextLine();

            for (var entry : map.entrySet()) {
                if (entry.getValue().equals(answer)) {
                    keyForAnswer = entry.getKey();
                }
            }

            String nokey = String.format("Wrong. The right answer is \"%s\".", map.get(defs[i]));
            String wrongAnswer =
                    String.format("Wrong. The right answer is \"%s\", but your definition is correct for \"%s\".",
                    map.get(defs[i]), keyForAnswer);


            if (!map.containsValue(answer)) {
                IOLog.println(nokey);
                if (!HardestCard.hardCard.containsKey(defs[i])) {
                    HardestCard.hardCard.put(defs[i], 1);
                } else {
                    int oldvalue = HardestCard.hardCard.get(defs[i]);
                    HardestCard.hardCard.put(defs[i], ++oldvalue);
                }
            } else if (answer.equals(map.get(defs[i]))) {
                IOLog.println("Correct!");
            } else {
                IOLog.println(wrongAnswer);
                if (!HardestCard.hardCard.containsKey(defs[i])) {
                    HardestCard.hardCard.put(defs[i], 1);
                } else {
                    int oldvalue = HardestCard.hardCard.get(defs[i]);
                    HardestCard.hardCard.put(defs[i], ++oldvalue);
                }

            }

        }
    }
}
