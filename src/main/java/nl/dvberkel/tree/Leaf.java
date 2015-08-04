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

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && this.getClass().equals(obj.getClass());
    }
}
