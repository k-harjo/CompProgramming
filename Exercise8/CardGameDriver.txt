import java.util.ArrayList;
import java.util.Random;


public class CardGameDriver {

    public static void main(String[] args) {
        ArrayList<PlayingCard> deck = new ArrayList<>();

        // Fill the deck with standard playing cards
        char[] suits = { 'H', 'D', 'C', 'S' };
        for (char suit : suits) {
            for (int value = 1; value <= 13; value++) {
                deck.add(new PlayingCard(suit, value));
            }
        }

        // Randomly select two cards and compare them
        Random rand = new Random();
        int index1 = rand.nextInt(deck.size());
        int index2 = rand.nextInt(deck.size());
        PlayingCard card1 = deck.get(index1);
        PlayingCard card2 = deck.get(index2);

        System.out.println("Card 1: " + card1);
        System.out.println("Card 2: " + card2);

        if (card1.isMatch(card2)) {
            System.out.println("The two cards match!");
        } else {
            System.out.println("The two cards do not match.");
        }
    }
}
