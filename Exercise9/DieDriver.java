public class DieDriver {
    public static void main(String[] args) {
        Die[] dice = new Die[5];

        for (int i = 0; i < dice.length; i++) {
            dice[i] = new Die();
        }

        int count3OfKind = 0;
        int count4OfKind = 0;
        int count5OfKind = 0;

        int rolls = 100000;
        for (int i = 0; i < rolls; i++) {
            for (Die die : dice) {
                die.rollDie();
            }

            if (isThreeOfAKind(dice)) {
                count3OfKind++;
            }
            if (isFourOfAKind(dice)) {
                count4OfKind++;
            }
            if (isFiveOfAKind(dice)) {
                count5OfKind++;
            }
        }

        System.out.println("In " + rolls + " rolls, you rolled 3 of a kind " + count3OfKind + " times,");
        System.out.println("4 of a kind " + count4OfKind + " times, and 5 of a kind " + count5OfKind + " times.");
    }

    public static boolean isThreeOfAKind(Die[] dice) {
        int[] counts = new int[7];
        for (Die die : dice) {
            counts[die.getValue()]++;
        }
        for (int count : counts) {
            if (count >= 3) {
                return true;
            }
        }
        return false;
    }

    public static boolean isFourOfAKind(Die[] dice) {
        int[] counts = new int[7];
        for (Die die : dice) {
            counts[die.getValue()]++;
        }
        for (int count : counts) {
            if (count >= 4) {
                return true;
            }
        }
        return false;
    }

    public static boolean isFiveOfAKind(Die[] dice) {
        int[] counts = new int[7];
        for (Die die : dice) {
            counts[die.getValue()]++;
        }
        for (int count : counts) {
            if (count == 5) {
                return true;
            }
        }
        return false;
    }
}
