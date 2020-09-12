package by.borisov.compositechain.parser;

import by.borisov.compositechain.parser.impl.SentenceParser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class SentenceParserTest {
    BaseParser sentenceParser;
    String sentenceForTest;

    @BeforeClass
    public void setUp() {
        sentenceParser = new SentenceParser();
        sentenceForTest = " Hello sentence!";
    }

    @AfterClass
    public void tierDown() {
        sentenceParser = null;
        sentenceForTest = null;
    }

    @Test
    public void parseSentencePositiveTest() {
        String expected = " Hello sentence!";
        String actual = sentenceParser.parse(sentenceForTest).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void parseSentenceNegativeTest() {
        String expected = " Hello sentence";
        String actual = sentenceParser.parse(sentenceForTest).toString();
        assertNotEquals(expected, actual);
    }
}
