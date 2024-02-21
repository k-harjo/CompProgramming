import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class ContributionTabulator {
    public static void main(String[] args) {
        int totalGoal = 10000000; // $10,000,000
        int maxContrib = Integer.MIN_VALUE;
        int minContrib = Integer.MAX_VALUE;
        int totalContrib = 0;
        int numContributions = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("input2.in"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("results.out"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                int contribution = Integer.parseInt(line);

                // Update total contributions and count
                totalContrib += contribution;
                numContributions++;

                // Update maximum and minimum contributions
                if (contribution > maxContrib) {
                    maxContrib = contribution;
                }
                if (contribution < minContrib) {
                    minContrib = contribution;
                }

                // Check if the total goal is met
                if (totalContrib >= totalGoal) {
                    // Calculate average contribution
                    double averageContrib = (double) totalContrib / numContributions;
                    double excessContrib = (double) totalContrib - totalGoal;

                    // Format monetary values with commas
                    DecimalFormat formatter = new DecimalFormat("#,###.00");
                    String maxContribFormatted = formatter.format(maxContrib);
                    String minContribFormatted = formatter.format(minContrib);
                    String averageContribFormatted = formatter.format(averageContrib);
                    String totalContribFormatted = formatter.format(totalContrib);
                    String excessContribFormatted = formatter.format(excessContrib);

                    // Write results to the output file
                    writer.write("It took " + numContributions + " contributions to reach the goal.\n");
                    writer.write("The maximum contribution received was $" + maxContribFormatted + ".\n");
                    writer.write("The minimum contribution received was $" + minContribFormatted + ".\n");
                    writer.write("The average contribution was $" + averageContribFormatted + ".\n");
                    writer.write("A total of $" + totalContribFormatted + " was collected.\n");
                    writer.write("The goal was exceeded by: $" + excessContribFormatted + ".\n");

                    // Exit the loop since the goal is met
                    break;
                }
            }

            // Check if the total contribution is less than the goal
            if (totalContrib < totalGoal) {
                double averageContrib = (double) totalContrib / numContributions;
                double diffContrib = (double) totalGoal - totalContrib;

                // Format monetary values with commas
                DecimalFormat formatter = new DecimalFormat("#,###.00");
                String maxContribFormatted = formatter.format(maxContrib);
                String minContribFormatted = formatter.format(minContrib);
                String averageContribFormatted = formatter.format(averageContrib);
                String totalContribFormatted = formatter.format(totalContrib);
                String diffContribFormatted = formatter.format(diffContrib);

                // Write results to the output file
                writer.write("The total contribution was not met.\n");
                writer.write("It took " + numContributions + " contributions to reach the goal.\n");
                writer.write("The maximum contribution received was $" + maxContribFormatted + ".\n");
                writer.write("The minimum contribution received was $" + minContribFormatted + ".\n");
                writer.write("The average contribution was $" + averageContribFormatted + ".\n");
                writer.write("A total of $" + totalContribFormatted + " was collected.\n");
                writer.write("The goal was short by $" + diffContribFormatted + ".");
            }

            System.out.println("Results written to results.out");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
