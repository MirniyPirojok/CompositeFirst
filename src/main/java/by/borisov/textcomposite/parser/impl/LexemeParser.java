package by.borisov.textcomposite.parser.impl;

import by.borisov.textcomposite.entity.ComponentType;
import by.borisov.textcomposite.entity.TextComponent;
import by.borisov.textcomposite.entity.impl.CompositeText;
import by.borisov.textcomposite.entity.impl.SymbolComponent;
import by.borisov.textcomposite.parser.BaseParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.borisov.textcomposite.entity.ComponentType.LETTER;
import static by.borisov.textcomposite.entity.ComponentType.PUNCTUATION;

public class LexemeParser implements BaseParser {
    static Logger logger = LogManager.getLogger();
    public static final String REGEX_SYMBOL = "\\w";

    public LexemeParser() {
    }

    @Override
    public TextComponent parse(String lexeme) {
        TextComponent componentLexeme = new CompositeText(ComponentType.LEXEME);

        char[] symbols = lexeme.toCharArray();
        TextComponent componentSymbol;
        for (char symbol : symbols) {
            if (String.valueOf(symbol).matches(REGEX_SYMBOL)) {
                componentSymbol = new SymbolComponent(symbol, LETTER);
            } else {
                componentSymbol = new SymbolComponent(symbol, PUNCTUATION);
            }
            componentLexeme.add(componentSymbol);
        }
        logger.info("Lexeme parsed to symbols.");

        return componentLexeme;
    }
}
