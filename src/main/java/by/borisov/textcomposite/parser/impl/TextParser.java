package by.borisov.textcomposite.parser.impl;

import by.borisov.textcomposite.entity.ComponentType;
import by.borisov.textcomposite.entity.TextComponent;
import by.borisov.textcomposite.entity.impl.CompositeText;
import by.borisov.textcomposite.exception.CustomException;
import by.borisov.textcomposite.parser.BaseParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser implements BaseParser {
    static Logger logger = LogManager.getLogger();
    private static final String REGEX_PARAGRAPH = "([^.!?]+[^\\n]+[.!?\\n])";
    private final BaseParser paragraphParser = new ParagraphParser();

    public TextParser() {
    }

    @Override
    public TextComponent parse(String text) throws CustomException {
        TextComponent componentText = new CompositeText(ComponentType.TEXT);

        Matcher matcher = Pattern.compile(REGEX_PARAGRAPH).matcher(text);
        while (matcher.find()) {
            String paragraph = matcher.group();
            TextComponent componentParagraph = paragraphParser.parse(paragraph);
            componentText.add(componentParagraph);
        }

        logger.info("Text parsed to paragraphs.");
        return componentText;
    }
}
