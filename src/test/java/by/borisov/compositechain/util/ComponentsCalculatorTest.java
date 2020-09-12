package by.borisov.compositechain.util;

import by.borisov.compositechain.entity.TextComponent;
import by.borisov.compositechain.entity.impl.CompositeText;
import by.borisov.compositechain.entity.impl.SymbolComponent;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static by.borisov.compositechain.entity.ComponentType.LETTER;
import static by.borisov.compositechain.entity.ComponentType.PUNCTUATION;
import static by.borisov.compositechain.util.ComponentsCalculator.calculateLexemesLengths;
import static by.borisov.compositechain.util.ComponentsCalculator.calculateWordsLength;
import static by.borisov.compositechain.util.ComponentsCalculator.sumSymbolOccurrence;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class ComponentsCalculatorTest {
    TextComponent sentence1;
    TextComponent sentence2;
    TextComponent lexeme;
    TextComponent word;
    char symbolForTest;

    @BeforeClass
    public void setUp() {
        symbolForTest = 'o';
        sentence1 = new CompositeText();
        sentence2 = new CompositeText();
        lexeme = new CompositeText();
        word = new CompositeText();

        lexeme.add(new SymbolComponent('o', LETTER));
        lexeme.add(new SymbolComponent('n', LETTER));
        lexeme.add(new SymbolComponent(',', PUNCTUATION));

        word.add(new SymbolComponent('w', LETTER));
        word.add(new SymbolComponent('o', LETTER));
        word.add(new SymbolComponent('r', LETTER));
        word.add(new SymbolComponent('d', LETTER));


        sentence1.add(lexeme);
        sentence2.add(word);
    }

    @AfterClass
    public void tierDown() {
        sentence1 = null;
        sentence2 = null;
        lexeme = null;
    }

    @Test
    public void calculateLexemesLengthsPositiveTest() {
        int expected = 3;
        int actual = calculateLexemesLengths(sentence1);
        assertEquals(actual, expected);
    }

    @Test
    public void calculateLexemesLengthsNegativeTest() {
        int expected = 1;
        int actual = calculateLexemesLengths(sentence1);
        assertNotEquals(expected, actual);
    }

    @Test
    public void calculateWordsLengthPositiveTest() {
        int expected = 4;
        int actual = calculateWordsLength(sentence2);
        assertEquals(actual, expected);
    }

    @Test
    public void calculateWordsLengthNegativeTest() {
        int expected = 1;
        int actual = calculateWordsLength(sentence2);
        assertNotEquals(actual, expected);
    }

    @Test
    public void sumSymbolOccurrencePositiveTest() {
        int expected = 1;
        int actual = sumSymbolOccurrence(lexeme, symbolForTest);
        assertEquals(actual, expected);
    }

    @Test
    public void sumSymbolOccurrenceNegativeTest() {
        int expected = 0;
        int actual = sumSymbolOccurrence(lexeme, symbolForTest);
        assertNotEquals(actual, expected);
    }
}
