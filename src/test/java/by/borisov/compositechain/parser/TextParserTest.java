package by.borisov.compositechain.parser;

import by.borisov.compositechain.parser.impl.TextParser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class TextParserTest {
    BaseParser textParser;
    String textFotTest;

    @BeforeClass
    public void setUp() {
        textParser = new TextParser();
        textFotTest = "Hello text!\n Hello paragraph...";
    }

    @AfterClass
    public void tierDown() {
        textParser = null;
        textFotTest = null;
    }

    @Test
    public void textParsePositiveTest() {
        String expected = "\n Hello text!\n Hello paragraph...";
        String actual = textParser.parse(textFotTest).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void textParseNegativeTest() {
        String expected = "\n Hello text!\n Hello paragraph.";
        String actual = textParser.parse(textFotTest).toString();
        assertNotEquals(expected, actual);
    }
}

