package nl.dvberkel.tree;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class TreeTest {
    @Test
    public void shouldCreateALeafNode() {
        Tree tree = new Leaf();

        assertThat(tree, is(not(nullValue())));
    }
}

