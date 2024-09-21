/**
 * program the calculates the total energy cost of all the cards in Slay the Spire deck.
 * Create a report tha tallies the total energy cost and a energy cost histogram for the deck and
 * output the report in a pdf file
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class SlayTheSpire {

    static List<String> invalid_cards = new ArrayList<>();
    static HashMap<String, Integer> cardDeck = new HashMap<>();


    /**
     * Reads in the user's txt file line by line.
     * Checks for the correct format and cost range.
     * Records the card name and the cost of the card if it doesn't exist in the HashMap
     * otherwise it updates the card's cost (value) in the HashMap.
     * @param filePath
     * @return
     */
    public static boolean  readTxtFile(String filePath) {

        BufferedReader reader = null;

        try {
            //read file
            reader = new BufferedReader(new FileReader(filePath));
            String line;
            int line_counter = 0;

            //read file line by line
            while ((line = reader.readLine()) != null) {
                line_counter =+ 1; //counts the amount of lines in the txt file
                if(line_counter > 1000){
                    return false;
                }

                if( invalid_cards.size() > 10){
                    return false;
                }

                line = line.replaceAll("\\s+", ""); //remove white spaces in string
                line = line.toLowerCase(); //remove uppercase

                if (line.isEmpty()){ //checks if string is empty
                    invalid_cards.add(line); //adds to invalid_cards if true
                }

                if (line == null || !line.contains(":")) { //checks for invalid format
                    invalid_cards.add(line); //adds invalid card to invalid_card list
                }

                String[] str_and_int = line.split(":"); //split at ":"

                if(str_and_int.length == 2 && isInteger(str_and_int[1])){
                    String key = str_and_int[0];
                    int value = Integer.parseInt(str_and_int[1]);

                    if(!(value <= 6) || !(value >= 0)){
                        invalid_cards.add(line); //adds invalid card to invalid_card list
                    }

                    if (cardDeck.containsKey(key)) {
                        cardDeck.put(key, cardDeck.get(key) + value); //updates existing values of repeated keys
                    } else {
                        cardDeck.put(key, value);  //add new keys
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
        return true;
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


    public static void generateFile(boolean file_to_generate){

        if(file_to_generate == false){

            //generate VOID file
        }

        if(file_to_generate == true){

            //generate REPORT (deck id, total cost of cards in deck, histogram of cards in deck
        }
    }
    public static void main(String[] args) {

        String filePath = "/Users/sophiabrix/Desktop/Java Programs/SlayTheSpireDeckCostTally/src/Deck.txt";

        //SCANNER TO TAKE IN INPUT
        boolean file_to_generate = readTxtFile(filePath);

        generateFile(file_to_generate);

        System.out.println(cardDeck);
    }

}

/*
Things to check for:
- invalid cost value
- empty names
- card that's only spaces or a tab
-Must include invalid cards in the report!!!^^^ & ignore the values

- 10 invalid cards
- more than 1000 cards
-Produce a VOID report!!!^^^ (contains the message: VOID

AFTER ALL FILES HAVE BEEN GENERATED THE HASHMAP AND LIST SHOULD BE CLEARED!!!

 */