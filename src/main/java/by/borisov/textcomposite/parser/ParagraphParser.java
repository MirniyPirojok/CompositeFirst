package by.borisov.textcomposite.parser;

import by.borisov.textcomposite.entity.ComponentType;
import by.borisov.textcomposite.entity.CompositeText;
import by.borisov.textcomposite.entity.TextComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParagraphParser extends TextParser{
    static Logger logger = LogManager.getLogger();
    private final String PARAGRAPH_DELIMITER = "\\t";

    @Override
    public TextComponent parse(String str) {
        TextComponent paragraphs = new CompositeText(ComponentType.PARAGRAPH);

        return paragraphs;
    }
}
