package nl.dvberkel.tree;

public class Leaf implements Tree{
    @Override
    public int size() {
        return 1;
    }

    @Override
    public int depth() {
        return 0;
    }
}
