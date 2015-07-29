package nl.dvberkel.tree;

import nl.dvberkel.tree.visitor.Visitor;

public interface Tree {

    void accept(Visitor visitor);
}
