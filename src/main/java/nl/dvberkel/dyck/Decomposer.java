package nl.dvberkel.dyck;

public class Decomposer {
    private Checker checker;

    public Decomposer() {
        checker = new Checker();
    }

    public String[] decompose(String word) {
        if (!checker.check(word)) { throw new IllegalArgumentException(String.format("\"%s\" is not a Dyck word", word)); }
        int index = 1;
        while (checker.imbalance(word.substring(0, index)) != 0) {
            index++;
        }
        return new String[]{ word.substring(1, index-1), word.substring(index) };
    }
}
