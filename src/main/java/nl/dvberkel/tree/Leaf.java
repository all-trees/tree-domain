package nl.dvberkel.tree;

import nl.dvberkel.tree.visitor.Visitor;

public class Leaf implements Tree{

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
