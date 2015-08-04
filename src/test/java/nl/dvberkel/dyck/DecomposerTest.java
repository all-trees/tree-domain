package nl.dvberkel.dyck;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class DecomposerTest {
    private final String word;
    private final String[] expectedDecomposition;
    private Decomposer decomposer;

    public DecomposerTest(String word, String[] expectedDecomposition) {
        this.word = word;
        this.expectedDecomposition = expectedDecomposition;
    }

    @Before
    public void setUp() throws Exception {
        decomposer = new Decomposer();
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldThrowWhenNotADyckWord() {
        decomposer.decompose("1");
    }

    @Test
    public void shouldDecomposeDyckWord() {
        assertThat(decomposer.decompose(word), is(expectedDecomposition));
    }

    @Parameterized.Parameters(name = "{0} should decompose into {1}")
    public static Collection<Object[]> data() {
        Collection<Object[]> data = new ArrayList<Object[]>();
        data.add(new Object[]{"12", new String[]{"", ""}});
        data.add(new Object[]{"1122", new String[]{"12", ""}});
        data.add(new Object[]{"1212", new String[]{"", "12"}});
        data.add(new Object[]{"121212", new String[]{"", "1212"}});
        data.add(new Object[]{"112212", new String[]{"12", "12"}});
        data.add(new Object[]{"112122", new String[]{"1212", ""}});
        return data;
    }
}