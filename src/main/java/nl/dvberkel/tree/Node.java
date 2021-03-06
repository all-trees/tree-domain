package nl.dvberkel.tree;

import static java.lang.Math.max;

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

    public Tree right() { return right; }

    @Override
    public int size() {
        return left().size() + right().size() + 1;
    }

    @Override
    public int depth() {
        return max(left().depth(), right().depth()) + 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (!left().equals(node.left())) return false;
        return right().equals(node.right());

    }

    @Override
    public int hashCode() {
        int result = left().hashCode();
        result = 31 * result + right().hashCode();
        return result;
    }
}
