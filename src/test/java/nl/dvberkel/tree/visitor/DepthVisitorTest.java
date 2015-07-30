package nl.dvberkel.tree.visitor;

import nl.dvberkel.tree.Leaf;
import nl.dvberkel.tree.Node;
import nl.dvberkel.tree.Tree;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;

import static nl.dvberkel.tree.visitor.DepthVisitor.depthOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class DepthVisitorTest {
    private final Tree tree;
    private final int expectedDepth;

    public DepthVisitorTest(Tree tree, int expectedDepth) {
        this.tree = tree;
        this.expectedDepth = expectedDepth;
    }

    @Test
    public void shouldDetermineDepthOfATree() {
        assertThat(depthOf(tree), is(expectedDepth));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Collection<Object[]> data = new ArrayList<Object[]>();
        data.add(new Object[]{ new Leaf(), 0 });
        data.add(new Object[]{ new Node(new Leaf(), new Leaf()), 1 });
        data.add(new Object[]{ new Node(new Node(new Leaf(), new Leaf()), new Leaf()), 2 });
        data.add(new Object[]{ new Node(new Leaf(), new Node(new Leaf(), new Leaf())), 2 });
        data.add(new Object[]{ new Node(new Node(new Leaf(), new Leaf()), new Node(new Leaf(), new Leaf())), 2 });
        return data;
    }
}
