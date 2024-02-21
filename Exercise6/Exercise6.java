import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Exercise6 <inputFileName>");
            return;
        }

        Scanner scnr = new Scanner(System.in);
        System.out.print("Enter the number of rows (m): ");
        int m = scnr.nextInt();
        System.out.print("Enter the number of columns (n): ");
        int n = scnr.nextInt();

        String inputFileName = args[0];
        try {
            File inputFile = new File(inputFileName);
            Scanner fileScanner = new Scanner(inputFile);

            String inputString = fileScanner.nextLine();
            fileScanner.close();

            char[][] array = new char[m][n];

            int charIndex = 0;
            for (int i = 0; i < m; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j < n; j++) {
                        array[i][j] = charIndex < inputString.length() ? inputString.charAt(charIndex++) : '*';
                    }
                } else {
                    for (int j = n - 1; j >= 0; j--) {
                        array[i][j] = charIndex < inputString.length() ? inputString.charAt(charIndex++) : '*';
                    }
                }
            }

            StringBuilder outputString = new StringBuilder();
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < m; i++) {
                    if (array[i][j] != '*') {
                        outputString.append(array[i][j]);
                    }
                }
            }

            System.out.println("Output string: " + outputString.toString());

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + inputFileName);
        }
    }
}
