package nl.dvberkel.dyck;

import nl.dvberkel.tree.Leaf;
import nl.dvberkel.tree.Node;
import nl.dvberkel.tree.Tree;

public class Builder {
    Checker checker;

    public Builder() {
        checker = new Checker();
    }

    /**
     * Converts a <b>Dyck word</b> to a tree according to the following recursive definition
     * {@code build("")} converts to {@code new Leaf()} and {@code build("1x2y")} converts to
     * {@code new Node(build(x), build(y))}
     *
     * @param word a Dyck word
     * @return a {@link Tree} corresponding to {@code word}
     * @see <a href="https://en.wikipedia.org/wiki/Dyck_language">Dyck Language</a>
     * @see <a href="http://www.math.utah.edu/mathcircle/tessler-catalan-notes.pdf">Tessler-Catalan notes</a>
     */
    public Tree build(String word) {
        if (!checker.check(word)) { throw new IllegalArgumentException(String.format("\"%s\" is not a Dyck word", word));}
        return new Node(new Leaf(), new Leaf());
    }
}