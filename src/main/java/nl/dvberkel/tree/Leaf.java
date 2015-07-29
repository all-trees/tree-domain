package nl.dvberkel.tree;

class Leaf implements Tree{

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
