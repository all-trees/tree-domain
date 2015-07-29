package nl.dvberkel.tree;

class Node implements Tree {

    public Node(Tree left, Tree right) {
        if (left  == null) { throw new IllegalArgumentException(String.format("%s sub-tree is null", "left")); }
        if (right == null) { throw new IllegalArgumentException(String.format("%s sub-tree is null", "right")); }
    }

    @Override
    public void accept(Visitor visitor) {

    }
}
