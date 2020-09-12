package by.borisov.compositechain.comparator;

import by.borisov.compositechain.entity.TextComponent;
import by.borisov.compositechain.entity.impl.CompositeText;
import by.borisov.compositechain.entity.impl.SymbolComponent;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static by.borisov.compositechain.entity.ComponentType.LETTER;
import static by.borisov.compositechain.entity.ComponentType.PUNCTUATION;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class ComparatorBySymbolOccurrenceTest {
    ComparatorBySymbolOccurrence comparator;
    TextComponent equalLexeme1;
    TextComponent equalLexeme2;
    TextComponent notEqualLexeme;

    @BeforeClass
    public void setUp() {
        char symbolForTest = 'x';
        comparator = new ComparatorBySymbolOccurrence(symbolForTest);
        equalLexeme1 = new CompositeText();
        equalLexeme2 = new CompositeText();
        notEqualLexeme = new CompositeText();

        equalLexeme1.add(new SymbolComponent('x', LETTER));
        equalLexeme1.add(new SymbolComponent('y', LETTER));
        equalLexeme1.add(new SymbolComponent(',', PUNCTUATION));
        equalLexeme2.add(new SymbolComponent('x', LETTER));
        equalLexeme2.add(new SymbolComponent('y', LETTER));
        equalLexeme2.add(new SymbolComponent(',', PUNCTUATION));

        notEqualLexeme.add(new SymbolComponent('x'));
        notEqualLexeme.add(new SymbolComponent('x'));
    }

    @AfterClass
    public void tierDown() {
        comparator = null;
        equalLexeme1 = null;
        equalLexeme2 = null;
        notEqualLexeme = null;
    }

    @Test
    public void comparePositiveTest() {
        int actual = comparator.compare(equalLexeme1, equalLexeme2);
        int expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    public void compareNegativeTest() {
        int actual = comparator.compare(equalLexeme1, notEqualLexeme);
        int expected = 0;
        assertNotEquals(actual, expected);
    }
}
