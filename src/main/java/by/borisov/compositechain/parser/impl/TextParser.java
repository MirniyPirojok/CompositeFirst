package by.borisov.compositechain.parser.impl;

import by.borisov.compositechain.entity.ComponentType;
import by.borisov.compositechain.entity.TextComponent;
import by.borisov.compositechain.entity.impl.CompositeText;
import by.borisov.compositechain.parser.BaseParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextParser implements BaseParser {
    static Logger logger = LogManager.getLogger();
    public static final String PARAGRAPH_DELIMITER = "[\n]+";
    private final BaseParser paragraphParser = new ParagraphParser();

    public TextParser() {
    }

    @Override
    public TextComponent parse(String text) {
        TextComponent componentText = new CompositeText(ComponentType.TEXT);

        String[] paragraphs = text.split(PARAGRAPH_DELIMITER);
        for (String paragraph : paragraphs) {
            TextComponent componentParagraph = paragraphParser.parse(paragraph);
            componentText.add(componentParagraph);
        }

        logger.info("Text parsed to paragraphs.");
        return componentText;
    }
}
