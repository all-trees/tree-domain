package nl.dvberkel.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class TreeSizeTest {
    private final Tree tree;
    private final int expectedSize;

    public TreeSizeTest(Tree tree, int expectedSize) {
        this.tree = tree;
        this.expectedSize = expectedSize;
    }

    @Test
    public void shouldCountTheNumberOfNodesAndLeafs() {
        assertThat(tree.size(), is(expectedSize));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Collection<Object[]> data = new ArrayList<Object[]>();
        data.add(new Object[]{ new Leaf(), 1 });
        data.add(new Object[]{ new Node(new Leaf(), new Leaf()), 3 });
        data.add(new Object[]{ new Node(new Node(new Leaf(), new Leaf()), new Leaf()), 5 });
        data.add(new Object[]{ new Node(new Leaf(), new Node(new Leaf(), new Leaf())), 5 });
        data.add(new Object[]{ new Node(new Node(new Leaf(), new Leaf()), new Node(new Leaf(), new Leaf())), 7 });
        return data;
    }
}
