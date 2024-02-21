public class PlayingCard {
    private char suit;
    private int value;

    public PlayingCard(char s, int v) {
        suit = s;
        value = v;
    }

    public char getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public void setSuit(char s) {
        suit = s;
    }

    public void setValue(int v) {
        value = v;
    }

    public String toString() {
        return value + " of " + suit;
    }

    public boolean isMatch(PlayingCard p) {
        return suit == p.getSuit() && value == p.getValue();
    }
}
