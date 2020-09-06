package by.borisov.textcomposite.parser.impl;

import by.borisov.textcomposite.entity.ComponentType;
import by.borisov.textcomposite.entity.TextComponent;
import by.borisov.textcomposite.entity.impl.CompositeText;
import by.borisov.textcomposite.parser.BaseParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SentenceParser implements BaseParser {
    static Logger logger = LogManager.getLogger();
    private static final String LEXEME_DELIMITER = "\\s+";
    private final BaseParser lexemeParser = new LexemeParser();

    public SentenceParser() {
    }

    @Override
    public TextComponent parse(String sentence) {
        TextComponent componentSentence = new CompositeText(ComponentType.SENTENCE);
        String[] lexemes = sentence.split(LEXEME_DELIMITER);
        for (String lexeme : lexemes) {
            TextComponent componentLexeme = lexemeParser.parse(lexeme);
            componentSentence.add(componentLexeme);
        }
        logger.info("Sentence parsed to lexemes.");

        return componentSentence;
    }
}
