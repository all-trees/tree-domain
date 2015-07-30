package nl.dvberkel.tree;

public class Node implements Tree {
    private final Tree left;
    private final Tree right;

    public Node(Tree left, Tree right) {
        if (left  == null) { throw new IllegalArgumentException(String.format("%s sub-tree is null", "left")); }
        if (right == null) { throw new IllegalArgumentException(String.format("%s sub-tree is null", "right")); }
        this.left = left;
        this.right = right;
    }

    public Tree left() {
        return left;
    }

    public Tree right() {
        return right;
    }
}
