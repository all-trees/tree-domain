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
public class CheckerTest {
    private final String word;
    private final boolean valid;
    private Checker checker;

    public CheckerTest(String word, boolean valid) {
        this.word = word;
        this.valid = valid;
    }

    @Before
    public void setUp() throws Exception {
        checker = new Checker();
    }

    @Test
    public void shouldCheckDyckWord() {
        assertThat(checker.check(word), is(valid));
    }

    @Parameterized.Parameters(name = "is {0} a Dyck word? {1}")
    public static Collection<Object[]> data() {
        ArrayList<Object[]> data = new ArrayList<Object[]>();
        data.add(aDyckWord(""));
        data.add(aDyckWord("12"));
        data.add(aDyckWord("1212"));
        data.add(aDyckWord("1122"));
        data.add(not(aDyckWord("1")));
        data.add(not(aDyckWord("2")));
        data.add(not(aDyckWord("21")));
        data.add(not(aDyckWord("111")));
        data.add(not(aDyckWord("112")));
        data.add(not(aDyckWord("121")));
        data.add(not(aDyckWord("122")));
        data.add(not(aDyckWord("211")));
        data.add(not(aDyckWord("212")));
        data.add(not(aDyckWord("221")));
        data.add(not(aDyckWord("222")));
        data.add(not(aDyckWord("1111")));
        data.add(not(aDyckWord("1112")));
        data.add(not(aDyckWord("1121")));
        data.add(not(aDyckWord("1211")));
        data.add(not(aDyckWord("1221")));
        data.add(not(aDyckWord("1222")));
        data.add(not(aDyckWord("2111")));
        data.add(not(aDyckWord("2112")));
        data.add(not(aDyckWord("2121")));
        data.add(not(aDyckWord("2122")));
        data.add(not(aDyckWord("2211")));
        data.add(not(aDyckWord("2212")));
        data.add(not(aDyckWord("2221")));
        data.add(not(aDyckWord("2222")));
        return data;
    }

    private static Object[] aDyckWord(String word) {
        return new Object[]{ word, true };
    }

    private static Object[] not(Object[] original) {
        return new Object[]{ original[0], ! (boolean) original[1] };
    }
}
