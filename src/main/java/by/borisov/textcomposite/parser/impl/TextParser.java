package by.borisov.textcomposite.parser.impl;

import by.borisov.textcomposite.entity.ComponentType;
import by.borisov.textcomposite.entity.TextComponent;
import by.borisov.textcomposite.entity.impl.CompositeText;
import by.borisov.textcomposite.parser.BaseParser;
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
