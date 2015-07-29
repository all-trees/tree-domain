package nl.dvberkel.tree.visitor;

import nl.dvberkel.tree.Tree;
import nl.dvberkel.tree.Visitor;

public class SizeVisitor implements Visitor {
    public static int sizeOf(Tree tree) {
        SizeVisitor visitor = new SizeVisitor();
        tree.accept(visitor);
        return visitor.size();
    }

    private int count = 0;

    /**
     * @see {@link #sizeOf} to use SizeVisitor
     */
    private SizeVisitor(){ }

    @Override
    public void visit(Tree tree) {
        count++;
    }

    private int size() {
        return count;
    }
}
