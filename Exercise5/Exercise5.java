import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.in");
            File outputFile = new File("results.out");
            FileWriter writer = new FileWriter(outputFile);

            Scanner scanner = new Scanner(inputFile);

            while (scanner.hasNext()) {
                String word = scanner.next();
                String encryptedWord = encryptWord(word);
                writer.write(word.toUpperCase() + "\t" + encryptedWord.toUpperCase() + "\n");
            }

            writer.close();
            scanner.close();
            System.out.println("Encryption completed successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String encryptWord(String word) {
        int length = word.length();
        int midpoint = (length + 1) / 2;
        String firstHalf = word.substring(0, midpoint);
        String secondHalf = word.substring(midpoint);
        return secondHalf + firstHalf;
    }
}
