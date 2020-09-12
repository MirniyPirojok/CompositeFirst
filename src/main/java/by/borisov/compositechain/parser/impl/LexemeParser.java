package by.borisov.compositechain.parser.impl;

import by.borisov.compositechain.entity.ComponentType;
import by.borisov.compositechain.entity.TextComponent;
import by.borisov.compositechain.entity.impl.CompositeText;
import by.borisov.compositechain.entity.impl.SymbolComponent;
import by.borisov.compositechain.parser.BaseParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.borisov.compositechain.entity.ComponentType.LETTER;
import static by.borisov.compositechain.entity.ComponentType.PUNCTUATION;

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
