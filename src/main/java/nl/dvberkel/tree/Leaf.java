package nl.dvberkel.tree;

public class Leaf implements Tree{

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
