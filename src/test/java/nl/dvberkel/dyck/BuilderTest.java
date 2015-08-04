package nl.dvberkel.dyck;

import nl.dvberkel.tree.Leaf;
import nl.dvberkel.tree.Node;
import nl.dvberkel.tree.Tree;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class BuilderTest {
    private final String word;
    private final Tree expectedTree;
    private Builder builder;

    public BuilderTest(String word, Tree expectedTree) {
        this.word = word;
        this.expectedTree = expectedTree;
    }

    @Before
    public void setUp() throws Exception {
        builder = new Builder();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowWhenNotADyckWord(){
        builder.build("1");
    }

    @Test
    public void shouldConstructCorrectTree() {
        assertThat(builder.build(word), is(expectedTree));
    }

    @Parameterized.Parameters(name = "should construct correct tree of {0}")
    public static Collection<Object[]> data() {
        ArrayList<Object[]> data = new ArrayList<Object[]>();
        data.add(new Object[]{ "12", new Node(new Leaf(), new Leaf())});
        return data;
    }
}
