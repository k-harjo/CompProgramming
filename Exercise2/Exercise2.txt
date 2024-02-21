import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Convert Fahrenheit to Celsius
        System.out.print("Enter a Fahrenheit temperature: ");
        double fahrenheit = scanner.nextDouble();
        double celsius = (fahrenheit - 32) * 5 / 9;
        System.out.printf("%.2fF is equivalent to %.2fC\n", fahrenheit, celsius);

        // Convert Celsius to Fahrenheit
        System.out.print("Enter a Celsius temperature: ");
        double celsius2 = scanner.nextDouble();
        double fahrenheit2 = (9.0 / 5.0) * celsius2 + 32;
        System.out.printf("%.2fC is equivalent to %.2fF\n", celsius2, fahrenheit2);

        scanner.close();
    }
}
