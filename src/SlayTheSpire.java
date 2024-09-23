/**
 * This program is designed to read a text file containing card names and energy points for a
 * game called Slay The Spire Deck Cost Tally and generate a corresponding PDF file that summarizes the deck's
 * contents. It consists of several key components:
 *
 * <ul>
 *     <li><strong>Card Data Processing:</strong> The program reads a text file
 *     where each line contains a card name and its associated cost in the
 *     format "key:value". It validates the data, counts the lines, and checks
 *     for invalid entries.</li>
 *
 *     <li><strong>Invalid Card Tracking:</strong> The program maintains a list
 *     of invalid card entries based on specific criteria, such as improper
 *     formatting or out-of-range values.</li>
 *
 *     <li><strong>Total Cost Calculation:</strong> The program computes the
 *     total cost of the cards in the deck and provides this information for
 *     report generation.</li>
 *
 *     <li><strong>PDF Generation:</strong> Based on the processed card data,
 *     the program generates a PDF file that can be either a report of the
 *     deck or a VOID file indicating no valid data.</li>
 *
 *     <li><strong>User Interaction:</strong> The program interacts with the user
 *     to input the file path of the text file, ensuring it is valid before
 *     proceeding with data processing and PDF generation.</li>
 * </ul>
 *
 * <p>Overall, this program serves as a utility for managing and reporting
 * on card decks in a structured manner, providing valuable insights into
 * deck composition and costs.</p>
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.nio.file.Paths;


public class SlayTheSpire {

    static List<String> invalid_cards = new ArrayList<>();
    static HashMap<String, Integer> cardDeck = new HashMap<>();
    static List<String> cardNames = new ArrayList<>();


    /**
     * The validCards method initializes a predefined list of valid card names for the game "Slay the Spire".
     * This method populates the global cardNames list with a collection of card names used in the game.
     * Each card name added represents a playable card from the game across various characters and card types.
     */
    public static void validCards(){
        cardNames.add("Strike");
        cardNames.add("Defend");
        cardNames.add("Bash");
        cardNames.add("Inflame");
        cardNames.add("Cleave");
        cardNames.add("Whirlwind");
        cardNames.add("Juggernaut");
        cardNames.add("Reaper");
        cardNames.add("Bludgeon");
        cardNames.add("Double Tap");
        cardNames.add("Iron Wave");
        cardNames.add("Battle Trance");
        cardNames.add("Armaments");
        cardNames.add("Shrug It Off");
        cardNames.add("Demon Form");
        cardNames.add("Anger");
        cardNames.add("Body Slam");
        cardNames.add("Clothesline");
        cardNames.add("Dropkick");
        cardNames.add("Entrench");
        cardNames.add("Evolve");
        cardNames.add("Exhume");
        cardNames.add("Flame Barrier");
        cardNames.add("Ghostly Armor");
        cardNames.add("Headbutt");
        cardNames.add("Heavy Blade");
        cardNames.add("Immolate");
        cardNames.add("Infernal Blade");
        cardNames.add("Limit Break");
        cardNames.add("Metallicize");
        cardNames.add("Pummel");
        cardNames.add("Rampage");
        cardNames.add("Sever Soul");
        cardNames.add("Spot Weakness");
        cardNames.add("Sword Boomerang");
        cardNames.add("True Grit");
        cardNames.add("Uppercut");
        cardNames.add("Wild Strike");
        cardNames.add("Neutralize");
        cardNames.add("Survivor");
        cardNames.add("Adrenaline");
        cardNames.add("After Image");
        cardNames.add("Backflip");
        cardNames.add("Bane");
        cardNames.add("Blade Dance");
        cardNames.add("Bullet Time");
        cardNames.add("Caltrops");
        cardNames.add("Cloak and Dagger");
        cardNames.add("Corpse Explosion");
        cardNames.add("Crippling Poison");
        cardNames.add("Dash");
        cardNames.add("Deadly Poison");
        cardNames.add("Deflect");
        cardNames.add("Dodge and Roll");
        cardNames.add("Escape Plan");
        cardNames.add("Flying Knee");
        cardNames.add("Footwork");
        cardNames.add("Glass Knife");
        cardNames.add("Heel Hook");
        cardNames.add("Infinite Blades");
        cardNames.add("Noxious Fumes");
        cardNames.add("Outmaneuver");
        cardNames.add("Poisoned Stab");
        cardNames.add("Predator");
        cardNames.add("Prepared");
        cardNames.add("Quick Slash");
        cardNames.add("Skewer");
        cardNames.add("Slice");
        cardNames.add("Tactician");
        cardNames.add("Unload");
        cardNames.add("Zap");
        cardNames.add("Dualcast");
        cardNames.add("All for One");
        cardNames.add("Amplify");
        cardNames.add("Ball Lightning");
        cardNames.add("Biased Cognition");
        cardNames.add("Capacitor");
        cardNames.add("Chaos");
        cardNames.add("Cold Snap");
        cardNames.add("Compile Driver");
        cardNames.add("Coolheaded");
        cardNames.add("Creative AI");
        cardNames.add("Defragment");
        cardNames.add("Doom and Gloom");
        cardNames.add("Echo Form");
        cardNames.add("Electrodynamics");
        cardNames.add("FTL");
        cardNames.add("Force Field");
        cardNames.add("Fusion");
        cardNames.add("Genetic Algorithm");
        cardNames.add("Glacier");
        cardNames.add("Go for the Eyes");
        cardNames.add("Heatsinks");
        cardNames.add("Hyperbeam");
        cardNames.add("Machine Learning");
        cardNames.add("Melter");
        cardNames.add("Multi-Cast");
        cardNames.add("Reboot");
        cardNames.add("Recursion");
        cardNames.add("Recycle");
        cardNames.add("Reinforced Body");
        cardNames.add("Static Discharge");
        cardNames.add("Steam Barrier");
        cardNames.add("Storm");
        cardNames.add("Sweeping Beam");
        cardNames.add("Tempest");
        cardNames.add("Thunder Strike");
        cardNames.add("Turbo");
        cardNames.add("White Noise");
        cardNames.add("Eruption");
        cardNames.add("Vigilance");
        cardNames.add("Alpha");
        cardNames.add("Blasphemy");
        cardNames.add("Bowling Bash");
        cardNames.add("Brilliance");
        cardNames.add("Carve Reality");
        cardNames.add("Consecrate");
        cardNames.add("Crush Joints");
        cardNames.add("Cut Through Fate");
        cardNames.add("Deceive Reality");
        cardNames.add("Devotion");
        cardNames.add("Empty Body");
        cardNames.add("Empty Fist");
        cardNames.add("Fear No Evil");
        cardNames.add("Foresight");
        cardNames.add("Indignation");
        cardNames.add("Judgement");
        cardNames.add("Mental Fortress");
        cardNames.add("Nirvana");
        cardNames.add("Prostrate");
        cardNames.add("Sanctity");
        cardNames.add("Sash Whip");
        cardNames.add("Signature Move");
        cardNames.add("Swivel");
        cardNames.add("Third Eye");
        cardNames.add("Tranquility");
        cardNames.add("Vault");
        cardNames.add("Wave of the Hand");
        cardNames.add("Worship");
    }

    /**
     * Reads a text file and processes its content to populate a card deck and
     * track any invalid cards.
     *
     * <p>This method reads each line of the specified text file, checks for
     * formatting issues, and validates the data. It counts the number of lines
     * read and ensures that the number does not exceed 1000. If more than 10
     * invalid cards are encountered, the method will terminate early and return
     * false.</p>
     *
     * <p>The expected format for each valid line is "key:value", where 'key'
     * represents a valid card name and 'value' is an integer between 0 and 6. Lines
     * that do not conform to this format, are empty, or have a 'value' outside
     * this range will be considered invalid.</p>
     *
     * @param filePath the path to the text file to be read
     * @return true if the file was read successfully and all conditions were met;
     *         false if there were issues such as exceeding the line limit,
     *         encountering too many invalid cards, or if an IOException occurred.
     */
    public static boolean  readTxtFile(String filePath) {

        BufferedReader reader = null;

        try {
            //read file
            reader = new BufferedReader(new FileReader(filePath));
            String line;
            int line_counter = 0;
            String line_no_space;

            //read file line by line
            while ((line = reader.readLine()) != null) {
                line_counter += 1; //counts the amount of lines in the txt file

                if(line_counter > 1000){ //if there's more than 1000 lines void report is made
                    return false;
                }

                if( invalid_cards.size() > 10){ //if there's more than 10 invalid cards void report is made
                    return false;
                }

                line_no_space = line.replaceAll("\\s+", ""); //remove white spaces in string


                if (line_no_space.isEmpty()){ //checks if string is empty
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

                    // Check if key (card name) exists in the cardNames list
                    else if (!cardNames.contains(key)) {
                        invalid_cards.add(line); // if key is not in cardNames, add it to invalid_cards
                    }

                    else if (cardDeck.containsKey(key)) {
                        cardDeck.put(key, cardDeck.get(key) + value); //updates existing values of repeated keys
                    } else {
                        cardDeck.put(key, value);  //add new keys
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            return false; //returns false if exception occurs
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
     * Determines whether the provided string can be parsed as an integer.
     *
     * <p>This method checks if the input string is null or empty, returning
     * false in such cases. If the string contains a valid integer representation,
     * it returns true. Otherwise, it will catch a {@link NumberFormatException}
     * and return false.</p>
     *
     * @param str the string to be checked for integer validity
     * @return {@code true} if the string can be parsed as an integer;
     *         {@code false} if the string is null, empty, or not a valid integer.
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


    /**
     * Calculates the total cost of cards in the specified deck.
     *
     * <p>This method iterates through the values of the provided
     * {@link HashMap} representing a deck of cards and sums up
     * all the cost values associated with each card.</p>
     *
     * @param cardDeck a {@link HashMap} where keys are card names
     *                 and values are their corresponding costs
     * @return the total cost of all cards in the deck as an {@code int}
     */
    public static int calculateTotalDeckCost(HashMap<String, Integer> cardDeck){
        int total_cost = 0;
        for (Integer cost : cardDeck.values()){
            total_cost += cost; //adds up all cost values in cardDeck HashMap
        }

        return total_cost;
    }

    /**
     * Generates a PDF file for a deck of cards, either as a report or a VOID file.
     *
     * <p>This method constructs the file path based on the provided directory
     * and a unique deck ID. Depending on the {@code file_to_generate} parameter,
     * it either generates a VOID file or a detailed report of the card deck.</p>
     *
     * @param file_to_generate a {@code boolean} indicating whether to generate
     *                         a VOID file ({@code false}) or a report file
     *                         ({@code true})
     * @param directory_path a {@code String} representing the path to the
     *                       directory where the PDF file will be created
     * @throws IllegalArgumentException if the directory path is invalid or
     *                                  if there are issues generating the file
     */
    public static void generateFile(boolean file_to_generate, String directory_path){

        String deck_ID = DeckIDGenerator.generateUniqueNumber();


        int total_cost = calculateTotalDeckCost(cardDeck);

        if (!file_to_generate) { // generate VOID file
            //creating the file path with ID
            directory_path = directory_path +"/SpireDeck_" + deck_ID + "(VOID).pdf";
            directory_path = Paths.get(directory_path).toString();

            GeneratePDFFile.generateVoidPDF(directory_path, deck_ID);
        } else { // generate REPORT
            //creating the file path with ID
            directory_path = directory_path +"/SpireDeck_" + deck_ID + ".pdf";
            directory_path = Paths.get(directory_path).toString();
            GeneratePDFFile.generatePDF(directory_path, deck_ID, total_cost, cardDeck, invalid_cards);
        }
    }

    /**
     * The entry point of the application that prompts the user for a file path,
     * verifies its validity, and generates a corresponding PDF file based on the
     * contents of the specified file.
     *
     * <p>This method performs the following tasks:</p>
     * <ol>
     *     <li>Generates list of valid card names.</li>
     *     <li>Prompts the user to enter a file path.</li>
     *     <li>Checks if the provided path corresponds to a valid file.</li>
     *     <li>Reads the contents of the file to determine if a PDF report
     *         should be generated.</li>
     *     <li>Extracts the directory path from the provided file path to
     *         specify where to save the generated PDF.</li>
     *     <li>Calls the {@link #generateFile(boolean, String)} method to
     *         create the PDF file.</li>
     * </ol>
     *
     * @param args command-line arguments (not used in this application)
     */
    public static void main(String[] args) {
        validCards();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path:");
        //String filePath = "/Users/sophiabrix/Desktop/Java Programs/SlayTheSpireDeckCostTally/src/Deck.txt";

        String filePath = scanner.nextLine(); //takes user input

        File file = new File(filePath); //check for valid input file path
        if (!file.isFile()) {
            System.out.println("Invalid file path. Please enter a valid file path.");
        }

        scanner.close();

        boolean file_to_generate = readTxtFile(filePath);

        String directory_path = filePath.substring(0, filePath.lastIndexOf("/")); //get the directory part
        generateFile(file_to_generate, directory_path);

    }
}
