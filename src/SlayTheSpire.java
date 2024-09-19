/**
 * program the calculates the total energy cost of all the cards in Slay the Spire deck.
 * Create a report tha tallies the total energy cost and a energy cost histogram for the deck and
 * output the report in a pdf file
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class SlayTheSpire {


    /**
     * Reads in the user's txt file line by line.
     * Checks for the correct format and cost range.
     * Records the card name and the cost of the card if it doesn't exist in the HashMap
     * otherwise it updates the card's cost (value) in the HashMap.
     * @param filePath
     * @return
     */
    public static HashMap<String, Integer>  readTxtFile(String filePath) {
        HashMap<String, Integer> cardDeck = new HashMap<>();
        BufferedReader reader = null;

        try {
            //read file
            reader = new BufferedReader(new FileReader(filePath));
            String line;

            //read file line by line
            while ((line = reader.readLine()) != null) {
                line = line.replaceAll("\\s+", ""); //check for white spaces in string

                if (line == null || !line.contains(":")) { //checks for invalid format
                    cardDeck.put("Invalid Format", null);
                }
                String[] str_and_int = line.split(":");

                if(str_and_int.length == 2 && isInteger(str_and_int[1])){
                    String key = str_and_int[0];
                    int value = Integer.parseInt(str_and_int[1]);

                    if(!(value <= 6) || !(value >= 0)){
                        cardDeck.put("Invalid cost for: " + key, null);


                    }
                    if (cardDeck.containsKey(key)) {
                        //updates existing values of repeated keys
                        cardDeck.put(key, cardDeck.get(key) + value);
                    } else {
                        //add new keys
                        cardDeck.put(key, value);
                    }
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //close BufferedReader
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return cardDeck;
    }

    /**
     * Helper method for readTxtFile method.
     * Checks if the given string is an integer.
     * Returns false if string is empty or null.
     * Returns true if string can be parsed as an integer.
     * @param str
     * @return boolean
     */
    public static boolean isInteger(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(str); //try to parse string as integer
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {

        String filePath = "/Users/sophiabrix/Desktop/Java Programs/SlayTheSpireDeckCostTally/src/Deck.txt";


        HashMap<String, Integer> cardDeck = readTxtFile(filePath);

        System.out.println(cardDeck);
    }

}
