import java.io.*;
import java.util.HashSet;
import java.util.Random;

public class DeckIDGenerator {

    private static final String DECK_ID_FILE = "/Users/sophiabrix/Desktop/Java Programs/SlayTheSpireDeckCostTally/src/DeckIDs.txt";
    private static HashSet<String> generatedIDs = new HashSet<>();

    static {
        loadGeneratedNumbers();
    }

    //load previously generated numbers from file
    private static void loadGeneratedNumbers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(DECK_ID_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                generatedIDs.add(line.trim());
            }
        } catch (IOException e) {
            //file might not exist on first run, handle gracefully
        }
    }

    //generate a unique string of 9 digits
    public static String generateUniqueNumber() {
        Random random = new Random();
        String generated;

        do {
            generated = String.format("%09d", random.nextInt(1_000_000_000)); //generate 9-digit number
        } while (generatedIDs.contains(generated)); //check for uniqueness

        generatedIDs.add(generated);
        saveGeneratedNumber(generated); //save to file
        return generated;
    }

    //method to save the generated number to a file
    private static void saveGeneratedNumber(String number) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DECK_ID_FILE, true))) {
            writer.write(number);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}