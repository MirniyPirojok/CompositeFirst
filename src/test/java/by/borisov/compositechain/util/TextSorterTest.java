package by.borisov.compositechain.util;

import by.borisov.compositechain.entity.TextComponent;
import by.borisov.compositechain.entity.impl.CompositeText;
import by.borisov.compositechain.entity.impl.SymbolComponent;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static by.borisov.compositechain.entity.ComponentType.LEXEME;
import static by.borisov.compositechain.entity.ComponentType.PARAGRAPH;
import static by.borisov.compositechain.entity.ComponentType.SENTENCE;
import static org.testng.Assert.assertEquals;

public class TextSorterTest {
    TextSorter textSorter;
    TextComponent lexeme1;
    TextComponent lexeme2;
    TextComponent lexeme3;
    TextComponent sentence1;
    TextComponent sentence2;
    TextComponent paragraph1;
    TextComponent paragraph2;
    TextComponent text;
    char symbolForTest;

    @BeforeTest
    public void setUp() {
        textSorter = new TextSorter();
        lexeme1 = new CompositeText(LEXEME);
        lexeme2 = new CompositeText(LEXEME);
        lexeme3 = new CompositeText(LEXEME);
        sentence1 = new CompositeText(SENTENCE);
        sentence2 = new CompositeText(SENTENCE);
        paragraph1 = new CompositeText(PARAGRAPH);
        paragraph2 = new CompositeText(PARAGRAPH);
        text = new CompositeText();
        symbolForTest = 'x';

        lexeme1.add(new SymbolComponent('x'));
        lexeme1.add(new SymbolComponent('x'));

        lexeme2.add(new SymbolComponent('y'));
        lexeme2.add(new SymbolComponent('y'));
        lexeme2.add(new SymbolComponent(','));

        lexeme3.add(new SymbolComponent('z'));
        lexeme3.add(new SymbolComponent('z'));
        lexeme3.add(new SymbolComponent('z'));

        sentence1.add(lexeme1);
        sentence1.add(lexeme1);
        sentence1.add(lexeme3);

        sentence2.add(lexeme2);
        sentence2.add(lexeme2);

        paragraph1.add(sentence1);
        paragraph2.add(sentence2);
        paragraph2.add(sentence1);

        text.add(paragraph1);
        text.add(paragraph2);
    }

    @AfterTest
    public void tierDown() {
        textSorter = null;
        lexeme1 = null;
        lexeme2 = null;
        lexeme3 = null;
        sentence1 = null;
        sentence2 = null;
        paragraph1 = null;
        paragraph2 = null;
        text = null;
    }

    @Test
    public void testSortParagraphsBySentenceCount() {
        String expected = "\n xx xx zzz\n yy, yy, xx xx zzz";
        textSorter.sortParagraphsBySentenceCount(text);
        String actual = text.toString();
        assertEquals(actual, expected);
    }

    @Test
    public void testSortSentenceByLexemesLength() {
        String expected = " yy, yy,\n xx xx zzz\n xx xx zzz";
        String actual = textSorter.sortSentenceByLexemesLength(text);
        assertEquals(actual, expected);
    }

    @Test
    public void testSortSentenceByWordsLength() {
        String expected = " yy, yy,\n xx xx zzz\n xx xx zzz";
        String actual = textSorter.sortSentenceByWordsLength(text);
        assertEquals(actual, expected);
    }

    @Test
    public void testSortLexemesBySymbolOccurrence() {
        String expected = "[xx, xx, xx, xx, yy,, yy,, zzz, zzz]";
        String actual = textSorter.sortLexemesBySymbolOccurrence(text, symbolForTest);
        assertEquals(actual, expected);
    }
}