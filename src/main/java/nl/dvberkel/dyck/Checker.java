package nl.dvberkel.dyck;

import java.util.Iterator;

import static nl.dvberkel.dyck.PrefixIterator.prefixesOf;

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
        return noImbalance(word) && prefixesHaveNonNegativeImbalance(word);
    }

    private boolean noImbalance(String word) {
        return imbalance(word) == 0;
    }

    private boolean prefixesHaveNonNegativeImbalance(String word) {
        for (String prefix : prefixesOf(word)) {
            if (imbalance(prefix) < 0) {
                return false;
            }
        }
        return true;
    }

    protected int imbalance(String word) {
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

class PrefixIterator implements Iterator<String> {
    public static Iterable<String> prefixesOf(String word) {
        return () -> new PrefixIterator(word);
    }

    private final String word;
    private int prefixLength;

    private PrefixIterator(String word) {
        this.word = word;
        this.prefixLength = word.length() - 1;
    }

    @Override
    public boolean hasNext() {
        return prefixLength > 0;
    }

    @Override
    public String next() {
        return word.substring(0, prefixLength--);
    }
}