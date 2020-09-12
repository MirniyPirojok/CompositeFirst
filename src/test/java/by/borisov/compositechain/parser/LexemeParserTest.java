package by.borisov.compositechain.parser;

import by.borisov.compositechain.entity.TextComponent;
import by.borisov.compositechain.entity.impl.CompositeText;
import by.borisov.compositechain.entity.impl.SymbolComponent;
import by.borisov.compositechain.parser.impl.LexemeParser;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static by.borisov.compositechain.entity.ComponentType.LETTER;
import static by.borisov.compositechain.entity.ComponentType.LEXEME;
import static by.borisov.compositechain.entity.ComponentType.PUNCTUATION;

public class LexemeParserTest {
    BaseParser lexemeParser;
    String lexemeForTest;
    TextComponent symbol1;
    TextComponent symbol2;
    TextComponent symbol3;
    TextComponent symbol4;
    TextComponent symbol5;
    TextComponent symbol6;
    TextComponent symbol7;

    @BeforeClass
    public void setUp() {
        lexemeParser = new LexemeParser();
        lexemeForTest = "Lexeme,";
        symbol1 = new SymbolComponent('L', LETTER);
        symbol2 = new SymbolComponent('e', LETTER);
        symbol3 = new SymbolComponent('x', LETTER);
        symbol4 = new SymbolComponent('e', LETTER);
        symbol5 = new SymbolComponent('m', LETTER);
        symbol6 = new SymbolComponent('e', LETTER);
        symbol7 = new SymbolComponent(',', PUNCTUATION);
    }

    @AfterClass
    public void tierDown() {
        lexemeParser = null;
        lexemeForTest = null;
        symbol1 = null;
        symbol2 = null;
        symbol3 = null;
        symbol4 = null;
        symbol5 = null;
        symbol6 = null;
        symbol7 = null;
    }

    @Test
    public void parsePositiveTest() {
        TextComponent expected = new CompositeText(LEXEME);
        expected.add(symbol1);
        expected.add(symbol2);
        expected.add(symbol3);
        expected.add(symbol4);
        expected.add(symbol5);
        expected.add(symbol6);
        expected.add(symbol7);
        TextComponent actual = lexemeParser.parse(lexemeForTest);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void parseNegativeTest() {
        TextComponent expected = new CompositeText(LEXEME);
        expected.add(symbol1);
        expected.add(symbol2);
        expected.add(symbol3);
        expected.add(symbol4);
        expected.add(symbol5);
        expected.add(symbol6);
        TextComponent actual = lexemeParser.parse(lexemeForTest);

        Assert.assertNotEquals(expected, actual);
    }
}
