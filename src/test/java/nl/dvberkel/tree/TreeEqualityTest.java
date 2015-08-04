package nl.dvberkel.tree;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class TreeEqualityTest {

    @Test
    public void aLeafShouldEqualOtherLeaf() {
        assertThat(new Leaf(), is(new Leaf()));
    }

    @Test
    public void aNodeShouldEqualOtherNodeWithSimilarBranches() {
        assertThat(new Node(new Leaf(), new Leaf()), is(new Node(new Leaf(), new Leaf())));
    }

    @Test
    public void aNodeShouldNotEqualOtherNodeWithDissimilarBranches() {
        assertThat(new Node(new Node(new Leaf(), new Leaf()), new Leaf()), not(is(new Node(new Leaf(), new Leaf()))));
    }
}
