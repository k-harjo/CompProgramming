public class Die {
    private int value;

    public Die() {
        rollDie();
    }

    public void rollDie() {
        value = (int) (Math.random() * 6) + 1;
    }

    public int getValue() {
        return value;
    }
}
