package nl.dvberkel.tree;

import static java.lang.Math.max;

public interface Tree {
    static int sizeOf(Tree tree) {
        return tree.size();
    }

    static int depthOf(Tree tree) {
        return tree.depth();
    }

    int size();
    int depth();
}
