package by.borisov.compositechain.comparator;

import by.borisov.compositechain.entity.TextComponent;
import by.borisov.compositechain.entity.impl.CompositeText;
import by.borisov.compositechain.entity.impl.SymbolComponent;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class ComparatorByWordsLengthTest {
    ComparatorByWordsLength comparator;
    TextComponent word;
    TextComponent equalSentence1;
    TextComponent equalSentence2;
    TextComponent notEqualSentence;


    @BeforeClass
    public void setUp() {
        comparator = new ComparatorByWordsLength();
        word = new CompositeText();
        equalSentence1 = new CompositeText();
        equalSentence2 = new CompositeText();
        notEqualSentence = new CompositeText();

        word.add(new SymbolComponent('q'));
        word.add(new SymbolComponent('w'));
        word.add(new SymbolComponent('e'));

        equalSentence1.add(word);
        equalSentence2.add(word);

        notEqualSentence.add(word);
        notEqualSentence.add(word);
    }

    @AfterClass
    public void tierDown() {
        comparator = null;
        word = null;
        equalSentence1 = null;
        equalSentence2 = null;
        notEqualSentence = null;
    }

    @Test
    public void comparePositiveTest() {
        int actual = comparator.compare(equalSentence1, equalSentence2);
        int expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    public void compareNegativeTest() {
        int actual = comparator.compare(equalSentence1, notEqualSentence);
        int expected = 0;
        assertNotEquals(actual, expected);
    }
}
