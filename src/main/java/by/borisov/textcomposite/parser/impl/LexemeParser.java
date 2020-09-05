package by.borisov.textcomposite.parser.impl;

import by.borisov.textcomposite.entity.ComponentType;
import by.borisov.textcomposite.entity.TextComponent;
import by.borisov.textcomposite.entity.impl.CompositeText;
import by.borisov.textcomposite.entity.impl.SymbolComponent;
import by.borisov.textcomposite.parser.BaseParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LexemeParser implements BaseParser {
    static Logger logger = LogManager.getLogger();

    public LexemeParser() {
    }

    @Override
    public TextComponent parse(String lexeme) {
        TextComponent componentLexeme = new CompositeText(ComponentType.LEXEME);
        char[] symbols = lexeme.toCharArray();
        for (char symbol : symbols) {
            TextComponent componentSymbol = new SymbolComponent(symbol);
            componentLexeme.add(componentSymbol);
        }
        logger.info("Lexeme parsed to symbols.");

        return componentLexeme;
    }
}
