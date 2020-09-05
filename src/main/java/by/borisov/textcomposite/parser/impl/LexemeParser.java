package by.borisov.textcomposite.parser.impl;

import by.borisov.textcomposite.entity.ComponentType;
import by.borisov.textcomposite.entity.TextComponent;
import by.borisov.textcomposite.entity.impl.CompositeText;
import by.borisov.textcomposite.entity.impl.Symbol;
import by.borisov.textcomposite.parser.BaseParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LexemeParser implements BaseParser {
    static Logger logger = LogManager.getLogger();
    private static final String SYMBOL_DELIMITER = "";

    public LexemeParser() {
    }

    @Override
    public TextComponent parse(String lexeme) {
        TextComponent componentLexeme = new CompositeText(ComponentType.LEXEME);
        String[] symbols = lexeme.split(SYMBOL_DELIMITER); //TODO change symbol to char
        for (String symbol : symbols) {
            TextComponent componentSymbol = new Symbol(symbol);
            componentLexeme.add(componentSymbol);
        }
        return componentLexeme;
    }
}
