package by.borisov.textcomposite.parser.impl;

import by.borisov.textcomposite.entity.ComponentType;
import by.borisov.textcomposite.entity.TextComponent;
import by.borisov.textcomposite.entity.impl.CompositeText;
import by.borisov.textcomposite.parser.BaseParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParagraphParser implements BaseParser {
    static Logger logger = LogManager.getLogger();
    private static final String SENTENCE_DELIMITER = "[.?!]+\\s+";
    private final BaseParser sentenceParser = new SentenceParser();

    public ParagraphParser() {
    }

    @Override
    public TextComponent parse(String paragraph) {
        TextComponent componentParagraph = new CompositeText(ComponentType.PARAGRAPH);
        String[] sentences = paragraph.split(SENTENCE_DELIMITER);
        for (String sentence : sentences) {
            TextComponent componentSentence = sentenceParser.parse(sentence);
            componentParagraph.add(componentSentence);
        }
        logger.info("Paragraph parsed to sentences.");

        return componentParagraph;
    }
}
