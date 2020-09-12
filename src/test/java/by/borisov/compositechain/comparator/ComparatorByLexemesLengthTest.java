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

public class ComparatorByLexemesLengthTest {
    TextComponent lexeme;
    TextComponent equalSentence1;
    TextComponent equalSentence2;
    TextComponent notEqualSentence;
    ComparatorByLexemesLength comparatorByLexemesLength;

    @BeforeClass
    public void setUp() {
        lexeme = new CompositeText();
        equalSentence1 = new CompositeText();
        equalSentence2 = new CompositeText();
        notEqualSentence = new CompositeText();

        lexeme.add(new SymbolComponent('O', LETTER));
        lexeme.add(new SymbolComponent('n',LETTER));
        lexeme.add(new SymbolComponent(',',PUNCTUATION));

        equalSentence1.add(lexeme);
        equalSentence2.add(lexeme);

        notEqualSentence.add(lexeme);
        notEqualSentence.add(lexeme);

        comparatorByLexemesLength = new ComparatorByLexemesLength();
    }

    @AfterClass
    public void tierDown() {
        lexeme = null;
        equalSentence1 = null;
        equalSentence2 = null;
        notEqualSentence = null;
        comparatorByLexemesLength = null;
    }

    @Test
    public void comparePositiveTest() {
        int actual = comparatorByLexemesLength.compare(equalSentence1, equalSentence2);
        int expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    public void compareNegativeTest() {
        int actual = comparatorByLexemesLength.compare(equalSentence1, notEqualSentence);
        int expected = 0;
        assertNotEquals(actual, expected);
    }
}
