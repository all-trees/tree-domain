package nl.dvberkel.tree;

import static java.lang.Math.max;

public interface Tree {
    static int sizeOf(Tree tree) {
        if (tree instanceof Node) {
            Node node = (Node) tree;
            return sizeOf(node.left()) + sizeOf(node.right()) + 1;
        } else {
            return 1;
        }
    }

    static int depthOf(Tree tree) {
        if (tree instanceof Node) {
            Node node = (Node) tree;
            return max(depthOf(node.left()), depthOf(node.right())) + 1;
        } else {
            return 0;
        }
    }
}
