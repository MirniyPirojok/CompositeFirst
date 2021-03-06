package by.borisov.compositechain.util;

import by.borisov.compositechain.comparator.ComparatorByLexemesLength;
import by.borisov.compositechain.comparator.ComparatorBySymbolOccurrence;
import by.borisov.compositechain.comparator.ComparatorByWordsLength;
import by.borisov.compositechain.entity.TextComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TextSorter {
    static Logger logger = LogManager.getLogger();

    public void sortParagraphsBySentenceCount(TextComponent text) {
        text.getComponents().sort(
                Comparator.comparingInt(paragraph -> paragraph.getComponents().size()));
        logger.info("Paragraphs were sorted by sentence count.");
    }

    public String sortSentenceByLexemesLength(TextComponent text) {
        List<TextComponent> sentences = new ArrayList<>();

        List<TextComponent> paragraphs = text.getComponents();
        for (TextComponent paragraph : paragraphs) {
            sentences.addAll(paragraph.getComponents());
        }

        sentences.sort(new ComparatorByLexemesLength());
        logger.info("Sentences were sorted by lexemes length.");

        return sentences.stream().map(Object::toString).collect(Collectors.joining("\n"));
    }

    public String sortSentenceByWordsLength(TextComponent text) {
        List<TextComponent> sentences = new ArrayList<>();

        List<TextComponent> paragraphs = text.getComponents();
        for (TextComponent paragraph : paragraphs) {
            sentences.addAll(paragraph.getComponents());
        }

        sentences.sort(new ComparatorByWordsLength());
        logger.info("Sentences were sorted by words length.");

        return sentences.stream().map(Object::toString).collect(Collectors.joining("\n"));
    }

    public String sortLexemesBySymbolOccurrence(TextComponent text, char givenSymbol) {
        List<TextComponent> lexemes = new ArrayList<>();

        List<TextComponent> paragraphs = text.getComponents();
        for (TextComponent paragraph : paragraphs) {
            for (TextComponent sentences : paragraph.getComponents()) {
                lexemes.addAll(sentences.getComponents());
            }
        }

        lexemes.sort(new ComparatorBySymbolOccurrence(givenSymbol));
        logger.info(String.format("Lexemes were sorted by symbol '%s' occurrence.", givenSymbol));

        return lexemes.toString();
    }
}