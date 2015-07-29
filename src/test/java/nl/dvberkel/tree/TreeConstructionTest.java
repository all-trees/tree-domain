package nl.dvberkel.tree;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class TreeConstructionTest {
    @Test
    public void shouldCreateALeafNode() {
        Tree tree = new Leaf();

        assertThat(tree, is(not(nullValue())));
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldNotAllowANodeWithLeftSubtreeNull(){
        Tree aSubTree = mock(Tree.class);

        Tree node = new Node(null, aSubTree);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldNotAllowANodeWithRightSubtreeNull(){
        Tree aSubTree = mock(Tree.class);

        Tree node = new Node(aSubTree, null);
    }
}

