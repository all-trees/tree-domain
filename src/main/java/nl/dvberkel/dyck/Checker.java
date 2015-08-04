package nl.dvberkel.dyck;

public class Checker {
    private final String left;
    private final String right;

    public Checker() {
        this("1", "2");
    }

    public Checker(String left, String right) {

        this.left = left;
        this.right = right;
    }

    public boolean check(String word) {
        boolean valid = imbalance(word) == 0;
        int prefixLength = word.length() - 1;
        while (valid && prefixLength > 0) {
            String prefix = word.substring(0, prefixLength);
            valid = imbalance(prefix) >= 0;
            prefixLength--;
        }
        return valid;
    }

    private int imbalance(String word) {
        return count(word, left) - count(word, right);
    }

    private int count(String word, String substring) {
        int count = 0;
        for (int index = 0; index < word.length(); index++) {
            if (word.substring(index, index + substring.length()).equals(substring)) {
                count++;
            }
        }
        return count;
    }
}
