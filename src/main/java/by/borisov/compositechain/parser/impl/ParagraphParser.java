package by.borisov.compositechain.parser.impl;

import by.borisov.compositechain.entity.ComponentType;
import by.borisov.compositechain.entity.TextComponent;
import by.borisov.compositechain.entity.impl.CompositeText;
import by.borisov.compositechain.parser.BaseParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser implements BaseParser {
    static Logger logger = LogManager.getLogger();
    public static final String REGEX_SENTENCE =
            "[^.!?\\s][^.!?]*(?:[.!?](?!['\"]?\\s|$)[^.!?]*)*[.!?]?['\"]?(?=\\s|$)";
    private final BaseParser sentenceParser = new SentenceParser();

    public ParagraphParser() {
    }

    @Override
    public TextComponent parse(String paragraph) {
        TextComponent componentParagraph = new CompositeText(ComponentType.PARAGRAPH);

        Matcher matcher = Pattern.compile(REGEX_SENTENCE).matcher(paragraph);
        while (matcher.find()) {
            String sentence = matcher.group();
            TextComponent componentSentence = sentenceParser.parse(sentence);
            componentParagraph.add(componentSentence);
        }

        logger.info("Paragraph parsed to sentences.");
        return componentParagraph;
    }
}
