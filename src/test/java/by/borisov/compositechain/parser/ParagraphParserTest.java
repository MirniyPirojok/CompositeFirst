package by.borisov.compositechain.parser;

import by.borisov.compositechain.parser.impl.ParagraphParser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class ParagraphParserTest {
    BaseParser paragraphParser;
    String paragraphForTest;

    @BeforeClass
    public void setUp() {
        paragraphParser = new ParagraphParser();
        paragraphForTest = " Hello paragraph1!";
    }

    @AfterClass
    public void tierDown() {
        paragraphParser = null;
        paragraphForTest = null;
    }

    @Test
    public void paragraphParsePositiveTest() {
        String expected = " Hello paragraph1!";
        String actual = paragraphParser.parse(paragraphForTest).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void paragraphParseNegativeTest() {
        String expected = "! Hello paragraph1!";
        String actual = paragraphParser.parse(paragraphForTest).toString();
        assertNotEquals(expected, actual);
    }

}
