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
}

