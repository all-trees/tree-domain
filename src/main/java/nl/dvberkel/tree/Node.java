package nl.dvberkel.tree;

import nl.dvberkel.tree.visitor.Visitor;

public class Node implements Tree {
    private final Tree left;
    private final Tree right;

    public Node(Tree left, Tree right) {
        if (left  == null) { throw new IllegalArgumentException(String.format("%s sub-tree is null", "left")); }
        if (right == null) { throw new IllegalArgumentException(String.format("%s sub-tree is null", "right")); }
        this.left = left;
        this.right = right;
    }

    @Override
    public void accept(Visitor visitor) {
        left.accept(visitor);
        right.accept(visitor);
        visitor.visit(this);
    }
}
