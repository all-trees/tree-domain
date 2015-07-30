package nl.dvberkel.tree.visitor;

import nl.dvberkel.tree.Node;
import nl.dvberkel.tree.Tree;

import static java.lang.Math.max;

public class DepthVisitor implements Visitor {
    public static int depthOf(Tree tree) {
        DepthVisitor visitor = new DepthVisitor();
        tree.accept(visitor);
        return visitor.depth();
    }

    private int maxDepth;

    /**
     * @see {@link #depthOf} to use DepthVisitor
     */
    private DepthVisitor(){}

    @Override
    public void visit(Tree tree) {
        if (tree instanceof Node) {
            DepthVisitor leftVisitor = new DepthVisitor();
            DepthVisitor rightVisitor = new DepthVisitor();
            Node node = (Node) tree;
            node.left().accept(leftVisitor);
            node.right().accept(rightVisitor);
            maxDepth = max(leftVisitor.depth(), rightVisitor.depth()) + 1;
        } else {
            maxDepth = 0;
        }
    }

    private int depth() {
        return maxDepth;
    }
}
