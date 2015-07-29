package nl.dvberkel.tree;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TreeVisitorTest {
    @Test
    public void leafShouldAcceptVisitor() {
        Tree leaf = new Leaf();
        Visitor visitor = mock(Visitor.class);

        leaf.accept(visitor);

        verify(visitor).visit(leaf);
    }

    @Test
    public void NodeShouldAcceptVisitor() {
        Tree left = new Leaf();
        Tree right = new Leaf();
        Tree node = new Node(left, right);
        Visitor visitor = mock(Visitor.class);

        node.accept(visitor);

        verify(visitor).visit(left);
        verify(visitor).visit(right);
        verify(visitor).visit(node);
    }
}

